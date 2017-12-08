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
     * chb --> checkbox
     * spn --> spinner/combobox/dropdown
     * ttl --> title
     * icn --> icon
     */

    @FindBy(id = "com.mobi.wallet:id/button_bell")
    public WebElement icn_Notifications;

    @FindBy(id = "com.mobi.wallet:id/button_package")
    public WebElement icn_ShoppingCart;

    @FindBy(id = "com.mobi.wallet:id/text_notification_count")
    public WebElement lbl_NotificationCount;

    @FindBy(id = "com.mobi.wallet:id/text_balance")
    public WebElement lbl_AvailableBalance;

    @FindBy(id = "com.mobi.wallet:id/button_topup")
    public WebElement btn_TopUp;

    @FindBy(xpath = ".//android.widget.TextView[@text='Out For Breakfast']")
    public WebElement lbl_OutForBreakfast;

    @FindBy(xpath = ".//android.widget.TextView[@text='Best Deal']")
    public WebElement lbl_BestDeal;

    @FindBy(id = "com.mobi.wallet:id/button_paybill")
    public WebElement btn_PayBills;

    @FindBy(id = "com.mobi.wallet:id/button_mobile_reload")
    public WebElement btn_MobileReload;

    @FindBy(id = "com.mobi.wallet:id/button_transfer_money")
    public WebElement btn_TransferMoney;

    @FindBy(id = "com.mobi.wallet:id/button_rewards")
    public WebElement btn_Collections;

    @FindBy(id = "com.mobi.wallet:id/button_transaction_history")
    public WebElement btn_History;

    @FindBy(id = "com.mobi.wallet:id/ll_wallet")
    public WebElement btn_Wallet;

    @FindBy(id = "com.mobi.wallet:id/ll_offer")
    public WebElement btn_Offers;

    @FindBy(id = "com.mobi.wallet:id/ll_scan")
    public WebElement btn_Scan;

    @FindBy(id = "com.mobi.wallet:id/ll_pay")
    public WebElement btn_Pay;

    @FindBy(id = "com.mobi.wallet:id/ll_profile")
    public WebElement btn_Profile;
}
