package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyMobileNumberLocators {

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

    @FindBy (xpath = ".//android.widget.TextView[@text='VERIFY YOUR MOBILE NUMBER']")
    public  WebElement lbl_Title;

    @FindBy (xpath = ".//android.widget.TextView[@text='To enjoy the perks from paying with Kiple, you need to verify your mobile number']")
    public  WebElement lbl_message;

    @FindBy (id = "com.mobi.kiple:id/btnTakeMeThere")
    public WebElement btn_TakeMeThere;
}
