package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.AndroidPageFactory;

public class SetWalletIDLocators {

    private AndroidDriver androidDriver;
    private WalletLocators WalletScreen;

    public SetWalletIDLocators(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
    }

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

    public void createWalletID(String walletID){
//        Open WalletID Creator screen
        WalletScreen.btn_TopUp.click();

//        Enter wallet ID
        txt_WalletID.sendKeys(walletID);

//        Enter confirm walletID
        txt_ConfirmWalletID.sendKeys(walletID);

//        Tap Save button
        btn_Save.click();
    }
}
