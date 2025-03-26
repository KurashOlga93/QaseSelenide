package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Dropdown;
import elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class TestCasePage extends BasePage {

    private static final SelenideElement SAVE_CASE_BUTTON = $x("//*[@id='save-case']");
    private static final SelenideElement ADD_STEP_BUTTON = $x("//*[@type='button']//*[text()=' Add step']");
    private static final SelenideElement STEP_ACTION_INPUT = $x("(//*[@class = 'OwrMko']//*[contains(@class, 'ProseMirror toastui-editor-contents')])[1]");
    private static final SelenideElement DATA_INPUT = $x("(//*[@class = 'OwrMko']//*[contains(@class, 'ProseMirror toastui-editor-contents')])[2]");
    private static final SelenideElement EXPECTED_RESULT_INPUT = $x("(//*[@id='expected_result']");

    public ProjectPage fillTestCaseForm(String name, String description, String precondition, String postcondition) {
        new Input("title").write(name);
        new Input("Description").writeForTextareaForTestCase(description);
        new Input("Pre-conditions").writeForTextareaForTestCase(precondition);
        new Input("Post-conditions").writeForTextareaForTestCase(postcondition);
        new Dropdown("Status").dropdownSelectOption("Draft");
        new Dropdown("Severity").dropdownSelectOption("Major");
        new Dropdown("Priority").dropdownSelectOption("High");
        new Dropdown("Priority").dropdownSelectOption("High");
        new Dropdown("Type").dropdownSelectOption("Smoke");
        new Dropdown("Layer").dropdownSelectOption("API");
        new Button().click(ADD_STEP_BUTTON);
        STEP_ACTION_INPUT.setValue("First action");
        new Button().click(SAVE_CASE_BUTTON);
        return new ProjectPage();
    }
}