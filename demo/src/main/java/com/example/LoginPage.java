package com.example;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage {

    private WebDriver driver;
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/login";

    /*
    12345678	admin_ti
    23456789	coordinacion
    34567890	asesor_interno
    45678901	asesor_interno
    56789012	asesor_externo
    67890123	asesor_externo
    78901234	recepcion
    01234567	consulta
    */

    private By cedulaInput = By.id("cedula");
    private By passwordInput = By.id("password");
    private By codigodeVerificacionInput = By.id("codigo");//000111
    private By loginButton = By.xpath("//button[@type='submit']");
    private By rememberCheckbox = By.id("remember");
    private By errorMessage = By.xpath("//strong[contains(text(),'incorrectos')]");
    private By RegisterLink = By.xpath("//a[normalize-space()='Registrate para recibir nuestra ayuda']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void login(String cedula, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cedulaInput)).sendKeys(cedula);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickRemember() {
        driver.findElement(rememberCheckbox).click();
    }

    public boolean isErrorVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void clickRegister() {
        driver.findElement(RegisterLink).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void codigodeVerificacion(String codigo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(codigodeVerificacionInput)).sendKeys(codigo);
    }

}
