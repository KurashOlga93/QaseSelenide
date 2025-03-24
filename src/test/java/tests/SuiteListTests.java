package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$x;
import static tests.LoginTest.*;

public class SuiteListTests extends ProjectsListTest {

    public static String SUITE_NAME = PropertyReader.getProperty("suiteName");
    private static final SelenideElement SUITE_TEXT = $x("//*[text()='Suites']");
    private static final SelenideElement NO_CASES_TEXT = $x("//*[text()='Looks like you don’t have any suites and cases yet.']");

    @Test
    public void createSuiteTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createProject(PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        projectPage.openNewSuiteModalPage();
        newSuiteModalPage.fillSuiteForm(SUITE_NAME);
        SUITE_TEXT.shouldBe(Condition.visible);
    }

    @Test
    public void checkSuiteNameTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openExistProject();
        Assert.assertEquals(projectPage.getExistSuiteName(), "My first suite");
    }

    @Test
    public void deleteSuiteTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openExistProject();
        projectPage.deleteExistSuite();
        NO_CASES_TEXT.shouldBe(Condition.visible);
    }
}