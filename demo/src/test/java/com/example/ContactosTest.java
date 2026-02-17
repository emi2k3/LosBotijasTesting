package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;

public class ContactosTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private NuevoContactoPage nuevoContactoPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        nuevoContactoPage = new NuevoContactoPage(driver);

        loginPage.open();
        loginPage.login("12345678", "password");
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
