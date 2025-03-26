package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.NewProjectModalPage;
import pages.ProjectPage;
import pages.ProjectsListPage;

public class ProjectsSteps {

    ProjectsListPage projectsListPage;
    NewProjectModalPage newProjectModalPage;
    ProjectPage projectPage;
    LoginPage loginPage;

    public ProjectsSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectPage = new ProjectPage();
        this.loginPage = new LoginPage();
    }

    @Step("Create new project")
    public void createProject(String name, String code, String description) {
        projectsListPage.openCreateProjectModal();
        newProjectModalPage.fillProjectsForm(name, code, description);
    }

    @Step("Login and create project")
    public void loginAndCreateProject(String email, String password, String url, String name, String code, String description) {
        loginPage
                .openLoginPage(url)
                .login(email, password)
                .isOpened();
        projectsListPage.openCreateProjectModal();
        newProjectModalPage.fillProjectsForm(name, code, description);
    }

    @Step("Delete project after test")
    public void deleteProjectAfterTestStep() {
        projectPage.clickHeaderProjectsButton();
        if (projectsListPage.isProjectExist()) {
            projectsListPage.deleteExistProject();
        }
    }
}