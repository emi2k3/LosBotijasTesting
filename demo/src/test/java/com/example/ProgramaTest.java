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
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        System.setProperty("webdriver.edge.driver", "C:\\Users\\nigom\\OneDrive\\Desktop\\Reto 2\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe"); //Nico Gomez
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

    // =============================================
    // ===          TESTS: CREAR PROGRAMA        ===
    // =============================================

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

    // =============================================
    // ===         TESTS: EDITAR PROGRAMA        ===
    // =============================================

    @Test
    void EditarProgramaValido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego editarlo
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para editar válido", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "01/04/2026", "02/04/2026");
        crearProgramaPage.clickSubmit();
        // Editar
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa de pruebas editado", "Cerrado", "Programa para pruebas editado.");
        editarProgramaPage.completarFormularioContenido("Esto fue editado", "Objetivo editado", "Documentacion Editada", "Editado", "Texto", "Etiqueta editada");
        editarProgramaPage.completarFormularioFechas("02/19/2026", "02/20/2026");
        editarProgramaPage.clickSubmit();
    }

    @Test
    void EditarProgramaTodoInvalido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego editarlo con datos inválidos
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para editar inválido", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/20/2026", "02/20/2026");
        crearProgramaPage.clickSubmit();
        // Editar con todos los campos vacíos
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("", "", "");
        editarProgramaPage.completarFormularioContenido("", "", "", "", "Texto", "");
        editarProgramaPage.completarFormularioFechas("", "");
        editarProgramaPage.clickSubmit();
        assertTrue(editarProgramaPage.isGeneralFormErrorMessageDisplayed(),
                "Debe mostrarse un error al enviar el formulario completamente vacío.");
    }

    @Test
    void EditarProgramaFechaCierreInvalida() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego editarlo
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para editar fecha cierre", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/19/2026", "02/20/2026");
        crearProgramaPage.clickSubmit();
        // Editar con fecha de cierre anterior a la de inicio
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa fecha cierre inválida", "Abierto", "Descripción breve válida.");
        editarProgramaPage.completarFormularioContenido("Descripción completa válida.", "Objetivo válido.",
                "Documentación válida.", "campo_valido", "Texto", "Etiqueta válida");
        editarProgramaPage.completarFormularioFechas("02/19/2026", "01/01/2026"); // cierre ANTES que inicio
        editarProgramaPage.clickSubmit();
        assertTrue(editarProgramaPage.isGeneralFormErrorMessageDisplayed(),
                "Debe mostrarse un error por fecha de cierre anterior a la de inicio.");
    }

    @Test
    void EditarProgramaFechaInicioInvalida() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego editarlo
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para editar fecha inicio", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/20/2026", "02/20/2026");
        crearProgramaPage.clickSubmit();
        // Editar con fecha de inicio vacía
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa fecha inicio inválida", "Abierto", "Descripción breve válida.");
        editarProgramaPage.completarFormularioContenido("Descripción completa válida.", "Objetivo válido.",
                "Documentación válida.", "campo_valido", "Texto", "Etiqueta válida");
        editarProgramaPage.completarFormularioFechas("", "02/20/2026"); // inicio vacío
        editarProgramaPage.clickSubmit();
        assertTrue(editarProgramaPage.isGeneralFormErrorMessageDisplayed(),
                "Debe mostrarse un error por fecha de inicio vacía.");
    }

    //El test no pasa porque el sistema permite ingresar fechas invalidas.
    @Test
    void EditarProgramaFechasInvalidas() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego editarlo
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para editar fechas", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/19/2026", "02/20/2026");
        crearProgramaPage.clickSubmit();
        // Editar con fechas fuera de rango
        detalleProgramaPage.clickEditarPrograma();
        editarProgramaPage.completarFormularioGeneral("Programa de pruebas editado", "Cerrado", "Programa para pruebas editado.");
        editarProgramaPage.completarFormularioContenido("El programa ofrece financiamiento inicial y acompañamiento a emprendedores con proyectos innovadores.", "Fomentar el desarrollo de emprendimientos sostenibles.", "Editado", "Ser Editado", "Texto", "Etiqueta editada");
        editarProgramaPage.completarFormularioFechas("", "01/01/9999");
        editarProgramaPage.clickSubmit();
        assertTrue(editarProgramaPage.isGeneralFormErrorMessageDisplayed(), "Se debería ver el mensaje de error.");
    }

    // =============================================
    // ===       TESTS: ELIMINAR PROGRAMA        ===
    // =============================================

    @Test
    void EliminarPrograma() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para eliminar", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/20/2026", "02/21/2026");
        crearProgramaPage.clickSubmit();
        detalleProgramaPage.clickEliminarPrograma();
        detalleProgramaPage.clickConfirmEliminar();
        assertTrue(listadoProgramasPage.isEliminarProgramaSuccessMessageDisplayed(),
                "Se ve el mensaje de programa eliminado correctamente.");
    }

    @Test
    void EliminarProgramaCancelado() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        // Crear programa para luego cancelar su eliminación
        homePage.clickCrearCatalogoProgramas();
        crearProgramaPage.completarFormulario("Programa para cancelar eliminacion", "Abierto", "Descripción breve.",
                "Descripción completa.", "Objetivo.", "Requisitos.", "Documentación.",
                "campo_prueba", "Texto", "Campo de prueba", "02/19/2026", "02/20/2026");
        crearProgramaPage.clickSubmit();
        detalleProgramaPage.clickEliminarPrograma();
        detalleProgramaPage.clickCancelarEliminar();
        assertTrue(detalleProgramaPage.isDetalleDeProgramaTextDisplayed(),
                "Al cancelar la eliminación debe permanecer en la página de detalle.");
        assertTrue(listadoProgramasPage.isEliminarProgramaSuccessMessageDisplayed(), "Se ve el mensaje de programa eliminado correctmaente.|");
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}