package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetoII_Home {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By successModalTitle = By.id("example-modal-sizes-title-lg");
    
    private By gestionarContactosButton = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/contactos']");


    // ======= CONSTRUCTOR =======
    public RetoII_Home(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void clickGestionarContactos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gestionarContactosButton)).click();
    }
    

    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}

