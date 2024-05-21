package Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.*;

public class ProductPage{

public static String formalshoes_xpath = "/html/body/div[2]//h2[@class='FormalShoesTitle']";
public static String sportshoes_xpath = "/html/body/div[3]//h2[@class='SportsShoesTitle']";
public static String sneakers_xpath = "/html/body/div[4]//h2[@class='SneakerShoesTitle']";

public static String formalshoes_dropdown = "/html/body/div[2]//i[@class='fa fa-angle-double-down formalshoedropdown']";
public static String sportshoes_dropdown = "/html/body/div[3]//i[@class='fa fa-angle-double-down sportsshoedropdown']";
public static String sneakers_dropdown = "/html/body/div[4]//i[@class='fa fa-angle-double-down sneakershoedropdown']";

public static String formalfirst_table = "/html/body/div[2]/table//td[.='   Classic Cheltenham']";
public static String sportsfirst_table = "/html/body/div[3]/table//td[.='   Ultimate']";
public static String sneakersfirst_table = "/html/body/div[4]/table//td[.='   Archivo']";


    public static void formalshoes_getTitle() throws IOException {
        String ExpectedTitle = "Formal Shoes";
        String actualTitle = driver.findElement(By.cssSelector(".FormalShoesTitle")).getText();
        Assert.assertEquals(ExpectedTitle,  actualTitle);
        if(ExpectedTitle.equals(actualTitle)){
            test.log(Status.PASS, "Test passed for title verification");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+ "Test Passed");
        } else if (false) {
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
    }
    public static void sportshoes_getTitle(){
        String ExpectedTitle = "Sports Shoes";
        String actualTitle = driver.findElement(By.cssSelector(".SportsShoesTitle")).getText();
        Assert.assertEquals(ExpectedTitle,  actualTitle);
    }

    public static void sneakers_getTitle(){
        String ExpectedTitle = "Sneakers";
        String actualTitle = driver.findElement(By.cssSelector(".SneakerShoesTitle")).getText();
        Assert.assertEquals(ExpectedTitle,  actualTitle);
    }

    public static void formal_dropdownclick(){
        String expectedformalname = "   Classic Cheltenham";
        driver.findElement(By.xpath(formalshoes_dropdown)).click();
        String actualformalname = driver.findElement(By.xpath(formalfirst_table)).getText();
        Assert.assertEquals(expectedformalname, actualformalname);

    }
    public static void sports_dropdownclick(){
        String expectedsportsname = "   Ultimate";
        driver.findElement(By.xpath(sportshoes_dropdown)).click();
        String actualsportsname = driver.findElement(By.xpath(sportsfirst_table)).getText();
        Assert.assertEquals(expectedsportsname, actualsportsname);
    }
    public static void sneakers_dropdownclick(){
        String expectedsneakername = "   Archivo";
        driver.findElement(By.xpath(sneakers_dropdown)).click();
        String actualsneakername = driver.findElement(By.xpath(sneakersfirst_table)).getText();
        Assert.assertEquals(expectedsneakername, actualsneakername);
    }
}