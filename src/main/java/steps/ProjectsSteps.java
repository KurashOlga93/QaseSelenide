package steps;

import io.qameta.allure.Step;
import pages.NewProjectModalPage;
import pages.ProjectPage;
import pages.ProjectsListPage;

public class ProjectsSteps {

    ProjectsListPage projectsListPage;
    NewProjectModalPage newProjectModalPage;
    ProjectPage projectPage;
    LoginSteps loginSteps;

    public ProjectsSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectPage = new ProjectPage();
        this.loginSteps = new LoginSteps();
    }

    @Step("Create new project")
    public void createProject(String name, String code, String description) {
        projectsListPage.openCreateProjectModal();
        newProjectModalPage.fillProjectsForm(name, code, description);
    }
}