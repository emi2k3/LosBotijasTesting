package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private By programaRequisitos = By.xpath("//textarea[@id='requisitos']");
    private By programaDocumentacionRequerida = By.xpath("//textarea[@id='documentacion_requerida']");
    
    private By campoProgramaNombre = By.xpath("//input[@placeholder='ej: nombre_completo (sin espacios)']");
    private By campoProgramaTipo = By.xpath("//select[@name='requisitos[0][tipo]']");
    private By campoProgramaEtiqueta = By.xpath("//input[@placeholder='ej: Nombre Completo']");
    private By campoProgramaObligatorio = By.xpath("//input[@name='requisitos[0][requerido]']");

    private By fechaProgramaInicio = By.xpath("//input[@id='fecha_inicio_postulacion']");
    private By fechaProgramaFin = By.xpath("//input[@id='fecha_cierre_postulacion']");
    
    private By submitButton = By.xpath("//button[normalize-space()='Guardar']");

    // ======= CONSTRUCTOR =======
    public CrearProgramaPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void completarFormulario(String nombre, String estado, String descripcionCorta, String descripcionLarga, String objetivos, String requisitos, String documentacionRequerida) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(programaNombreInput)).sendKeys(nombre);
        wait.until(ExpectedConditions.elementToBeClickable(programaEstadoSelector)).sendKeys(estado);
        wait.until(ExpectedConditions.elementToBeClickable(programaDescripcionCorta)).sendKeys(descripcionCorta);
        wait.until(ExpectedConditions.elementToBeClickable(programaDescripcionLarga)).sendKeys(descripcionLarga);
        wait.until(ExpectedConditions.elementToBeClickable(programaObjetivos)).sendKeys(objetivos);
        wait.until(ExpectedConditions.elementToBeClickable(programaRequisitos)).sendKeys(requisitos);
        wait.until(ExpectedConditions.elementToBeClickable(programaDocumentacionRequerida)).sendKeys(documentacionRequerida);
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
    
    
}

