package com.trifinlabs.web.tests;

/**
 * Created by apadnevici on 8/30/2016.
 */

import com.trifinlabs.web.Pages;
import com.trifinlabs.web.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.trifinlabs.web.Browser;
import com.trifinlabs.web.Configs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class LoginTest {
    final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");


    @Given("^I navigate to the mock application$")
    public void given_I_navigate_to_the_mock_application(){
        Pages pages = (Pages) context.getBean("pages");
        logger.info("Entering: I navigate to the mock application");
        Browser.initialize();
        Browser.navigate(Configs.getApplication().getProperty("defaul-url"));
        HomePage homePage = pages.getPage(HomePage.class);
        Assert.assertTrue(homePage.isAt());
    }

    @When("^I try to login with '(.+)' credentials$")
    public void when_I_try_to_login(String credentialsType){
        logger.info("Entering: I try to login with " +
                credentialsType + " credentials");
    }

    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcome){
        logger.info("Entering: I should see that I logged in " + outcome);
    }
}