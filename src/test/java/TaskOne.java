import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskOne {

    @Test
    public void searchCourse() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        driver.findElement(By.name("password")).sendKeys("olgaOlga");
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'AQA Practice']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[text() = 'AQA Practice']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[text() = 'Select']"))).click();
        Select selCountry = new Select(driver.findElement(By.xpath("//select[@title = 'Select country']")));
        selCountry.selectByVisibleText("USA");
        Select selLanguage = new Select(driver.findElement(By.xpath("//select[@title = 'Select language']")));
        selLanguage.selectByVisibleText("English");
        Select selType = new Select(driver.findElement(By.xpath("//select[@title = 'Select type']")));
        selType.selectByVisibleText("Testing");
        driver.findElement(By.xpath("//input[@title = 'Start date']")).sendKeys("17.02.2025");
        driver.findElement(By.xpath("//input[@title = 'End date']")).sendKeys("03.03.2025");
        Select selCourse = new Select(driver.findElement(By.id("MultipleSelect")));
        selCourse.selectByValue("AQA Python");
        selCourse.selectByValue("AQA Java");
        driver.findElement(By.xpath("//div//button[text() = 'Search']")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//section//h2[text() = 'Unfortunately, we did not find any courses matching your chosen criteria.']")).getText(), "Unfortunately, we did not find any courses matching your chosen criteria.");
    }
}
