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

    public String randomDigit = new SimpleDateFormat("MMddHHmm").format(Calendar.getInstance().getTime());
    public String email = prefix + "email" + randomDigit + "@gmail.com";
    public String phoneNumber = "601" + randomDigit;
    public String password = "q1111111";
    public String fullName = "test name";
    public String otp = "123456";
    public String pin = "111111";


    @Parameters({"platformName","platformVersion", "deviceName", "uRL", "prefix"})
    @BeforeTest
    public void initializeTestSuite(String platformName, String platformVersion, String deviceName, String uRL, String prefix) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

//        Device information
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

//        App information
        caps.setCapability("appPackage","com.mobi.wallet");
        caps.setCapability("appActivity","com.mobi.wallet.MainActivity");
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

//        Server inform
        androidDriver = new AndroidDriver(new URL(uRL), caps);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        Initialize variable "prefix" from Parameter of TestNG
        this.prefix = prefix;
    }

    @AfterTest
    public void cleanTestSuite(){
        androidDriver.closeApp();
        androidDriver.quit();
    }
}
