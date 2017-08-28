package configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TestInitiation {

    public AndroidDriver androidDriver;
    public String prefix;

    public String randomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
    public String email = prefix + "email" + randomText + "@gmail.com";
    public String firstName = "test";
    public String lastName = "name";
    public String pin = "123456";
    public String walletID = "q@111111";

    @BeforeTest
    @Parameters({"platformName","platformVersion", "deviceName", "uRL", "prefix"})
    public void initializeTestSuite(String platformName, String platformVersion, String deviceName, String uRL, String prefix) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

//        Device information
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

//        App information
        caps.setCapability("appPackage","com.mobi.kiple");
        caps.setCapability("appActivity","com.mobi.wallet.MainActivity");
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

//        Server inform
        androidDriver = new AndroidDriver(new URL(uRL), caps);
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//        Initialize variable "prefix" from Parameter of TestNG
        this.prefix = prefix;
    }

    @AfterTest
    public void cleanTestSuite(){
        androidDriver.closeApp();
        androidDriver.quit();
    }
}
