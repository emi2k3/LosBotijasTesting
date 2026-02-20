package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;

public class ContactosTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private CrearContactoPage nuevoContactoPage;
    private HomePage homePage;
    private CrearPostulacionPage crearPostulacionPage;
    private SelectProfilePage selectProfilePage;
    private LoginVerificarPage loginVerificarPage;
    private UnidadesAtencionPage unidadesAtencionPage;
    private ListadoContactosPage listadoContactosPage;

    @BeforeEach
    void setUp() {
        // System.setProperty("webdriver.edge.driver",
        // "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        // System.setProperty("webdriver.edge.driver",
        // "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico
        // D
        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        nuevoContactoPage = new CrearContactoPage(driver);
        homePage = new HomePage(driver);
        loginVerificarPage = new LoginVerificarPage(driver);
        crearPostulacionPage=new CrearPostulacionPage(driver);
        selectProfilePage =new SelectProfilePage(driver); 
        unidadesAtencionPage = new UnidadesAtencionPage(driver);
        listadoContactosPage=new ListadoContactosPage(driver);
    }

    @Test
    void desactivarContacto() {
        loginPage.open();
        loginPage.login("12345666", "!Lucaswachin7"); // Usuario contacto
        loginVerificarPage.byPassCode();
        homePage.clickPerfilContacto();
        homePage.clickEditarUsuario();
        // homePage.clickDesactivarCuenta(); ver despues
    }

    @Test
    void verProgramas() {
        loginPage.open();
        loginPage.login("12345666", "!Lucaswachin7"); // Usuario contacto
        loginVerificarPage.byPassCode();
        homePage.clickNuevaPostulacion();
        assertEquals(
                "Postulaciones a programas",
                homePage.obtenerTituloPostulaciones());
    }

    @Test
    void postularProgramasValido() {
        loginPage.open();
        loginPage.login("12345666", "!Lucaswachin7"); // Usuario contacto
        loginVerificarPage.byPassCode();
        homePage.clickNuevaPostulacion();
        homePage.clickEnPostulacion();
        homePage.clickPostularme();
        crearPostulacionPage.completarPostulacion(
        "Lucas Contact",
        "C:\\Users\\Usuario\\OneDrive\\Escritorio\\Lucas Contact.docx"
 );}

 @Test
    void postularProgramasInvalido() {
        loginPage.open();
        loginPage.login("12345666", "!Lucaswachin7"); // Usuario contacto
        loginVerificarPage.byPassCode();
        homePage.clickNuevaPostulacion();
        homePage.clickEnPostulacion();
        homePage.clickPostularme();
        crearPostulacionPage.completarPostulacion(
        "",
        ""
);

assertTrue(crearPostulacionPage.camposSiguenVacios());

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
                "Encargado");

        nuevoContactoPage.submit();
        nuevoContactoPage.getError();
    }

    @Test
    void desactivarContactoComoFuncionario() {
        // Este test asume que hay al menos un contacto registrado"
        loginPage.open();
        loginPage.login("12345678", "password");
        assertTrue(homePage.isWelcomeTextDisplayed(), "El texto de bienvenida se muestra, el login fue exitoso.");

        // TEST CRASHEA POR LAS COOKIES, PENDIENTE DE SOLUCIONAR.
    }

    @Test
    void unidadAtencionTodoValido(){
        loginPage.open();
        loginPage.enterCedula("55555555"); // es una cuenta dual.
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        loginVerificarPage.byPassCode();
        selectProfilePage.selectProfile("contacto"); 
        homePage.clickVerUnidadesAtencion();
        unidadesAtencionPage.clickCrearUnidad();
        nuevoContactoPage.fillFormUnidadControl(
                "Juan",
                "Perez",
                "72734370",
                "JP18@example.com",
                "099143567",
                "!Juanperezwachin7");

        nuevoContactoPage.continuarUnidadControl();
        loginVerificarPage.byPassCode();
    }

    @AfterEach
    void tearDown() {
        // driver.quit();
    }
}
