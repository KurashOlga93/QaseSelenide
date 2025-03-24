package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends BaseTest {

    public static String USER = PropertyReader.getProperty("user");
    public static String PASSWORD = PropertyReader.getProperty("password");
    public static String LOGIN_URL = PropertyReader.getProperty("loginUrl");

    private static final SelenideElement PROJECTS_TITLE = $x("//h1[text()='Projects']");

    @Test
    public void successLogin() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        PROJECTS_TITLE.shouldBe(Condition.visible);
    }
}