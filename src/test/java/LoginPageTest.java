import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.driver.DriverSetUp;
import utils.driver.listener.MyListener;

@Listeners({MyListener.class})

public class LoginPageTest {

    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetUp.driverInit();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

    @Description("Login Positive Test")
    @Epic("Epic 2")
    @Story("US-101")
    @Test(priority = 1)
    public void loginPositiveTest() {
        loginPage.openLoginPage();
        loginPage.setEmailLogIn("olga@mail.ru");
        loginPage.setPasswordLogIn("olgaOlga");
        loginPage.clickSignInButton();
    }

    @Description("Login Negative Test With Wrong Email")
    @Epic("Epic 2")
    @Story("US-102")
    @Test(priority = 2)
    public void loginNegativeTestWithWrongEmail() {
        loginPage.openLoginPage()
                .setEmailLogIn("ola@mail.ru")
                .setPasswordLogIn("olgaOlga")
                .clickSignInButton()
                .checkErrorMessageSignIn();
    }

    @Description("Login Negative Test With Wrong Password")
    @Epic("Epic 2")
    @Story("US-102")
    @Test(priority = 3)
    public void loginNegativeTestWithWrongPassword() {
        loginPage.openLoginPage()
                .setEmailLogIn("olga@mail.ru")
                .setPasswordLogIn("olgooollga")
                .clickSignInButton()
                .checkErrorMessageSignIn();
    }

    @Description("Link Registration")
    @Epic("Epic 2")
    @Story("US-108")
    @Test(priority = 4)
    public void linkRegistration() {
        loginPage.openLoginPage()
                .clickRegistrationRef()
                .checkRegistrationFormName();
    }

    @Description("Registration Positive Test")
    @Epic("Epic 1")
    @Story("US-101")
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

    @Description("Link SignIn/Problem Test")
    @Epic("Epic 1")
    @Story("US-108")
    @Test(priority = 6)
    public void linkSignIn() {
        loginPage.openRegistration()
                .clickSignInRef()
                .checkSignInFormName();
    }

    @Description("Registration Without Data Test")
    @Epic("Epic 1")
    @Story("US-104")
    @Test(priority = 10)
    public void registrationWithoutDataTest() throws InterruptedException {
        loginPage.openRegistration()
                .clickSubmitButton()
                .checkErrorMessageRegistration();
    }

    @Description("Registration With Short Password Test")
    @Epic("Epic 1")
    @Story("US-107")
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

    @Description("Registration With Wrong Password Confirmation Test")
    @Epic("Epic 1")
    @Story("US-107")
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

    @Description("Registration With Wrong Email Test")
    @Epic("Epic 1")
    @Story("US-106")
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
