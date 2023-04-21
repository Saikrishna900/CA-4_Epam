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
        select.selectByVisibleText("SQL");
    }

    @Test
    void menu_list_2() {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-2")));
        select.selectByVisibleText("JUnit");
    }

    @Test
    void menu_list_3() throws InterruptedException {
        Select select = new Select(driver.findElement(By.id("dropdowm-menu-3")));
        select.selectByVisibleText("JQuery");
        Thread.sleep(2000);
    }

    @Test
    void check_box() throws InterruptedException {
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='option-1']"));
        checkbox1.click();
        WebElement uncheckbox3 = driver.findElement(By.cssSelector("input[value='option-3']"));
        uncheckbox3.click();
        WebElement checkbox4 = driver.findElement(By.cssSelector("input[value='option-4']"));
        checkbox4.click();
        Thread.sleep(2000);
    }

    @Test
    void radio_button() throws InterruptedException {
        WebElement radio_button4 = driver.findElement(By.cssSelector("input[value='purple']"));
        radio_button4.click();
        Thread.sleep(3000);
    }

    @AfterClass
    void closeDriver() {
        driver.close();
    }
}
