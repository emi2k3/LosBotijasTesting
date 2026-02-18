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
    private HomePage homePage;
    private ListadoContactosPage listadocontactosPage;
    private LoginVerificarPage loginVerificarPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        funcionariosPage = new FuncionariosPage(driver);
        listadocontactosPage = new ListadoContactosPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginVerificarPage loginVerificarPage = new LoginVerificarPage(driver);

        loginPage.open();
        loginPage.login("12345678", "password");
        loginPage.clickLoginButton();
        loginVerificarPage.byPassCode();
        homePage.clickVerGestionarUsuario();
    }

    @Test
    void crearFuncionarioConCredencialesRepetidas() {
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
    void editarFuncionarioTodoValido() {

        listadocontactosPage.clickEditarContacto();
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
        // Finally ensure the submit is in view
        WebElement submit = driver.findElement(By.id("submit")); // Adjust the locator as needed
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'auto', block:'center'});", submit);

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());
    
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
        assertTrue(funcionariosPage.isAlertVisible());

    }

    @Test
    public void Caso5() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());

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
        assertTrue(funcionariosPage.isAlertVisible());

    }

    @Test
    public void Caso8() {

        listadocontactosPage.clickEditarContacto();

        funcionariosPage.fillForm("juan", "perez", "6666666", "123456789", "juan.perez@demo.com", "password", "Consulta");
        funcionariosPage.submit();
        assertTrue(funcionariosPage.isAlertVisible());

    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
