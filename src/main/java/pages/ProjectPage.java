package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new suite']");
    private static final SelenideElement OPTION_BUTTON = $x("//*[contains(@class,'fa-ellipsis-h')]");
    private static final SelenideElement DELETE_BUTTON = $x("//*[text()='Delete']");
    private static final SelenideElement SUBMIT_DELETE_BUTTON = $x("//button[@type='submit']");
    private static final SelenideElement SUITE_NAME = $x("//*[@title='My first suite']");

    public NewSuiteModalPage openNewSuiteModalPage() {
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_SUITE));
        new Button().click(CREATE_NEW_SUITE);
        return new NewSuiteModalPage();
    }

    public String getExistSuiteName() {
        return SUITE_NAME.getText();
    }

    public ProjectPage deleteExistSuite() {
        OPTION_BUTTON.click();
        DELETE_BUTTON.click();
        SUBMIT_DELETE_BUTTON.click();
        return new ProjectPage();
    }
}