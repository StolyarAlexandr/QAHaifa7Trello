package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileVisabilityTest extends TestBase {

    @BeforeMethod
    public void initTests()  {
        // Open Login Window
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("user"),15);
        // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
               //Submit login attlassian
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),20);
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
                    //Enter attlassian password and submit it
        waitUntilElementIsClickable(By.id("password"),20);
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        waitUntilElementIsClickable(By.id("login-submit"),20);
        driver.findElement(By.id("login-submit")).click();
            //Open Profile&Visability Page
        waitUntilElementIsClickable(By.xpath("//button[@aria-label = 'Open Member Menu']"),20);
        driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']")).click();
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),20);
        driver.findElement(By.xpath("//a[@data-test-id = 'header-member-menu-profile']")).click();
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),20);
        waitUntilElementIsVisible(By.xpath("//a[@data-tab='profile']"),20);

    }

    @Test
    public void isProfileVisabilityPage() {

        WebElement profileTab = driver.findElement(By.xpath("//a[@data-tab='profile']"));
        Assert.assertEquals(profileTab.getText(), "Profile and Visibility");
    }

    @Test
    public void userNameVerification() {
        WebElement memberMenuIcon = driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']"));
        String titleMenu = memberMenuIcon.getAttribute("title");
        System.out.println("Title: " + titleMenu);
        String userNameInTitle = titleMenu.substring(titleMenu.indexOf("(")+1,titleMenu.length()-1);
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println("Username: " + userNameField.getAttribute("value"));
        Assert.assertEquals(userNameInTitle, userNameField.getAttribute("value"));
    }
}
