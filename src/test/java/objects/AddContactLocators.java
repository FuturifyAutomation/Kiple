package objects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AddContactLocators {

    private AndroidDriver androidDriver;

    public AddContactLocators(AndroidDriver androidDriver){
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
     */

    @FindBy(id = "com.android.contacts:id/cliv_name_textview")
    public WebElement lbl_ContactItem;

    @FindBy(id = "com.android.contacts:id/signInButton")
    public WebElement btn_SyncContact;

    @FindBy (id = "com.android.contacts:id/floating_action_button")
    public WebElement btn_AddContact;

    @FindBy (xpath = ".//android.widget.EditText[@text='Name']")
    public WebElement txt_Name;

    @FindBy (xpath = ".//android.widget.EditText[@text='Phone number']")
    public WebElement txt_PhoneNumber;

    @FindBy (xpath = ".//android.widget.EditText[@text='Email']")
    public WebElement txt_Email;

    @FindBy (id = "com.android.contacts:id/menu_done")
    public WebElement btn_Save;

    @FindBy (id = "com.android.contacts:id/select_all_checkbox")
    public WebElement chb_SelectAll;

    @FindBy (id = "com.android.contacts:id/menu_delete")
    public WebElement btn_Delete;

    @FindBy (xpath = ".//android.widget.Button[@text='Delete']")
    public WebElement btn_ConfirmDelete;

    public void addContact(String name, String phoneNumber, String email){
//        Setting timeout
        androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//        Check any contact exist delete
        if (!androidDriver.findElements(By.id("com.android.contacts:id/cliv_name_textview")).isEmpty()){
//            Long tap on existing contact
            TouchAction touchAction = new TouchAction(androidDriver);
            touchAction.longPress(androidDriver.findElement(By.id("com.android.contacts:id/cliv_name_textview"))).perform();

            if (chb_SelectAll.getAttribute("checked") == "false"){
//            Select contact to delete
            chb_SelectAll.click();
            }

//            Tap on Delete button
            btn_Delete.click();

//            Tap on Delete button on Confirmation
            btn_ConfirmDelete.click();
        }

//        Setting timeout to default
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//        Tap Add Contact button
        btn_AddContact.click();

//        Enter name
        txt_Name.sendKeys(name);

//        Enter phone number
        txt_PhoneNumber.sendKeys(phoneNumber);

//        Enter email
        txt_Email.sendKeys(email);

//        Tap Save button
        btn_Save.click();
    }
}