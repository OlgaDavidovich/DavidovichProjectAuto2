package lesson15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskThree {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");

        WebElement element1;
        WebElement element2;

        element1 = driver.findElement(By.xpath("//button[@type = 'submit']"));
        element2 = driver.findElement(By.xpath("//a[@title = 'Women']"));

        TaskThree.compareByY(element1, element2);
        TaskThree.compareByX(element1, element2);
        TaskThree.compareBySize(element1, element2);
    }

    public static void compareByY(WebElement element1, WebElement element2) {

        if (element1.getLocation().y == element2.getLocation().y) {
            System.out.println("The elements are at the same height");
        } else if (element1.getLocation().y < element2.getLocation().y) {
            System.out.println("element 1 is higher then element 2");
        } else {
            System.out.println("element 2 is higher then element 1");
        }
    }

    public static void compareByX(WebElement element1, WebElement element2) {

        if (element1.getLocation().x == element2.getLocation().x) {
            System.out.println("The elements are on the same level");
        } else if (element1.getLocation().x < element2.getLocation().x) {
            System.out.println("element 1 is to the left of the element 2");
        } else {
            System.out.println("element 2 is to the left of the element 1");
        }
    }

    public static void compareBySize(WebElement element1, WebElement element2) {

        int size1 = element1.getSize().getHeight() * element1.getSize().getWidth();
        int size2 = element2.getSize().getHeight() * element2.getSize().getWidth();
        if (size1 == size2) {
            System.out.println("The elements are the same");
        } else if (size1 > size2) {
            System.out.println("The element 1 is bigger than element 2");
        } else {
            System.out.println("The element 2 is bigger than element 1");
        }
    }
}

