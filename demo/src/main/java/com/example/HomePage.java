package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By successModalTitle = By.id("example-modal-sizes-title-lg");
    
    private By gestionarContactosButton = By.xpath("//a[@class='btn btn-primary btn-sm px-3'][contains(text(),'Ver')]");

    private By welcomeText = By.xpath("//h1[@class='h3 fw-bold mb-1']");

    private By homePageLoad = By.xpath("//h1[@class='h3 fw-bold mb-1' and text()='Hola, Carlos Rodríguez']");
    
    private By gestionarFuncionariosButton = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/funcionarios']");

    //Gestionar funcionarios
    private By verGestionarUsuarioButton = By.cssSelector(".btn.btn-secondary.btn-sm.px-3");

    //Para hacer logout
    private By userMenuButton = By.xpath("//span[@class='text-white fw-semibold']");
    private By logoutButton = By.xpath("//button[normalize-space()='Cerrar sesión']");


    // ======= CONSTRUCTOR =======
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(userMenuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
    
    public void clickGestionarContactos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gestionarContactosButton)).click();
    }
    
    public boolean isWelcomeTextDisplayed() {
        return driver.findElement(welcomeText).isDisplayed();
    }

    public void clickVerGestionarUsuario() {
        driver.findElement(verGestionarUsuarioButton).click();
    }

    public void clickGestionarFuncionarios() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(gestionarFuncionariosButton)).click();
    }

    public boolean isHomePageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLoad)).isDisplayed();
    }

    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}

