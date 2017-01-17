package com.trifinlabs.web;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Configs {
    private static Properties pageTitles;
    private static Properties application;
    private static Properties pageUrls;

    public static Properties getPageTitles() {
        Resource resource = new ClassPathResource("/page-titles" +
                ".properties");
        try {
            pageTitles = PropertiesLoaderUtils.loadProperties
                    (resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageTitles;
    }

    public static Properties getApplication() {
        Resource resource = new ClassPathResource("/application" +
                ".properties");
        try {
            application = PropertiesLoaderUtils.loadProperties
                    (resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return application;
    }

    public static Properties getPageUrls() {
        Resource resource = new ClassPathResource("/page-urls" +
                ".properties");
        try {
            pageUrls = PropertiesLoaderUtils.loadProperties
                    (resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageUrls;
    }
}
