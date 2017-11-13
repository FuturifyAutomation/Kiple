package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileReloadLocators {

    private AndroidDriver androidDriver;

    public MobileReloadLocators(AndroidDriver androidDriver){
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

    @FindBy (id = "com.mobi.kiple:id/text_title")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/spnMobileOperator")
    public WebElement spn_MobileOperator;

    @FindBy(id = "com.mobi.kiple:id/tvTitle")
    public WebElement lbl_SelectMobileOperatorPopup;

    @FindBy(id = "com.mobi.kiple:id/spnPackage")
    public WebElement spn_Package;

    @FindBy(id = "com.mobi.kiple:id/edtPhone")
    public WebElement txt_PhoneNumber;

    @FindBy(id = "com.mobi.kiple:id/ibtnSelectContact")
    public WebElement btn_Contacts;

    @FindBy(id = "com.mobi.kiple:id/btnNext")
    public WebElement btn_Proceed;

    public void selectMobileOperator(String operatorName){
//        Tap on Operator selection
        spn_MobileOperator.click();

//        Select operator
        androidDriver.findElement(By.xpath(".//android.widget.CheckedTextView[@text='" + operatorName + "']")).click();
    }

    public void selectPackage(String packageAmount){
//        Tap on Operator selection
        spn_Package.click();

//        Select operator
        androidDriver.findElement(By.xpath(".//android.widget.CheckedTextView[@text='" + packageAmount + "']")).click();
    }
}