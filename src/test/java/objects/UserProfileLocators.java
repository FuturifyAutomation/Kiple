package objects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileLocators {

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

    @FindBy(id = "com.mobi.wallet:id/imvEditAvatar")
    public WebElement btn_UploadAvatar;

    @FindBy (id = "com.mobi.wallet:id/btnEdit")
    public WebElement btn_EditProfile;

    @FindBy (id = "com.mobi.wallet:id/btnSecurity")
    public WebElement btn_Security;

    @FindBy (id = "com.mobi.wallet:id/btnInvite")
    public WebElement btn_InviteFriend;

    @FindBy (id = "com.mobi.wallet:id/btnWithdrawal")
    public WebElement btn_Withdrawal;

    @FindBy (id = "com.mobi.wallet:id/btnSetting")
    public WebElement btn_Setting;

    @FindBy (id = "com.mobi.wallet:id/btnLogout")
    public WebElement btn_Logout;
}