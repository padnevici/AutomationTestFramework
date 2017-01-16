package com.trifinlabs.web.tests;

/**
 * Created by apadnevici on 8/30/2016.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com\\trifinlabs\\web\\features",//path to the features
        tags = {"@run"})//what tags to include(@)/exclude(@~)
public class Runner {
}