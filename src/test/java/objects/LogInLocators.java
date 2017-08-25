package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInLocators {

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chb --> checkbox
     * spn --> spinner/combobox/dropdown
     */

    @FindBy (id = "com.mobi.kiple:id/edtEmail")
    public WebElement txt_Email;

    @FindBy (id = "com.mobi.kiple:id/edtPassword")
    public WebElement txt_Password;

    @FindBy (id = "com.mobi.kiple:id/btnLogIn")
    public WebElement btn_Login;

    @FindBy (id = "com.mobi.kiple:id/tvForgotPIN")
    public WebElement lbl_ForgotPassword;

    @FindBy (id = "com.mobi.kiple:id/login_button")
    public WebElement btn_LogInWithFacebook;

    @FindBy (id = "com.mobi.kiple:id/tvSignUp")
    public  WebElement lbl_SignUpWithEmail;

    public void logIn(String email, String password){
        //Input email
        txt_Email.sendKeys(email);

        //Input password
        txt_Password.sendKeys(password);

        //Tap Login button
        btn_Login.click();
    }
}


