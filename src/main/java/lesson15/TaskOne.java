package lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskOne {

    public static void main(String[] args) throws InterruptedException {
        TaskOne.testOne();
        TaskOne.testTwo();
        TaskOne.testThree();
        TaskOne.testFour();
    }
    public static void testOne() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        driver.findElement(By.name("password")).sendKeys("olgaOlga");
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
    }
    public static void testTwo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        driver.findElement(By.name("password")).sendKeys("tomTomTom");
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
    }
    public static void testThree() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text() ='Registration']")).click();
    }
    public static void testFour() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/registration");
        Thread.sleep(2000);
        // driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        //  driver.findElement(By.name("password")).sendKeys("tomTomTom");
        driver.findElement(By.xpath("//span[text() ='Sing in']")).click();
    }
}
