package helper.factory;

import com.google.common.collect.Lists;
import common.common.enums.RequestEnum;
import helper.strategy.SendMailStrategy;
import helper.strategy.SendShortMsgStrategy;
import helper.strategy.SendStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 发送消息-工厂
 *
 * @author liuSonglin
 */
public class SendStrategyFactory {

    private Map<Integer, SendStrategy> strategyFactoryMap;

    private SendStrategyFactory() {
        List<SendStrategy> strategies = Lists.newArrayList();
        strategies.add(new SendMailStrategy());
        strategies.add(new SendShortMsgStrategy());
        /** 每增加一种策略在此添加进来即可 **/
        strategyFactoryMap = strategies.stream().collect(Collectors.toMap(sendStrategy -> sendStrategy.getSendType().getValue(), sendStrategy -> sendStrategy));
    }

    private static class Holder {
        public static SendStrategyFactory instance = new SendStrategyFactory();
    }

    public static SendStrategyFactory getInstance() {
        return Holder.instance;
    }

    public SendStrategy getSendStrategy(RequestEnum requestEnum) {
        SendStrategy sendStrategy = strategyFactoryMap.get(requestEnum.getValue());
        if (sendStrategy == null) {
            throw new IllegalArgumentException("please input right type");
        }
        return sendStrategy;
    }
}
