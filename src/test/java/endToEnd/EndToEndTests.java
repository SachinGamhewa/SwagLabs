package endToEnd;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.SecondCheckoutPage;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Test_Class_02 - End To End Tests")
public class EndToEndTests extends BaseTests {

    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected SecondCheckoutPage secondCheckoutPage;

    @BeforeEach
    public void getToInventoryPage(){
        loginPage.setUsername(VALID_USERNAME);
        loginPage.setPassword(VALID_PASSWORD);
        inventoryPage = loginPage.clickLoginButton();
        inventoryPage.getInventoryPage();
    }

    @Test
    @DisplayName("Sample End To End Test - Checkout with all details")
    public void checkoutWithAllDetails() throws InterruptedException {
            inventoryPage.clickBackpackAddToCartButton();
            cartPage=inventoryPage.clickShoppingCartLink();
            checkoutPage= cartPage.clickCheckoutButton();
            checkoutPage.fillFirstNameInputBox("First Name");
            checkoutPage.fillLastNameInputBox("Last Name");
            checkoutPage.fillPostalCodeInputBox("Postal code");
            secondCheckoutPage=checkoutPage.clickContinueToSecondCheckoutButton();
            secondCheckoutPage.clickOnFinishButton();
            Assertions.assertEquals(secondCheckoutPage.getExpectedURLAfterSuccessfulOrder(),secondCheckoutPage.getCurrentURL(),"Didn't navigate to Success Page !");
    }
}
