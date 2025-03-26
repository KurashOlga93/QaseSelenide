package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$x;

public class NewProjectModalPage extends ProjectsListPage {

    private static final SelenideElement CREATE_PROJECT_BUTTON = $x("//button[@type='submit']");

    public NewProjectModalPage isOpened(){
        CREATE_PROJECT_BUTTON.shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage fillProjectsForm(String name,String code, String description) {
        isOpened();
        wait.until(ExpectedConditions.visibilityOf(CREATE_PROJECT_BUTTON));
        new Input("project-name").writeToProjectsField(name);
        new Input("project-code").clear();
        new Input("project-code").writeToProjectsField(code);
        new Input("description-area").write(description);
        new Button().click(CREATE_PROJECT_BUTTON);
        return new ProjectPage();
    }
}
