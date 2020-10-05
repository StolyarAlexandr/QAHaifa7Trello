package tests;

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
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
        homePage = new HomePageHelper(driver);
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void loginNegativeLoginEmpty()  {
        loginPage.loginNotAttlassian("",PASSWORD);
        loginPage.pressLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),"Missing email",
                "The text of the error message is not correct");
    }

    @Test
    public void loginNegativeLoginIncorrect()  {
        loginPage.loginNotAttlassian("Pupkin@gmail.com",PASSWORD);
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
        Assert.assertTrue(loginPage.getBoadsIconName().equals("Boards"),"The text on the button is not 'Board'");
    }



}
