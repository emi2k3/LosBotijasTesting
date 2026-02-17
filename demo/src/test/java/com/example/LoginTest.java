package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;


public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage HomePage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        HomePage = new HomePage(driver);
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
