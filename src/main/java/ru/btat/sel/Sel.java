package ru.btat.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sel {
    public static void main2(String[] args) {
        long start = System.currentTimeMillis();

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu-sandbox");
        options.addArguments("--headless");


        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://avito.ru");
        String title = driver.getTitle();
        long stop = System.currentTimeMillis();
        System.err.println(title + " - " + (stop - start));

        driver.close();
        driver.quit();

    }
}
