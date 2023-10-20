package stepDefinitions;

import config.env;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.io.IOException;

import static config.env.driver;
import static config.env.url;


public class Hooks {
    @Before
    public void before() {
        // Comment this when use edge instead chrome
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions opt = new ChromeOptions();
//        driver = new ChromeDriver();

        //Un comment this when use edge drive if there any version issue in chrome driver
        WebDriverManager.edgedriver().setup();
        EdgeOptions opt = new EdgeOptions();
        driver = new EdgeDriver(opt);

        driver.manage().window().maximize();
        driver.get(url);
    }


    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "/src/test/resources/screenshots/" + scenario.getName() + ".png"));
        }
        driver.quit();
    }
}
