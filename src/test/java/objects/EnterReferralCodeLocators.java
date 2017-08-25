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
     * chk --> checkbox
     */

    @FindBy (xpath = ".//android.widget.TextView[@text=['Enter Referral code']")
    public WebElement lbl_Header;

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

    @FindBy (id = "com.mobi.kiple:id/btnSkip")
    public WebElement btn_SkipUploadAvatar;
}
