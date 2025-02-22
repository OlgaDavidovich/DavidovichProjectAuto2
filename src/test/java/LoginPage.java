import io.qameta.allure.Step;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
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

    public String getErrorMessageSignIn() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageSignIn)).getText();
    }

    public String getErrorMessageRegistration() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageRegistration)).getText();
    }

    public String getErrorMessagePasswordReg() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessagePasswordReg)).getText();
    }

    public String getErrorMessageLengthPasswordReg() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLengthPasswordReg)).getText();
    }

    public String getErrorMessageWrongEmailReg() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageWrongEmailReg)).getText();
    }

    public String getRegistrationFormName() {
        return wait.until(ExpectedConditions.visibilityOf(registrationFormName)).getText();
    }

    public String getSignInFormName() {
        return wait.until(ExpectedConditions.visibilityOf(signInFormName)).getText();
    }

   @Step("Open Login Page")
    public LoginPage openLoginPage() {
       logger.info("Open Login Page");
        driver.get("https://qa-course-01.andersenlab.com/login");
        return this;
    }
    @Step("Open Registration Page")
    public LoginPage openRegistration() {
        logger.info("Open Registration Page");
        driver.get("https://qa-course-01.andersenlab.com/registration");
        return this;
    }
    @Step("Set Email on Login Page")
    public LoginPage setEmailLogIn(String email) {
        logger.info("Set Email on Login Page");
        emailOption.sendKeys(email);
        return this;
    }
    @Step("Set Password on Login Page")
    public LoginPage setPasswordLogIn(String password) {
        logger.info("Set Password on Login Page");
        passwordOption.sendKeys(password);
        return this;
    }
    @Step("Click Sign in Button on Login Page")
    public LoginPage clickSignInButton() {
        logger.info("Click Sign in Button on Login Page");
        signInButton.click();
        return this;
    }
    @Step("Click Registration Link on Login Page")
    public LoginPage clickRegistrationRef() {
        registrationRef.click();
        return this;
    }
    @Step("Set First Name on Registration Page")
    public LoginPage setFirstNameRegistration(String firstName) {
        logger.info("Set First Name on Registration Page");
        firstNameRegForm.sendKeys(firstName);
        return this;
    }
    @Step("Set Last Name on Registration Page")
    public LoginPage setLastNameRegistration(String lastName) {
        logger.info("Set Last Name on Registration Page");
        lastNameRegForm.sendKeys(lastName);
        return this;
    }
    @Step("Set Date Of Birth on Registration Page")
    public LoginPage setDateOfBirthRegistration(String date) {
        logger.info("Set Date Of Birth on Registration Page");
        dateOfBirthRegForm.sendKeys(date);
        return this;
    }
    @Step("Set Email on Registration Page")
    public LoginPage setEmailRegistration(String email) {
        logger.info("Set Email on Registration Page");
        emailRegForm.sendKeys(email);
        return this;
    }
    @Step("Set Password on Registration Page")
    public LoginPage setPasswordRegistration(String password) {
        logger.info("Set Password on Registration Page");
        passwordRegForm.sendKeys(password);
        return this;
    }
    @Step("Set Password Confirmation on Registration Page")
    public LoginPage setPasswordConfirmationRegistration(String passwordConf) throws InterruptedException {
        logger.info("Set Password Confirmation on Registration Page");
        passwordConfirmationRegForm.sendKeys(passwordConf);
        Thread.sleep(2000);
        return this;
    }
    @Step("Click Submit Button on Registration Page")
    public LoginPage clickSubmitButton() {
        logger.info("Click Submit Button on Registration Page");
        submitButton.click();
        return this;
    }
    @Step("Click Sign In Link on Registration Page")
    public LoginPage clickSignInRef() {
        wait.until(ExpectedConditions.elementToBeClickable(singInRef)).click();
        return this;
    }
    @Step("Click Email Form on Registration Page")
    public LoginPage clickEmailRegForm() {
        emailRegForm.click();
        return this;
    }
    @Step("Click Last Name Form on Registration Page")
    public LoginPage clickLastNameRegForm() {
        lastNameRegForm.click();
        return this;
    }
    @Step("Click Password Form on Registration Page")
    public LoginPage clickPasswordRegForm() {
        passwordRegForm.click();
        return this;
    }
    @Step("Check message if Email or password is not valid")
    public LoginPage checkErrorMessageSignIn() {
        Assert.assertEquals(getErrorMessageSignIn(), "Email or password is not valid");
        return this;
    }
    @Step("Check Registration Form Name")
    public LoginPage checkRegistrationFormName() {
        Assert.assertEquals(getRegistrationFormName(), "Registration");
        return this;
    }
    @Step("Check Sign In Form Name")
    public LoginPage checkSignInFormName() {
        Assert.assertEquals(getSignInFormName(), "Sign In");
        return this;
    }
    @Step("Check message if information is required")
    public LoginPage checkErrorMessageRegistration() {
        Assert.assertEquals(getErrorMessageRegistration(), "Required");
        return this;
    }
    @Step("Check message if password has wrong length")
    public LoginPage checkErrorMessageLengthPasswordReg() {
        Assert.assertEquals(getErrorMessageLengthPasswordReg(), "Minimum 8 characters");
        return this;
    }
    @Step("Check message if password confirmation doesn't match")
    public LoginPage checkErrorMessagePasswordReg() {
        Assert.assertEquals(getErrorMessagePasswordReg(), "Passwords must match");
        return this;
    }
    @Step("Check message if email address is invalid")
    public LoginPage checkErrorMessageWrongEmailReg() {
        Assert.assertEquals(getErrorMessageWrongEmailReg(), "Invalid email address");
        return this;
    }
}
