package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsLocators {

    private AndroidDriver androidDriver;

    public PayBillsLocators(AndroidDriver androidDriver){
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
     * spn --> spinner/combo box/dropdown
     * frm --> frame
     * ttl --> title
     */

    @FindBy (id = "com.mobi.wallet:id/text_title")
    public WebElement ttl_PayBills;

    @FindBy(id = "com.mobi.wallet:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.wallet:id/spnBill")
    public WebElement spn_Bill;

    @FindBy(id = "com.mobi.wallet:id/edtAmount")
    public WebElement txt_Amount;

    @FindBy(id = "com.mobi.wallet:id/edtAccount")
    public WebElement txt_AccountNumber;

    @FindBy(id = "com.mobi.wallet:id/btnNext")
    public WebElement btn_Proceed;

    @FindBy(id = "com.mobi.wallet:id/imvCancel")
    public WebElement btn_Close;

    public void selectBills(String billName){
//        Tap on Bills selection
        spn_Bill.click();

//        Select bill
        androidDriver.findElement(By.xpath(".//android.widget.CheckedTextView[@text='" + billName + "']")).click();
    }
}
