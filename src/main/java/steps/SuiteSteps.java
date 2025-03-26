package steps;

import io.qameta.allure.Step;
import pages.*;

import static org.testng.CommandLineArgs.SUITE_NAME;

public class SuiteSteps {

    ProjectsListPage projectsListPage;
    NewProjectModalPage newProjectModalPage;
    ProjectPage projectPage;
    LoginPage loginPage;
    NewSuiteModalPage newSuiteModalPage;

    public SuiteSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectPage = new ProjectPage();
        this.loginPage = new LoginPage();
        this.newSuiteModalPage = new NewSuiteModalPage();
    }

    @Step("Create test suite")
    public void createSuite(String name) {
        projectPage.openNewSuiteModalPage();
        newSuiteModalPage.fillSuiteForm(SUITE_NAME);
    }
}
