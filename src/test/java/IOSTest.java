import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;

public class IOSTest extends iOSPractice {
    public static void main(String[] args) throws MalformedURLException {

        IOSDriver<IOSElement> driver= iosCapab();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//*[@value='Text Entry']").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello");
        driver.findElementByName("OK").click();
        driver.navigate().back();

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);

        TouchAction action = new TouchAction(driver);
    }
}

