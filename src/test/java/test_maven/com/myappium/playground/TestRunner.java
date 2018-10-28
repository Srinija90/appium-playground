package test_maven.com.myappium.playground;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.TestNGCucumberRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefs" }, tags= {"Ignore"})

public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	private AndroidDriver<AndroidElement> driver = MyDriver.getDriver();

	public AndroidDriver getDriver() {
		return driver;
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}


	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
		driver.quit();
	}

}
