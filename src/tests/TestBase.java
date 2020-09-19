package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    // Create constantes.
    public static final String LOGIN = "alexandrqa7@gmail.com";
    public static final String PASSWORD = "46094609";

    WebDriver driver;

    @BeforeMethod
    public void StartAppl() throws InterruptedException {
        //Driver initialization.      Open Trello application
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + "en");
        driver = new ChromeDriver(options);
        driver.get("https://trello.com/");
        Thread.sleep(2000);

    }
   @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
