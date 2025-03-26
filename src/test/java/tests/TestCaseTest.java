package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import static tests.LoginTest.*;
import static tests.ProjectsListTest.*;

public class TestCaseTest extends BaseTest {

    public static String CASE_NAME = PropertyReader.getProperty("caseName");
    public static String CASE_DESCRIPTION = PropertyReader.getProperty("caseDescription");
    public static String CASE_PRECONDITION = PropertyReader.getProperty("casePreCondition");
    public static String CASE_POSTCONDITION = PropertyReader.getProperty("casePostCondition");

    @Test(description = "Create new test case")
    public void createTestCase() {
        projectsSteps.loginAndCreateProject(USER, PASSWORD, LOGIN_URL, PROJECT_NAME, PROJECT_CODE, PROJECT_DESCRIPTION);
        projectPage.openTestCasePage();
        testCasePage.fillTestCaseForm(CASE_NAME, CASE_DESCRIPTION, CASE_PRECONDITION, CASE_POSTCONDITION);
        Assert.assertEquals(projectPage.getExistCaseName(), "New test case");
        projectsSteps.deleteProjectEndStep();
    }
}
