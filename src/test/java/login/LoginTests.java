package login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import base.BaseTests;
import pages.InventoryPage;

@TestMethodOrder(MethodOrderer.DisplayName.class)
@DisplayName("Test_Class_01 - Login Tests")
public class LoginTests extends BaseTests {

    @Test
    @DisplayName("TC_001 - Test Successful Login")
    public void testSuccessfulLogin() {
        loginPage.setUsername(VALID_USERNAME);
        loginPage.setPassword(VALID_PASSWORD);
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLAfterLogin(), inventoryPage.getCurrentURL(),"Login Failure !");
    }

    @Test
    @DisplayName("TC_002 - Test Unsuccessful Login With Incorrect Username")
    public void testUnsuccessfulLoginIncorrectUsername() {
        loginPage.setUsername(INVALID_USERNAME);
        loginPage.setPassword(VALID_PASSWORD);
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLBeforeLogin(), inventoryPage.getCurrentURL(),"Failure !");
    }

    @Test
    @DisplayName("TC_003 - Test Unsuccessful Login With Incorrect Password")
    public void testUnsuccessfulLoginIncorrectPassword() {
        loginPage.setUsername(VALID_USERNAME);
        loginPage.setPassword(INVALID_PASSWORD);
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLBeforeLogin(), inventoryPage.getCurrentURL(),"Failure !");
    }

    @Test
    @DisplayName("TC_004 - Test Unsuccessful Login With Incorrect Username & Password")
    public void testUnsuccessfulLoginIncorrectUsernameAndPassword() {
         loginPage.setUsername(INVALID_USERNAME);
         loginPage.setPassword(INVALID_PASSWORD);
         InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLBeforeLogin(), inventoryPage.getCurrentURL(),"Failure !");
    }

    @Test
    @DisplayName("TC_005 - Test Unsuccessful Login With Empty Username & Password")
    public void testUnsuccessfulLoginEmptyUsernameAndPassword(){
        loginPage.setUsername("");
        loginPage.setPassword("");
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLBeforeLogin(), inventoryPage.getCurrentURL(),"Failure !");
    }

    @DisplayName("TC_006 - Test Unsuccessful Login, data is fetched from @CSVSource")
    @ParameterizedTest(name = "index=> username=''{0}'', password=''{1}''")
    @CsvSource({"INVALID_USERNAME,VALID_PASSWORD","VALID_USERNAME,INVALID_PASSWORD","INVALID_USERNAME,INVALID_PASSWORD","'',''"})
    public void testUnsuccessfulLogin(String username,String password){
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        InventoryPage inventoryPage = loginPage.clickLoginButton();
        Assertions.assertEquals(inventoryPage.getExpectedURLBeforeLogin(), inventoryPage.getCurrentURL(),"Failure !");
    }
}
