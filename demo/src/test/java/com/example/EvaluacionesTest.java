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
    private ListadoEvaluacionesPage listadoEvaluacionesPage;
    private ListadoResultadosEvaluacionesPage listadoResultadosEvaluacionesPage;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        nuevoContactoPage = new CrearContactoPage(driver);
        homePage = new HomePage(driver);
        listadoContactosPage = new ListadoContactosPage(driver);
        listadoEvaluacionesPage = new ListadoEvaluacionesPage(driver);
        loginVerificarPage = new LoginVerificarPage(driver);
        listadoResultadosEvaluacionesPage = new ListadoResultadosEvaluacionesPage(driver);

        loginPage.open();
        loginPage.login("55242946", "12345678nM@");
        //loginPage.login("34567890", "password"); //Login como funcionario asesor
        //loginPage.login("12345678", "password"); //Login como funcionario administrador
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

    // ===== TEST COMO ASESOR =====

    //Falla por que no tengo permiso de administrador
    @Test
    void verResultadosEvaluacion_AsAsesor() {
        homePage.isHomePageLoaded();
        homePage.clickVerEvaluacionesAsAsesor();
        listadoEvaluacionesPage.isListaDeEvaluacionesTextDisplayed();
        
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
