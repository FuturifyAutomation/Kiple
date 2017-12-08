package modules;

import configurations.TestInitiation;
import objects.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

public class UserProfile extends TestInitiation {

    private LogInLocators LoginScreen;
    private WalletLocators WalletScreen;
    private SignUpLocators SignUpScreen;
    private EnterPinLocators EnterPinScreen;
    private UserProfileLocators UserProfileScreen;
    private EditProfileLocators EditProfileScreen;
    private WithdrawCashLocators WithdrawCashScreen;
    private PaymentReceiptLocators PaymentReceiptScreen;

    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();
    SoftAssert softAssert4 = new SoftAssert();
    SoftAssert softAssert5 = new SoftAssert();

    private String username = "uat10@mailinator.com";
    private String password = "q1111111";
    private String receiver = "uat24@mailinator.com";

    @BeforeMethod
    public void initializeTestCase() throws InterruptedException {
//        Initialize locators
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        SignUpScreen = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
        EnterPinScreen = AndroidPageFactory.initElements(androidDriver, EnterPinLocators.class);
        UserProfileScreen = AndroidPageFactory.initElements(androidDriver, UserProfileLocators.class);
        EditProfileScreen = AndroidPageFactory.initElements(androidDriver, EditProfileLocators.class);
        WithdrawCashScreen = AndroidPageFactory.initElements(androidDriver, WithdrawCashLocators.class);
        PaymentReceiptScreen = AndroidPageFactory.initElements(androidDriver, PaymentReceiptLocators.class);

/*//        Sign up first account
        SignUpScreen.signUpAccount(firstName, lastName, firstEmail, randomText, randomText, pin, pin);
        SetWalletScreen.createWalletID(walletID);
        WalletScreen.lbl_Logout.click();

//        Add contacts to device
        Activity contactsActivity = new Activity("com.android.contacts", "com.android.contacts.activities.PeopleActivity");
        androidDriver.startActivity(contactsActivity);
        AddContactScreen.addContact("Transfer Contact", randomText, email);

//        Swap to Kiple app
        Activity kipleActivity = new Activity("com.mobi.kiple", "com.mobi.wallet.MainActivity");
        androidDriver.startActivity(kipleActivity);

//        Sign up second account
        String newRandomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
        String newEmail = prefix + "email" + newRandomText + "@gmail.com";
        SignUpScreen.signUpAccount(firstName, lastName, newEmail, newRandomText, newRandomText, pin, pin);
        SetWalletScreen.createWalletID(walletID);*/

//        Work around to handle register flow
        LoginScreen.logIn(username, password);
    }

//    @Test
//    public void VerifyWithdrawingCash(){
//
//        String recipientName = "test name";
//        String amount = "50";
//        String bankName = "HSBC BANK";
//        String bankAccountNumber = "12345678";
//        String nricNumber = "87654321";
//
////        Open Profile
//        WalletScreen.btn_Profile.click();
//
////        Tap on Withdrawal option
//        ProfileScreen.btn_Withdrawal.click();
//
////        Check Point: Withdraw Cash screen should appear
//        softAssert5.assertEquals(WithdrawCashScreen.ttl_WithdrawCash.getText(), "Withdraw Cash");
//
////        Enter recipient name
//        WithdrawCashScreen.txt_RecipientName.sendKeys(recipientName);
//
////        Check Point: Recipient name should be displayed in Recipient Name field
//        softAssert5.assertEquals(WithdrawCashScreen.txt_RecipientName.getText(), recipientName);
//
////        Enter amount
//        WithdrawCashScreen.txt_Amount.sendKeys(amount);
//
////        Check Point: Amount should be displayed in Amount field
//        softAssert5.assertEquals(WithdrawCashScreen.txt_Amount.getText(), amount);
//
////        Select bank
//        WithdrawCashScreen.selectBank(bankName);
//
////        Check Point: Bank name should be displayed on Bank selection
//        softAssert5.assertEquals(WithdrawCashScreen.spn_Banks.getText(), bankName);
//
////        Enter Bank Account Number
//        WithdrawCashScreen.txt_BankAccountNumber.sendKeys(bankAccountNumber);
//
////        Check Point: Bank Account Number should be displayed in Bank Account Number field
//        softAssert5.assertEquals(WithdrawCashScreen.txt_BankAccountNumber.getText(), bankAccountNumber);
//
////        Enter NRIC Number
//        WithdrawCashScreen.txt_NRICPassportNumber.sendKeys(nricNumber);
//
////        Check Point: NRIC Number Number should be displayed in NRIC Number Number field
//        softAssert5.assertEquals(WithdrawCashScreen.txt_NRICPassportNumber.getText(), nricNumber);
//
////        Tap on Next button
//        WithdrawCashScreen.btn_Proceed.click();
//
////        Check Point: Verify Pin screen should appear
//        softAssert5.assertEquals(EnterPinScreen.ttl_EnterVerificationPin.getText(), "PIN");
//
////        Check Point: transaction should be successful
//        softAssert5.assertAll();
//    }

    @Test
    public void VerifyEditingProfile(){

//        Go to Edit Profile
        UserProfileScreen.btn_EditProfile.click();

//        CheckPoint: full name, username and country should be following registration
        softAssert1.assertEquals(EditProfileScreen.ttl_EditProfile.getText(), "Edit Profile");
        softAssert1.assertEquals(EditProfileScreen.lbl_FullName.getText(), "ố ồ");
        softAssert1.assertEquals(EditProfileScreen.lbl_UserName.getText(), username);
        softAssert1.assertEquals(EditProfileScreen.spn_Country.getText(), "Malaysia");

//        Enter phone number, passport, gender
        EditProfileScreen.txt_EmailOrPhoneNumber.sendKeys(username);
        EditProfileScreen.txt_PassportNumber.sendKeys("76234816");
        EditProfileScreen.btn_Male.click();

//        Tap Back button
        EditProfileScreen.btn_Back.click();

//        Go back Edit Profile
        UserProfileScreen.btn_EditProfile.click();

//        CheckPoint: phone number, passport, gender should empty
        softAssert1.assertEquals(EditProfileScreen.txt_EmailOrPhoneNumber.getText(), " ");
        softAssert1.assertEquals(EditProfileScreen.txt_PassportNumber.getText(), " ");
        softAssert1.assertEquals(EditProfileScreen.btn_Male.getAttribute("checked"), "false");




    }
}