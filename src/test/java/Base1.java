import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base1 {
    public static AndroidDriver<AndroidElement> Capab() throws MalformedURLException {

        AndroidDriver<AndroidElement> driver;
        File appDir = new File("src/test/java/");
        File app = new File(appDir, "General-Store.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM_N975U1");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AppiumDriverLocalService.buildDefaultService().start();


        AndroidDriver <AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return androidDriver;
    }
}

