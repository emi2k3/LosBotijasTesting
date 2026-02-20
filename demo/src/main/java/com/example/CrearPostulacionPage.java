package com.example;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CrearPostulacionPage {

    private WebDriver driver;

    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/postulaciones/create";


    private By nombreCompletoInput = By.id("resp_campo_prueba");

    private By adjuntarArchivoInput =  By.id("archivos");

    private By enviarPostulacionBtn =By.id("submitBtn");

    private By mensajeExito =
            By.xpath("//*[contains(text(),'Postulación enviada')]");



    public CrearPostulacionPage(WebDriver driver) {
        this.driver = driver;
    }


    public void open() {
        driver.get(url);
    }


    public void ingresarNombreCompleto(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(nombreCompletoInput))
                .sendKeys(nombre);
                }
    }


    public void adjuntarArchivo(String rutaArchivo) {
        if (rutaArchivo != null && !rutaArchivo.isBlank()) {
        driver.findElement(adjuntarArchivoInput).sendKeys(rutaArchivo);
        ((JavascriptExecutor) driver)
            .executeScript("document.activeElement.blur();");

        }
    }

   public void clickEnviarPostulacion() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement boton = wait.until(
            ExpectedConditions.presenceOfElementLocated(enviarPostulacionBtn)
    );

   
    ((JavascriptExecutor) driver)
            .executeScript("document.activeElement.blur();");


    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", boton);

    wait.until(ExpectedConditions.elementToBeClickable(boton));

    try {
        boton.click();
    } catch (ElementClickInterceptedException e) {
        // ⭐ click JS si algo lo tapa
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", boton);
    }
}

   

    public void completarPostulacion(String nombre, String rutaArchivo) { 
        ingresarNombreCompleto(nombre);
        adjuntarArchivo(rutaArchivo);
        ((JavascriptExecutor) driver).executeScript("document.activeElement.blur();");
        clickEnviarPostulacion();
    }

   public boolean camposSiguenVacios() {
    String nombre = driver.findElement(nombreCompletoInput).getAttribute("value");
    String archivo = driver.findElement(adjuntarArchivoInput).getAttribute("value");

    return nombre.isEmpty() && archivo.isEmpty();
}



    public boolean postulacionEnviada() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mensajeExito))
                .isDisplayed();
    }

    public String obtenerMensajeExito() {
        return driver.findElement(mensajeExito).getText();
    }
}
