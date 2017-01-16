package com.trifinlabs.web;

import org.openqa.selenium.support.PageFactory;
import com.trifinlabs.web.pages.AbstractPage;

import java.util.HashMap;


public class Pages {
    private HashMap<String, AbstractPage> pages;

    public Pages() {
        pages = new HashMap();
    }

    public <T extends AbstractPage> T getPage(Class<T> type) {
        T page = null;
        if(pages.containsKey(type.getName()) == false) {
            try {
                page = type.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            pages.put(type.getName(),page );
        }
        PageFactory.initElements(Browser.getWebDriver(), page);
        return type.cast(pages.get(type.getName()));
    }

//    public static HomePage getHeaderPage() {
//        HomePage page = new HomePage();
//        PageFactory.initElements(Browser.getWebDriver(), page);
//        return page;
//    }
//
//    public static GoogleSearchPage getGoogleSearchPage() {
//        GoogleSearchPage page = new GoogleSearchPage();
//        PageFactory.initElements(Browser.getWebDriver(), page);
//        return page;
//    }
//
//    public static GooglePlayPage getGooglePlayPage() {
//        GooglePlayPage page = new GooglePlayPage();
//        PageFactory.initElements(Browser.getWebDriver(), page);
//        return page;
//    }
//
//    public static ApplicationPage getApplicationPage() {
//        ApplicationPage page = new ApplicationPage();
//        PageFactory.initElements(Browser.getWebDriver(), page);
//        return page;
//    }
}
