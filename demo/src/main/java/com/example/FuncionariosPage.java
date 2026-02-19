package com.example;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class FuncionariosPage {

    private WebDriver driver;

    private By createButton = By.cssSelector(".bi-plus");
    private By nameInput = By.id("nombre");
    private By lastNameInput = By.id("apellido");
    private By cedulaInput = By.id("cedula");
    private By phoneInput = By.id("telefono");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By roleSelect = By.id("rol");
    private By submitButton = By.xpath("//*[@id='app']/main/div/div/div/div[2]/form/div[6]/button");
    private By alertMessage = By.xpath("//div[@role='alert']");

    public FuncionariosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreate() {
        driver.findElement(createButton).click();
    }

    public void fillForm(String name, String lastName, String cedula, String phone, String email, String password) {

        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(cedulaInput).sendKeys(cedula);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectRole(String role) {
        driver.findElement(roleSelect).sendKeys(role);
    }

    public void submit() {
        driver.findElement(submitButton).click();
    }

    public boolean isAlertVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        return true;
    }
}
