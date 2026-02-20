package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrearProgramaPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======
    private By crearProgramaText = By.xpath("//h2[@class='fw-normal mb-0']");

    //Formulario
    private By programaNombreInput = By.xpath("//input[@id='nombre']");
    private By programaEstadoSelector = By.xpath("//select[@id='estado']");
    private By programaDescripcionCorta = By.xpath("//input[@id='breve_descripcion']");
    private By programaDescripcionLarga = By.xpath("//textarea[@id='descripcion_completa']");
    private By programaObjetivos = By.xpath("//textarea[@id='objetivo']");
    private By programaDocumentacionRequerida = By.xpath("//textarea[@id='documentacion_requerida']");
    
    private By campoProgramaNombre = By.xpath("//input[@placeholder='ej: nombre_completo (sin espacios)']");
    private By campoProgramaTipo = By.xpath("//select[@name='requisitos[0][tipo]']");
    private By campoProgramaEtiqueta = By.xpath("//input[@placeholder='ej: Nombre Completo']");
    private By campoProgramaObligatorio = By.xpath("//input[@name='requisitos[0][requerido]']");

    private By fechaProgramaInicio = By.xpath("//input[@id='fecha_inicio_postulacion']");
    private By fechaProgramaFin = By.xpath("//input[@id='fecha_cierre_postulacion']");
    
    private By submitButton = By.cssSelector("button[type='submit'].px-4");

    private By formErrorMessage = By.xpath("//div[@class='alert alert-danger py-2']");
    private By formStartDateErrorMessage = By.xpath("//div[@class='invalid-feedback' and contains(text(), 'La fecha de inicio no puede superar los 5 años desde hoy')]");
    private By formEndDateErrorMessage = By.xpath("//div[@class='invalid-feedback' and contains(text(), 'La fecha de cierre no puede superar los 5 años desde hoy')]");

    // ======= CONSTRUCTOR =======
    public CrearProgramaPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void completarFormulario(String nombre,
                                 String estado,
                                 String descripcionCorta,
                                 String descripcionLarga,
                                 String objetivos,
                                 String requisitos,
                                 String documentacionRequerida,
                                 String nombreProgramaNombre,
                                 String tipoRequisito,
                                 String etiquetaRequisito,
                                 String fechaInicioRequisito,
                                 String fechaFinRequisito) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    type(wait, programaNombreInput, nombre);
    type(wait, programaEstadoSelector, estado);
    type(wait, programaDescripcionCorta, descripcionCorta);
    type(wait, programaDescripcionLarga, descripcionLarga);

    // Este campo está disparando el re-render
    type(wait, programaObjetivos, objetivos);

    type(wait, programaDocumentacionRequerida, documentacionRequerida);
    type(wait, campoProgramaNombre, nombreProgramaNombre);
    type(wait, campoProgramaTipo, tipoRequisito);
    type(wait, campoProgramaEtiqueta, etiquetaRequisito);
    type(wait, fechaProgramaInicio, fechaInicioRequisito);
    type(wait, fechaProgramaFin, fechaFinRequisito);
    }


    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // ======= Metodos para assertions =======
    public boolean isCrearProgramaDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(crearProgramaText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFormErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(formErrorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isStartDateErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(formStartDateErrorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEndDateErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(formEndDateErrorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ======= Helper Methods =======
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
        new org.openqa.selenium.support.ui.Select(element)
                .selectByVisibleText(text);
    } else {
        element.clear();
        element.sendKeys(text);
    }
    }



    
}

