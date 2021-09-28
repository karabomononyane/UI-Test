package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportsArticlesObjects {

    public  WebDriver hdriver;
    //int articlesCount;
    public  SportsArticlesObjects(WebDriver adriver){
        hdriver = adriver;
        PageFactory.initElements(adriver, this);
    }

    @FindBy(xpath = "//*[@id='orb-search-q']")
    @CacheLookup
    WebElement searchField;

    @FindBy(xpath = "//*[@id='orb-search-button']")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(xpath = "//a[contains(@href, 'https://www.bbc.co.uk/programmes')]")
    @CacheLookup
    WebElement articles;

    public void typeSports(String label){
        if(searchField.isEnabled()){
            searchField.sendKeys(label);

        } else{
            System.out.println("Element Not found");
            Assert.fail("Element Not found");
        }

    }

    public void clickSearch() {
        btnSearch.click();
    }

    //articlesCount = 10;
    public void printArticle(){
        int articlesCount = hdriver.findElements(By.xpath("//a[contains(@href, 'https://www.bbc.co.uk/programmes')]")).size();
        /*for(int i=0; i< articlesCount; i++){
            System.out.println(">>>>>>>>>><<<<<<<<<<<<<<<<<<<");
            System.out.println(hdriver.findElements(By.xpath("//a[contains(@href, 'https://www.bbc.co.uk/programmes')]")).get(i).getText());
        }*/
        String articleHeader1 = hdriver.findElements(By.xpath("//a[contains(@href, 'https://www.bbc.co.uk/programmes')]")).get(0).getText();
        String articleHeader2 = hdriver.findElements(By.xpath("//a[contains(@href, 'https://www.bbc.co.uk/programmes')]")).get(articlesCount-1).getText();
        System.out.println(articleHeader1);
        System.out.println(articleHeader2);

    }


}
