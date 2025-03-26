package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Input {

    String label;

    public String inputLocator = "//*[@name='%s']";
    public String inputCreateProjectLocator = "//*[@id='%s']";
    public String textAreaTestCaseLocator = "//*[contains(text(), '%s')]/parent::div//*[contains(@class, 'ProseMirror toastui-editor-contents')]";
    private String inputCaseStepLocator = "//*[contains(@class, 'toastui-editor-ww-container')]//*[contains(text(), '%s')]";


    public Input(String label) {
        this.label = label;
    }

    public Input write(String text) {
        $x(String.format(inputLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeForInputCaseStep(String text) {
        $x(String.format(inputCaseStepLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeForTextareaForTestCase(String text) {
        $x(String.format(textAreaTestCaseLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input writeToProjectsField(String text) {
        $x(String.format(inputCreateProjectLocator, label)).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public Input clear() {
        SelenideElement element = $x(String.format(inputCreateProjectLocator, label));
        element.click();
        element.clear();
        return this;
    }
}