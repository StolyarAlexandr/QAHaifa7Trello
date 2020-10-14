package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;

public class LoginTests extends TestBase {
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    HomePageHelper homePage;

    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        //loginPage = new LoginPageHelper(driver);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        homePage.waitUntilPageIsLoaded()
                .openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void loginNegativeLoginEmpty()  {
        loginPage.loginNotAttlassian("",PASSWORD)
                .pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),"Missing email",
                "The text of the error message is not correct");
    }

    @Test
    public void loginNegativeLoginIncorrect()  {
        loginPage.loginNotAttlassian("Pupkin@gfd.ru",PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"There isn't an account for this username",
                "The error message is not 'There isn't an account for this username'");
    }

    @Test
    public void loginNegativePasswordIncorrect()  {
        loginPage.loginAsAttlassian(LOGIN,PASSWORD+"1");
        Assert.assertTrue(loginPage.getAttlassianErrorMessage().contains("Incorrect email address and"),
                "The error message is not contains the text 'Incorrect email address and'");
    }

    @Test
    public void loginPositive()  {
        loginPage.loginAsAttlassian(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(boardsPage.getBoadsIconName().equals("Boards"),"The text on the button is not 'Board'");
    }



}
