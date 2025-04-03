package pages;

import org.openqa.selenium.*;

public class InventoryPage {
    private final String expectedURLBeforeLogin="https://www.saucedemo.com/";
    private final String expectedURLAfterLogin="https://www.saucedemo.com/inventory.html";

    private By ShoppingCartLink = new By.ByClassName("shopping_cart_link");
    private By BackpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    private WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getExpectedURLAfterLogin(){
        return expectedURLAfterLogin;
    }

    public String getExpectedURLBeforeLogin(){
        return expectedURLBeforeLogin;
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void clickAddToCartButton(By element)
    {
        driver.findElement(element).click();
    }

    public void clickBackpackAddToCartButton(){
        clickAddToCartButton(BackpackAddToCartButton);
    }

    public CartPage clickShoppingCartLink(){
        driver.findElement(ShoppingCartLink).click();
        return new CartPage(driver);
    }

    public void getInventoryPage(){
        driver.get(expectedURLAfterLogin);
    }

}
