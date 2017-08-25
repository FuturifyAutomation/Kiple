package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawCashLocators {

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

    @FindBy(id = "com.mobi.kiple:id/edtRecipientName")
    public WebElement txt_RecipientName;

    @FindBy(id = "com.mobi.kiple:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobi.kiple:id/spinnerTextCab")
    public WebElement spn_Banks;

    @FindBy(id = "com.mobi.kiple:id/edtBankNumber")
    public WebElement txt_BankAccountNumber;

    @FindBy(id = "com.mobi.kiple:id/edtNricNumber")
    public WebElement txt_NRICNumber;

    @FindBy(id = "com.mobi.kiple:id/btnCancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/btnProcess")
    public WebElement btn_Next;
}