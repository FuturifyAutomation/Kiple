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
     * spn --> spinner/combobox/dropdown
     */

    @FindBy(id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.kiple:id/button_close")
    public WebElement btn_close;
}
