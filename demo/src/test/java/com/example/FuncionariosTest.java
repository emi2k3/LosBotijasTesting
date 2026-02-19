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
    private RegistroContactoPage registroContactoPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        System.setProperty("webdriver.edge.driver", "C:\\Users\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        funcionariosPage = new FuncionariosPage(driver);
        listadocontactosPage = new ListadoContactosPage(driver);
        homePage = new HomePage(driver);
        LoginVerificarPage loginverificarpage = new LoginVerificarPage(driver);
        RegistroContactoPage registroContactopage = new RegistroContactoPage(driver);

        loginPage.open();
        loginPage.login("12345678", "password");
        loginverificarpage.byPassCode();
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
    }

    @Test
    void crearFuncionarioConCredencialesRepetidas() {
        homePage.clickVerFuncionarios();
        funcionariosPage.clickCreate();
        funcionariosPage.fillForm(

                "Juan", "Pérez",
                "71451123",
                "099345678",
                "juan.perez@saltoinnova.gub.uy",
                "passworD1@"

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
    public void EditarFuncionario_email_ya_utilizado() {
        homePage.clickVerFuncionarios();
        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm(

            "juan", 
            "perez", 
            registroContactoPage.generarCedula(), 
            "099045678", 
            "juan.perez@saltoinnova.gub.uy", 
            null

        );

        funcionariosPage.submit();

    }

    @Test
    public void EditarFuncionario_cedula_ya_utilizada() {
        homePage.clickVerFuncionarios();
        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm(

            "juan",
         "perez",
         "7145112",
         "099045678",
         registroContactoPage.generateRandomEmail(),
         null

        );
        funcionariosPage.submit();

    }

    @Test
    public void EditarFuncionario_Email_ya_utilizado() {
        homePage.clickVerFuncionarios();
        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm(

            "juan",
         "perez",
         registroContactoPage.generarCedula(),
          "099045678",
          "juan.perez@saltoinnova.gub.uy",
           null

        );
        funcionariosPage.selectRole("Consulta");
        funcionariosPage.submit();

    }

    @Test
    public void EditarContacto_Cédula_ya_utilizada() {
        homePage.clickVerContactos();
        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm(
            
            "juan",
            "perez",
            "55242946",
            "099045678",
            registroContactoPage.generateRandomEmail(),
            null

        );

        funcionariosPage.selectRole("Titular");
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
