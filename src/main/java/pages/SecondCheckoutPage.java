package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondCheckoutPage {

    private WebDriver driver;
    public SecondCheckoutPage (WebDriver driver) {
        this.driver=driver;
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    private By FinishButton= new By.ById("finish");

    public void clickOnFinishButton(){
        driver.findElement(FinishButton).click();
    }


    private final String expectedURLAfterSuccessfulOrder="https://www.saucedemo.com/checkout-complete.html";
    public String getExpectedURLAfterSuccessfulOrder(){
        return expectedURLAfterSuccessfulOrder;
    }
}
