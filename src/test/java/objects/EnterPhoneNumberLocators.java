package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterPhoneNumberLocators {

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(id = "com.mobi.kiple:id/tvHeader")
    public WebElement lbl_Header;

    @FindBy (id = "com.mobi.kiple:id/edtPhone")
    public WebElement txt_PhoneNumber;

    @FindBy (id = "com.mobi.kiple:id/btnNext")
    public WebElement btn_Next;

    @FindBy (id = "com.mobi.kiple:id/tvSkip")
    public WebElement lbl_SkipNow;
}
