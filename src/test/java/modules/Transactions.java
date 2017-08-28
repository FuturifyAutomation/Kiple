package modules;

import configurations.TestInitiation;
import io.appium.java_client.android.Activity;
import objects.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transactions extends TestInitiation {

    private TopUpLocators TopUpScreen;
    private WalletLocators WalletScreen;
    private SignUpLocators SignUpScreen;
    private PayBillsLocators PayBillsScreen;
    private AddContactLocators AddContactScreen;
    private SetWalletIDLocators SetWalletScreen;
    private MobileReloadLocators MobileReloadScreen;
    private WithdrawCashLocators WithdrawCashScreen;
    private TransferMoneyLocators TransferMoneyScreen;
    private SecurePaymentPageLocators SecurePaymentPageScreen;

    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();
    SoftAssert softAssert4 = new SoftAssert();
    SoftAssert softAssert5 = new SoftAssert();

    @BeforeMethod
    public void initializeTestCase() throws InterruptedException {
//        Initialize locators
        TopUpScreen = AndroidPageFactory.initElements(androidDriver, TopUpLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        SignUpScreen = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
        PayBillsScreen = AndroidPageFactory.initElements(androidDriver, PayBillsLocators.class);
        AddContactScreen = AndroidPageFactory.initElements(androidDriver, AddContactLocators.class);
        SetWalletScreen = AndroidPageFactory.initElements(androidDriver, SetWalletIDLocators.class);
        MobileReloadScreen = AndroidPageFactory.initElements(androidDriver, MobileReloadLocators.class);
        WithdrawCashScreen = AndroidPageFactory.initElements(androidDriver, WithdrawCashLocators.class);
        TransferMoneyScreen = AndroidPageFactory.initElements(androidDriver, TransferMoneyLocators.class);
        SecurePaymentPageScreen = AndroidPageFactory.initElements(androidDriver, SecurePaymentPageLocators.class);

//        Sign up first account
        SignUpScreen.signUpAccount(firstName, lastName, "Email" + email, randomText, randomText, pin, pin);
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
        SetWalletScreen.createWalletID(walletID);
    }

    @Test
    public void VerifyToppingUpBalanceByUsingOnlineBanking() throws InterruptedException {

//        Tap on Top Up button
        WalletScreen.btn_TopUp.click();

//        Top Up screen should appear
        softAssert1.assertEquals(TopUpScreen.lbl_Header.getText(), "Top Up");

//        Select RM50 option
        TopUpScreen.btn_50RM.click();

//        Check Point: RM50 should be highlighted
        softAssert1.assertEquals(TopUpScreen.btn_50RM.getAttribute("checked"), "true");

//        Select "Online Banking" option
        TopUpScreen.btn_OnlineBanking.click();

//        Check Point: Online Banking should be highlighted
        softAssert1.assertEquals(TopUpScreen.btn_OnlineBanking.getAttribute("checked"), "true");

//        Tap on Next button
        TopUpScreen.btn_Next.click();

//        Check Point: Secure Payment Page screen should appear
        softAssert1.assertEquals(SecurePaymentPageScreen.lbl_Header.getText(), "Secure Payment Page");

//        Tap Close button
        SecurePaymentPageScreen.btn_close.click();

//        Check Point: Top Up screen should appear.
        softAssert1.assertEquals(TopUpScreen.lbl_Header.getText(), "Top Up");

//        Tap Back button
        TopUpScreen.btn_Back.click();

//        Check Point: Wallet screen should appear
        softAssert1.assertTrue(WalletScreen.lbl_YourBalance.isDisplayed());
        WalletScreen.lbl_Logout.click();
        softAssert1.assertAll();
    }

    @Test
    public void VerifyingTransferringMoney(){

//        Tap on Transfer money option
        WalletScreen.btn_MoneyTransfer.click();

//        Money Transfer screen should appear
        softAssert2.assertEquals(TransferMoneyScreen.lbl_Header.getText(), "Transfer Money");

//        Tap on Contact/Email option
        TransferMoneyScreen.btn_ContactEmail.click();

//        Check Point "Contacts" and "Email" should appear
        softAssert2.assertTrue(TransferMoneyScreen.btn_Contact.isDisplayed());
        softAssert2.assertTrue(TransferMoneyScreen.btn_Email.isDisplayed());
    }
}