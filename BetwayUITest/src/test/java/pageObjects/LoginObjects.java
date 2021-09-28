package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
    public WebDriver zdriver;
    public LoginObjects(WebDriver kdriver){
        zdriver = kdriver;
        PageFactory.initElements(kdriver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    @CacheLookup
    WebElement lnkSignin;

    @FindBy(xpath = "//input[@id='user-identifier-input']")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//input[@id='password-input']")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//button[@id='submit-button']")
    @CacheLookup
    WebElement btnSignin;

    //
    @FindBy(xpath = "//div[@id='form-message-username']")
    @CacheLookup
    WebElement messageUsername;

    //Error Message
    @FindBy(xpath = "//div[@id='form-message-general']")
    @CacheLookup
    WebElement messageError;


    public void clicklnkSignin(){
        lnkSignin.click();
    }

    public void setUserName(String user){
        userName.clear();
        userName.sendKeys(user);
    }

    public void setPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }

    public  void clickSignin(){
        btnSignin.click();
    }

    public String checkErrorMessage(){
        String message;
        if(messageUsername.isDisplayed()){
            message = messageUsername.getText();
            return message;
        } else if(messageError.isDisplayed()){
            message = messageError.getText();
            return message;
        } else{
            return "Empty";
        }

    }

}
