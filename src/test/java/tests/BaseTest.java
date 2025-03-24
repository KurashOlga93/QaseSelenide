package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.NewProjectModalPage;
import pages.NewSuiteModalPage;
import pages.ProjectPage;
import pages.ProjectsListPage;
import steps.LoginSteps;
import steps.ProjectsSteps;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {

    protected LoginSteps loginSteps;
    protected ProjectsSteps projectsSteps;
    protected ProjectPage projectPage;
    protected NewProjectModalPage newProjectModalPage;
    protected ProjectsListPage projectsListPage;
    protected NewSuiteModalPage newSuiteModalPage;

    SoftAssert softAssert = new SoftAssert();

    public void initPages(){
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        projectPage = new ProjectPage();
        newProjectModalPage = new NewProjectModalPage();
        projectsListPage = new ProjectsListPage();
        newSuiteModalPage = new NewSuiteModalPage();
    }

    @BeforeMethod
    public  void initTest(){

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";
        initPages();
    }

    @AfterMethod
    public void endTest(){
        softAssert.assertAll();
        //getWebDriver().quit();
    }
}
