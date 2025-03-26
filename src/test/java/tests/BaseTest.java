package tests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import steps.ProjectsSteps;
import steps.SuiteSteps;

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
    protected SuiteSteps suiteSteps;
    protected TestCasePage testCasePage;

    public void initPages() {
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        projectPage = new ProjectPage();
        newProjectModalPage = new NewProjectModalPage();
        projectsListPage = new ProjectsListPage();
        newSuiteModalPage = new NewSuiteModalPage();
        suiteSteps = new SuiteSteps();
        testCasePage = new TestCasePage();
    }

    @BeforeMethod
    public void initTest() {

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
    public void endTest() {
        projectPage.clickHeaderProjectsButton();
        if (projectsListPage.isProjectExist()) {
            projectsListPage.deleteExistProject();
        }else {
            System.out.println("There is no projects.");
        }
    }
}