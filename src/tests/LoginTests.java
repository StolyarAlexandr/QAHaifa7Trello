package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
                        //Open login window
        waitUntilElementIsClickable(By.xpath("//*[@class='btn btn-sm btn-link text-white']"),10);
        WebElement loginIcon = driver.findElement(By
                    .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
    }

    @Test
    public void loginNegativeLoginEmpty() throws InterruptedException {
           // Enter empty login and password
        waitUntilElementIsClickable(By.id("password"),15);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("pupkin");
             //Press login button
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementIsPresent(By.id("error"),10);
             //Print error massage
        System.out.println("Error: " + driver
                .findElement(By.id("error")).getText());
        Assert.assertEquals("Missing email", driver.findElement(By.id("error")).getText(),"Missing email");

    }

    @Test
    public void loginNegativeLoginIncorrect() throws InterruptedException {
            // Enter not existent login
        waitUntilElementIsClickable(By.id("user"),15);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("pupkin@mail.ru");

            //Enter existent password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("pupkin");

             //Press login button
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        waitUntilElementsAreVisible(By.id("error"),3000);
        Thread.sleep(2000);

             //Print error message
       System.out.println("Error: "+ driver
                .findElement(By.id("error")).getText());


    }
    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
            // Enter email field for attlassian
        waitUntilElementIsClickable(By.id("user"),10);
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);

             //Submit login attlassian
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();

             //Enter an incorrect password and submit it
       // waitUntilElementIsClickable(By.id("password"),10);
        Thread.sleep(5000);
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys("46094607");

        waitUntilElementIsClickable(By.id("login-submit"),10);
        driver.findElement(By.id("login-submit")).click();

        Thread.sleep(2000);
        //waitUntilElementIsPresent(By.xpath("//div[@id='login-error']"),10);
        System.out.println("Error: "+ driver.findElement(By.xpath("//div[@id='login-error']")).getText());
        Thread.sleep(3000);
    }
    @Test
    public void loginPositive() throws InterruptedException {
                // Enter login field for attlassian
        waitUntilElementIsClickable(By.id("user"),15);
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
              //Submit login attlassian
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(2000);
                //Enter attlassian password and submit it
        waitUntilElementIsClickable(By.id("password"),20);
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"),10);
        driver.findElement(By.id("login-submit")).click();

        waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),45);
        //System.out.println("Boards button text: "+ driver
              //  .findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']")).getText());

        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id = 'header-boards-menu-button']")).getText().equals("Boards"));
    }

}
