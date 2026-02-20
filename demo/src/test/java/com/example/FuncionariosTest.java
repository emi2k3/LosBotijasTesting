package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;

public class FuncionariosTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private FuncionariosPage funcionariosPage;
    private ListadoContactosPage listadocontactosPage;
    private LoginVerificarPage loginVerificarPage;
    private SelectProfilePage selectProfilePage;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
         System.setProperty("webdriver.edge.driver","C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"); 
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        funcionariosPage = new FuncionariosPage(driver);
        listadocontactosPage = new ListadoContactosPage(driver);
        loginVerificarPage= new LoginVerificarPage(driver);
        selectProfilePage=new SelectProfilePage(driver);
        homePage=new HomePage(driver);
        
        loginPage.open();
        loginPage.enterCedula("55555555"); // es una cuenta dual.
                loginPage.enterPassword("password");
                loginPage.clickLoginButton();
                loginVerificarPage.byPassCode();
             selectProfilePage.selectProfile("funcionario");
       
    }

    @Test
    void crearFuncionarioConCredencialesRepetidas() {// aca poner datos que ya existen en el sistema.
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

     @Test
    void crearFuncionarioTodoValido() {// aca poner datos que no esten repetidos y usen el estandar correcto.
        funcionariosPage.clickCreate();
        funcionariosPage.fillForm(
                "Funcionario", "Test",
                "455566734",
                "098187219",
                "testfuncionario@gmail.com",
                "!Lucaswachin7",
                "Consulta"
        );
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());
    }

    @Test
    void editarFuncionarioTodoValido() {
        homePage.clickVerFuncionarios();
        listadocontactosPage.clickEditarContacto();
        funcionariosPage.fillForm(

                "Dual", 
                "Perfil",
                registroContactoPage.generarCedula(),
                "099045678",
                "dual.perfil@demo.com",
                null

        );
        //Diferentes tipos de scroll porque no me anda el del profe
        Actions actions = new Actions(driver);
        try {
            for (int i = 0; i < 3; i++) {
                actions.sendKeys(Keys.END).perform();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            //si no anduvo no hacer nada.
        }
        // Force scrolling the document element to bottom (covers custom scroll containers)
        ((JavascriptExecutor) driver).executeScript("if(document.scrollingElement){document.scrollingElement.scrollTop = document.scrollingElement.scrollHeight;}else{window.scrollTo(0, document.body.scrollHeight);} ");
        funcionariosPage.selectRole("admin");
        funcionariosPage.submit();
    
    }

     @Test
void cerrarPrograma() {
    funcionariosPage.verProgramaClick();
    funcionariosPage.clickProgramaCard();
    funcionariosPage.clickEditarPrograma();
    funcionariosPage.seleccionarEstadoCerrado();
    funcionariosPage.clickActualizar();
    assertTrue(driver.getPageSource().contains("Cerrado"));
}

    @Test
    public void Caso3() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());

    }

    @Test
    public void Caso4() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();

    }

    @Test
    public void Caso5() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();

    }

    @Test
    public void Caso6() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());

    }

    @Test
    public void Caso7() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();

    }

    @Test
    public void CrearFuncionario_Cédula_y_Email_ya_utilizados() {

        homePage.clickVerContactos();
        funcionariosPage.clickCreate();
        funcionariosPage.fillForm(

                "Juan", "Pérez",
                "71451123",
                "099345678",
                "nicod@gmail.com",
                null

        );
        //Diferentes tipos de scroll porque no me anda el del profe
        Actions actions = new Actions(driver);
        try {
            for (int i = 0; i < 3; i++) {
                actions.sendKeys(Keys.END).perform();
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            //si no anduvo no hacer nada.
        }
        // Force scrolling the document element to bottom (covers custom scroll containers)
        ((JavascriptExecutor) driver).executeScript("if(document.scrollingElement){document.scrollingElement.scrollTop = document.scrollingElement.scrollHeight;}else{window.scrollTo(0, document.body.scrollHeight);} ");
        funcionariosPage.selectRole("admin");
        funcionariosPage.submit();

    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
