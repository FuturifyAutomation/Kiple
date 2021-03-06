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
     * spn --> spinner/combo box/dropdown
     * frm --> frame
     * ttl --> title
     */

    @FindBy (id = "com.mobi.wallet:id/edtEmail")
    public WebElement txt_Email;

    @FindBy (id = "com.mobi.wallet:id/edtPassword")
    public WebElement txt_Password;

    @FindBy(id = "com.mobi.wallet:id/cbRemember")
    public WebElement chb_RememberMe;

    @FindBy (id = "com.mobi.wallet:id/tvForgotPIN")
    public WebElement lbl_ForgotPassword;

    @FindBy (id = "com.mobi.wallet:id/btnLogIn")
    public WebElement btn_Login;

    @FindBy (id = "com.mobi.wallet:id/btnLogInFB")
    public WebElement btn_Facebook;

    @FindBy (id = "com.mobi.wallet:id/btnLogInGG")
    public WebElement btn_Google;

    @FindBy (id = "com.mobi.wallet:id/tvSignUp")
    public  WebElement lbl_SignUp;

    public void logIn(String username, String password){
        //Input email
        txt_Email.sendKeys(username);

        //Input password
        txt_Password.sendKeys(password);

        //Tap Login button
        btn_Login.click();
    }
}


