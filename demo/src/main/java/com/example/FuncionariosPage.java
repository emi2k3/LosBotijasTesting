package com.example;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FuncionariosPage {

    private WebDriver driver;

    // URL
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By funcionario2Card = By.xpath("//*[@id=\"app\"]/main/div/div[4]/div/div/div[9]/div");
    private By funcionario2CardInactive = By.xpath("//*[@id=\"app\"]/main/div/div[4]/div/div/div[3]");
    private By detallesFuncionario2 = By.xpath("//*[@id=\"app\"]/main/div/div[4]/div/div/div[12]");
    private By eliminarFuncionario2ConfirmButton = By.xpath("//button[normalize-space()='Eliminar Funcionario']");
    private By funcionarioEliminadoText = By.xpath("//div[@role='alert']");
    private By inactiveButton = By.xpath("//*[@id=\"app\"]/main/div/div[3]/div/div/a[3]");

    private By createFuncionarioButton = By.xpath("//i[@class='bi bi-plus']");
    private By createFuncionarioNameInput = By.xpath("//input[@id='nombre']");
    private By createFuncionarioLastNameInput = By.xpath("//input[@id='apellido']");
    private By createFuncionarioCedulaInput = By.xpath("//input[@id='cedula']");
    private By createFuncionarioPhoneInput = By.xpath("//input[@id='telefono']");
    private By createFuncionarioEmailInput = By.xpath("//input[@id='email']");
    private By createFuncionarioPasswordInput = By.xpath("//input[@id='password']");
    private By createFuncionarioRole = By.xpath("//select[@id='rol']");
    private By createFuncionarioSubmitButton = By.xpath("//button[@type='submit']");

    // ======= CONSTRUCTOR =======
    public FuncionariosPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public boolean isFuncionario2CardVisible() {
        return driver.findElement(funcionario2Card).isDisplayed();
    }

    public boolean isNOTFuncionario2CardVisible() {
        return driver.findElements(funcionario2Card).isEmpty();
    }

    public boolean isFuncionario2CardInactiveVisible() {
        return driver.findElement(funcionario2CardInactive).isDisplayed();
    }

    public void clickFuncionario2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar a que sea visible
        WebElement boton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(detallesFuncionario2)
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

    public void clickEliminarFuncionario2Confirm() {
        driver.findElement(eliminarFuncionario2ConfirmButton).click();
    }

    public void aceptarAlerta(){  
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isFuncionarioEliminadoTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(funcionarioEliminadoText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickInactiveButton() {
        driver.findElement(inactiveButton).click();
    }

    public void clickCreateFuncionarioButton() {
        driver.findElement(createFuncionarioButton).click();
    }
    
    public void enterCreateFuncionarioName(String name) {
        driver.findElement(createFuncionarioNameInput).sendKeys(name);
    }

    public void enterCreateFuncionarioLastName(String lastName) {
        driver.findElement(createFuncionarioLastNameInput).sendKeys(lastName);
    }

    public void enterCreateFuncionarioCedula(String cedula) {
        driver.findElement(createFuncionarioCedulaInput).sendKeys(cedula);
    }

    public void enterCreateFuncionarioPhone(String phone) {
        driver.findElement(createFuncionarioPhoneInput).sendKeys(phone);
    }

    public void enterCreateFuncionarioEmail(String email) {
        driver.findElement(createFuncionarioEmailInput).sendKeys(email);
    }

    public void enterCreateFuncionarioPassword(String password) {
        driver.findElement(createFuncionarioPasswordInput).sendKeys(password);
    }

    public void selectCreateFuncionarioRole(String role) {
        WebElement selectElement = driver.findElement(createFuncionarioRole);
        selectElement.click(); // Abrir el dropdown
        WebElement option = selectElement.findElement(By.xpath(".//option[normalize-space()='" + role + "']"));
        option.click(); // Seleccionar la opción
    }

    public void clickCreateFuncionarioSubmit() {
        driver.findElement(createFuncionarioSubmitButton).click();
    }


}

