package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ContactoTest {

    private WebDriver driver;
    private HomePage HomePage;
    private LoginPage LoginPage;

    // CAMBIAR SEGÚN ENTORNO
    private String path_to_extension = "C:\\DevTools\\Extensions\\2026.208.2004_0";
    private String path_to_driver = "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe";

    // ===== SETUP =====
    @BeforeEach
    public void setUp() {

        EdgeOptions options = new EdgeOptions();

        options.addArguments(
                "--disable-notifications",
                "--disable-geolocation",
                "--disable-infobars"
        );

        options.addArguments("load-extension=" + path_to_extension);

        System.setProperty("webdriver.edge.driver", path_to_driver);

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        HomePage = new HomePage(driver);
        LoginPage = new LoginPage(driver);
    }

    @Test
        public void BorrarContacto() {
        LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario");
                //Ver como navegar hacia gestion usuario
                //Ver como apretar en un contacto el boton eliminar.

        }

    // ===== TEARDOWN =====
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
