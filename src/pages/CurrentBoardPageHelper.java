package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrentBoardPageHelper extends PageBase{
    String boardName;

    public CurrentBoardPageHelper(WebDriver driver, String boardName) {
        super(driver);
        this.boardName = boardName;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.id("workspaces-preamble-board-header-button"),15);
        waitUntilElementIsPresent(By.tagName("h1"),10);
    }

    public String getCurrentBoardHeader(){
        return driver.findElement(By.tagName("h1")).getText();
    }

    public boolean isCorrectCurrentBoard() {
        return driver.findElement(By.tagName("h1")).getText().equals(this.boardName);
    }
}
