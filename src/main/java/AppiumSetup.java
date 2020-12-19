import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumSetup {
    private static AndroidDriver driver;
    public static void main(String[] args) {
        try {
            openApp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Starting app failed");
        }
        try {
            testDagboek();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void openApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability("platformName","android");
        cap.setCapability("appPackage","com.example.faith");
        cap.setCapability("appActivity",".MainActivity");
        cap.setCapability("noReset",true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,cap);
        System.out.println("App started");

    }
    private static void testDagboek() throws InterruptedException {
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
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("com.example.faith:id/image_bib");
        el4.click();
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("add_dagboek");
        el5.click();
        Thread.sleep(2000);
        MobileElement el6 = (MobileElement) driver.findElementById("com.example.faith:id/textInputTitelDagboek");
        el6.click();
        el6.sendKeys("Dagboektest");
        driver.navigate().back();
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.faith:id/textInputDescription");
        el7.click();
        el7.sendKeys("Dagboektest");
        driver.navigate().back();
        MobileElement el8 = (MobileElement) driver.findElementById("com.example.faith:id/btSaveDagboek");
        el8.click();
        Thread.sleep(2000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout");
        el9.click();

    }

}
