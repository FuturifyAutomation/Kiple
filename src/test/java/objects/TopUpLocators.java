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
     * chk --> checkbox
     */

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

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

    @FindBy(id = "com.mobi.kiple:id/button_online_banking")
    public WebElement btn_OnlineBanking;

    @FindBy(id = "com.mobi.kiple:id/button_credit")
    public WebElement btn_CreditDebitCard;

    @FindBy(id = "com.mobi.kiple:id/button_cancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/button_next")
    public WebElement btn_Next;
}
