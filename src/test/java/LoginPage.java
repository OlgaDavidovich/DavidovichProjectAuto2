import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public LoginPage openLoginPage() {
        driver.get("https://qa-course-01.andersenlab.com/login");
        return this;
    }

    public LoginPage openRegistration() {
        driver.get("https://qa-course-01.andersenlab.com/registration");
        return this;
    }

    public LoginPage setEmailLogIn(String email) {
        emailOption.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordLogIn(String password) {
        passwordOption.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public LoginPage clickRegistrationRef() {
        registrationRef.click();
        return this;
    }
    public LoginPage setFirstNameRegistration(String firstName) {
        firstNameRegForm.sendKeys(firstName);
        return this;
    }

    public LoginPage setLastNameRegistration(String lastName) {
        lastNameRegForm.sendKeys(lastName);
        return this;
    }

    public LoginPage setDateOfBirthRegistration(String date) {
        dateOfBirthRegForm.sendKeys(date);
        return this;
    }

    public LoginPage setEmailRegistration(String email) {
        emailRegForm.sendKeys(email);
        return this;
    }

    public LoginPage setPasswordRegistration(String password) {
        passwordRegForm.sendKeys(password);
        return this;
    }

    public LoginPage setPasswordConfirmationRegistration(String passwordConf) throws InterruptedException {
        passwordConfirmationRegForm.sendKeys(passwordConf);
        Thread.sleep(2000);
        return this;
    }

    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public LoginPage clickSignInRef() {
        wait.until(ExpectedConditions.elementToBeClickable(singInRef)).click();
        return this;
    }

    public LoginPage clickEmailRegForm() {
        emailRegForm.click();
        return this;
    }

    public LoginPage clickLastNameRegForm() {
        lastNameRegForm.click();
        return this;
    }

    public LoginPage clickPasswordRegForm() {
        passwordRegForm.click();
        return this;
    }

    public LoginPage checkErrorMessageSignIn() {
        Assert.assertEquals(getErrorMessageSignIn(), "Email or password is not valid");
        return this;
    }

    public LoginPage checkRegistrationFormName() {
        Assert.assertEquals(getRegistrationFormName(), "Registration");
        return this;
    }

    public LoginPage checkSignInFormName() {
        Assert.assertEquals(getSignInFormName(), "Sign In");
        return this;
    }

    public LoginPage checkErrorMessageRegistration() {
        Assert.assertEquals(getErrorMessageRegistration(), "Required");
        return this;
    }

    public LoginPage checkErrorMessageLengthPasswordReg() {
        Assert.assertEquals(getErrorMessageLengthPasswordReg(), "Minimum 8 characters");
        return this;
    }

    public LoginPage checkErrorMessagePasswordReg() {
        Assert.assertEquals(getErrorMessagePasswordReg(), "Passwords must match");
        return this;
    }

    public LoginPage checkErrorMessageWrongEmailReg() {
        Assert.assertEquals(getErrorMessageWrongEmailReg(), "Invalid email address");
        return this;
    }
}
