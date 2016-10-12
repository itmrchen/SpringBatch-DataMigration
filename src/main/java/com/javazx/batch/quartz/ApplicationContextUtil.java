package com.javazx.batch.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContextUtil instance;

    private ApplicationContext applicationContext;

    private static synchronized ApplicationContextUtil getInstance() {

        if (instance == null) {
            instance = new ApplicationContextUtil();
        }

        return instance;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        if (getInstance().applicationContext == null) {
            getInstance().applicationContext = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return getInstance().applicationContext;
    }

}
