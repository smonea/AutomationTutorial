package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    public WebDriver driver;

    @BeforeMethod

    public void prepareEnvironment (){

        driver = new EdgeDriver();

        //Accesam o pagina specifica.

        driver.get("https://demoqa.com");

        //Facem browserul in modul maximize.

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod

    public void clearEnvironment(){
        driver.quit();
    }
}
