package org.iammrchenh.infrastructure.security.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenh
 * @date 2021/1/18
 */
@Configuration
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(Class<T> classes) {
        return context.getBean(classes);
    }

    public static void publishEvent(ApplicationEvent event) {
        context.publishEvent(event);
    }

}
