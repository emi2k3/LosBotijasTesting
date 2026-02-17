package com.example;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RegistroContactoPage {

    private WebDriver driver;
    private String url = "http://reto2026.brazilsouth.cloudapp.azure.com/registro/contacto";


    private By nameInput = By.xpath("//input[@placeholder='Pedro']");
    private By lastNameInput = By.xpath("//input[@placeholder='Pérez']");
    private By cedulaInput = By.xpath("//input[@placeholder='1.234.567-8 o 12345678']");
    private By emailInput = By.xpath("//input[@placeholder='correo@ejemplo.com']");
    private By phoneInput = By.xpath("//input[@placeholder='099 123 456 o 2901 2345']");
    private By passwordInput = By.xpath("//input[@id='contacto_password']");
    private By acceptDataCheckbox = By.xpath("//input[@id='consentimiento_datos']");

    private By submitButton = By.xpath("//button[@type='submit']");

    private By comercialName = By.xpath("//input[@name='nombre_comercial']");
    private By unitType = By.xpath("//select[@id='tipo-unidad']");
    private By personQuantity = By.xpath("//select[@name='cantidad_personas']");
    private By onlineCanalCheckbox = By.xpath("//input[@id='canal_online']");
    public By descriptionInput = By.xpath("//textarea[@name='descripcion']");

    private By confirmButton = By.xpath("//button[@type='submit']");

    //Error form message
    private By formEmailError = By.xpath("//div[@class='invalid-feedback']");



    public RegistroContactoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public String generarCedula() {
        Random random = new Random();

        // Generar número base de 7 dígitos (con ceros a la izquierda si es necesario)
        int numeroBase = random.nextInt(10_000_000);
        String base = String.format("%07d", numeroBase);

        int[] coeficientes = {2, 9, 8, 7, 6, 3, 4};
        int suma = 0;

        // Calcular suma ponderada
        for (int i = 0; i < 7; i++) {
            int digito = Character.getNumericValue(base.charAt(i));
            suma += digito * coeficientes[i];
        }

        int resto = suma % 10;
        int digitoVerificador = (resto == 0) ? 0 : 10 - resto;

        return base + digitoVerificador;
    }

    public String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            email.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        email.append("@example.com");
        return email.toString();
    }


    public void RegisterStepOne(String name, String lastName, String cedula, String email, String phone, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(cedulaInput).sendKeys(cedula);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(acceptDataCheckbox).click();
        driver.findElement(submitButton).click();
    }

    public void RegisterStepTwo(String comercialName, String unitType, String personQuantity, String description) {
        driver.findElement(this.comercialName).sendKeys(comercialName);
        driver.findElement(this.unitType).sendKeys(unitType);
        driver.findElement(this.personQuantity).sendKeys(personQuantity);
        driver.findElement(this.descriptionInput).sendKeys(description);
        driver.findElement(onlineCanalCheckbox).click();
        driver.findElement(submitButton).click();
    }

    public boolean isFormEmailErrorVisible() {
        try {
            driver.findElement(formEmailError);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
