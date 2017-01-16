package com.trifinlabs.web.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.trifinlabs.web.Browser;
import com.trifinlabs.web.Configs;

/**
 * Created by padne_000 on 1/16/2017.
 */
public abstract class AbstractPage implements IsAt {
    final Logger logger = LoggerFactory.getLogger(HomePage.class);
    final String pageName = this.getClass().getSimpleName();


//    ApplicationContext context =
//            new ClassPathXmlApplicationContext("Beans.xml");

    public boolean isAt() {
        boolean result = Browser.getTitle().contains(Configs.getPageTitles()
                .getProperty(
                        this.getClass().getSimpleName()));
        if (result) {
            logger.info(String.format("Title for [%s] is correct", pageName));
            return result;
        }

        logger.info(String
                .format("Title for [%s] page is not correct", pageName));
        return false;
    }
}
