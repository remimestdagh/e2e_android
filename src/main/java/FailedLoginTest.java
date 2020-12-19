import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FailedLoginTest {
    private static AndroidDriver driver;

    @Test
    public void init() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("platformName", "android");
        cap.setCapability("appPackage", "com.example.faith");
        cap.setCapability("appActivity", ".MainActivity");
        cap.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, cap);
        System.out.println("App started");

        Thread.sleep(2000);
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.faith:id/editTextTextEmailAddress");
        el1.click();
        el1.sendKeys("jef.seys.y0431@student.hogent.be");
        driver.navigate().back();
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.faith:id/editTextNumberPassword");
        el2.click();
        el2.sendKeys("VERKEERD");
        driver.navigate().back();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.faith:id/button_login");
        el3.click();
        Assert.assertTrue(Boolean.parseBoolean(el3.getAttribute("displayed")));
    }
}
