package com.example;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class FuncionariosPage {

    private WebDriver driver;

    //private By createButton = By.cssSelector(".bi-plus");
    private By createButton = By.cssSelector("a[href*='funcionarios/create']");
    private By nameInput = By.id("nombre");
    private By lastNameInput = By.id("apellido");
    private By cedulaInput = By.id("cedula");
    private By phoneInput = By.id("telefono");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("funcionario_password");
    private By roleSelect = By.id("rol");
    private By submitButton = By.xpath("//button[normalize-space()='Guardar funcionario']");

    private By programaCard =
        By.cssSelector(".card.shadow-sm.rounded-4");
    private By editarProgramaBtn =
        By.cssSelector("a[title='Editar']");
    private By alertMessage = By.xpath("//div[@role='alert']");  
    private By verDetalleBtn =
        By.xpath("//a[normalize-space()='Ver detalle']");
    private By actualizarBtn =
        By.xpath("//button[.//text()[contains(.,'Actualizar')]]");
    private By estadoSelect = By.id("estado");

private By verProgramaButton =
        By.cssSelector("a[href*='programas']");
    public FuncionariosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProgramaCard() {
    driver.findElement(programaCard).click();
}

public void clickEditarPrograma() {
    driver.findElement(editarProgramaBtn).click();
}

public void clickVerDetalle() {
    driver.findElement(verDetalleBtn).click();
}

public void seleccionarEstadoCerrado() {
    new Select(driver.findElement(estadoSelect))
            .selectByVisibleText("Cerrado");
}

public void clickActualizar() {
    driver.findElement(actualizarBtn).click();
}


    public void clickCreate() {
        driver.findElement(createButton).click();
    }

    public void fillForm(String name, String lastName, String cedula,
                     String phone, String email, String password, String role) {

    driver.findElement(nameInput).sendKeys(name);
    driver.findElement(lastNameInput).sendKeys(lastName);
    driver.findElement(cedulaInput).sendKeys(cedula);
    driver.findElement(phoneInput).sendKeys(phone);
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);

    Select rol = new Select(driver.findElement(roleSelect));
    rol.selectByVisibleText(role.trim());
}

    public void submit() {
        driver.findElement(submitButton).click();
    }

       public void verProgramaClick() {
        driver.findElement(verProgramaButton).click();
    }

    public boolean isAlertVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        return true;
    }
}
