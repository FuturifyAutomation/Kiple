package modules;

import objects.*;
import org.testng.annotations.*;
import configurations.TestInitiation;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Account extends TestInitiation {

    private LogInLocators LoginScreen;
    private TopUpLocators TopUpScreen;
    private SignUpLocators SignUpScreen;
    private SetPINLocators SetPINScreen;
    private WalletLocators WalletScreen;
    private VerifyAccountLocators EnterOTPScreen;
    private SetWalletIDLocators SetWalletIDScreen;
    private EnterPhoneNumberLocators EnterPhoneNumberScreen;
    private EnterReferralCodeLocators EnterReferralCodeScreen;
    private VerifyMobileNumberLocators VerifyMobileNumberScreen;

    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();

    @BeforeMethod
    public void initializeTestCase(){

//        Initialize locators
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        TopUpScreen = AndroidPageFactory.initElements(androidDriver, TopUpLocators.class);
        SignUpScreen = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
        SetPINScreen = AndroidPageFactory.initElements(androidDriver, SetPINLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        EnterOTPScreen = AndroidPageFactory.initElements(androidDriver, VerifyAccountLocators.class);
        SetWalletIDScreen = AndroidPageFactory.initElements(androidDriver, SetWalletIDLocators.class);
        EnterPhoneNumberScreen = AndroidPageFactory.initElements(androidDriver, EnterPhoneNumberLocators.class);
        EnterReferralCodeScreen = AndroidPageFactory.initElements(androidDriver, EnterReferralCodeLocators.class);
        VerifyMobileNumberScreen = AndroidPageFactory.initElements(androidDriver, VerifyMobileNumberLocators.class);
    }

    @Test
    public void VerifySigningUpAccountWithinVerifyPhoneNumber(){

//        Go to Sign Up screen
        LoginScreen.lbl_SignUpWithEmail.click();

//        Check Point: Sign Up screen should appear
        softAssert1.assertTrue(SignUpScreen.txt_FirstName.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_LastName.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_Email.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_ConfirmEmail.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_Password.isEnabled());
        softAssert1.assertTrue(SignUpScreen.txt_ConfirmPassword.isEnabled());

//        Input information
        SignUpScreen.enterAccountInformation(firstName, lastName, email, randomText);

//        Check Point: Verify Your Mobile Number screen should appear
        softAssert1.assertTrue(VerifyMobileNumberScreen.btn_TakeMeThere.isEnabled());

//        Tap Take Me There button
        VerifyMobileNumberScreen.btn_TakeMeThere.click();

//        Check Point: Enter Phone Number screen should appear
        softAssert1.assertEquals(EnterPhoneNumberScreen.lbl_Header.getText(), "Enter Phone Number");

//        Enter phone number
        EnterPhoneNumberScreen.txt_PhoneNumber.sendKeys(randomText);

//        Tap Next button
        EnterPhoneNumberScreen.btn_Next.click();

//        Check Point: Enter OTP screen should appear
        softAssert1.assertEquals(EnterOTPScreen.lbl_Header.getText(), "Enter OTP");

//        Enter OTP
        EnterOTPScreen.txt_OTP.sendKeys(pin);

//        Tap Next button
        EnterOTPScreen.btn_Next.click();

//        Check Point: Set PIN screen should appear
        softAssert1.assertEquals(SetPINScreen.lbl_Header.getText(), "Set PIN");

//        Enter PIN
        SetPINScreen.txt_PIN.sendKeys(pin);

//        Enter confirm PIN
        SetPINScreen.txt_ConfirmPIN.sendKeys(pin);

//        Tap Save button
        SetPINScreen.btn_Save.click();

//        Check Point: Enter Referral Code screen should appear
        softAssert1.assertTrue(EnterReferralCodeScreen.txt_ReferralCode.isEnabled());

//        Check on "I don't have referral code" radio button
        EnterReferralCodeScreen.rad_NotHaveReferralCode.click();

//        Tap Submit button
        EnterReferralCodeScreen.btn_Submit.click();

//        Tap Skip button in Upload Photo screen
        EnterReferralCodeScreen.btn_SkipUploadAvatar.click();

//        Check Point: Wallet screen should appear
        softAssert1.assertTrue(WalletScreen.lbl_YourBalance.isDisplayed());
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifyCreatingWalletID(){

//        Tap Top up button
        WalletScreen.btn_TopUp.click();

//        Check Point: Set Wallet ID screen should appear
        softAssert2.assertEquals(SetWalletIDScreen.lbl_Header.getText(), "Set Wallet ID");

//        Check Point: The phone number should be displayed in Set Wallet ID screen
        softAssert2.assertTrue(SetWalletIDScreen.lbl_PhoneNumber.getText().contains(randomText.substring(1)));

//        Enter Wallet ID
        SetWalletIDScreen.txt_WalletID.sendKeys(walletID);

//        Enter confirm wallet ID
        SetWalletIDScreen.txt_ConfirmWalletID.sendKeys(walletID);

//        Tap Save button
        SetWalletIDScreen.btn_Save.click();

//        Check Point: Wallet screen should appear
        softAssert2.assertTrue(WalletScreen.lbl_YourBalance.isDisplayed());

//        Tap Top up again
        WalletScreen.btn_TopUp.click();

//        Check Point: Top Up screen should appear
        softAssert2.assertEquals(TopUpScreen.lbl_Header.getText(), "Top up");

//        Go to Login screen
        TopUpScreen.btn_Back.click();
        WalletScreen.lbl_Logout.click();
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifySigningUpAccountWithoutVerifyPhoneNumber() throws InterruptedException {

        String randomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
        String email = prefix + "email" + randomText + "@gmail.com";

//        Sign up new account
        SignUpScreen.signUpAccount(firstName, lastName, email, randomText, "", pin, pin);

//        Tap Top Up button
        WalletScreen.btn_TopUp.click();

//        Check Point: Enter Phone Number screen should appear
        softAssert3.assertEquals(EnterPhoneNumberScreen.lbl_Header.getText(), "Enter Phone Number");

//        Verify phone number
        SignUpScreen.verifyPhoneNumber(randomText, pin, pin);

//        Enter wallet ID
        SetWalletIDScreen.txt_WalletID.sendKeys(walletID);

//        Enter confirm walletID
        SetWalletIDScreen.txt_ConfirmWalletID.sendKeys(walletID);

//        Tap Save button
        SetWalletIDScreen.btn_Save.click();

//        Tap Top up again
        WalletScreen.btn_TopUp.click();

//        Check Point: Top Up screen should appear
        softAssert2.assertEquals(TopUpScreen.lbl_Header.getText(), "Top up");
        softAssert3.assertAll();
    }
}