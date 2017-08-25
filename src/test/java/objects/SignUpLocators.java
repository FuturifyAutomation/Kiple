package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.AndroidPageFactory;

public class SignUpLocators{

    private AndroidDriver androidDriver;

    private LogInLocators LoginScreen;
    private SetPINLocators SetPINScreen;
    private EnterOTPLocators EnterOTPScreen;
    private EnterPhoneNumberLocators EnterPhoneNumberScreen;
    private EnterReferralCodeLocators EnterReferralCodeScreen;
    private VerifyMobileNumberLocators VerifyMobileNumberScreen;

    public SignUpLocators(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        SetPINScreen = AndroidPageFactory.initElements(androidDriver, SetPINLocators.class);
        EnterOTPScreen = AndroidPageFactory.initElements(androidDriver, EnterOTPLocators.class);
        EnterPhoneNumberScreen = AndroidPageFactory.initElements(androidDriver, EnterPhoneNumberLocators.class);
        EnterReferralCodeScreen = AndroidPageFactory.initElements(androidDriver, EnterReferralCodeLocators.class);
        VerifyMobileNumberScreen = AndroidPageFactory.initElements(androidDriver, VerifyMobileNumberLocators.class);
    }

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(id = "com.mobi.kiple:id/imbBack")
    public WebElement btn_Back;

    @FindBy (id = "com.mobi.kiple:id/edtFirstName")
    public WebElement txt_FirstName;

    @FindBy (id = "com.mobi.kiple:id/edtLastName")
    public WebElement txt_LastName;

    @FindBy (id = "com.mobi.kiple:id/edtEmail")
    public WebElement txt_Email;

    @FindBy (id = "com.mobi.kiple:id/edtConfirmEmail")
    public WebElement txt_ConfirmEmail;

    @FindBy (id = "com.mobi.kiple:id/edtPassword")
    public WebElement txt_Password;

    @FindBy (id = "com.mobi.kiple:id/edtConfirmPassword")
    public WebElement txt_ConfirmPassword;

    @FindBy (id = "com.mobi.kiple:id/tvDateOfBirth")
    public WebElement btn_DateOfBirth;

    @FindBy (id = "com.mobi.kiple:id/rdbMale")
    public WebElement rad_Male;

    @FindBy (id = "com.mobi.kiple:id/rdbFemale")
    public WebElement rad_Female;

    @FindBy (id = "com.mobi.kiple:id/cbTerm")
    public WebElement chk_Term;

    @FindBy (id = "com.mobi.kiple:id/btnSubmit")
    public WebElement btn_Submit;

    public void enterAccountInformation(String firstName, String lastName, String email, String password){
//        Enter first name
        txt_FirstName.sendKeys(firstName);

//        Enter last name
        txt_LastName.sendKeys(lastName);

//        Enter email
        txt_Email.sendKeys(email);

//        Enter confirm email
        txt_ConfirmEmail.sendKeys(email);

//        Enter password
        txt_Password.sendKeys(password);

//        Enter confirm password
        txt_ConfirmPassword.sendKeys(password);

//        Check on Term and Condition checkbox
        chk_Term.click();

//        Tap submit
        btn_Submit.click();
    }

    public void verifyPhoneNumber(String phoneNumber, String otp, String pin){
//        Enter phone number
        EnterPhoneNumberScreen.txt_PhoneNumber.sendKeys(phoneNumber);

//        Tap Next button
        EnterPhoneNumberScreen.btn_Next.click();

//        Enter OTP
        EnterOTPScreen.txt_OTP.sendKeys(otp);

//        Tap Next button
        EnterOTPScreen.btn_Next.click();

//        Set PIN
        SetPINScreen.txt_PIN.sendKeys(pin);

//        Enter confirm PIN
        SetPINScreen.txt_ConfirmPIN.sendKeys(pin);

//        Tap Save button
        SetPINScreen.btn_Save.click();
    }

    public void signUpAccount(String firstName, String lastName, String email, String password, String phoneNumber, String otp, String pin) throws InterruptedException {
//        Go to Sign Up screen
        LoginScreen.lbl_SignUpWithEmail.click();

//        Enter account information
        enterAccountInformation(firstName, lastName, email, password);

        if (phoneNumber == ""){

//            Go back Login screen
            Thread.sleep(2000);
            androidDriver.pressKeyCode(AndroidKeyCode.BACK);

//            Login
            LoginScreen.logIn(email, password);

        }else {

//           Tap Take Me There button
            VerifyMobileNumberScreen.btn_TakeMeThere.click();

//           Verify Mobile Number
            verifyPhoneNumber(phoneNumber, otp, pin);

//           Skip referral code
            EnterReferralCodeScreen.rad_NotHaveReferralCode.click();

//           Tap Submit button
            EnterReferralCodeScreen.btn_Submit.click();

//           Skip upload photo
            EnterReferralCodeScreen.btn_SkipUploadAvatar.click();
        }
    }
}
