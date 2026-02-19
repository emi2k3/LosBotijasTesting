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
    private EditarProgramaPage editarProgramaPage;
    private CrearProgramaPage crearProgramaPage;
    private ListadoProgramasPage listadoProgramasPage;
    private DetalleProgramaPage detalleProgramaPage;

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
        editarProgramaPage = new EditarProgramaPage(driver);
        listadoProgramasPage = new ListadoProgramasPage(driver);
        detalleProgramaPage = new DetalleProgramaPage(driver);
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
        crearProgramaPage.completarFormulario("wasd", "Abierto", " ", " ", 
        " ", " ", "", "wasd", "Texto", "wasd", "01/04/2026", "02/04/2026");
        crearProgramaPage.clickSubmit();
        assertTrue(crearProgramaPage.isFormErrorMessageDisplayed(), "Se esperaba un mensaje de error por datos inválidos, pero no se mostró.");
    }

    @Test
    void CrearProgramaFechasInvalidas() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa de pruebas", "Abierto", "Programa para pruebas.", "Programa para pruebas muy probadas.", 
        "Probar", "Ser probado", "Pasar pruebas", "Requisito de prueba", "Texto", "Etiqueta de requisito", "18/02/9999", "18/04/9999");
        crearProgramaPage.clickSubmit();
        assertTrue(crearProgramaPage.isStartDateErrorMessageDisplayed(), "Se esperaba un mensaje de error para la fecha de inicio inválida, pero no se mostró.");
        assertTrue(crearProgramaPage.isEndDateErrorMessageDisplayed(), "Se esperaba un mensaje de error para la fecha de cierre inválida, pero no se mostró.");
    }
    
    @Test
    void EditarProgramaValido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickVerCatalogoProgramas();
        listadoProgramasPage.clickVerDetallePrimerPrograma();
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa de pruebas editado", "Cerrado", "Programa para pruebas editado.");
        editarProgramaPage.completarFormularioContenido("Esto fue editado", "Objetivo editado", "Documentacion Editada", "Editado", "Texto", "Etiqueta editada");
        editarProgramaPage.completarFormularioFechas("01/05/2026", "02/05/2026");
        editarProgramaPage.clickSubmit();
    }

    //El test no pasa porque el el sistema permite ingresar fechas invalidas pero si lo corrigen debería pasar.
    @Test
    void EditarProgramaInvalido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickVerCatalogoProgramas();
        listadoProgramasPage.clickVerDetallePrimerPrograma();
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa de pruebas editado", "Cerrado", "Programa para pruebas editado.");
        editarProgramaPage.completarFormularioContenido("El programa ofrece financiamiento inicial y acompañamiento a emprendedores con proyectos innovadores.", "Fomentar el desarrollo de emprendimientos sostenibles.", "Editado", "Ser Editado", "Texto", "Etiqueta editada");
        editarProgramaPage.completarFormularioFechas("01/05/2999", "02/05/3000");
        editarProgramaPage.clickSubmit();
        assertTrue(editarProgramaPage.isGeneralFormErrorMessageDisplayed(), "Se debería ver el mensaje de error.");
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
