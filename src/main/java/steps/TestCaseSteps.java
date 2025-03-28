package steps;

import io.qameta.allure.Step;
import pages.*;

public class TestCaseSteps {

    ProjectPage projectPage;
    TestCasePage testCasePage;

    public TestCaseSteps() {
        this.projectPage = new ProjectPage();
        this.testCasePage = new TestCasePage();
    }

    @Step("Create test case and check test case name visible and correct")
    public void createCaseAndCheckCaseNameVisible(String name, String description, String precondition, String postcondition) {
        projectPage.openTestCasePage();
        testCasePage.fillTestCaseForm(name, description, precondition, postcondition);
        projectPage.checkExistCaseNameVisible();
    }
}