package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ScoresFixturesObjects;

import java.util.concurrent.TimeUnit;

public class StepsTeams {

    public WebDriver driver;
    private ScoresFixturesObjects lp;

    @Given("user Launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new ScoresFixturesObjects(driver);

    }

    @When("user opens url {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("Output all team names with a match today.")
    public void output_all_team_names_with_a_match_today() {
        lp.getTeams();
        System.out.println("Search displayed..."+driver.findElement(By.xpath("//*[@id='orb-search-q']")).isEnabled()+">>"+driver.findElement(By.xpath("//*[@id='orb-search-q']")).isDisplayed());
    }



}
