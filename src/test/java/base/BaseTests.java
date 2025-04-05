package base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {

    private  WebDriver driver;
    protected  LoginPage loginPage;

    @BeforeAll
    public  void setUp() {      
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--guest");
        options.addArguments("--disable-gpu");
        options.addArguments("--avoid-stats");

        driver = new ChromeDriver(options);
    }

    @BeforeEach
    public void getToLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.getLoginPage();
    }

    @AfterAll
    public  void tearDown()
    {
        driver.quit();
    }
  
}
