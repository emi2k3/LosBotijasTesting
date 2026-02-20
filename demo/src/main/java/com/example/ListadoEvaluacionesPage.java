package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListadoEvaluacionesPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By listaDeEvaluacionesText = By.xpath("//h2[@class='fw-normal mb-0']");

    private By nuevaEvaluacionButton = By.xpath("//button[normalize-space()='Crear nueva evaluación']");
    private By volverButton = By.xpath("//a[@class='btn btn-outline-secondary rounded-pill']");
    private By responderEvaluacionButton = By.xpath("//button[normalize-space()='Responder evaluación']");
    //private By 

    //De la lista de evaluaciones
    

    // ======= CONSTRUCTOR =======
    public ListadoEvaluacionesPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void clickNuevaEvaluacion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nuevaEvaluacionButton)).click();
    }

    public void clickVolver() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(volverButton)).click();
    }

    public void clickResponderEvaluacion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(responderEvaluacionButton)).click();
    }

    // ======= GETTERS (para assertions) =======
    public String getListaDeEvaluacionesText() {
        return driver.findElement(listaDeEvaluacionesText).getText();
    }

    public boolean isListaDeEvaluacionesTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(listaDeEvaluacionesText)).isDisplayed();
    }
}

