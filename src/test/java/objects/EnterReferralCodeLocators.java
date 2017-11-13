package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterReferralCodeLocators {

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
    public WebElement ttl_EnterReferralCode;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy (id = "com.mobi.kiple:id/rbHave")
    public WebElement rad_HaveReferralCode;

    @FindBy (id = "com.mobi.kiple:id/rbHavent")
    public WebElement rad_NotHaveReferralCode;

    @FindBy (id = "com.mobi.kiple:id/edtReferCode")
    public WebElement txt_ReferralCode;

    @FindBy (id = "com.mobi.kiple:id/btnScanQR")
    public WebElement btn_ScanQRCode;

    @FindBy (id = "com.mobi.kiple:id/btnSubmitReferral")
    public WebElement btn_Submit;
}
