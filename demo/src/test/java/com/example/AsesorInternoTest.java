package com.example;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AsesorInternoTest {

    private WebDriver driver;
    private HomePage HomePage;
    private LoginPage LoginPage;
    private ProgramasPage ProgramasPage;
   

    // CAMBIAR ESTO EN BASE AL ENTORNO QUE EJECUTA EL TESTING
private String path_to_extension = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\2026.208.2004_0";
private String path_to_driver = "C:\\Users\\Usuario\\OneDrive\\Escritorio\\InnovaAutomation\\edgedriver_win64\\msedgedriver.exe";

    // Setup
    @BeforeEach
        public void setUp() {

        EdgeOptions options = new EdgeOptions();

        options.addArguments(
                "--disable-notifications",
                "--disable-geolocation",
                "--disable-infobars"
        );

        options.addArguments("load-extension=" + path_to_extension);
        System.setProperty("webdriver.edge.driver", path_to_driver);

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        HomePage = new HomePage(driver);
        LoginPage = new LoginPage(driver);
        ProgramasPage= new ProgramasPage(driver);
      
        }

         public void LoginAsAsesorInterno() {
                LoginPage.openPage();
                LoginPage.enterCedula("45678901");
                LoginPage.enterPassword("password");
                LoginPage.clickLoginButton();

        }

        
    
    @AfterEach
        public void tearDown() {
                if (driver != null) {
              //  driver.quit(); //cierra el edge.
                }
        }
}
