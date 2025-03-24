package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$x;
import static tests.LoginTest.*;

public class ProjectsListTest extends BaseTest {

    public static String PROJECT_NAME = PropertyReader.getProperty("Project");
    public static String PROJECT_DESCRIPTION = PropertyReader.getProperty("This is description.");
    private static final SelenideElement CREATE_NEW_SUITE = $x("//*[text()='Create new Suite']");
    private static final SelenideElement TABLE = $x("//table");


    @Test
    public void createProjectTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.
                createProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        CREATE_NEW_SUITE.shouldBe(Condition.visible);
    }

    @Test
    public void checkProjectNameTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        Assert.assertEquals(projectsListPage.getExistProjectName(), "Olga");
    }

    @Test
    public void deleteProjectTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.deleteExistProject();
        TABLE.shouldBe(Condition.disappear);
    }
}

