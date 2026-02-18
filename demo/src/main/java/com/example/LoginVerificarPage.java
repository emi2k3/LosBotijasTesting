package com.example;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginVerificarPage {

    private WebDriver driver;
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/login/verificar";


    private By ingresaElCodigoText = By.xpath("//h2[@class='h5 fw-bold mb-0']");
    private By codeInput = By.id("codigo");
    private By submitButton = By.xpath("//button[normalize-space()='Verificar e ingresar']");

    //Constructor
    public LoginVerificarPage(WebDriver driver) {
        this.driver = driver;
    }

    //Metodos
    public void open() {
        driver.get(url);
    }

    public void fillCode(String code) {
        driver.findElement(codeInput).sendKeys(code);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    //Greeters para assertions

    public boolean isIngresaElCodigoTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ingresaElCodigoText));
        return true;
    }
}
