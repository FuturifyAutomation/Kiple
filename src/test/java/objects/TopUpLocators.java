package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopUpLocators {

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
    public WebElement ttl_TopUp;

    @FindBy(id = "com.mobiduu.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobiduu.kiple:id/button_option_1")
    public WebElement btn_Option01;

    @FindBy(id = "com.mobiduu.kiple:id/button_option_2")
    public WebElement btn_Option02;

    @FindBy(id = "com.mobiduu.kiple:id/button_option_3")
    public WebElement btn_Option03;

    @FindBy(id = "com.mobiduu.kiple:id/button_option_4")
    public WebElement btn_Option04;

    @FindBy(id = "com.mobiduu.kiple:id/edtAmount")
    public WebElement txt_AddManualAmount;

    @FindBy(id = "com.mobiduu.kiple:id/btn_pay_online")
    public WebElement btn_PayByOnlineBanking;

    @FindBy(id = "com.mobiduu.kiple:id/btn_pay_credit")
    public WebElement btn_PayByCreditDebitCard;
}
