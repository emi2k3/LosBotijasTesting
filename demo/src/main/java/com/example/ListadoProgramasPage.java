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

public class ListadoProgramasPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/programas";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    //Texto y botones
    private By listaDeProgramasText = By.xpath("//h2[@class='fw-normal mb-0']");
    private By crearProgramaButton = By.xpath("//i[@class='bi bi-plus-lg']");
    private By volverButton = By.xpath("//i[@class='bi bi-arrow-left']"); 

    // Lista de programas
    private By verDetallePrograma1Button = By.xpath("//div[@class='container-fluid py-4']//div[1]//div[1]//div[1]//div[2]//a[1]"); 

    //Mensaje de confirmación al eliminar un programa
    private By eliminarProgramaSuccessMessage = By.xpath("//div[contains(., 'Programa eliminado correctamente')]");

    // ======= CONSTRUCTOR =======
    public ListadoProgramasPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void clickCrearPrograma() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(crearProgramaButton)).click();
    }

    public void clickVolver() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(volverButton)).click();
    }

    public void clickVerDetallePrimerPrograma() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(verDetallePrograma1Button)).click();
    }

    
    // ======= GETTERS (para assertions) =======
    public boolean isListaDeProgramasTextDisplayed() {
        try {
            return driver.findElement(listaDeProgramasText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEliminarProgramaSuccessMessageDisplayed() {
        try {
            return driver.findElement(eliminarProgramaSuccessMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

