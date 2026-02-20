package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditarProgramaPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    // Botones de navegación entre secciones del formulario
    private By generalButton   = By.xpath("//button[@id='tab-general-tab']");
    private By contenidoButton = By.xpath("//button[@id='tab-contenido-tab']");
    private By fechasButton    = By.xpath("//button[@id='tab-fechas-tab']");

    // Formulario general
    private By nombreProgramaInput  = By.xpath("//input[@id='nombre']");
    private By estadoProgramaSelector = By.xpath("//select[@id='estado']");
    private By descripcionCortaInput = By.xpath("//input[@id='breve_descripcion']");

    // Formulario contenido
    private By descripcionLargaInput      = By.xpath("//textarea[@id='descripcion_completa']");
    private By objetivosInput             = By.xpath("//textarea[@id='objetivo']");
    private By requisitosNombreCampoInput = By.xpath("//input[@name='requisitos[0][nombre]']");
    private By requisitosTipoCampoSelector = By.xpath("//select[@name='requisitos[0][tipo]']");
    private By requisitosEtiquetaCampoInput = By.xpath("//input[@name='requisitos[0][label]']");
    private By documentacionRequeridaInput = By.xpath("//textarea[@id='documentacion_requerida']");

    // Formulario fechas
    private By fechaInicioInput = By.xpath("//input[@id='fecha_inicio_postulacion']");
    private By fechaFinInput    = By.xpath("//input[@id='fecha_cierre_postulacion']");

    // Botón submit
    // La validación de errores es nativa del browser (tooltip HTML5), no hay alert en el DOM.
    // Para detectar que hubo error verificamos que seguimos en la página de edición.
    private By submitButton      = By.xpath("//button[normalize-space()='Actualizar']");
    private By editarProgramaTitle = By.xpath("//h1[contains(normalize-space(),'Editar programa')]");

    // ======= CONSTRUCTOR =======
    public EditarProgramaPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void completarFormularioGeneral(String nombre, String estado, String descripcionCorta) {
        scrollAndClick(generalButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        type(wait, nombreProgramaInput, nombre);
        type(wait, estadoProgramaSelector, estado);
        type(wait, descripcionCortaInput, descripcionCorta);
    }

    public void completarFormularioContenido(String descripcionLarga, String objetivos, String docRequerida, String reqNombre, String reqTipo, String reqEtiqueta) {
        scrollAndClick(contenidoButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        type(wait, descripcionLargaInput, descripcionLarga);
        type(wait, objetivosInput, objetivos);
        type(wait, documentacionRequeridaInput, docRequerida);
        type(wait, requisitosNombreCampoInput, reqNombre);
        type(wait, requisitosTipoCampoSelector, reqTipo);
        type(wait, requisitosEtiquetaCampoInput, reqEtiqueta);
    }

    public void completarFormularioFechas(String fechaInicio, String fechaFin) {
        scrollAndClick(fechasButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        type(wait, fechaInicioInput, fechaInicio);
        type(wait, fechaFinInput, fechaFin);
    }

    public void clickSubmit() {
        scrollAndClick(submitButton);
    }

    // ======= GETTERS (para assertions) =======

    /**
     * Retorna true si seguimos en la página de edición, lo que indica que
     * el browser bloqueó el submit por validación (tooltip HTML5 nativo).
     * Si el form se envió correctamente, navegamos a otra página y este
     * elemento ya no existe.
     */
    public boolean isGeneralFormErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(editarProgramaTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ======= Helper Methods =======
    private void scrollAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void type(WebDriverWait wait, By locator, String text) {
        WebElement element = wait.until(
                ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(locator)
                )
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        String tag = element.getTagName();

        if (tag.equalsIgnoreCase("select")) {
            if (text != null && !text.isEmpty()) {
                new org.openqa.selenium.support.ui.Select(element)
                        .selectByVisibleText(text);
            }
        } else {
            element.clear();
            element.sendKeys(text);
        }
    }
}