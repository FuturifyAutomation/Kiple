package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePaymentPageLocators {

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

    @FindBy(id = "com.mobi.kiple:id/text_title")
    public WebElement ttl_SecurePaymentPage;

    @FindBy(id = "com.mobi.kiple:id/button_close")
    public WebElement btn_Close;

    @FindBy(id = "proceed-with-payment")
    public WebElement btn_TopUpWithBank;

    @FindBy(xpath = ".//android.view.View[@content-desc='Cancel this transaction']")
    public WebElement btn_CancelThisTransaction;
}
