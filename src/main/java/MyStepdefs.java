import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyStepdefs {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "email")
    private static WebElement emailOption;
    @FindBy(name = "password")
    private static WebElement passwordOption;
    @FindBy(xpath = "//button[text() ='Sign in']")
    private static WebElement signInButton;
    @FindBy(xpath = "//span[text() ='Registration']")
    private static WebElement registrationRef;
    @FindBy(xpath = "//div//span[text() = 'Email or password is not valid']")
    private static WebElement errorMessageSignIn;
    @FindBy(xpath = "//div//h1[text() = 'Registration']")
    private static WebElement registrationFormName;
    @FindBy(name = "firstName")
    private static WebElement firstNameRegForm;
    @FindBy(name = "lastName")
    private static WebElement lastNameRegForm;
    @FindBy(name = "dateOfBirth")
    private static WebElement dateOfBirthRegForm;
    @FindBy(name = "email")
    private static WebElement emailRegForm;
    @FindBy(name = "password")
    private static WebElement passwordRegForm;
    @FindBy(name = "passwordConfirmation")
    private static WebElement passwordConfirmationRegForm;
    @FindBy(xpath = "//button[text() ='Submit']")
    private static WebElement submitButton;
    @FindBy(xpath = "//span[text() ='Sing in']")
    private static WebElement singInRef;
    @FindBy(xpath = "//div//h1[text() = 'Sign In']")
    private static WebElement signInFormName;
    @FindBy(xpath = "//div//span[text() = 'Required']")
    private static WebElement errorMessageRegistration;
    @FindBy(xpath = "//div//div//span[text() = 'Passwords must match']")
    private static WebElement errorMessagePasswordReg;
    @FindBy(xpath = "//div//div//span[text() = 'Minimum 8 characters']")
    private static WebElement errorMessageLengthPasswordReg;
    @FindBy(xpath = "//div//span[text() = 'Invalid email address']")
    private static WebElement errorMessageWrongEmailReg;
    @FindBy(xpath = "//div//div[text() = 'olga@mail.ru']")
    private static WebElement emailInSystem;
    public String getEmailFromSystemPage() {
        return wait.until(ExpectedConditions.visibilityOf(emailInSystem)).getText();
    }
    public String getErrorMessageWrongEmailReg() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageWrongEmailReg)).getText();
    }
    public String getErrorMessageSignIn() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageSignIn)).getText();
    }
    public String getRegistrationFormName() {
        return wait.until(ExpectedConditions.visibilityOf(registrationFormName)).getText();
    }
    @Given("Set up driver")
    public void set_up_driver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @When("Open Login page")
    public void open_login_page() {
        driver.get("https://qa-course-01.andersenlab.com/login");
    }

    @And("Set correct email")
    public void set_correct_email() {
        emailOption.sendKeys("olga@mail.ru");
    }

    @And("Set correct password")
    public void set_correct_password() {
        passwordOption.sendKeys("olgaOlga");
    }

    @And("Click Sign In button")
    public void click_signIn_button() {
        signInButton.click();
    }

    @Then("User is in system")
    public void user_is_in_system() {
        Assert.assertEquals(getEmailFromSystemPage(), "olga@mail.ru");
    }

    @When("Open Registration page")
    public void openRegistrationPage() {
        driver.get("https://qa-course-01.andersenlab.com/registration");
    }

    @And("Set correct first name")
    public void setCorrectFirstName() {
        firstNameRegForm.sendKeys("Olga");
    }

    @And("Set correct last name")
    public void setCorrectLastName() {
        lastNameRegForm.sendKeys("Ivanova");
    }

    @And("Set correct date of birth")
    public void setCorrectDateOfBirth() {
        dateOfBirthRegForm.sendKeys("01/05/2000");
    }

    @And("Click email registration")
    public void clickLastNameRegistration() {
        emailRegForm.click();
    }

    @And("Set incorrect email by registration")
    public void setIncorrectEmailByRegistration() {
        emailRegForm.sendKeys("ольга@mail.ru");
    }

    @And("Set correct password by registration")
    public void setCorrectPasswordByRegistration() {
        passwordRegForm.sendKeys("55555555");
    }

    @And("Set correct password confirmation by registration")
    public void setCorrectPasswordConfirmationByRegistration() {

        passwordConfirmationRegForm.sendKeys("55555555");
    }

    @Then("Check error message wrong email registration")
    public void checkErrorMessageWrongEmailRegistration() {
        Assert.assertEquals(getErrorMessageWrongEmailReg(), "Invalid email address");
    }

    @And("Set incorrect email")
    public void setIncorrectEmail() {
        emailOption.sendKeys("ola@mail.ru");
    }

    @Then("Check error message Sign In")
    public void checkErrorMessageSignIn() {
        Assert.assertEquals(getErrorMessageSignIn(), "Email or password is not valid");
    }

    @And("click registration ref")
    public void clickRegistrationRef() {
        registrationRef.click();
    }

    @Then("check registration form name")
    public void checkRegistrationFormName() {
        Assert.assertEquals(getRegistrationFormName(), "Registration");
    }
    @And("Driver quit")
    public void driverQuit() {
        driver.quit();
    }
}
