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
        Thread.sleep(2000);
                         //Submit login attlassian
        WebElement loginAttlButton = driver.findElement(By.id("login"));
        loginAttlButton.click();
        Thread.sleep(2000);
                        //Enter attlassian password and submit it
        WebElement passwordAttlField = driver.findElement(By.id("password"));
        passwordAttlField.click();
        passwordAttlField.clear();
        passwordAttlField.sendKeys(PASSWORD);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(20000);

        WebElement boardTest1 = driver.findElement(By.xpath("//body/div[@id='trello-root']/div[@id='chrome-container']/div[@class='BfrybzRYI4wt4w']/div[@id='surface']/main[@id='popover-boundary']/div[@id='content']/div[@class='member-boards-view']/div[@class='js-boards-page']/div[@class='js-react-root']/div/div[@class='home-container']/div[@class='home-sticky-container']/div[@class='all-boards']/div/div[@class='content-all-boards']/div[@class='boards-page-board-section mod-no-sidebar']/div/ul[@class='boards-page-board-section-list']/li[@class='boards-page-board-section-list-item']/a[@class='board-tile']/div[1]"));
        boardTest1.click();
        Thread.sleep(2000);
    }


    @Test
    public void createListPositive() throws InterruptedException {
                //Quantity of lists before
        System.out.println("List quantity before: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
                //Add list
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
        Thread.sleep(2000);
                 //Quantity of lists after
        System.out.println("List quantity after: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());

    }

    @Test
    public void createAndDeleteListPositive() throws InterruptedException {
            //Quantity of lists before
        driver.manage().window().fullscreen();
        System.out.println("List quantity before: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
             //Button Add list
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
        Thread.sleep(2000);
            //Open list actions
        WebElement listActions = driver.findElement(By.cssSelector("div.chrome.chrome-85.windows.body-custom-board-background.body-dark-board-background.body-board-view:nth-child(1) div.BfrybzRYI4wt4w:nth-child(1) div._1gjOnviSVp-BXI:nth-child(2) main._2-ZL0JUhEcuafN:nth-child(2) div.board-wrapper div.board-main-content div.board-canvas div.u-fancy-scrollbar.js-no-higher-edits.js-list-sortable.ui-sortable div.js-list.list-wrapper:nth-child(2) div.list.js-list-content div.list-header.js-list-header.u-clearfix.is-menu-shown div.list-header-extras > a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-sm.icon-overflow-menu-horizontal"));
        listActions.click();
        Thread.sleep(2000);
            //Archive this list
        WebElement archiveList = driver.findElement(By.cssSelector("div.chrome.chrome-85.windows.body-custom-board-background.body-dark-board-background.body-board-view:nth-child(1) div.pop-over.is-shown:nth-child(4) div.no-back div.pop-over-content.js-pop-over-content.u-fancy-scrollbar.js-tab-parent div:nth-child(1) div:nth-child(1) ul.pop-over-list:nth-child(5) li:nth-child(1) > a.js-close-list"));
        archiveList.click();
        Thread.sleep(2000);
            //Quantity of lists after
        System.out.println("List quantity after: "+ driver.findElements(By.xpath("//div[@class='list js-list-content']")).size());
    }


}
