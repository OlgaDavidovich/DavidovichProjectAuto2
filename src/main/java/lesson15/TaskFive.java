package lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskFive {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        driver.findElement(By.name("password")).sendKeys("olgaOlga");
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
        String filePath = "C:\\Users\\Admin\\Desktop\\AQA\\foto.jpg";
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(filePath);
    }
}
