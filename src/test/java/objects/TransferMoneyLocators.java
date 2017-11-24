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
     * spn --> spinner/combo box/dropdown
     * frm --> frame
     * ttl --> title
     */

    @FindBy (id = "com.mobiduu.kiple:id/text_title")
    public WebElement ttl_TransferMoney;

    @FindBy(id = "com.mobiduu.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobiduu.kiple:id/tgbContactEmail")
    public WebElement btn_Contact;

    @FindBy(id = "com.mobiduu.kiple:id/tgbScanQRCode")
    public WebElement btn_ScanQRCode;

    @FindBy(id = "com.mobiduu.kiple:id/edtValue")
    public WebElement txt_SelectDestination;

    @FindBy(id = "com.mobiduu.kiple:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobiduu.kiple:id/button_proceed")
    public WebElement btn_Proceed;

    @FindBy(id = "com.mobiduu.kiple:id/tvTitle")
    public WebElement ttl_TransferConfirmation;

    @FindBy(id = "com.mobiduu.kiple:id/tvAmount")
    public WebElement lbl_Amount;

    @FindBy(id = "com.mobiduu.kiple:id/tvReceiverName")
    public WebElement lbl_ReceiverName;

    @FindBy(id = "com.mobiduu.kiple:id/button_ok")
    public WebElement btn_Ok;

    @FindBy(id = "com.mobiduu.kiple:id/tvContact")
    public WebElement btn_ContactOption;

    @FindBy(id = "com.mobiduu.kiple:id/tvEmail")
    public WebElement btn_EmailOption;

    @FindBy(id = "com.mobiduu.kiple:id/imvCancel")
    public WebElement btn_CloseTransferConfirmation;

    @FindBy(id = "com.android.packageinstaller:id/permission_message")
    public WebElement lbl_Permission;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public WebElement btn_Allow;
}