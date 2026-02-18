package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.*;


public class ProgramaTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private LoginVerificarPage loginVerificarPage;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        //System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64\\msedgedriver.exe");//Emma
        //System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\LosBotijasTesting\\edgedriver_win64\\msedgedriver.exe");//Nico D
        //System.setProperty("C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe"); //LucasChiappini
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginVerificarPage = new LoginVerificarPage(driver);
    }

    @Test
    void CrearProgramaValido() {
        loginPage.open();
        loginPage.login("12345678", "password");
        loginVerificarPage.byPassCode();
        homePage.clickCrearCatalogoProgramas();
        

    }
    
    @AfterEach
    void tearDown() {
        //driver.quit();
    }
}
