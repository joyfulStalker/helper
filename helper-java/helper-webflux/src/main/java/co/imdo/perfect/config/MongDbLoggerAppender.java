package co.imdo.perfect.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import co.imdo.perfect.util.SpringUtil;
import com.mongodb.BasicDBObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

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
            doc.append("formattedMessage", eventObject.getFormattedMessage());
            doc.append("message", eventObject.getThrowableProxy().getMessage());

            //TODO 需要改成响应式写法
            StackTraceElementProxy[] stackTraceElementProxyArray = eventObject.getThrowableProxy().getStackTraceElementProxyArray();
            String str = "";
            for (int i = 0; i < stackTraceElementProxyArray.length; i++) {
                str += stackTraceElementProxyArray[i].getSTEAsString() + "\r\n";
            }

            doc.append("ste", str);
            mongoTemplate.save(doc, "log_collection").subscribe();
        }
    }
}
