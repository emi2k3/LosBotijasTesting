package com.example;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class NuevoContactoPage {

    private WebDriver driver;

    private By nombre = By.name("nombre");
    private By telefono = By.name("telefono");
    private By apellido = By.name("apellido");
    private By email = By.name("email");
    private By cedula = By.name("cedula");
    private By password = By.id("contacto_password");
    private By rol = By.name("rol_en_empresa");
    private By consentimiento = By.id("consentimiento_datos");
    private By submit = By.xpath("//button[@type='submit']");
    private By error = By.className("invalid-feedback");

    public NuevoContactoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String n, String t, String a, String e, String c, String p, String r) {

        driver.findElement(nombre).sendKeys(n);
        driver.findElement(telefono).sendKeys(t);
        driver.findElement(apellido).sendKeys(a);
        driver.findElement(email).sendKeys(e);
        driver.findElement(cedula).sendKeys(c);
        driver.findElement(password).sendKeys(p);
        driver.findElement(rol).sendKeys(r);
        driver.findElement(consentimiento).click();
    }

    public void submit() {
        driver.findElement(submit).click();
    }

    public String getError() {
        return driver.findElement(error).getText();
    }
}
