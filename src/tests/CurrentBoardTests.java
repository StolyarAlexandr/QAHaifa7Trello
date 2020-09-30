package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),10);
        waitUntilElementIsPresent(By.tagName("h1"),10);
    }

    @Test
    public void isCorrectCurrentBoard(){
        System.out.println("Header of the current board:" + driver.findElement(By.tagName("h1")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"Test 1", "Header of the screen is not 'Test 1'");
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
        driver.manage().window().fullscreen();
                    //If there are no lists create th new list
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
        if (addListButton.getText().equals("Add a list")){
            addListButton.click();
            waitUntilElementIsClickable(By.xpath("//input[@type='submit']"),5);
                    //Fill the name of new list and submit it
            WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
            addNamelistField.click();
            addNamelistField.clear();
            addNamelistField.sendKeys("QA7.3");
            WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
            submitNewList.click();
                     //Cancel the new adding list control
            waitUntilElementIsClickable(By.cssSelector("a.icon-close.dark-hover"),5);
            WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
            xButton.click();
            waitUntilElementIsInvisible(By.cssSelector("a.icon-close.dark-hover"),5);
        }

        waitUntilElementsAreVisible(By.xpath("//div[@class = 'list js-list-content']"),10);

        System.out.println("Lists quantity after adding the new list: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
        int quantityListsInTheBeginning = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        addListButton =driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
                        //Open the extra menu for any list
        WebElement extraMenu = driver.findElement(By.cssSelector("a.list-header-extras-menu"));
        extraMenu.click();
                         // Put the list to the archive
        waitUntilElementIsClickable(By.cssSelector("a.js-close-list"),15);
        WebElement closeExtraMenu = driver.findElement(By.cssSelector("a.js-close-list"));
        closeExtraMenu.click();
        waitUntilElementIsInvisible(By.cssSelector("a.js-close-list"),5);
                        //Print the quantity of lists
        int quantityListsAtTheEnd = driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']")).size();
        System.out.println("Lists quantity at the end: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
        Assert.assertEquals(quantityListsAtTheEnd,quantityListsInTheBeginning-1,
                "The quantityListsAtTheEnd is not quantityListsInTheBeginning-1");

    }

}
