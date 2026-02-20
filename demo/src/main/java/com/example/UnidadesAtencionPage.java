package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UnidadesAtencionPage {

    private WebDriver driver;

    // URL
    private String url = "https://saltoinnova.brazilsouth.cloudapp.azure.com/unidades-atencion";

    // ======= LOCALIZADORES Y ELEMENTOS =======

    private By crearUnidadButton =
            By.xpath("//a[contains(@href,'/registro/contacto/iniciar')]");

    // ======= CONSTRUCTOR =======
    public UnidadesAtencionPage(WebDriver driver) {
        this.driver = driver;
    }

    // ======= ACCIONES =======

    public void openPage() {
        driver.get(url);
    }

    public void clickCrearUnidad() {
        driver.findElement(crearUnidadButton).click();
    }
}
