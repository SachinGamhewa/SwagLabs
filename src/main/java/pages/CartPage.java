package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    public CartPage (WebDriver driver) {
        this.driver=driver;
    }

    private By CheckoutButton= new By.ById("checkout");
    public CheckoutPage clickCheckoutButton(){
        driver.findElement(CheckoutButton).click();
        return new CheckoutPage(driver);
    }
}
