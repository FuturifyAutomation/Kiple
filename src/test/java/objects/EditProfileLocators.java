package objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileLocators {

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

    @FindBy(id = "com.mobi.wallet:id/text_title")
    public WebElement ttl_EditProfile;

    @FindBy (id = "com.mobi.wallet:id/button_back")
    public WebElement btn_Back;

    @FindBy (id = "com.mobi.wallet:id/tvFullName")
    public WebElement lbl_FullName;

    @FindBy (id = "com.mobi.wallet:id/tvUserName")
    public WebElement lbl_UserName;

    @FindBy (id = "com.mobi.wallet:id/btnReset")
    public WebElement btn_ChangePassword;

    @FindBy (id = "com.mobi.wallet:id/edtEmailPhone")
    public WebElement txt_EmailOrPhoneNumber;

    @FindBy (id = "com.mobi.wallet:id/edtPassportNumber")
    public WebElement txt_PassportNumber;

    @FindBy(id = "com.mobi.wallet:id/tvCountry")
    public WebElement spn_Country;

    @FindBy(id = "com.mobi.wallet:id/rdbMale")
    public WebElement btn_Male;

    @FindBy(id = "com.mobi.wallet:id/rdbFemale")
    public WebElement btn_Female;

    @FindBy(id = "com.mobi.wallet:id/btnSave")
    public WebElement btn_Proceed;

    @FindBy(id = "com.mobi.wallet:id/imvCancel")
    public WebElement btn_Close;
}