package modules;

import objects.*;
import org.testng.annotations.*;
import configurations.TestInitiation;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

public class Account extends TestInitiation {

    private LogInLocators LoginScreen;
    private TopUpLocators TopUpScreen;
    private SignUpLocators SignUpScreen;
    private EnterPinLocators SetPINScreen;
    private WalletLocators WalletScreen;
    private ProfileLocators ProfileScreen;
    private CreateWalletIdLocators CreateWalletIdScreen;
    private EnterReferralCodeLocators EnterReferralCodeScreen;
    private VerifyEmailOrPhoneNumberLocators VerifyEmailOrPhoneNumberScreen;

    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();

    @BeforeMethod
    public void initializeTestCase(){

//        Initialize locators
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        TopUpScreen = AndroidPageFactory.initElements(androidDriver, TopUpLocators.class);
        SignUpScreen = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
        SetPINScreen = AndroidPageFactory.initElements(androidDriver, EnterPinLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        ProfileScreen = AndroidPageFactory.initElements(androidDriver, ProfileLocators.class);
        CreateWalletIdScreen = AndroidPageFactory.initElements(androidDriver, CreateWalletIdLocators.class);
        EnterReferralCodeScreen = AndroidPageFactory.initElements(androidDriver, EnterReferralCodeLocators.class);
        VerifyEmailOrPhoneNumberScreen = AndroidPageFactory.initElements(androidDriver, VerifyEmailOrPhoneNumberLocators.class);
    }

    @Test
    public void VerifySigningUpAccountUsingEmail(){

//        Go to Sign Up screen
        LoginScreen.lbl_SignUp.click();

//        Check Point: Sign Up screen should appear
        softAssert1.assertTrue(SignUpScreen.txt_FullName.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_Username.isEnabled());
        softAssert1.assertTrue(SignUpScreen.spn_Country.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_Password.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_ConfirmPassword.isEnabled());
        softAssert1.assertTrue(SignUpScreen.btn_SignUp.isEnabled());

//        Enter full name
        SignUpScreen.txt_FullName.sendKeys(fullName);

//        Enter username
        SignUpScreen.txt_Username.sendKeys(email);

//        Enter password
        SignUpScreen.txt_Password.sendKeys(password);

//        Enter confirm password
        SignUpScreen.txt_ConfirmPassword.sendKeys(password);

//        Tap sign up
        SignUpScreen.btn_SignUp.click();

//        Check Point: Verify Email screen should appear
        softAssert1.assertEquals(VerifyEmailOrPhoneNumberScreen.ttl_VerifyEmailOrPhoneNumber.getText(), "Verify Email");

//        Enter OTP
        VerifyEmailOrPhoneNumberScreen.txt_OTP.sendKeys(otp);

//        Check Point: Enter Referral Code screen should appear
        softAssert1.assertEquals(EnterReferralCodeScreen.ttl_EnterReferralCode.getText(), "Enter Referral Code");

//        Check on "I don't have referral code" radio button
        EnterReferralCodeScreen.rad_NotHaveReferralCode.click();

//        Tap Submit button
        EnterReferralCodeScreen.btn_Submit.click();

//        Check Point: Wallet screen should appear
        softAssert1.assertTrue(WalletScreen.lbl_AvailableBalance.isDisplayed());
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifyCreatingWalletId(){

//        Tap Top up button
        WalletScreen.btn_TopUp.click();

//        Check Point: Create Wallet ID screen should appear
        softAssert2.assertEquals(CreateWalletIdScreen.ttl_CreateWalletId.getText(), "Create Wallet Id");

//        Check Point: The email should be displayed in Create Wallet Id screen
        softAssert2.assertEquals(CreateWalletIdScreen.lbl_username.getText(), email);

//        Enter Wallet pin
        CreateWalletIdScreen.txt_Pin.sendKeys(pin);

//        Enter confirm wallet pin
        CreateWalletIdScreen.txt_ConfirmPin.sendKeys(pin);

//        Tap Create Wallet button
        CreateWalletIdScreen.btn_CreateWallet.click();

//        Check Point: Top Up screen should appear
        softAssert2.assertEquals(TopUpScreen.ttl_TopUp.getText(), "Top Up");

//        Logout
        TopUpScreen.btn_Back.click();
        WalletScreen.btn_Profile.click();
        ProfileScreen.btn_Logout.click();
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifySigningUpAccountUsingPhoneNumber() throws InterruptedException {

//        Go to Sign Up screen
        LoginScreen.lbl_SignUp.click();

//        Enter full name
        SignUpScreen.txt_FullName.sendKeys(fullName);

//        Enter username
        SignUpScreen.txt_Username.sendKeys(phoneNumber);

//        Enter password
        SignUpScreen.txt_Password.sendKeys(password);

//        Enter confirm password
        SignUpScreen.txt_ConfirmPassword.sendKeys(password);

//        Tap sign up
        SignUpScreen.btn_SignUp.click();

//        Check Point: Verify Phone Number screen should appear
        softAssert3.assertEquals(VerifyEmailOrPhoneNumberScreen.ttl_VerifyEmailOrPhoneNumber.getText(), "Verify Phone Number");

//        Enter OTP
        VerifyEmailOrPhoneNumberScreen.txt_OTP.sendKeys(otp);

//        Check on "I don't have referral code" radio button in Enter Referral Code screen
        EnterReferralCodeScreen.rad_NotHaveReferralCode.click();

//        Tap Submit button
        EnterReferralCodeScreen.btn_Submit.click();

//        Check Point: Wallet screen should appear
        softAssert3.assertTrue(WalletScreen.lbl_AvailableBalance.isDisplayed());

//        Tap Top Up button
        WalletScreen.btn_TopUp.click();

//        Check Point: The phone number should be displayed in Create Wallet Id screen
        softAssert3.assertEquals(CreateWalletIdScreen.lbl_username.getText(), phoneNumber);

//        Enter wallet pin
        CreateWalletIdScreen.txt_Pin.sendKeys(pin);

//        Enter confirm wallet pin
        CreateWalletIdScreen.txt_ConfirmPin.sendKeys(pin);

//        Tap Create Wallet button
        CreateWalletIdScreen.btn_CreateWallet.click();

//        Check Point: Top Up screen should appear
        softAssert3.assertEquals(TopUpScreen.ttl_TopUp.getText(), "Top Up");
        softAssert3.assertAll();
    }
}