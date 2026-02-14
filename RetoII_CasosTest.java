package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class RetoII_CasosTest {

    private WebDriver driver;
    private RetoII_Home retoII_Home;
    private RetoII_EditarContacto retoII_EditarContacto;
    private RetoII_ListadoContactos retoII_ListadoContactos;
    private RetoII_NuevoContacto retoII_NuevoContacto;
    private RetoII_Login retoII_Login;
    private RetoII_SignIn retoII_SingIn;

    @BeforeEach
        public void setUp() {

        EdgeOptions options = new EdgeOptions();

        options.addArguments(
                "--disable-notifications",
                "--disable-geolocation",
                "--disable-infobars"
        );

        options.addArguments("load-extension=C:\\Users\\jleod\\Reto II\\resorses\\2026.208.2004_0");

        System.setProperty("webdriver.edge.driver", "C:\\Users\\jleod\\Reto II\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        retoII_Home = new RetoII_Home(driver);
        retoII_EditarContacto = new RetoII_EditarContacto(driver);
        retoII_ListadoContactos = new RetoII_ListadoContactos(driver);
        retoII_NuevoContacto = new RetoII_NuevoContacto(driver);
        retoII_Login = new RetoII_Login(driver);
        retoII_SingIn = new RetoII_SignIn(driver);

        driver.navigate().to("http://reto2026.brazilsouth.cloudapp.azure.com/");

    }

    @Test
    public void Caso1() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.clickGestionarContactos();
        retoII_ListadoContactos.clickNuevoContacto();

        retoII_NuevoContacto.enterNombre("juan");
        retoII_NuevoContacto.enterTelefono("123456789");
        retoII_NuevoContacto.enterApellido("perez");
        retoII_NuevoContacto.enterEmail("dual.perfil@demo.com");
        retoII_NuevoContacto.enterCedula("5555555");
        retoII_NuevoContacto.enterContrasena("password123");
        retoII_NuevoContacto.selectRol("Encargado");
        retoII_NuevoContacto.checkAceptar();
        retoII_NuevoContacto.clickGuardarContacto();
        retoII_NuevoContacto.getErrorMessage();
    }

    @Test
    public void Caso2() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_Home.clickGestionarFuncionarios();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("6666666");
        retoII_EditarContacto.editarEmail("juan.perez@demo.com");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_EditarContacto.editarCentroUnidad("Centro de Desarrollo");
        retoII_EditarContacto.selectRolFuncionario("Desarrollador");
        retoII_EditarContacto.selectEstado("Activo");
        retoII_EditarContacto.clickGuardarCambios();

    }

    @Test
    public void Caso3() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_Home.clickGestionarFuncionarios();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("919115652");
        retoII_EditarContacto.editarEmail("erich95@example.com");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_EditarContacto.editarCentroUnidad("Centro de Desarrollo");
        retoII_EditarContacto.selectRolFuncionario("Desarrollador");
        retoII_EditarContacto.selectEstado("Activo");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso4() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_Home.clickGestionarFuncionarios();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("69816032");
        retoII_EditarContacto.editarEmail("juanceto01@example.com");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_EditarContacto.editarCentroUnidad("Centro de Desarrollo");
        retoII_EditarContacto.selectRolFuncionario("Desarrollador");
        retoII_EditarContacto.selectEstado("Activo");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso5() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_Home.clickGestionarFuncionarios();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("69816032");
        retoII_EditarContacto.editarEmail("erich95@example.com");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        retoII_EditarContacto.editarCentroUnidad("Centro de Desarrollo");
        retoII_EditarContacto.selectRolFuncionario("Desarrollador");
        retoII_EditarContacto.selectEstado("Activo");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso6() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        retoII_Home.clickGestionarContactos();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("12779918");
        retoII_EditarContacto.editarEmail("sbogisich@example.com");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso7() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        retoII_Home.clickGestionarContactos();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("16145618");
        retoII_EditarContacto.editarEmail("sbogisich@example.com");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso8() {

        retoII_Login.enterCedula("12345678");
        retoII_Login.enterPassword("password");
        retoII_Login.clickRememberCheckbox();
        retoII_Login.clickLoginButton();

        retoII_Home.isHomePageLoaded();
        retoII_Home.clickGestionarContactos();
        retoII_ListadoContactos.clickEditarContacto();

        retoII_EditarContacto.editarNombre("juan");
        retoII_EditarContacto.editarTelefono("123456789");
        retoII_EditarContacto.editarApellido("perez");
        retoII_EditarContacto.editarCedula("12779918");
        retoII_EditarContacto.editarEmail("paconi@example.com");
        retoII_EditarContacto.clickGuardarCambios();
        retoII_NuevoContacto.getErrorMessage();

    }

    @Test
    public void Caso9() {

        retoII_Login.clickRegisterLink();

        retoII_SingIn.enterNombre("juan");
        retoII_SingIn.enterTelefono("123456789");
        retoII_SingIn.enterApellido("perez");
        retoII_SingIn.enterEmail("erich95@example.com");
        retoII_SingIn.enterCedula("5555555");
        retoII_SingIn.enterContrasena("password123");
        retoII_SingIn.checkAceptar();
        retoII_SingIn.clickGuardarContacto();
        retoII_SingIn.getErrorMessage();

    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }
}

