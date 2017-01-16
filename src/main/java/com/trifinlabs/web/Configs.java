package com.trifinlabs.web;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Configs {
    private static Properties pageTitles;
    private static Properties application;

    public static Properties getPageTitles() {
        Resource pageTitlesResource = new ClassPathResource("/page-titles" +
                ".properties");
        try {
            pageTitles = PropertiesLoaderUtils.loadProperties
                    (pageTitlesResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageTitles;
    }

    public static Properties getApplication() {
        Resource applicationResource = new ClassPathResource("/application" +
                ".properties");
        try {
            application = PropertiesLoaderUtils.loadProperties
                    (applicationResource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return application;
    }

}
