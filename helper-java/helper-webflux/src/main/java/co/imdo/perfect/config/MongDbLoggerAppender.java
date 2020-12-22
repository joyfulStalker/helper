package co.imdo.perfect.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import co.imdo.perfect.entity.LogCollection;
import co.imdo.perfect.service.LogCollectionService;
import co.imdo.perfect.service.impl.LogCollectionServiceImpl;
import co.imdo.perfect.util.ApplicationContextProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liu
 */
@Slf4j
public class MongDbLoggerAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {

    @Override
    protected void append(ILoggingEvent eventObject) {
        try {
            if (ApplicationContextProvider.applicationContext == null) {
                return;
            }
            System.out.println("MongDbLoggerAppender1:" + Thread.currentThread().getName());

            System.out.println("日志接收");
            LogCollectionService logService = ApplicationContextProvider.applicationContext.getBean(LogCollectionServiceImpl.class);
            if (logService != null) {
                LogCollection logCollection = new LogCollection();
                logCollection.setMessage(eventObject.getFormattedMessage());
                logCollection.setThread(eventObject.getThreadName());
                logCollection.setLogger(eventObject.getLoggerName());
                logCollection.setLevel(eventObject.getLevel().toString());

                logService.save(logCollection);
                System.out.println("保存日志结束");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ReactiveMongoTemplate reactiveMongoTemplate = ApplicationContextProvider.getBean("reactiveMongoTemplate");
//        if (reactiveMongoTemplate != null) {
//            final BasicDBObject doc = new BasicDBObject();
//            doc.append("_id", ObjectId.get());
//            doc.append("level", eventObject.getLevel().toString());
//            doc.append("logger", eventObject.getLoggerName());
//            doc.append("thread", eventObject.getThreadName());
//            doc.append("message", eventObject.getFormattedMessage());
//            reactiveMongoTemplate.save(doc, "log_collection");
//        }

//        ReactiveMongoTemplate mongoTemplate = ApplicationContextProvider.getBean(ReactiveMongoTemplate.class);
//        if (mongoTemplate != null) {
//            final BasicDBObject doc = new BasicDBObject();
//            doc.append("_id", ObjectId.get());
//            doc.append("level", eventObject.getLevel().toString());
//            doc.append("logger", eventObject.getLoggerName());
//            doc.append("thread", eventObject.getThreadName());
//            doc.append("message", eventObject.getFormattedMessage());
//            mongoTemplate.save(doc, "log_collection");
//        }
    }
}
