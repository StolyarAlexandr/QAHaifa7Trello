package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPageHelper extends PageBase {

    public BoardsPageHelper(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//button[@data-test-id ='header-boards-menu-button']"),45);
    }

    public void openCurrentBoardPage(String boardNamme) {
        WebElement board = driver.findElement(By
                .xpath("//li[@class='boards-page-board-section-list-item'][.//div[@title ='" + boardNamme+"']]"));
        board.click();
    }
}
