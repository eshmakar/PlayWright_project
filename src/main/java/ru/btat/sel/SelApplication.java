package ru.btat.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelApplication {
    public static void main2(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu-sandbox");
//        options.addArguments("--headless");


        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://avito.ru");

//              //div/i/img[@src='https://www.avito.st/s/common/components/monetization/icons/web/x20_7.svg']

        WebElement search = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        search.click();

        search.sendKeys("note");

        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

}
