package base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

public class BaseTests {

    private  WebDriver driver;
    protected  LoginPage loginPage;
    
    protected static String VALID_USERNAME;
    protected static String VALID_PASSWORD;
    protected static String INVALID_USERNAME;
    protected static String INVALID_PASSWORD;

    @BeforeAll
    public  void setUp() {
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); 
        options.addArguments("--guest");
        options.addArguments("--disable-gpu");
        options.addArguments("--avoid-stats");

        VALID_USERNAME = System.getenv("VALID_USERNAME");
        VALID_PASSWORD = System.getenv("VALID_PASSWORD");
        INVALID_USERNAME = System.getenv("INVALID_USERNAME");
        INVALID_PASSWORD = System.getenv("INVALID_PASSWORD");

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
