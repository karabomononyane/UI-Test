package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginObjects;
import pageObjects.SportsArticlesObjects;

import java.util.concurrent.TimeUnit;

public class StepsLogin {

    public WebDriver driver;
    private LoginObjects loginObj;

    @Given("has launched browser and navigated to {string}")
    public void hasLaunchedBrowserAndNavigatedTo(String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        loginObj = new LoginObjects(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        loginObj.clicklnkSignin();
    }

    @Given("user enters username {string} and password {string} input fields")
    public void userEntersUsernameAndPasswordInputFields(String user, String passwd) {
        loginObj.setUserName(user);
        loginObj.setPassword(passwd);
    }

    @When("user click on sign in button")
    public void user_click_on_sign_in_button() {
        loginObj.clickSignin();
    }
    @Then("display and error message")
    public void display_and_error_message() {
        String errorMsg;
        errorMsg = loginObj.checkErrorMessage();
        if(!errorMsg.equalsIgnoreCase("Empty")){
            Assert.assertTrue(true);
            System.out.println(errorMsg);
        } else{
            Assert.assertTrue(false);
            System.out.println(errorMsg);
        }

    }


}
