package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileReloadLocators {

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

    @FindBy(id = "com.mobi.kiple:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.kiple:id/spnMobileOperator")
    public WebElement spn_MobileOperator;

    @FindBy(xpath = ".//android.widget.TextView[@text='Select Mobile Operator']/android.widget.TextView[1]")
    public WebElement lbl_MobileOperatorValue;

    @FindBy(id = "com.mobi.kiple:id/spnPackage")
    public WebElement spn_Package;

    @FindBy(xpath = ".//android.widget.TextView[@text='Select Package']/android.widget.TextView[1]")
    public WebElement lbl_PackageValue;

    @FindBy(id = "com.mobi.kiple:id/edtPhone")
    public WebElement txt_PhoneNumber;

    @FindBy(id = "com.mobi.kiple:id/ibtnSelectContact")
    public WebElement btn_Contacts;

    @FindBy(id = "android:id/button1")
    public WebElement btn_CancelSelectContact;

    @FindBy(id = "com.mobi.kiple:id/btnCancel")
    public WebElement btn_Cancel;

    @FindBy(id = "com.mobi.kiple:id/btnNext")
    public WebElement btn_Next;
}