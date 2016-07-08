

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Home on 7/8/2016.
 */
public class MyTest {
    protected static WebDriver driver;
    String baseUrl ="http://www.google.com";

    @BeforeClass
    public static void startBrowser() {
        driver = WebDriverFireFoxFactory.getWebDriverCapabilitiesFireFox();
        // Put an Implicit wait on driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void testDriver() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("lst-ib")).sendKeys("Харьков");
        driver.findElement(By.name("btnG")).click();
        Thread.sleep(2000);
        String firstValueActualResult = driver.findElement(By.xpath("//h3[contains(@class,'r')][1]/a")).getText();
        String expectedResult="Харьков — Википедия";
        Thread.sleep(2000);

        Assert.assertEquals(firstValueActualResult,expectedResult,"Test failed");
    }
    @AfterClass
    public static void closeBrowser() {
        driver.findElement(By.id("lst-ib")).clear();
        driver.quit();;
    }
}
