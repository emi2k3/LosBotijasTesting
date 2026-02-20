package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalleProgramaPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/programas";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    //Texto y botones
    private By detalleDeProgramaText = By.cssSelector(".h4");
    private By eliminarProgramaButton = By.cssSelector(".btn-outline-danger");
    private By editarProgramaButton = By.cssSelector(".bi-pencil");
    private By volverButton = By.xpath("//a[@class='btn btn-outline-secondary btn-sm rounded-pill']");

    //Confirmación de eliminar programa
    private By confirmEliminarButton = By.cssSelector(".btn.btn-danger");
    private By cancelEliminarButton = By.cssSelector(".modal-footer:nth-child(3) > .btn");




    // ======= CONSTRUCTOR =======
    public DetalleProgramaPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void clickEliminarPrograma() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(eliminarProgramaButton)).click();
    }

    public void clickEditarPrograma() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(editarProgramaButton)).click();
    }

    public void clickVolver() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(volverButton)).click();
    }

    public void clickConfirmEliminar() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(confirmEliminarButton)).click();
    }

    public void clickCancelarEliminar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cancelEliminarButton)).click();
    }
     // ======= Helper Methods =======

    
    // ======= GETTERS (para assertions) =======
    public boolean isDetalleDeProgramaTextDisplayed() {
        try {
            return driver.findElement(detalleDeProgramaText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

