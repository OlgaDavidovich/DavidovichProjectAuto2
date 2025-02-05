import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaskFourDataProvider {
    @Test(dataProvider = "loginData")
    public void checkLogIn(String email, String password) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-course-01.andersenlab.com/login");
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text() ='Sign in']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    @DataProvider(name = "loginData")
    public Object[][] createData() {
        return new Object[][]{
                {"olga@mail.ru", "olgaOlga"}, {"tom@mail.ru", "tomTomTom"}, {"alina@mail.ru", "alinaAlina"}
        };
    }
}
