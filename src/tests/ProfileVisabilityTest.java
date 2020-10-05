package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileVisabilityTest extends TestBase{
    @BeforeMethod
    public void initTests() throws InterruptedException {
        //Open login window
        WebElement loginIcon = driver.findElement(By
                .xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        //Thread.sleep(10000);
        waitUntilElementIsClickable(By.id("user"),15);
        // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        //Submit login attlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        //Thread.sleep(15000);
        waitUntilElementIsClickable(By.id("password"),20);
        waitUntilElementIsClickable(By.id("login-submit"),10);
        //Enter attlassian password and submit it
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(30000);
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),55);
        //Open QA7Haifa board
        WebElement qa7HaifaBoard = driver.findElement(By
                .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='QA Haifa7']]"));
        qa7HaifaBoard.click();
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
        waitUntilElementIsPresent(By.tagName("h1"),10);
        //Open Profile&Visability Page
        waitUntilElementIsClickable(By.xpath("//button[@aria-label = 'Open Member Menu']"),10);
        driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']")).click();
        waitUntilElementIsClickable(By.xpath("//a[@data-test-id = 'header-member-menu-profile']"),10);
        driver.findElement(By.xpath("//a[@data-test-id = 'header-member-menu-profile']")).click();
        waitUntilElementIsClickable(By.xpath("//input[@name='username']"),10);
        waitUntilElementIsVisible(By.xpath("//a[@data-tab='profile']"),10);
    }

    @Test
    public void isProfileVisabilityPage(){
        WebElement profileTab = driver.findElement(By.xpath("//a[@data-tab='profile']"));
        Assert.assertEquals(profileTab.getText(), "Profile and Visibility");
    }

    @Test
    public void userNameVerification(){
        WebElement memberMenuIcon = driver.findElement(By.xpath("//button[@aria-label = 'Open Member Menu']"));
        String titleMenu = memberMenuIcon.getAttribute("title");
        System.out.println("Title: " + titleMenu);
        String userNameInTitle = titleMenu.substring(titleMenu.indexOf("(")+1,titleMenu.length()-1);
        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        System.out.println("Username: " + userNameField.getAttribute("value"));
        Assert.assertEquals(userNameInTitle, userNameField.getAttribute("value"));
    }
}
