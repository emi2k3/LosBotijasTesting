package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;


public class RegisterTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private RegistroContactoPage registroContactoPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registroContactoPage = new RegistroContactoPage(driver);
    }

    @Test
    void RegistroValido() {
        loginPage.open();
        loginPage.clickRegister();
        registroContactoPage.RegisterStepOne("Joe", "Doe", registroContactoPage.generarCedulaValida(), "joe.doe@example.com", "099000111", "!Hola123");
        registroContactoPage.RegisterStepTwo("Comercial Joe", "Idea", "1 a 5", "Descripción de prueba para el registro de contacto.");
        registroContactoPage.clickSubmit();
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
