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

public class ListadoContactosPage {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/contactos";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By successModalTitle = By.id("example-modal-sizes-title-lg");
    
    private By nuevoContactoButton = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/contactos/create']");
    private By editarContactoButton = By.xpath("//a[@title='Editar' and contains(@class,'btn-light')]");
    
    // ======= CONSTRUCTOR =======
    public ListadoContactosPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void clickNuevoContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nuevoContactoButton)).click();
    }

    
    public void clickEditarContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar a que sea visible
        WebElement boton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(editarContactoButton)
        );

        // Asegurar que no quede debajo de otros elementos
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", 
            boton
        );

        try {
            // Intento principal → Actions para evitar overlays
            new Actions(driver).moveToElement(boton)
                .pause(Duration.ofMillis(120))
                .click()
                .perform();
        } catch (ElementClickInterceptedException e) {
            // Fallback → Click directo por JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", boton);
        }
    }


    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}

