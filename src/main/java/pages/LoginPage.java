package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private String LoginPageURL = "https://www.saucedemo.com/";
    private WebDriver driver;
    private By userNameField= By.id("user-name");
    private By passwordField= By.id("password");
    private By loginButton= By.id("login-button");


    public LoginPage (WebDriver driver) {
        this.driver=driver;
    }

    public void setUsername(String username){
        driver.findElement(userNameField).clear();
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public InventoryPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new InventoryPage(driver);
    }

    public void getLoginPage(){
      driver.get(LoginPageURL);
    }
}
