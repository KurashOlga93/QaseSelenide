package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static tests.LoginTest.*;

public class ProjectsListTest extends BaseTest {

    public static String PROJECT_NAME = PropertyReader.getProperty("projectName");
    public static String PROJECT_DESCRIPTION = PropertyReader.getProperty("projectDescription");
    public static String PROJECT_CODE = PropertyReader.getProperty("projectCode");

    @Test(description = "Create project and check button on Project page")
    public void createProjectTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.
                createProject(PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        Assert.assertEquals(projectPage.checkCreateSuiteButton(), "Create new suite");
    }

    @Test(description = "Create project and check project name")
    public void checkProjectNameTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        projectsSteps.checkProjectNameVisible();
    }

    @Test(description = "Create project, delete created project and check message")
    public void deleteProjectTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        projectsSteps.deleteProjectAndCheckText();
    }
}