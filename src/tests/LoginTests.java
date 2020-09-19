package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    WebDriver driver;

    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {

           // Enter empty login and password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("marinaqa");
        //Press login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(5000);
        //Print error mssage
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());


    }
    @Test
    public void loginWrongPasswordAndLogo() throws InterruptedException {

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("pupkin@mail.ru");
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("pupkin");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(2000);
        System.out.println("Error: "+ driver.findElement(By.xpath("//div[@id='error']//p[@class='error-message']")).getText());


    }
    @Test
    public void loginWrongPasswordAndRightLogo() throws InterruptedException {

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("alexandrqa7@gmail.com");
        Thread.sleep(2000);

        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(2000);

        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys("46094607");

        WebElement loginButton = driver.findElement(By.id("login-submit"));
        loginButton.click();
        Thread.sleep(2000);
        System.out.println("Error: "+ driver.findElement(By.xpath("//div[@id='login-error']")).getText());

    }
    @Test
    public void loginPositive() throws InterruptedException {

        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("alexandrqa7@gmail.com");
        Thread.sleep(2000);

        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(2000);

        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys("46094609");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);

        System.out.println("Boards button text: "+ driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']")).getText());

    }

}
