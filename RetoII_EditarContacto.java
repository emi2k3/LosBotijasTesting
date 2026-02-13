package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetoII_EditarContacto {

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
    private By guardarCambiosButton = By.xpath("//button[@type='submit']");
    private By cancelarButton = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/contactos/12']");
    private By errorMessage = By.className("invalid-feedback");

    // ======= CONSTRUCTOR =======
    public RetoII_EditarContacto(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void editarNombre(String nombre) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nombreTextbox)).clear();
        driver.findElement(nombreTextbox).sendKeys(nombre);
    }

    public void editarTelefono(String telefono) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(telefonoTextbox)).clear();
        driver.findElement(telefonoTextbox).sendKeys(telefono);
    }

    public void editarApellido(String apellido) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(apellidoTextbox)).clear();
        driver.findElement(apellidoTextbox).sendKeys(apellido);
    }

    public void editarEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(emailTextbox)).clear();
        driver.findElement(emailTextbox).sendKeys(email);
    }

    public void editarCedula(String cedula) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cedulaTextbox)).clear();
        driver.findElement(cedulaTextbox).sendKeys(cedula);
    }

    public void editarContrasena(String contrasena) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contrasenaTextBox)).clear();
        driver.findElement(contrasenaTextBox).sendKeys(contrasena);
    }

    public void clickGuardarCambios() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(guardarCambiosButton)).click();
    }

    public void clickCancelar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancelarButton)).click();
    }

    public void selectRol(String rol) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(rolselector));
        driver.findElement(rolselector).sendKeys(rol);
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

