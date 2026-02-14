package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class UnidadAtencionTest {

    private WebDriver driver;
    private HomePage HomePage;
    private LoginPage LoginPage;

    // CAMBIAR SEGÚN ENTORNO
    private String path_to_extension = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\2026.208.2004_0";
    private String path_to_driver = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"; 

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
        public void UnidadAtencion() {
        //falta info
        }

    @Test
        public void UnidadAtencionVacio() {
        //Falta info
        }

    // ===== TEARDOWN =====
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

