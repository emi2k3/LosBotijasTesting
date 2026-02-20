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
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/contactos";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By barraDeBusqueda = By.id("buscador-contactos");
    
    private By nuevoContactoButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/contactos/create']");
    private By editarContactoButton = By.xpath("//a[@title='Editar' and contains(@class,'btn-light')]");
    private By eliminarContactoButton= By.xpath("/html/body/main/div/div[4]/div/div/div[15]/div/div[3]/button");
    private By desactivarContactoButton=By.xpath("//*[@id=\"deleteModal3\"]/div/div/div[3]/form/button");
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

      public void clickEliminarContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(eliminarContactoButton)).click();
    }

      public void clickDesactivarContacto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(desactivarContactoButton)).click();
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
    public boolean isBarraDeBusquedaDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(barraDeBusqueda));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

