import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.Platform.*;

/**
 * Created by Home on 7/8/2016.
 */
public class WebDriverFireFoxFactory {
    private static WebDriver driver;

    public WebDriverFireFoxFactory() {
    }

    public static WebDriver getWebDriverFireFox() {
        return new FirefoxDriver();

    }
    public static WebDriver getWebDriverCapabilitiesFireFox() {

       //https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
       // http://www.javased.com/?api=org.openqa.selenium.remote.DesiredCapabilities

        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(false);
        profile.setPreference("general.useragent.locale","en");
        profile.setPreference("intl.accept_languages","en");
        profile.setPreference("browser.download.downloadDir","C:\\Downloads");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
              return  new FirefoxDriver(capabilities);

    }
}

