package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import static tests.LoginTest.*;

public class SuiteListTests extends ProjectsListTest {

    public static String SUITE_NAME = PropertyReader.getProperty("suiteName");

    @Test(description = "Create suite and check suite name")
    public void createSuiteTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(SUITE_NAME);
        Assert.assertEquals(projectPage.getExistSuiteName(), "My first suite");
    }

    @Test(description = "Delete suite test and check text")
    public void deleteSuiteTest() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(SUITE_NAME);
        projectPage.deleteExistSuite();
        String noSuitesText = projectPage.getNoSuitesText();
        Assert.assertEquals(noSuitesText, "Looks like you don’t have any suites and cases yet.");
    }
}