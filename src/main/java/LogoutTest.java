import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class LogoutTest {
    private static AndroidDriver driver;

    @Before
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
        el2.sendKeys("P@ssword123");
        driver.navigate().back();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.faith:id/button_login");
        el3.click();
        System.out.println("logged in");
    }

    @Test
    public void logoutTest() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.faith:id/image_bar");
        Assert.assertTrue(Boolean.parseBoolean(el1.getAttribute("displayed")));
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("More options");
        el2.click();
        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.click();
        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.faith:id/editTextTextEmailAddress");
        Assert.assertTrue(Boolean.parseBoolean(el4.getAttribute("displayed")));
    }
}
