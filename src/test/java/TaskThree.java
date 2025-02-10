import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TaskThree {

    @Test
    public void practiceAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.name("email")).sendKeys("olga@mail.ru");
        driver.findElement(By.name("password")).sendKeys("olgaOlga");
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'AQA Practice']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[text() = 'AQA Practice']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[text() = 'Actions, Alerts & Iframes']"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@title= 'Finish your registration']")));

        driver.findElement((By.xpath("//div//button[text() = 'Confirm']"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String firstAlert = alert.getText();
        Assert.assertEquals(firstAlert, "You have called alert!");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text() = 'Congratulations, you have successfully enrolled in the course!']")).getText(), "Congratulations, you have successfully enrolled in the course!");

        driver.findElement((By.xpath("//div//button[text() = 'Get Discount']"))).click();
        try {
            Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
            String secondAlert = alert2.getText();
            Assert.assertEquals(secondAlert, "Are you sure you want to apply the discount?");
            alert.accept();
            Assert.assertEquals(driver.findElement(By.xpath("//span[text() = You received a 10% discount on the second course.']")).getText(), "You received a 10% discount on the second course.");
        } catch (Exception e) {
            System.out.println("There is no alert!");
        }

        driver.findElement((By.xpath("//div//button[text() = 'Cancel course']"))).click();
        try {
            Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
            String thirdAlert = alert3.getText();
            Assert.assertEquals(thirdAlert, "Here you may describe a reason why you are cancelling your registration (or leave this field empty)");
            String inputText = "Test";
            alert.sendKeys("inputText");
            alert3.accept();
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class = 'font-light flex']")).getText().contains("Test"));
        } catch (Exception e) {
            System.out.println("There is no alert!");
        }
    }
}
