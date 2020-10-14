package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPageHelper extends PageBase {
    @FindBy(xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profileVisabiltyMenu;

    public MenuPageHelper(WebDriver driver) {
        super(driver);
    }
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileVisabiltyMenu,10);
    }

    public void openProfileVisibility() {
        profileVisabiltyMenu.click();
    }
}
