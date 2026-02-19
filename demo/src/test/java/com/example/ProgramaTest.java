package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;


public class ProgramaTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private LoginVerificarPage loginVerificarPage;
    private HomePage homePage;
    private CrearProgramaPage crearProgramaPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        //System.setProperty("C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"); //LucasChiappini
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginVerificarPage = new LoginVerificarPage(driver);
        crearProgramaPage = new CrearProgramaPage(driver);
    }

    @Test
    void CrearProgramaValido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa de pruebas", "Abierto", "Programa para pruebas.", "Programa para pruebas muy probadas.", 
        "Probar", "Ser probado", "Pasar pruebas", "Requisito de prueba", "Texto", "Etiqueta de requisito", "01/04/2026", "02/04/2026");
        crearProgramaPage.clickSubmit();
    }

    @Test
    void CrearProgramaInvalido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("", "Abierto", "", "", 
        "", "", "", "wasd", "Texto", "wasd", "01/04/2026", "02/04/2026");
        crearProgramaPage.clickSubmit();
        assertTrue(crearProgramaPage.isFormErrorMessageDisplayed(), "Se esperaba un mensaje de error por datos inválidos, pero no se mostró.");
    }
    
    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
