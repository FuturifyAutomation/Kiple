package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawCashLocators {

    private AndroidDriver androidDriver;

    public WithdrawCashLocators(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
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
     * ttl --> title
     */

    @FindBy (id = "com.mobi.wallet:id/text_title")
    public WebElement ttl_WithdrawCash;

    @FindBy(id = "com.mobi.wallet:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.wallet:id/edtRecipientName")
    public WebElement txt_RecipientName;

    @FindBy(id = "com.mobi.wallet:id/edtNricNumber")
    public WebElement txt_NRICPassportNumber;

    @FindBy(id = "com.mobi.wallet:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobi.wallet:id/spnBanks")
    public WebElement spn_Banks;

    @FindBy(id = "com.mobi.wallet:id/edtBankNumber")
    public WebElement txt_BankAccountNumber;

    @FindBy(id = "com.mobi.wallet:id/btnProcess")
    public WebElement btn_Proceed;

    @FindBy(id = "com.mobi.wallet:id/imvCancel")
    public WebElement btn_Close;

    public void selectBank(String bankName){
//        Tap on Bank selection
        spn_Banks.click();

//        Select bank name
        androidDriver.findElement(By.xpath(".//android.widget.CheckedTextView[@text='" + bankName + "']")).click();
    }
}