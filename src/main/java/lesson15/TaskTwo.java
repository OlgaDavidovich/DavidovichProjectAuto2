package lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TaskTwo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ArrayList<String> pages = new ArrayList<>();
        String page1 = "http://www.automationpractice.pl/index.php";
        String page2 = " https://zoo.waw.pl/";
        String page3 = "https://www.w3schools.com/";
        String page4 = "https://www.clickspeedtester.com/click-counter/";
        String page5 = "https://andersenlab.com/";
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);
        pages.add(page5);

        for (String s : pages) {
            driver.get(s);
            if (pages.indexOf(s) != pages.size() - 1) {
                driver.switchTo().newWindow(WindowType.WINDOW);
            }
        }
        for (String s : pages) {
            driver.navigate().to(s);
            String x = driver.getTitle();
            System.out.println(x);
            System.out.println(driver.getCurrentUrl());
            if (x.contains("Zoo")) {
                driver.close();
            }
        }
    }
}


