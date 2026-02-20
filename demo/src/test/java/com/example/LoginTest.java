package com.example;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;


public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage HomePage;
    private SelectProfilePage selectProfilePage;
    private LoginVerificarPage loginVerificarPage;


    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        System.setProperty("webdriver.edge.driver","C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"); //LucasChiappini
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        HomePage = new HomePage(driver);
        selectProfilePage=new SelectProfilePage(driver);
        loginVerificarPage=new LoginVerificarPage(driver);
    }

    @Test
    void loginValido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        assertTrue(HomePage.isWelcomeTextDisplayed(), "El texto de bienvenida se muestra, el login fue exitoso.");

    }

    @Test
    void loginUsuarioInvalido() {
        loginPage.open();
        loginPage.login("999999999", "password");
        assertTrue(loginPage.isErrorVisible());
    }

    @Test
    void loginContraseñaInvalida() {
        loginPage.open();
        loginPage.login("12345678", "wrongpassword");
        assertTrue(loginPage.isErrorVisible());
    }

   @Test
        public void LoginDual() { 
                loginPage.open();
                loginPage.enterCedula("55555555"); // es una cuenta dual.
                loginPage.enterPassword("password");
                loginPage.clickLoginButton();
                loginVerificarPage.byPassCode();
             assertTrue(selectProfilePage.isPageLoaded());
             selectProfilePage.selectProfile("contacto"); // contacto o funcionario (esto son los 2 que podes poner para seleccionar el perfil)
        

        }

    @Test
    void loginCredencialesInvalidas() {
        loginPage.open();
        loginPage.login("999999999", "wrongpassword");
        assertTrue(loginPage.isErrorVisible());
    }
    
    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
