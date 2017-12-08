package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWalletIdLocators {

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
    public WebElement ttl_CreateWalletId;

    @FindBy(id = "com.mobi.kiple:id/tvPhone")
    public WebElement lbl_username;

    @FindBy(id = "com.mobi.kiple:id/edtWalletID")
    public WebElement txt_Pin;

    @FindBy(id = "com.mobi.kiple:id/edtConfirmWalletID")
    public WebElement txt_ConfirmPin;

    @FindBy(id = "com.mobi.kiple:id/btnSave")
    public WebElement btn_CreateWallet;

    public void createWalletID(String walletPin){
//        Enter wallet Pin
        txt_Pin.sendKeys(walletPin);

//        Enter confirm walletID
        txt_ConfirmPin.sendKeys(walletPin);

//        Tap Save button
        btn_CreateWallet.click();
    }
}
