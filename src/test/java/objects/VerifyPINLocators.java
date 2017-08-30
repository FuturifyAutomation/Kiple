package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerifyPINLocators {

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

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

    @FindBy (id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy (id = "com.mobi.kiple:id/edtPIN")
    public WebElement txt_PIN;

    @FindBy (id = "com.mobi.kiple:id/btnProcess")
    public WebElement btn_Proceed;

    @FindBy (id = "com.mobi.kiple:id/btnCancel")
    public WebElement btn_Cancel;

    public void verifyPIN(String pin){
//        Enter PIN
        txt_PIN.sendKeys(pin);

//        Tap Proceed button
        btn_Proceed.click();
    }
}
