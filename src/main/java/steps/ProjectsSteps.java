package steps;

import io.qameta.allure.Step;
import pages.NewProjectModalPage;
import pages.ProjectPage;
import pages.ProjectsListPage;

public class ProjectsSteps extends BaseSteps {

    ProjectsListPage projectsListPage;
    NewProjectModalPage newProjectModalPage;
    ProjectPage projectPage;

    public ProjectsSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.newProjectModalPage = new NewProjectModalPage();
        this.projectPage = new ProjectPage();
    }

    @Step("Create new project")
    public void createProject(String name, String description) {
        projectsListPage.openCreateProjectModal();
        newProjectModalPage.fillProjectsForm(name, description);
    }
}
