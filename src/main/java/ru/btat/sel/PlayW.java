package ru.btat.sel;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlayW {
    public static void main2(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<String> arg = new ArrayList<>() {{
            add("--no-sandbox");
            add("--disable-gpu-sandbox");
        }};
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(arg).setHeadless(false));

//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(arg).setHeadless(false).setSlowMo(50));
//            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://avito.ru");
//            page.click("#downshift-1-input");
            page.fill("#downshift-1-input", "iphone");
            System.out.println();

            System.err.println(page.evaluate("#downshift-1-item-3"));
//            page.keyboard().press("Enter");
            page.mouse().move(200,250);
            page.keyboard().press("Control+U");
            Thread.sleep(15000);

        //  page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("avito.png")));
            String title = page.title();
            long stop = System.currentTimeMillis();
            System.err.println(title + " - " + (stop-start));

        }
    }
}























