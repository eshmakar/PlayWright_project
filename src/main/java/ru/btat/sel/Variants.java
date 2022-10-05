package ru.btat.sel;

import com.microsoft.playwright.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Variants {
    public static List<String> arg = new ArrayList<>() {{
        add("--no-sandbox");
        add("--disable-gpu-sandbox");
    }};
    public static List<String> words;

    public static void main(String[] args) throws InterruptedException, IOException {
        words = Files.readAllLines(Paths.get("things.txt"));
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setArgs(arg).setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://avito.ru");


            for (String word : words) {

                page.fill("//input[@data-marker='search-form/suggest']", word);
                System.out.println(word);
                Thread.sleep(1000);
                int i = 0;

                while (true) {
                    try {
                        String content = page.querySelector(String.format("//li[@id='downshift-0-item-%d']", i++)).textContent();
//                        elementHandles.forEach(ElementHandle::textContent);
                        System.out.println(content);
                    } catch (NullPointerException nullPointerException) {
                        System.err.println("_____________");
                        break;
                    }
                }

            }


        }
    }
}
