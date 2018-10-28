package stepdefs;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import test_maven.com.myappium.playground.MyDriver;
import test_maven.com.myappium.playground.TestRunner;

public class StepDefinitions {
	private TestRunner testRunner;

	public StepDefinitions(TestRunner tr) {
		this.testRunner = tr;
	}

	@Given("a valid user")
	public void valid_user() {
		AndroidDriver driver = testRunner.getDriver();
		
		driver.resetApp();
	}

	@When("^user navigates to the ([^\"]*) screen$")
	public void user_navigation1(String pref) {
		AndroidDriver driver = testRunner.getDriver();

		if (pref.equals("preferences")) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		} else if (pref.equals("preferences-dependencies")) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		} else if (pref.equals("In-line preferences")) {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElementByXPath("//android.widget.TextView[@text='9. Switch']").click();
		}

	}

	@When("^user clicks the Wifi checkbox$")
	public void user_clicks_the_Wifi_checkbox() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();

		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("^user enters the text in Wifi settings text box$")
	public void user_enters_the_text_in_Wifi_settings_text_box() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();

		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByClassName("android.widget.EditText").sendKeys("ASDF123");
	}

	@When("^user click on ok button$")
	public void user_click_on_ok_button() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();

		driver.findElementById("android:id/button1").click();
	}

	@When("^user turn ON the first switch preference$")
	public void user_turn_ON_the_first_switch_preference() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//No Unique classnames available in the apk
		List<AndroidElement> togglebuttons = driver.findElementsByClassName("android.widget.Switch");
		MobileElement toggle = togglebuttons.get(0);
		
		//Performing gesture tap action
		int startX = toggle.getLocation().getX();
	    int startY = toggle.getLocation().getY();
		new TouchAction(driver).tap(point(startX+20, startY+30)).perform();
	}

	@Then("^switch preference should get turn ON$")
	public void switch_preference_should_get_turn_ON() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();

		List<AndroidElement> togglebuttons = driver.findElementsByClassName("android.widget.Switch");
		MobileElement toggle = togglebuttons.get(0);
		Assert.assertEquals(toggle.getText(), "ON");
	}

	@Then("^a new Wifi setting is added$")
	public void a_new_Wifi_setting_is_added() throws Throwable {
		AndroidDriver driver = testRunner.getDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").isEnabled();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		MobileElement result = (MobileElement) driver.findElementByClassName("android.widget.EditText");
		Assert.assertEquals(result.getText(), "ASDF123");
	}
}
