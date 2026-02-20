package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/perfil/seleccionar";

    // ======= LOCALIZADORES =======

    private By pageTitle = By.xpath("//*[@id=\"app\"]/main/div/div/div/div[1]/h1"); 
    private By contactoOption = By.xpath("//*[@id=\"app\"]/main/div/div/div/div[2]/div[1]/a/div");
    private By funcionarioOption = By.xpath("//*[@id=\"app\"]/main/div/div/div/div[2]/div[2]");

    // ======= CONSTRUCTOR =======
    public SelectProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // ======= ACCIONES =======

    public void openPage() {
        driver.get(url);
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public void selectContacto() {
        wait.until(ExpectedConditions.elementToBeClickable(contactoOption));
        driver.findElement(contactoOption).click();
    }

    public void selectFuncionario() {
        wait.until(ExpectedConditions.elementToBeClickable(funcionarioOption));
        driver.findElement(funcionarioOption).click();
    }


    public void selectProfile(String profile) {
        if (profile.equalsIgnoreCase("contacto")) {
            selectContacto();
        } else if (profile.equalsIgnoreCase("funcionario")) {
            selectFuncionario();
        } else {
            throw new IllegalArgumentException("Perfil no válido: " + profile);
        }
    }

    // ======= GETTERS =======

    public String getPageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }
}