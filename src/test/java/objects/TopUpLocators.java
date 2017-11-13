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

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement ttl_TopUp;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/button_option_1")
    public WebElement btn_50RM;

    @FindBy(id = "com.mobi.kiple:id/button_option_2")
    public WebElement btn_100RM;

    @FindBy(id = "com.mobi.kiple:id/button_option_3")
    public WebElement btn_150RM;

    @FindBy(id = "com.mobi.kiple:id/button_option_4")
    public WebElement btn_200RM;

    @FindBy(id = "com.mobi.kiple:id/edtAmount")
    public WebElement txt_AddManualAmount;

    @FindBy(id = "com.mobi.kiple:id/btn_pay_online")
    public WebElement btn_PayByOnlineBanking;

    @FindBy(id = "com.mobi.kiple:id/btn_pay_credit")
    public WebElement btn_PayByCreditDebitCard;
}
