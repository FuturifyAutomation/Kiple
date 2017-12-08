package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyEmailOrPhoneNumberLocators {

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

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement ttl_VerifyEmailOrPhoneNumber;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/edtVerifyCode")
    public WebElement txt_OTP;

    @FindBy(id = "com.mobi.kiple:id/tvTitle")
    public WebElement lbl_Username;

    @FindBy(id = "com.mobi.kiple:id/btnResendCode")
    public WebElement btn_ResendConfirmationCode;
}
