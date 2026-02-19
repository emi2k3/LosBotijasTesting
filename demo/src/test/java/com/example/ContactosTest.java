package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactosTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private CrearContactoPage nuevoContactoPage;
    private HomePage homePage;
    private ListadoContactosPage listadoContactosPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        nuevoContactoPage = new CrearContactoPage(driver);
        homePage = new HomePage(driver);
        listadoContactosPage = new ListadoContactosPage(driver);

        loginPage.open();
        loginPage.login("12345678", "password");
    }


    @Test
    void desactivarContactoComoFuncionario() {
        // Este test asume que hay al menos un contacto registrado"
        loginPage.open();
        loginPage.login("12345678", "password");
        assertTrue(homePage.isWelcomeTextDisplayed(), "El texto de bienvenida se muestra, el login fue exitoso.");
        homePage.clickVerContactos();
        //TEST CRASHEA POR LAS COOKIES, PENDIENTE DE SOLUCIONAR.
    }

    @Test
    void crearContactoConEmailDuplicado() {

        nuevoContactoPage.fillForm(
                "Juan",
                "123456789",
                "Perez",
                "erich95@example.com",
                "5555555",
                "password123",
                "Encargado"
        );

        nuevoContactoPage.submit();
        nuevoContactoPage.getError();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
