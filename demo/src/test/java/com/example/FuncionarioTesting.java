package com.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class FuncionarioTesting {

    private WebDriver driver;
    private HomePage HomePage;
    private LoginPage LoginPage;
    private FuncionariosPage FuncionariosPage;

    // CAMBIAR ESTO EN BASE AL ENTORNO QUE EJECUTA EL TESTING
    private String path_to_extension = "C:\\DevTools\\Extensions\\2026.208.2004_0";
    private String path_to_driver = "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe";

    // Setup
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
        FuncionariosPage = new FuncionariosPage(driver);
        }

        // Metodos utilizados en los tests
        public void LoginAsFuncionario() {
                LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
        }

        public void fillCreateFuncionarioForm(String name, String lastName, String cedula, String phone, String email, String password, String role) {
                FuncionariosPage.enterCreateFuncionarioName(name);
                FuncionariosPage.enterCreateFuncionarioLastName(lastName);
                FuncionariosPage.enterCreateFuncionarioCedula(cedula);
                FuncionariosPage.enterCreateFuncionarioPhone(phone);
                FuncionariosPage.enterCreateFuncionarioEmail(email);
                FuncionariosPage.enterCreateFuncionarioPassword(password);
                FuncionariosPage.selectCreateFuncionarioRole(role);
        }

        //Tests
        @Test
        //Necesario reactivar el funcionario antes de probar esto.
        public void DeactivateaFuncionaryAsFuncionaryTest() {
                LoginAsFuncionario();
                HomePage.clickVerGestionarUsuario();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                assertTrue(FuncionariosPage.isFuncionario2CardVisible(), "Debería ser visible el funcionario 2 antes de eliminarlo");
                FuncionariosPage.clickFuncionario2();
                FuncionariosPage.clickEliminarFuncionario2Confirm();
                FuncionariosPage.aceptarAlerta();
                assertTrue(FuncionariosPage.isNOTFuncionario2CardVisible(), "NO debería verse el funcionario 2 en la lista de usuarios activos");
                //Si se quiere verificar que el funcionario 2 aparece en la lista de inactivos, se puede descomentar lo siguiente:
                /* FuncionariosPage.clickInactiveButton();
                assertTrue(FuncionariosPage.isFuncionario2CardInactiveVisible(), "Debería ser visible el funcionario 2 en la lista de usuarios inactivos"); */
        }

        @Test
        public void createFuncionaryWithUsedCredentials(){
                LoginAsFuncionario();
                HomePage.clickVerGestionarUsuario();
                FuncionariosPage.clickCreateFuncionarioButton();
                fillCreateFuncionarioForm("Test", "Test", "12345678", "12345678", "carlos.rodriguez@saltoinnova.gub.uy", "password", "Consulta");
                FuncionariosPage.clickCreateFuncionarioSubmit();
        }

         @Test
        public void CrearFuncionarioEmailYaUtilizado() {
        LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario");
                //Ver como navegar hacia gestion de funcionaria
                //Apretar en el boton crear.
                //Rellenar los campos (con un email creado)
                //Click en boton guardar

        }

        
           @Test
        public void CrearFuncionarioCedulaYaUtilizado() {
        LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario");
                //Ver como navegar hacia gestion de funcionaria
                //Apretar en el boton crear.
                //Rellenar los campos (con un cedula creado)
                //Click en boton guardar

        }

        @Test
        public void CrearFuncionario() {
        LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario");
                //Ver como navegar hacia gestion de funcionaria
                //Apretar en el boton crear.
                //Rellenar los campos (camino feliz)
                //Click en boton guardar

        }

        // ======= SCROLL HASTA EL FONDO =======
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Click en SUBMIT
        //practiceFormPage2.submitForm();

        // ======= ASSERTIONS JUNIT 4 =======
        /*assertEquals(
                "Thanks for submitting the form",
                practiceFormPage2.getSuccessModalTitle()
        );
        System.out.println("Assertion 1 completada");

        assertNotNull(
                "El texto del modal es null",
                practiceFormPage2.getSuccessModalTitle()
        );
        System.out.println("Assertion 2 completada");

        assertTrue(
                "El mensaje no contiene la palabra 'Thanks'",
                practiceFormPage2.getSuccessModalTitle().contains("Thanks")
        );
        System.out.println("Assertion 3 completada");

        assertFalse(
                "El mensaje del modal está vacío",
                practiceFormPage2.getSuccessModalTitle().isEmpty()
        );
        System.out.println("Assertion 4 completada");
        */

        // ===============================
        // ASSERTIONS JUNIT 5 (COMENTADAS)
        // ===============================

        /*
        // assertEquals (JUnit 5)
        org.junit.jupiter.api.Assertions.assertEquals(
                "Thanks for submitting the form",
                practiceFormPage2.getSuccessModalTitle(),
                "El título del modal no es el esperado"
        );

        // assertNotNull (JUnit 5)
        org.junit.jupiter.api.Assertions.assertNotNull(
                practiceFormPage2.getSuccessModalTitle(),
                "El texto del modal es null"
        );

        // assertTrue (JUnit 5)
        org.junit.jupiter.api.Assertions.assertTrue(
                practiceFormPage2.getSuccessModalTitle().contains("Thanks"),
                "El mensaje no contiene la palabra 'Thanks'"
        );

        // assertFalse (JUnit 5)
        org.junit.jupiter.api.Assertions.assertFalse(
                practiceFormPage2.getSuccessModalTitle().isEmpty(),
                "El mensaje del modal está vacío"
        );

        // assertAll (SOLO JUNIT 5)
        org.junit.jupiter.api.Assertions.assertAll(
                "Validaciones del modal",
                () -> org.junit.jupiter.api.Assertions.assertEquals(
                        "Thanks for submitting the form",
                        practiceFormPage2.getSuccessModalTitle()
                ),
                () -> org.junit.jupiter.api.Assertions.assertTrue(
                        practiceFormPage2.getSuccessModalTitle().startsWith("Thanks")
                ),
                () -> org.junit.jupiter.api.Assertions.assertNotNull(
                        practiceFormPage2.getSuccessModalTitle()
                )
        );
        */

        // ===============================
    @AfterEach
        public void tearDown() {
                if (driver != null) {
                //driver.quit();
                }
        }
}

