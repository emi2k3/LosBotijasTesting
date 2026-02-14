package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetoII_NuevoContacto {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By successModalTitle = By.id("example-modal-sizes-title-lg");
    
    private By nombreTextbox = By.name("nombre");
    private By telefonoTextbox = By.name("telefono");
    private By apellidoTextbox = By.name("apellido");
    private By emailTextbox = By.name("email");
    private By cedulaTextbox = By.name("cedula");
    private By contrasenaTextBox = By.id("contacto_password");
    private By rolselector = By.name("rol_en_empresa");
    private By guardarContactoButton = By.xpath("//button[@type='submit']");
    private By volverButton = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/contactos']");
    private By aceptarCheckbox = By.id("consentimiento_datos");
    private By errorMessage = By.className("invalid-feedback");

    // ======= CONSTRUCTOR =======
    public RetoII_NuevoContacto(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void enterNombre(String nombre) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nombreTextbox));
        driver.findElement(nombreTextbox).sendKeys(nombre);
    }

    public void enterTelefono(String telefono) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(telefonoTextbox));
        driver.findElement(telefonoTextbox).sendKeys(telefono);
    }

    public void enterApellido(String apellido) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(apellidoTextbox));
        driver.findElement(apellidoTextbox).sendKeys(apellido);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailTextbox));
        driver.findElement(emailTextbox).sendKeys(email);
    }

    public void enterCedula(String cedula) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cedulaTextbox));
        driver.findElement(cedulaTextbox).sendKeys(cedula);
    }

    public void enterContrasena(String contrasena) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contrasenaTextBox));
        driver.findElement(contrasenaTextBox).sendKeys(contrasena);
    }

    public void clickGuardarContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(guardarContactoButton)).click();
    }

    public void clickVolver() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(volverButton)).click();
    }

    public void selectRol(String rol) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(rolselector));
        driver.findElement(rolselector).sendKeys(rol);
    }

    public void checkAceptar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aceptarCheckbox)).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}


