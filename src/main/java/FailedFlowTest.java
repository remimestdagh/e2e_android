import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FailedFlowTest {
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
    public void testDagboekVerkeerdeValidatie() throws InterruptedException {

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.faith:id/image_bib");
        el4.click();
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("add_dagboek");
        el5.click();
        Thread.sleep(2000);
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.faith:id/textInputTitelDagboek");
        el6.click();
        el6.sendKeys("");
        driver.navigate().back();
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.faith:id/textInputDescription");
        el7.click();
        el7.sendKeys("Dagboektest");
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.faith:id/btSaveDagboek");
        el8.click();
        Thread.sleep(2000);
        Assert.assertTrue(Boolean.parseBoolean(el8.getAttribute("displayed")));

    }
    @Test
    public void testInfoBalieVerkeerdeValidatie() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.faith:id/image_bali");
        el4.click();
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Hulpbron toevoegen");
        el5.click();
        Thread.sleep(2000);
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.faith:id/textInputTitel");
        el6.click();
        el6.sendKeys("");
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.faith:id/textInputBeschrijving");
        el7.click();
        el7.sendKeys("");
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.faith:id/textInputEmailadres");
        el8.click();
        el8.sendKeys("test@test.be");
        driver.navigate().back();
        MobileElement el9 = (MobileElement) driver.findElementById("com.example.faith:id/textInputTelefoonnummer");
        el9.click();
        el9.sendKeys("050211364");
        driver.navigate().back();
        MobileElement el10 = (MobileElement) driver.findElementById("com.example.faith:id/textInputUrl");
        el10.click();
        el10.sendKeys("www.epic.be");
        driver.navigate().back();
        MobileElement el11 = (MobileElement) driver.findElementById("com.example.faith:id/textInputChatUrl");
        el11.click();
        el11.sendKeys("www.epic.be/test");
        driver.navigate().back();
        MobileElement el12 = (MobileElement) driver.findElementById("com.example.faith:id/btnSaveHulpbron");
        el12.click();
        Thread.sleep(2000);
        Assert.assertTrue(Boolean.parseBoolean(el12.getAttribute("displayed")));

    }
}
