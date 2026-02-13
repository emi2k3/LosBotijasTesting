package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RetoII_Login {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By successModalTitle = By.id("example-modal-sizes-title-lg");
    
    private By cedulaInput = By.id("cedula");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By rememberCheckbox = By.id("remember");
    private By registerLink = By.xpath("//a[@href='http://reto2026.brazilsouth.cloudapp.azure.com/registro/contacto']");

    // ======= CONSTRUCTOR =======
    public RetoII_Login(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    
    public void enterCedula(String cedula) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(cedulaInput));
        driver.findElement(cedulaInput).sendKeys(cedula);
    }

    public void enterPassword(String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void clickRememberCheckbox() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(rememberCheckbox));
        driver.findElement(rememberCheckbox).click();
    }

    public void clickRegisterLink() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}

