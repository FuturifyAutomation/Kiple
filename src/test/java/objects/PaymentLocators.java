package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentLocators {

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

    @FindBy(id = "com.mobi.kiple:id/tvAmount")
    public WebElement lbl_BalanceAmount;

    @FindBy(id = "com.mobi.kiple:id/tvAccount")
    public WebElement lbl_BillAccountNumber;

    @FindBy(id = "com.mobi.kiple:id/cbKipleKash")
    public WebElement chb_KipleKash;

    @FindBy(id = "com.mobi.kiple:id/tvBalanceKipleKash")
    public WebElement lbl_KipleKashBalance;

    @FindBy(id = "com.mobi.kiple:id/tvPayKipleKash")
    public WebElement lbl_KipleKashPay;

    @FindBy(id = "com.mobi.kiple:id/cbCash")
    public WebElement chb_Cash;

    @FindBy(id = "com.mobi.kiple:id/tvBalanceCash")
    public WebElement lbl_CashBalance;

    @FindBy(id = "com.mobi.kiple:id/tvPayCash")
    public WebElement lbl_CashPay;

    @FindBy(id = "com.mobi.kiple:id/btnCancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/btnNext")
    public WebElement btn_Next;
}
