package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramasPage {

    private WebDriver driver;
    private WebDriverWait wait;

    
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/programas";



    private By pageTitle = By.xpath("//*[@id=\"app\"]/main/div/div[1]/h2"); 


    public ProgramasPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }



    public void openPage() {
        driver.get(url);
    }

    public boolean isPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

}