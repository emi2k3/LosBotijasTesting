package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private RegistroContactoPage registroContactoPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registroContactoPage = new RegistroContactoPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    void RegistroValido() {
        loginPage.open();
        loginPage.clickRegister();
        registroContactoPage.RegisterStepOne("Joe", "Doe", registroContactoPage.generarCedula(), registroContactoPage.generateRandomEmail(), "099000111", "!Hola123");
        registroContactoPage.RegisterStepTwo("Comercial Joe", "Idea", "1 a 5", "Descripción de prueba para el registro de contacto.");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));

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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'auto', block:'center'});", submit);
        //Ahora si, esperar a que el botón sea clickeable y hacer click

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(submit));
        registroContactoPage.clickConfirmButton();
        assertTrue(homePage.isWelcomeTextDisplayed(), "El texto de bienvenida se muestra, el registro fue exitoso.");
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
