package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown {


    ChromeDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        driver.manage().window().maximize();
    }

    @Test
    void menu_list_1() {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        select.selectByVisibleText("Python");
    }

    @Test
    void menu_list_2() {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-2")));
        select.selectByVisibleText("TestNG");
    }

    @Test
    void menu_list_3() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-3")));
        select.selectByIndex(2);
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    void check_box() throws InterruptedException {
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='option-2']"));
        checkbox2.click();
        WebElement checkbox3 = driver.findElement(By.cssSelector("input[value='option-3']"));
        checkbox3.click();
        checkbox3.click();
        Thread.sleep(2000);
    }

    @Test
    void radio_button() throws InterruptedException {
        WebElement radio_button4 = driver.findElement(By.cssSelector("input[value='yellow']"));
        radio_button4.click();
        Thread.sleep(3000);
    }

    @AfterClass
    void closeDriver() {
        driver.close();
    }
}
