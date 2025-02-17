import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {

    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeClass
    public void SetUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        Thread.sleep(2000);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        loginPage.openLoginPage();
        loginPage.setEmailLogIn("olga@mail.ru");
        loginPage.setPasswordLogIn("olgaOlga");
        loginPage.clickSignInButton();
    }

    @Test(priority = 2)
    public void loginNegativeTestWithWrongEmail() {
        loginPage.openLoginPage()
                .setEmailLogIn("ola@mail.ru")
                .setPasswordLogIn("olgaOlga")
                .clickSignInButton()
                .checkErrorMessageSignIn();
    }

    @Test(priority = 3)
    public void loginNegativeTestWithWrongPassword() {
        loginPage.openLoginPage()
                .setEmailLogIn("olga@mail.ru")
                .setPasswordLogIn("olgooollga")
                .clickSignInButton()
                .checkErrorMessageSignIn();
    }

    @Test(priority = 4)
    public void linkRegistration() {
        loginPage.openLoginPage()
                .clickRegistrationRef()
                .checkRegistrationFormName();
    }

    @Test(priority = 5)
    public void registrationPositiveTest() throws InterruptedException {
        loginPage.openRegistration()
                .setFirstNameRegistration("Kim")
                .setLastNameRegistration("Davidov")
                .setDateOfBirthRegistration("05.05.2000")
                .clickEmailRegForm()
                .setEmailRegistration("kim@mail.ru")
                .setPasswordRegistration("kkkkkkkk")
                .setPasswordConfirmationRegistration("kkkkkkkk")
                .clickSubmitButton();
    }

    @Test(priority = 6)
    public void linkSignIn() {
        loginPage.openRegistration()
                .clickSignInRef()
                .checkSignInFormName();
    }

    @Test(priority = 10)
    public void registrationWithoutDataTest() throws InterruptedException {
        loginPage.openRegistration()
                .clickSubmitButton()
                .checkErrorMessageRegistration();
    }

    @Test(priority = 7)
    public void registrationWithShortPasswordTest() throws InterruptedException {
        loginPage.openRegistration()
                .setFirstNameRegistration("Olga")
                .setLastNameRegistration("Davidov")
                .setDateOfBirthRegistration("05.05.2000")
                .clickEmailRegForm()
                .setEmailRegistration("olgad@mail.ru")
                .setPasswordRegistration("olg")
                .setPasswordConfirmationRegistration("olg")
                .checkErrorMessageLengthPasswordReg();
    }

    @Test(priority = 8)
    public void registrationWithWrongPasswordConfirmationTest() throws InterruptedException {
        loginPage.openRegistration()
                .setFirstNameRegistration("Olga")
                .setLastNameRegistration("Davidov")
                .setDateOfBirthRegistration("05.05.2000")
                .clickLastNameRegForm()
                .setEmailRegistration("olgad@mail.ru")
                .setPasswordRegistration("olgaOlga")
                .setPasswordConfirmationRegistration("tomTomTom")
                .clickPasswordRegForm()
                .checkErrorMessagePasswordReg();
    }

    @Test(priority = 9)
    public void registrationWithWrongEmailTest() throws InterruptedException {
        loginPage.openRegistration()
                .setFirstNameRegistration("Olga")
                .setLastNameRegistration("Davidov")
                .setDateOfBirthRegistration("05.05.2000")
                .clickLastNameRegForm()
                .setEmailRegistration("цукенр@mail.ru")
                .setPasswordRegistration("olgaOlga")
                .setPasswordConfirmationRegistration("olgaOlga")
                .checkErrorMessageWrongEmailReg();
    }
}
