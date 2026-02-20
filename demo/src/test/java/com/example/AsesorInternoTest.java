package com.example;

import org.openqa.selenium.edge.EdgeDriver;


import org.junit.jupiter.api.*;
import org.openqa.selenium.*;


public class AsesorInternoTest {
 private WebDriver driver;
    private LoginPage loginPage;
    private LoginVerificarPage loginVerificarPage;
    private HomePage homePage;
    private ListadoEvaluacionesPage listadoEvaluacionesPage;

@BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        System.setProperty("webdriver.edge.driver","C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"); 
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        loginVerificarPage= new LoginVerificarPage(driver);
        homePage=new HomePage(driver);
        listadoEvaluacionesPage=new ListadoEvaluacionesPage(driver);
        
        loginPage.open();
        loginPage.enterCedula("56789012"); 
                loginPage.enterPassword("password");
                loginPage.clickLoginButton();
                loginVerificarPage.byPassCode();
    }

     @Test
    void administrarPostulacion() {
        homePage.clickAdministrarPostulaciones();
    }

    @Test
    void crearEvaluacion() {
        homePage.clickEvaluaciones();
        listadoEvaluacionesPage.clickNuevaEvaluacion();// manda 403
        
    }

}
