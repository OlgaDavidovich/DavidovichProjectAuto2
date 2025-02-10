import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TaskTwo {

    @Test
    public void practiceDAD() throws InterruptedException {

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[text() = 'Drag & Drop']"))).click();

        actions.clickAndHold(driver.findElement(By.id("manual1")))
                .moveToElement(driver.findElement(By.xpath("//section[@class = 'flex-1']//div//div[@id = 'target-manual1']")))
                .release()
                .build()
                .perform();

       actions.dragAndDrop(driver.findElement(By.id("manual2")), driver.findElement(By.xpath("//section[@class = 'flex-1']//div//div[@id = 'target-manual2']")))
                .perform();
       Thread.sleep(1000);

       actions.dragAndDrop(driver.findElement(By.id("auto1")), driver.findElement(By.id("target-auto1")))
                .perform();
        Thread.sleep(1000);
        
        actions.dragAndDrop(driver.findElement(By.id("auto2")), driver.findElement(By.id("target-auto2")))
                .perform();
    }
}
