package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new suite']");

    public NewSuiteModalPage openNewSuiteModalPage() {
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_SUITE));
        new Button().click(CREATE_NEW_SUITE);
        return new NewSuiteModalPage();
    }
}
