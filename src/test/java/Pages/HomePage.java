package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {
    public static String hamburger_menu_xpath = "//*[@id='menuToggle']/input";
    public static String onlineproducts_link = "//*[@id=\"menu\"]/a[3]/li";

    public static void click_hamburger_menu() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();

    }

    public static void click_orderproducts_link() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(onlineproducts_link)).click();

    }

}
