package common.aop;

import com.alibaba.fastjson.JSON;
import common.common.base.BaseCode;
import common.common.base.R;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liusonglin
 * @date 2018年8月1日
 */

@Slf4j
@Aspect
@Order(5)
@Component
public class MonitorAspect {

    private static final String POINT = "execution (* *.web..*.*(..))";
//    private static final String POINT = "execution (* helper.web..*.*(..))";

    @Pointcut(POINT)
    public void performance() {
    }

    /**
     * 两者兼容
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("performance() || @annotation(common.anno.Monitor)")
    public Object logServiceAccess(ProceedingJoinPoint pjp) throws Throwable {

        /**
         * 记录切面的信息
         */
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        String fullMethodName = className + "." + methodName;
        log.info(fullMethodName + "将被调用");
        // 请求参数 打印
        Object[] args = pjp.getArgs();
        for (Object parm : args) {
            // 过滤request
            if (!"org.apache.catalina.connector.RequestFacade".equals(parm.getClass().getName())) {
                log.info("请求参数：" + parm);
            }
        }

        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        long takeTimeMillis = end - start;

        if (result != null && result instanceof R) {
            ((R) result).setCode(BaseCode.SUCCESS);
            ((R) result).setTakeTimeMillis(takeTimeMillis);
        }
        // 响应结果打印
        if (result != null) {
            log.info("响应数据:" + JSON.toJSONString(result));
        }

        log.info(fullMethodName + "调用结束," + "耗时:" + takeTimeMillis + "ms");

        return result;
    }
}