package co.imdo.perfect.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import cn.hutool.core.date.DateUtil;
import co.imdo.perfect.util.SpringUtil;
import com.mongodb.BasicDBObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liu
 */
@Slf4j
public class MongDbLoggerAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (SpringUtil.applicationContext == null) {
            return;
        }
        ReactiveMongoTemplate mongoTemplate = SpringUtil.getBean(ReactiveMongoTemplate.class);
        if (mongoTemplate != null) {
            final BasicDBObject doc = new BasicDBObject();
            doc.append("level", eventObject.getLevel().toString());
            doc.append("logger", eventObject.getLoggerName());
            doc.append("thread", eventObject.getThreadName());
            doc.append("interfaceMsg", eventObject.getFormattedMessage());
            doc.append("causeBy", eventObject.getThrowableProxy().getMessage());
            doc.append("occurTime", DateUtil.formatDateTime(new Date(eventObject.getTimeStamp())));
            final IThrowableProxy[] suppressed = eventObject.getThrowableProxy().getSuppressed();

            List<Map<String, Object>> detailMsg = new ArrayList<>();
            for (int i = 0; i < suppressed.length; i++) {
                Map map = new HashMap<>(16);
                map.put("message", suppressed[i].getMessage().toString());

                List traceList = new ArrayList();
                for (int j = 0; j < suppressed[i].getStackTraceElementProxyArray().length; j++) {
                    traceList.add(suppressed[i].getStackTraceElementProxyArray()[j].getSTEAsString());
                }
                map.put("trace", traceList);
                detailMsg.add(map);
            }

            doc.append("detailMsg", detailMsg);
            doc.append("ste", Arrays.stream(eventObject.getThrowableProxy().getStackTraceElementProxyArray())
                    .map(StackTraceElementProxy::getSTEAsString).collect(Collectors.joining()));
            mongoTemplate.save(doc, "log_collection").subscribe();
        }
    }
}
