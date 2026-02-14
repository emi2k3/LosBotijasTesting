package com.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LoginTesting {

    private WebDriver driver;
    private HomePage HomePage;
    private LoginPage LoginPage;

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
        }

        // TESTS

        @Test
        public void loginValidoTest() {
                LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario"
                );
        }


        @Test
        public void loginUsuarioInvalidoTest() {
                LoginPage.openPage();
                LoginPage.enterCedula("wronguser");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();
                assertTrue(LoginPage.isErrorMessageDisplayed(), "Debería verse el texto de usuario / contraseña incorrectos");
        }

        @Test
        public void loginContraseñaInvalidaTest() {
                LoginPage.openPage();
                LoginPage.enterCedula("12345678");
                LoginPage.enterPassword("wrongpassword");
                LoginPage.clickLoginButton();
                assertTrue(LoginPage.isErrorMessageDisplayed(), "Debería verse el texto de usuario / contraseña incorrectos");
        }

        @Test
        public void loginTodoInvalidoTest() {
                LoginPage.openPage();
                LoginPage.enterCedula("wronguser");
                LoginPage.enterPassword("wrongpassword");
                LoginPage.clickLoginButton();
                assertTrue(LoginPage.isErrorMessageDisplayed(), "Debería verse el texto de usuario / contraseña incorrectos");
        }


        @Test
        public void LoginDual() { // Me falta informacion, esta explicado en mi documento.
        LoginPage.openPage();
                LoginPage.enterCedula("12345678"); //No tengo el usuario dual
                LoginPage.enterPassword("password");//
                LoginPage.clickLoginButton();
                assertTrue(HomePage.isWelcomeTextDisplayed(), "Debería verse el texto de bienvenida al usuario");
        

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
                driver.quit();
                }
        }
}

