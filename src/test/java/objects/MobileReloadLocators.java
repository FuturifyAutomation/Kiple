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

    @FindBy (id = "com.mobi.wallet:id/text_title")
    public WebElement lbl_Header;

    @FindBy(id = "com.mobi.wallet:id/button_back")
    public WebElement btn_Back;

    @FindBy(id = "com.mobi.wallet:id/spnMobileOperator")
    public WebElement spn_MobileOperator;

    @FindBy(id = "com.mobi.wallet:id/tvTitle")
    public WebElement lbl_SelectMobileOperatorPopup;

    @FindBy(id = "com.mobi.wallet:id/spnPackage")
    public WebElement spn_Package;

    @FindBy(id = "com.mobi.wallet:id/edtPhone")
    public WebElement txt_PhoneNumber;

    @FindBy(id = "com.mobi.wallet:id/ibtnSelectContact")
    public WebElement btn_Contacts;

    @FindBy(id = "com.mobi.wallet:id/btnNext")
    public WebElement btn_Proceed;

    @FindBy(id = "com.mobi.wallet:id/imvCancel")
    public WebElement btn_Close;

    public void selectMobileOperator(String operatorName) throws InterruptedException {

//        Get current operator
        String currentOperator = spn_MobileOperator.getText();
        int count = 0;

//        Tap on Operator selection
        spn_MobileOperator.click();
        Thread.sleep(3000);

//        Select operator
        while (currentOperator != operatorName){
            spn_MobileOperator.click();
            Thread.sleep(3000);
            count = count + 1;
            androidDriver.findElement(By.xpath(".//android.widget.GridView[1]/android.widget.LinearLayout[" + count + "]")).click();
            btn_Close.click();
            currentOperator = spn_MobileOperator.getText();
        }
    }

    public void selectPackage(String packageAmount){
//        Tap on Operator selection
        spn_Package.click();

//        Select operator
        androidDriver.findElement(By.xpath(".//android.widget.ListView[1]/android.widget.TextView[@text='" + packageAmount + "']")).click();
        btn_Close.click();
    }
}