package com.example;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CrearContactoPage {

    private WebDriver driver;

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By nombre = By.xpath("//input[@placeholder='Pedro']");
    private By apellido = By.xpath("//input[@placeholder='Pérez']");
    private By cedula = By.xpath("//input[@placeholder='1.234.567-8 o 12345678']");
    private By email = By.xpath("//input[@placeholder='correo@ejemplo.com']");
    private By telefono = By.xpath("//input[@placeholder='099 123 456 o 2901 2345']");
    private By password = By.xpath("//input[@id='contacto_password']");
    private By consentimientoCheckbox = By.xpath("//input[@id='consentimiento_datos']");
    private By rolSelector = By.xpath("//select[@name='rol_en_empresa']");
    private By submit = By.xpath("//button[normalize-space()='Guardar contacto']");
    private By error = By.className("invalid-feedback");

    // ======= CONSTRUCTOR =======
    public CrearContactoPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void submit() {
        driver.findElement(submit).click();
    }

    public String getError() {
        return driver.findElement(error).getText();
    }

    public void fillForm(String nombre, String apellido, String cedula, String email, String telefono, String password, String rol) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.nombre)).sendKeys(nombre);
        wait.until(ExpectedConditions.elementToBeClickable(this.apellido)).sendKeys(apellido);
        wait.until(ExpectedConditions.elementToBeClickable(this.cedula)).sendKeys(cedula);
        wait.until(ExpectedConditions.elementToBeClickable(this.email)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(this.telefono)).sendKeys(telefono);
        wait.until(ExpectedConditions.elementToBeClickable(this.password)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(this.rolSelector)).sendKeys(rol);
        wait.until(ExpectedConditions.elementToBeClickable(this.consentimientoCheckbox)).click();
    }
}
