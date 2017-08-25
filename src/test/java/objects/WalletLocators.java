package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletLocators {

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(id = "com.mobi.kiple:id/text_logout")
    public WebElement lbl_Logout;

    @FindBy(id = "com.mobi.kiple:id/text_balance")
    public WebElement lbl_YourBalance;

    @FindBy(id = "com.mobi.kiple:id/button2")
    public WebElement lbl_LastTransactionBalance;

    @FindBy(id = "com.mobi.kiple:id/button_topup")
    public WebElement btn_TopUp;

    @FindBy(id = "com.mobi.kiple:id/button_paybill")
    public WebElement btn_PayBills;

    @FindBy(id = "com.mobi.kiple:id/button_mobile_reload")
    public WebElement btn_MobileReload;

    @FindBy(id = "com.mobi.kiple:id/button_transfer_money")
    public WebElement btn_MoneyTransfer;

    @FindBy(id = "com.mobi.kiple:id/button_withdrawal")
    public WebElement btn_Withdrawal;
}
