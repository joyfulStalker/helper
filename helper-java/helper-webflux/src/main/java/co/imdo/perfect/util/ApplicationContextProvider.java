package co.imdo.perfect.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    public static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextProvider.applicationContext == null && applicationContext != null) {
            ApplicationContextProvider.applicationContext = applicationContext;
        }
    }

    /**
     * 根据class获取bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据name
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}