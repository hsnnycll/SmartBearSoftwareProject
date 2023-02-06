package smartBearProject.stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import smartBearProject.utilities.ConfigurationReader;
import smartBearProject.utilities.Driver;


public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(":::::::::TEST INFORMATION:::::::::");
        System.out.println("Browser :: " + ConfigurationReader.getProperty("browser"));
        System.out.println("URL :: " + ConfigurationReader.getProperty("url"));
        System.out.println("Environment :: " + ConfigurationReader.getProperty("environment"));
        System.out.println("Test Scenario :: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
