package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper extends PageBase{

    public LoginPageHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void loginAsAttlassian(String login, String password) {
        enterLoginAsAttlassian(login);
        submitAsAttlassian();
        enterPasswordAsAttlassian(password);
    }

    public String getBoadsIconName(){
        return driver.findElement(By.xpath("//button[@data-test-id ='header-boards-menu-button']"))
                .getText();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.id("password"),15);
        waitUntilElementIsClickable(By.id("login"),10);
        waitUntilElementIsClickable(By.id("user"),15);
    }

    public String getErrorMessage(){
        waitUntilElementIsVisible(By.id("error"), 15);
        return driver.findElement(By.id("error")).getText();
    }

    public String getAttlassianErrorMessage(){
        waitUntilElementIsVisible(By.id("login-error"), 15);
        return driver.findElement(By.id("login-error")).getText();
    }

    public void pressLoginButton() {
        waitUntilElementIsClickable(By.id("login"),10);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    public void enterNotAttlassianPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterNotAttlassianLogin(String login) {
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterLoginAsAttlassian(String login) {
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(login);
    }
    public void submitAsAttlassian() {
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement loginAttlButton = driver.findElement(By.xpath("//input[@value='Log in with Atlassian']"));
        loginAttlButton.click();
        waitUntilElementIsClickable(By.id("password"),20);
    }
    public void enterPasswordAsAttlassian(String password) {
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(password);
        driver.findElement(By.id("login-submit")).click();
    }
    public void loginNotAttlassian(String login, String password) {
        enterNotAttlassianLogin(login);
        enterNotAttlassianPassword(password);
        pressLoginButton();
    }

}

