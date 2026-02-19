package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EvaluacionesTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private CrearContactoPage nuevoContactoPage;
    private HomePage homePage;
    private ListadoContactosPage listadoContactosPage;
    private LoginVerificarPage loginVerificarPage;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        System.setProperty("webdriver.edge.driver", "C:\\Users\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        nuevoContactoPage = new CrearContactoPage(driver);
        homePage = new HomePage(driver);
        listadoContactosPage = new ListadoContactosPage(driver);
        loginVerificarPage = new LoginVerificarPage(driver);

        loginPage.open();
        loginPage.login("55242946", "12345678nM@");
        loginVerificarPage.byPassCode();
    }


    @Test
    void responderEvaluación() {

        homePage.isHomePageLoaded();
        homePage.clickResponderEvaluaciones();
        
    }

    @Test
    void verResultadoEvaluación_verunaevaluación() {

        homePage.isHomePageLoaded();
        homePage.clickSeguimientoEvaluaciones();

    }

    @Test
    void verResultadoEvaluación_vermievolución() {
        
        homePage.isHomePageLoaded();
        homePage.clickResultadoEvaluaciones();
       
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
