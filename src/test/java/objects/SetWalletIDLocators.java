package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetWalletIDLocators {

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

    @FindBy(id = "com.mobi.kiple:id/tvPhone")
    public WebElement lbl_PhoneNumber;

    @FindBy(id = "com.mobi.kiple:id/edtWalletID")
    public WebElement txt_WalletID;

    @FindBy(id = "com.mobi.kiple:id/edtConfirmWalletID")
    public WebElement txt_ConfirmWalletID;

    @FindBy(id = "com.mobi.kiple:id/btnSave")
    public WebElement btn_Save;

    public void setWalletID(String walletID){
//        Enter wallet ID
        txt_WalletID.sendKeys(walletID);

//        Enter confirm walletID
        txt_ConfirmWalletID.sendKeys(walletID);

//        Tap Save button
        btn_Save.click();
    }
}
