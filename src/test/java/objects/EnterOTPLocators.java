package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterOTPLocators {

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

    @FindBy (id = "com.mobi.kiple:id/tvHeader")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.kiple:id/edtOTP")
    public WebElement txt_OTP;

    @FindBy(id = "com.mobi.kiple:id/btnNext")
    public WebElement btn_Next;

    @FindBy(id = "com.mobi.kiple:id/tvSkip")
    public WebElement btn_SkipNow;
}
