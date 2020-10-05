package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.CurrentBoardPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;


public class CurrentBoardTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa7currentBoard;
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests()  {
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        homePage = new HomePageHelper(driver);
        qaHaifa7currentBoard = new CurrentBoardPageHelper(driver,"QA Haifa7");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoardPage("QA Haifa7");
        qaHaifa7currentBoard.waitUntilPageIsLoaded();
    }


    @Test
    public void isCorrectCurrentBoard(){
        Assert.assertEquals(qaHaifa7currentBoard.getCurrentBoardHeader(),"QA Haifa7",
                "The header of the screen is not 'QA Haifa7'");
    }

    @Test
    public void isCorrectCurrentBoard2(){
        Assert.assertTrue(qaHaifa7currentBoard.isCorrectCurrentBoard(),
                "The header of the screen is not 'QA Haifa7'");
    }

    @Test
    public void createListPositive()  {

        System.out.println("Lists quantity before: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());
        //Press 'Add list' or 'Add another list'
        WebElement addListButton = driver.findElement(By.xpath("//span[@class='placeholder']"));
        addListButton.click();
        //Fill the name of new list and submit it
        WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
        addNamelistField.click();
        addNamelistField.clear();
        addNamelistField.sendKeys("test");
        WebElement submitNewList = driver.findElement(By.xpath("//input[@type='submit']"));
        submitNewList.click();
        //Cancel the new adding list control
        WebElement xButton = driver.findElement(By.cssSelector("a.icon-close.dark-hover"));
        xButton.click();
        System.out.println("Lists quantity after: " + driver
                .findElements(By.xpath("//div[@class = 'list js-list-content']"))
                .size());

    }

    @Test
    public void putAnyListToArchive()  {

        //If there are no lists create the new list
        WebElement addListButton = driver.findElement(By.cssSelector("a.open-add-list"));
        System.out.println("Text on the button: " + addListButton.getText());
        if (addListButton.getText().equals("Add a list")){
            addListButton.click();
            waitUntilElementIsClickable(By.xpath("//input[@type='submit']"),5);
            //Fill the name of new list and submit it
            WebElement addNamelistField = driver.findElement(By.xpath("//input[@name='name']"));
            addNamelistField.click();
            addNamelistField.clear();
            addNamelistField.sendKeys("test");
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