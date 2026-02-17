package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;

public class FuncionariosTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private FuncionariosPage funcionariosPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        funcionariosPage = new FuncionariosPage(driver);

        loginPage.open();
        loginPage.login("12345678", "password");
    }

    @Test
    void crearFuncionarioConCredencialesRepetidas() {
        funcionariosPage.clickCreate();
        funcionariosPage.fillForm(
                "Test", "Test",
                "12345678",
                "12345678",
                "carlos.rodriguez@saltoinnova.gub.uy",
                "password",
                "Consulta"
        );
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
