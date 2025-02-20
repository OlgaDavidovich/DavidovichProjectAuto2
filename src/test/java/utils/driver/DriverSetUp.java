package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {
    private static WebDriver driver;

    private static WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getInstance() {
        if (driver == null) {
            try {
                driver = setUpDriver();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return driver;
    }

    public static WebDriver driverInit() {
        driver = getInstance();
        return driver;
    }
}
