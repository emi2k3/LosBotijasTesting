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

public class ListadoResultadosEvaluacionesPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/funcionario/resultados";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By resultadosGeneralesText = By.xpath("//h2[@class='fw-normal mb-0']");




    // ======= CONSTRUCTOR =======
    public ListadoResultadosEvaluacionesPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }
    

    // ======= GETTERS (para assertions) =======
    public boolean isResultadosGeneralesTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultadosGeneralesText)).isDisplayed();
    }
}

