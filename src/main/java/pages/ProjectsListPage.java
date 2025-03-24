package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {

    private static final SelenideElement CREATE_NEW_PROJECT = $x("//*[text()='Create new project']");
    private static final SelenideElement PROJECT_NAME = $x("//a[text()='Olga']");
    private static final SelenideElement OPTIONS_BUTTON = $x("//*[@data-icon='ellipsis-vertical']");
    private static final SelenideElement REMOVE_BUTTON = $x("//*[@data-testid='remove']");
    private static final SelenideElement DELETE_PROJECT_BUTTON = $x("//*[@type='button']//*[text()='Delete project']");

    public ProjectsListPage isOpened() {
        wait.until(ExpectedConditions.visibilityOf(CREATE_NEW_PROJECT));
        return this;
    }

    public ProjectPage openExistProject() {
        isOpened();
        PROJECT_NAME.click();
        return new ProjectPage();
    }

    public NewProjectModalPage openCreateProjectModal() {
        isOpened();
        new Button().click(CREATE_NEW_PROJECT);
        return new NewProjectModalPage();
    }

    public String getExistProjectName() {
        isOpened();
        return PROJECT_NAME.getText();
    }

    public ProjectsListPage deleteExistProject() {
        isOpened();
        OPTIONS_BUTTON.click();
        REMOVE_BUTTON.click();
        DELETE_PROJECT_BUTTON.click();
        return new ProjectsListPage();
    }
}