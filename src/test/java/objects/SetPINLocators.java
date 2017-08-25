package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetPINLocators {

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

    @FindBy (id = "com.mobi.kiple:id/edtNewPassword")
    public WebElement txt_PIN;

    @FindBy (id = "com.mobi.kiple:id/edtConfirmPassword")
    public WebElement txt_ConfirmPIN;

    @FindBy (id = "com.mobi.kiple:id/btnSave")
    public WebElement btn_Save;

}
