package com.bptn.weatherapp.automation.cucumberRunners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
//@SelectClasspathResource("com/bptn/weatherapp/automation/pageFeatures/registerPage.feature")
//@SelectClasspathResource("com/bptn/weatherapp/automation/pageFeatures/loginPage.feature")
//@SelectClasspathResource("com/bptn/weatherapp/automation/pageFeatures/weatherPage.feature")
//@SelectClasspathResource("com/bptn/weatherapp/automation/pageFeatures/feedPage.feature")
@SelectClasspathResource("com/bptn/weatherapp/automation/restFeatures/userEndPoint.feature")
@SelectClasspathResource("com/bptn/weatherapp/automation/restFeatures/weatherEndPoint.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.bptn.weatherapp.automation")
//@IncludeTags("GetWeatherByCityNameValidTest")
//@IncludeTags("RestTest | CreateFeedMetaDataValidTest |CreateFeedMetaDataInValidTest")
public class RunCucumberTest {
}