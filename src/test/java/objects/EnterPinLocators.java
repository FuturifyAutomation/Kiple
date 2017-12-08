package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterPinLocators {

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

    @FindBy (id = "com.mobi.kiple:id/tv")
    public WebElement ttl_EnterVerificationPin;

    @FindBy (id = "com.mobi.kiple:id/edtPassword")
    public WebElement txt_PIN;

    @FindBy (id = "com.mobi.kiple:id/tvForgotPIN")
    public WebElement lnk_ForgotPin;

    @FindBy (xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;

    @FindBy (xpath = ".//android.widget.Button[@text='CANCEL']")
    public WebElement btn_Cancel;
}
