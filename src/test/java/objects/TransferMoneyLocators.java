package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferMoneyLocators {

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chb --> checkbox
     * spn --> spinner/combobox/dropdown
     * frm --> frame
     */

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/tgbContactEmail")
    public WebElement btn_ContactEmail;

    @FindBy(id = "com.mobi.kiple:id/tvContact")
    public WebElement btn_Contact;

    @FindBy(id = "com.mobi.kiple:id/tvEmail")
    public WebElement btn_Email;

    @FindBy(id = "com.mobi.kiple:id/email")
    public WebElement lbl_ContactValue;

    @FindBy(id = "com.mobi.kiple:id/touch_outside")
    public WebElement frm_OutSide;

    @FindBy(id = "com.mobi.kiple:id/tgbScanQRCode")
    public WebElement btn_ScanQRCode;

    @FindBy(id = "com.mobi.kiple:id/edtValue")
    public WebElement txt_EmailMobileNumberReferralCode;

    @FindBy(id = "com.mobi.kiple:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobi.kiple:id/button_cancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/button_proceed")
    public WebElement btn_Next;
}