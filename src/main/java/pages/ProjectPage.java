package pages;

import com.codeborne.selenide.Condition;
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
    private static final SelenideElement NO_SUITES_TEXT = $x("//*[text()='Looks like you don’t have any suites and cases yet.']");
    private static final SelenideElement PROJECTS_HEADER_BUTTON = $x("//a[text()='Projects']");
    private static final SelenideElement NEW_TEST_BUTTON = $x("//*[text()='New test']");
    private static final SelenideElement EXIST_CASE_NAME = $x("//*[text()='New test case']");
    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");



    public NewSuiteModalPage openNewSuiteModalPage() {
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_SUITE));
        new Button().click(CREATE_NEW_SUITE);
        return new NewSuiteModalPage();
    }

    public TestCasePage openTestCasePage() {
        wait.until(ExpectedConditions.visibilityOf(NEW_TEST_BUTTON));
        new Button().click(NEW_TEST_BUTTON);
        return new TestCasePage();
    }

    public ProjectsListPage clickHeaderProjectsButton() {
        PROJECTS_HEADER_BUTTON.click();
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_PROJECT));
        return new ProjectsListPage();
    }

    public ProjectPage checkMessageNoSuitesAndCases() {
       NO_SUITES_TEXT.shouldBe(Condition.visible);
       return new ProjectPage();
    }

    public ProjectPage checkExistSuiteNameVisible() {
        SUITE_NAME.shouldBe(Condition.visible);
        return new ProjectPage();
    }

    public ProjectPage checkExistCaseNameVisible() {
        EXIST_CASE_NAME.shouldBe(Condition.visible);
        return new ProjectPage();
    }

    public ProjectPage deleteExistSuite() {
        OPTION_BUTTON.click();
        DELETE_BUTTON.click();
        SUBMIT_DELETE_BUTTON.click();
        return new ProjectPage();
    }

    public String checkCreateSuiteButton() {
        return CREATE_NEW_SUITE.getText();
    }
}