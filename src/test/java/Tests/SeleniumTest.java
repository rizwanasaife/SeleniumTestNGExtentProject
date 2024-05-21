package Tests;

import Pages.HomePage;
import Pages.ProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

public class SeleniumTest {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        HomePage.click_hamburger_menu();
        HomePage.click_orderproducts_link();
    }

    public static String capture(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\hp\\IdeaProjects\\SeleniumTestNGExtent\\src\\test\\java\\Tests" + System.currentTimeMillis() + ".png");
        String errfilepath = dest.getAbsolutePath();
        FileUtils.copyFile(srcfile,dest);
        return errfilepath;
    }

    @Test
    void validateTitles() throws InterruptedException, IOException {
        test = extent.createTest("Validate shoe titles", "Validate shoes titles are correct");
        ProductPage.formalshoes_getTitle();
        ProductPage.sportshoes_getTitle();
        ProductPage.sneakers_getTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalshoes() throws InterruptedException {
        test = extent.createTest("Validate formal shoe titles", "Validate formal shoes titles are correct");

        ProductPage.formal_dropdownclick();
    }
    @Test
    void validateSportsshoes() throws InterruptedException {
        test = extent.createTest("Validate sports shoe titles", "Validate sports shoes titles are correct");

        ProductPage.sports_dropdownclick();
    }

    @Test
    void validateSneakershoes() throws InterruptedException {
        test = extent.createTest("Validate sneaker shoe titles", "Validate sneaker shoes titles are correct");

        ProductPage.sneakers_dropdownclick();
    }

    @AfterSuite
    public static void cleanUp(){
        extent.flush();
    }

}
