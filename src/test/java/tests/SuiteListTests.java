package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.PropertyReader;
import static tests.LoginTest.*;
import static tests.ProjectsListTest.*;

public class SuiteListTests extends BaseTest {

    public static String SUITE_NAME = PropertyReader.getProperty("suiteName");

    @Test(description = "Create suite and check suite name")
    public void createSuiteTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(SUITE_NAME);
        projectPage.checkExistSuiteNameVisible();
    }

    @Test(description = "Delete suite test and check text")
    public void deleteSuiteTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(SUITE_NAME);
        suiteSteps.deleteSuiteAndCheckMessage();
    }
}