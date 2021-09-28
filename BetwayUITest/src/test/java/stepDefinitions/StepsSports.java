package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.SportsArticlesObjects;

import java.util.concurrent.TimeUnit;

public class StepsSports {
    public WebDriver driver;
    private SportsArticlesObjects tp;

    @Given("User has searched for all articles related to {string} and user navigated to {string}")
    public void userHasSearchedForAllArticlesRelatedToAndUserNavigatedTo(String label, String url) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        //System.out.println(label+ " >>>> "+url);
        driver.manage().window().maximize();
        if(driver.equals(null)==false){
            tp = new SportsArticlesObjects(driver);
        } else{
            System.out.println("Driver empty");
            driver.quit();
        }


        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        tp.typeSports(label);
        tp.clickSearch();
    }

    @Then("Output the first heading and the last heading returned on the page.")
    public void output_the_first_heading_and_the_last_heading_returned_on_the_page() {
        tp.printArticle();
    }


}
