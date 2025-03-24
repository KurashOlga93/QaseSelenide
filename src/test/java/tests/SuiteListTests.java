package tests;
import org.testng.annotations.Test;
import utils.PropertyReader;
import static tests.LoginTest.*;

public class SuiteListTests extends BaseTest {

    public static String SUITE_NAME = PropertyReader.getProperty("New suite");

    @Test
    public void createSuiteTest() {
        loginSteps.
                login(USER, PASSWORD, LOGIN_URL);
        projectsListPage.openExistProject();
        projectPage.openNewSuiteModalPage();
        newSuiteModalPage.fillSuiteForm(SUITE_NAME);
    }
}
