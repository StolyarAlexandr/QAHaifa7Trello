package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CurrentBoardTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
                            // Open Login Window
        WebElement loginIcon = driver.findElement(By.xpath("//*[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(2000);
                         // Enter login field for attlassian
        WebElement loginField = driver.findElement(By.id("user"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys(LOGIN);
        //Thread.sleep(2000);
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
        //Thread.sleep(20000);
                        //Open Test1 board
        waitUntilElementIsClickable(By.xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='Test 1']]"),20);
        WebElement boardTest1 = driver.findElement(By
                .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='Test 1']]"));
        boardTest1.click();
        Thread.sleep(2000);
    }


    @Test
    public void createListPositive() throws InterruptedException {
                //Quantity of lists before
        System.out.println("List quantity before: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
                //Add list
        waitUntilElementIsClickable(By.xpath("//span[@class='placeholder']"),10000);
        WebElement addList = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addList.click();
                //Fill the name of new list
        WebElement addNameList = driver.findElement(By.xpath("//input[@placeholder='Enter list title...']"));
        addNameList.click();
        addNameList.clear();
        addNameList.sendKeys("QA7.3");
                //Add list
        WebElement addNewList = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        addNewList.click();
                 //Quantity of lists after
        System.out.println("List quantity after: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());

    }

    @Test
    public void putAnyListToArchive() throws InterruptedException {
            //Print the quantity of lists
        driver.manage().window().fullscreen();
        System.out.println("List quantity before: "+ driver
                .findElements(By.xpath("//div[@class='list js-list-content']")).size());
             //Button Add list
        waitUntilElementIsClickable(By.xpath("//span[@class='placeholder']"),10000);
        WebElement addList = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addList.click();
            //Fill the name of new list
        WebElement addNameList = driver.findElement(By.xpath("//input[@placeholder='Enter list title...']"));
        addNameList.click();
        addNameList.clear();
        addNameList.sendKeys("QA7.3");
            //Submit Add list
        WebElement addNewList = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
        addNewList.click();

            //Open list actions
        WebElement listActions = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        listActions.click();

            //Archive this list
        WebElement archiveList = driver.findElement(By.cssSelector("a.js-close-list"));
        archiveList.click();

            //Quantity of lists after
        System.out.println("List quantity after: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
    }


}
