package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;
    public CheckoutPage (WebDriver driver) {
        this.driver=driver;
    }

    private By FirstNameInputBox= new By.ById("first-name");
    public void fillFirstNameInputBox(String text){
        driver.findElement(FirstNameInputBox).sendKeys(text);
    }

    private By LastNameInputBox= new By.ById("last-name");
    public void fillLastNameInputBox(String text){
        driver.findElement(LastNameInputBox).sendKeys(text);
    }

    private By PostalCodeInputBox= new By.ById("postal-code");
    public void fillPostalCodeInputBox(String text){
        driver.findElement(PostalCodeInputBox).sendKeys(text);
    }

    private By ContinueToSecondCheckoutButton= new By.ById("continue");
    public SecondCheckoutPage clickContinueToSecondCheckoutButton(){
        driver.findElement(ContinueToSecondCheckoutButton).click();
        return new SecondCheckoutPage(driver);
    }
}
