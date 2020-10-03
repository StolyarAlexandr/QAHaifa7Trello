package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        waitUntilHomePageIsLoad();
        openLoginPage();
        waitUntilLoginPageIsLoaded();
    }

    @Test
    public void loginNegativeLoginEmpty() {
        enterEmptyLoginAndPassword(PASSWORD);
        pressLoginButton();
        Assert.assertEquals(getErrorMessage(),"Missing email",
                "The text of the error message is not correct");
    }

    @Test
    public void loginNegativeLoginIncorrect() {
        enterNotAtlassianLogin("878455");
        enterNotAtlassianPassword(PASSWORD);
        pressLoginButton();
        Assert.assertEquals(getErrorMessage(),"There isn't an account for this username",
                "The error message is not 'There isn't an account for this username'");
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
            // Enter email field for attlassian

        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(LOGIN);

             //Submit login attlassian
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement loginAttlButton = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        loginAttlButton.click();
        waitUntilElementIsClickable(By.id("password"),20);

             //Enter an incorrect password and submit it


        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys("46094607");
        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsVisible(By.id("login-error"),15);
        System.out.println("Error: "+ driver.findElement(By.xpath("//div[@id='login-error']")).getText());
        System.out.println("Error message: " + driver
                .findElement(By.id("login-error")).getText());
        Assert.assertTrue(driver.findElement(By.id("login-error")).getText().contains("Incorrect email address and"),
                "The error message is not contains the text 'Incorrect email address and'");
    }

    @Test
    public void loginPositive() throws InterruptedException {
                // Enter login field for attlassian

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

        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id ='header-boards-menu-button']"))
                .getText().equals("Boards"),"The text on the button is not 'Board'");
    }


    private void waitUntilLoginPageIsLoaded() {
        waitUntilElementIsClickable(By.id("password"),15);
        waitUntilElementIsClickable(By.id("login"),15);
        waitUntilElementIsClickable(By.id("user"),15);
    }

    private void openLoginPage() {
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
    }

    private void waitUntilHomePageIsLoad() {
        waitUntilElementIsClickable(By.xpath("//*[@class='btn btn-sm btn-link text-white']"),10);
    }

    public String getErrorMessage(){
        waitUntilElementIsInvisible(By.id("error"),10);
        return driver.findElement(By.id("error")).getText();
    }

    private void pressLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    private void enterEmptyLoginAndPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void enterNotAtlassianPassword(String password) {
        //Enter existent password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    private void enterNotAtlassianLogin(String login) {
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(login);
    }

}
