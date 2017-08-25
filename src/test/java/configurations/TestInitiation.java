package configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestInitiation {

    public AndroidDriver androidDriver;

    @BeforeTest
    @Parameters({"platformName","platformVersion", "deviceName", "uRL", "appPackage", "appActivity"})
    public void setUp(String platformName, String platformVersion, String deviceName, String uRL, String appPackage, String appActivity) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

//        Device information
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

//        App information
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity",appActivity);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

//        Server inform
        androidDriver = new AndroidDriver(new URL(uRL), caps);
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        androidDriver.closeApp();
        androidDriver.quit();
    }
}
