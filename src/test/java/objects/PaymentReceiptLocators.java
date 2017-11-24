package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentReceiptLocators {

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
    public WebElement ttl_PaymentReceipt;

    @FindBy(id = "com.mobiduu.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobiduu.kiple:id/tvPaymentType")
    public WebElement lbl_PaymentType;

    @FindBy(id = "com.mobiduu.kiple:id/tvAmount")
    public WebElement lbl_Amount;
}
