import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

        File f = new File("src/test/java/");
        File fs = new File(f, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM_N975U1");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());


        var srv = AppiumDriverLocalService.buildDefaultService();


        if (srv.isRunning()) {
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else {
            throw new RuntimeException("appium isn't started");
        }

    }
}