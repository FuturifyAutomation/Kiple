package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsLocators {

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

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/spinnerTextCab")
    public WebElement spn_Bill;

    @FindBy(id = "com.mobi.kiple:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobi.kiple:id/edtAccount")
    public WebElement txt_AccountNumber;

    @FindBy(id = "com.mobi.kiple:id/button_cancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/button_next")
    public WebElement btn_Next;
}
