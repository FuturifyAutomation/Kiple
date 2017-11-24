package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.AndroidPageFactory;

public class SignUpLocators{

    private AndroidDriver androidDriver;

    private LogInLocators LoginScreen;
    private EnterPinLocators SetPINScreen;
    private EnterReferralCodeLocators EnterReferralCodeScreen;
    private VerifyEmailOrPhoneNumberLocators VerifyEmailOrPhoneNumberScreen;

    public SignUpLocators(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        SetPINScreen = AndroidPageFactory.initElements(androidDriver, EnterPinLocators.class);
        EnterReferralCodeScreen = AndroidPageFactory.initElements(androidDriver, EnterReferralCodeLocators.class);
        VerifyEmailOrPhoneNumberScreen = AndroidPageFactory.initElements(androidDriver, VerifyEmailOrPhoneNumberLocators.class);
    }

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chb --> checkbox
     * spn --> spinner/combo box/dropdown
     * frm --> frame
     * ttl --> title
     */

    @FindBy(id = "com.mobi.kiple:id/imbBack")
    public WebElement btn_Back;

    @FindBy (id = "com.mobiduu.kiple:id/edtFullName")
    public WebElement txt_FullName;

    @FindBy (id = "com.mobiduu.kiple:id/edtEmail")
    public WebElement txt_Username;

    @FindBy (id = "com.mobiduu.kiple:id/tvCountry")
    public WebElement spn_Country;

    @FindBy (id = "com.mobiduu.kiple:id/edtPassword")
    public WebElement txt_Password;

    @FindBy (id = "com.mobiduu.kiple:id/edtConfirmPassword")
    public WebElement txt_ConfirmPassword;

    @FindBy (id = "com.mobiduu.kiple:id/tvCondition")
    public WebElement lnk_TermConditions;

    @FindBy (id = "com.mobiduu.kiple:id/btnSubmit")
    public WebElement btn_SignUp;

    public void signUpAccount(String fullName, String username, String password, String otp, String referralCode){
//        Go to Sign Up screen
        LoginScreen.lbl_SignUp.click();

//        Enter full name
        txt_FullName.sendKeys(fullName);

//        Enter username
        txt_Username.sendKeys(username);

//        Enter password
        txt_Password.sendKeys(password);

//        Enter confirm password
        txt_ConfirmPassword.sendKeys(password);

//        Tap sign up
        btn_SignUp.click();

//        Enter OTP
        VerifyEmailOrPhoneNumberScreen.txt_OTP.sendKeys(otp);

//        Enter referral code
        EnterReferralCodeScreen.txt_ReferralCode.sendKeys(referralCode);

//        Tap Submit
        EnterReferralCodeScreen.btn_Submit.click();
    }
}
