package modules;

import configurations.TestInitiation;
import objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.AndroidPageFactory;

import java.util.List;

public class test extends TestInitiation {

    private LogInLocators LoginScreen;
    private WalletLocators WalletScreen;
    private MobileReloadLocators MobileReloadScreen;
    private PayBillsLocators PayBillsScreen;
    private UserProfileLocators UserProfileScreen;
    private EditProfileLocators EditProfileScreen;
    private WithdrawCashLocators WithdrawCashScreen;

    @BeforeMethod
    public void setUp(){
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        MobileReloadScreen = AndroidPageFactory.initElements(androidDriver, MobileReloadLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        PayBillsScreen = AndroidPageFactory.initElements(androidDriver, PayBillsLocators.class);
        UserProfileScreen = AndroidPageFactory.initElements(androidDriver, UserProfileLocators.class);
        EditProfileScreen = AndroidPageFactory.initElements(androidDriver, EditProfileLocators.class);
        WithdrawCashScreen = AndroidPageFactory.initElements(androidDriver, WithdrawCashLocators.class);
    }

    @Test
    public void testcase() throws InterruptedException {
        LoginScreen.logIn("uat10@mailinator.com", "q1111111");
        Thread.sleep(3000);
        WalletScreen.btn_Profile.click();
        Thread.sleep(3000);
        UserProfileScreen.btn_EditProfile.click();
        Thread.sleep(3000);

//        Select operator
//        while (currentBill != "UMobile"){
        EditProfileScreen.spn_Country.click();
//            Thread.sleep(10000);
//            List<WebElement> imageView = androidDriver.findElements(By.className("android.widget.ImageView"));
//            imageView.get(count).click();
//            count = count + 1;
//            Thread.sleep(10000);
        EditProfileScreen.btn_Close.click();
            List<WebElement> editView = androidDriver.findElements(By.className("android.widget.EditText"));
            System.out.println(editView.size());
//            currentOperator = MobileReloadScreen.spn_MobileOperator.getText();
//            System.out.println("Get lần " + count + ": " + currentOperator);
//        }
    }
}
