package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By successModalTitle = By.id("example-modal-sizes-title-lg");

    private By welcomeText = By.xpath("//h1[@class='h3 fw-bold mb-1']");

    private By homePageLoad = By.xpath("//p[normalize-space()='Panel de Funcionario']");


    //Gestionar funcionarios
    private By verGestionarUsuarioButton = By.cssSelector(".btn.btn-secondary.btn-sm.px-3");
    private By gestionarEditarUsuarioButton= By.xpath("//a[contains(@href,'/edit')]");

    private By crearFuncionarioButton = By.cssSelector(".btn.btn-outline-secondary.btn-sm.px-3");

    //Gestionar contactos
private By perfilContacto =
        By.xpath("//a[contains(@class,'dropdown-toggle')]");
        private By nuevaPostulacionButton =
        By.xpath("//a[normalize-space()='Nueva postulación']");
        private By enPostulacion=By.xpath("//*[@id=\"app\"]/main/div/div[2]/div[1]");
        private By tituloPostulaciones = By.xpath("//h1[contains(text(),'Postulaciones a programas')]");
private By postularmeButton =
        By.xpath("//a[contains(@class,'btn-primary') and normalize-space()='Postularme']");
        


    //Agenda Reuniones
    private By verAgendaReunionesButton = By.xpath("//a[@class='btn btn-success btn-sm px-3'][contains(text(),'Ver')]");

    //Segimiento Evaluaciones
    private By responderIsLoad = By.xpath("//*[@id='app']'/main/div/div/div/form/div[2]/div[1]/h3'");
    private By responderEvaluaciones = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/contacto/respuestas/create']");
    private By verEvaluacionesButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/evaluaciones']");
    private By resultadoEvaluacionesButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/contacto/mis-resultados']");

    //Catalogo Programas
    private By vercatalogoProgramasButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/programas'][normalize-space()='Ver']");
    private By crearCatalogoProgramasButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/programas/create']");

    
    //Gestion Postulaciones
    private By verPostulacionesButton = By.xpath("//a[@class='btn btn-danger btn-sm px-3'][contains(text(),'Ver postulaciones')]");
    private By administrarPostulacionesButton =
        By.xpath("//a[normalize-space()='Administrar']");
private By desactivarCuentaButton =
        By.cssSelector("button[data-bs-target='#deleteModalAccountModal']");

private By confirmarDesactivarBtn =
    By.cssSelector("#deleteModalAccountModal .btn-danger");




    //Seguimiento Planes de accion
    private By planesButton = By.xpath("//a[@class='btn btn-primary btn-sm px-3'][contains(text(),'Planes')]");
    private By accionesButton = By.xpath("//a[@class='btn btn-outline-primary btn-sm px-3'][contains(text(),'Acciones')]");

    //Unidades de atencion
    private By verUnidadesAtencionButton =
    By.xpath("//*[@id='app']/main/div/div/div[2]/div[1]/div/div/div[2]/a");
    private By evaluacionesButton =
        By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[2]/div/div/div[2]/a[1]");
    //Para hacer logout
    private By userMenuButton = By.xpath("//span[@class='text-white fw-semibold']");
    private By logoutButton = By.xpath("//button[normalize-space()='Cerrar sesión']");

    //Roles asesor
    private By resultadoEvaluacionesAsAsesorButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/funcionario/resultados']");
    private By verEvaluacionesAsAsesorButton = By.xpath("//a[@href='https://saltoinnova.brazilsouth.cloudapp.azure.com/evaluaciones']");


    // ======= CONSTRUCTOR =======
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======
    public void openPage() {
        driver.get(url);
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(userMenuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
    
    public void clickEvaluaciones() {
        driver.findElement(evaluacionesButton).click();
    }

  public void clickPerfilContacto() {
        driver.findElement(perfilContacto).click();
    }

     public void clickNuevaPostulacion() {
        driver.findElement(nuevaPostulacionButton).click();
    }

     public void clickEnPostulacion() {
        driver.findElement(enPostulacion).click();
    }

    public void clickPostularme() {
    driver.findElement(postularmeButton).click();
}

    public String obtenerTituloPostulaciones() {
    return driver.findElement(tituloPostulaciones).getText();
}
    
    public boolean isWelcomeTextDisplayed() {
        return driver.findElement(welcomeText).isDisplayed();
    }

    public void clickVerGestionarUsuario() {
        driver.findElement(verGestionarUsuarioButton).click();
    }


     public void clickEditarUsuario() {
        driver.findElement(gestionarEditarUsuarioButton).click();
    }

 public void clickDesactivarCuenta() {
driver.findElement(desactivarCuentaButton).click();
}



    public boolean isHomePageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLoad)).isDisplayed();
    }

    public void clickCrearFuncionario() {
        driver.findElement(crearFuncionarioButton).click();
    }

    public void clickVerAgendaReuniones() {
        driver.findElement(verAgendaReunionesButton).click();
    }

    public void clickSeguimientoEvaluaciones() {
        driver.findElement(verEvaluacionesButton).click();
    }

    public void clickResultadoEvaluaciones() {
        driver.findElement(resultadoEvaluacionesButton).click();
    }

    public void clickVerCatalogoProgramas() {
        driver.findElement(vercatalogoProgramasButton).click();
    }

    public void clickCrearCatalogoProgramas() {
        driver.findElement(crearCatalogoProgramasButton).click();
    }

    public void clickVerPostulaciones() {
        driver.findElement(verPostulacionesButton).click();
    }

    public void clickAdministrarPostulaciones() {
        driver.findElement(administrarPostulacionesButton).click();
    }

    public void clickPlanes() {
        driver.findElement(planesButton).click();
    }

    public void clickAcciones() {
        driver.findElement(accionesButton).click();
    }

    public void clickVerUnidadesAtencion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(verUnidadesAtencionButton)).click();
    }

    

    // ======= GETTERS (para assertions) =======
    public String getSuccessModalTitle() {
        return driver.findElement(successModalTitle).getText();
    }
}

