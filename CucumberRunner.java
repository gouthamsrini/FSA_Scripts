package runner;

import org.testng.annotations.DataProvider;

import base.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/features/T03_CreateAcc.feature","src/test/java/features/T04_CreateCase.feature"},
                 glue = "stepsDefinition",
                 monochrome = true,
                 publish = true,
                 tags="@functional")
public class CucumberRunner extends BaseTest {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}        