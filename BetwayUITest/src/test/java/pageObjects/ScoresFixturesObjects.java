package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScoresFixturesObjects {

    public WebDriver ldriver;
    public ScoresFixturesObjects(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@id='page']")
    @CacheLookup
    WebElement titleHeader;

    @FindBy(xpath = "//article[@class='sp-c-fixture']/div/span/span/span")
    @CacheLookup
    WebElement teamsName;

    public  void getHeader(){
        titleHeader.getText();
    }

    public  void  getTeams(){

        int teamsCount = ldriver.findElements(By.xpath("//article[@class='sp-c-fixture']/div/span/span/span")).size();
        //if the teams names / if there are matches today
        if(teamsName.isDisplayed()){
            for(int i=0; i<teamsCount; i++){
                String clubName = ldriver.findElements(By.xpath("//article[@class='sp-c-fixture']/div/span/span/span")).get(i).getText();
                if(clubName.length()>0){

                    System.out.println(clubName);
                }


            }
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue("There are no matches today!", true);

        }

    }

}
