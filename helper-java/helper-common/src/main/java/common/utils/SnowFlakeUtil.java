package common.utils;

import com.google.common.collect.Maps;
import common.common.enums.DataCenterEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

/**
 * @author liu
 */
@Slf4j
public class SnowFlakeUtil {

    /**
     * 机器编号
     */
    @Value("${snow-flake.machine-identify:1}")
    private Long machineIdentify;

    /**
     * 只用数据做主键 ，不考虑机器号，机器号不同
     */
    private final Map<DataCenterEnum, SnowFlakeId> snowFlakeShortIdMap = Maps.newConcurrentMap();

    private SnowFlakeId getSnowFlakeShortId(DataCenterEnum dataCenterEnum) {
        if (snowFlakeShortIdMap.get(dataCenterEnum) == null) {
            synchronized (SnowFlakeUtil.class) {
                if (snowFlakeShortIdMap.get(dataCenterEnum) == null) {
                    log.info("dataCenterEnum:" + dataCenterEnum + "加入到map");
                    snowFlakeShortIdMap.put(dataCenterEnum, new SnowFlakeId(dataCenterEnum.getValue(), machineIdentify));
                }
            }
        }
        return snowFlakeShortIdMap.get(dataCenterEnum);
    }


    /**
     * 产生下一个ID
     *
     * @return
     */
    public long nextId(DataCenterEnum dataCenterEnum) {
        return this.getSnowFlakeShortId(dataCenterEnum).nextId();
    }


    private class SnowFlakeId {
        /**
         * 起始的时间戳
         */
        private final static long START_TIMESTAMP = 1480166465631L;

        /**
         * 每一部分占用的位数
         */
        private final static long SEQUENCE_BIT = 12;   //序列号占用的位数
        private final static long MACHINE_BIT = 5;     //机器标识占用的位数
        private final static long DATA_CENTER_BIT = 5; //数据中心占用的位数

        /**
         * 每一部分的最大值
         */
        private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);
        private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
        private final static long MAX_DATA_CENTER_NUM = -1L ^ (-1L << DATA_CENTER_BIT);

        /**
         * 每一部分向左的位移
         */
        private final static long MACHINE_LEFT = SEQUENCE_BIT;
        private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
        private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

        private long dataCenterId;  //数据中心
        private long machineId;     //机器标识
        private long sequence = 0L; //序列号
        private long lastTimeStamp = -1L;  //上一次时间戳

        private long getNextMill() {
            long mill = getNewTimeStamp();
            while (mill <= lastTimeStamp) {
                mill = getNewTimeStamp();
            }
            return mill;
        }

        private long getNewTimeStamp() {
            return System.currentTimeMillis();
        }


        /**
         * 根据指定的数据中心ID和机器标志ID生成指定的序列号
         *
         * @param dataCenterId 数据中心ID
         * @param machineId    机器标志ID
         */
        private SnowFlakeId(long dataCenterId, long machineId) {
            if (dataCenterId > MAX_DATA_CENTER_NUM || dataCenterId < 0) {
                throw new IllegalArgumentException("DtaCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0！");
            }
            if (machineId > MAX_MACHINE_NUM || machineId < 0) {
                throw new IllegalArgumentException("MachineId can't be greater than MAX_MACHINE_NUM or less than 0！");
            }
            this.dataCenterId = dataCenterId;
            this.machineId = machineId;
        }


        /**
         * 产生下一个ID
         *
         * @return
         */
        private synchronized long nextId() {
            long currTimeStamp = getNewTimeStamp();

            if (currTimeStamp < lastTimeStamp) {
                throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
            }

            if (currTimeStamp == lastTimeStamp) {
                //相同毫秒内，序列号自增
                sequence = (sequence + 1) & MAX_SEQUENCE;
                //同一毫秒的序列数已经达到最大
                if (sequence == 0L) {
                    currTimeStamp = getNextMill();
                }
            } else {
                //不同毫秒内，序列号置为0
                sequence = 0L;
            }

            lastTimeStamp = currTimeStamp;
            return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT //时间戳部分
                    | dataCenterId << DATA_CENTER_LEFT       //数据中心部分
                    | machineId << MACHINE_LEFT             //机器标识部分
                    | sequence;                             //序列号部分
        }
    }


}