package modules;

import configurations.TestInitiation;
import objects.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

public class Transactions extends TestInitiation {

    private LogInLocators LoginScreen;
    private TopUpLocators TopUpScreen;
    private WalletLocators WalletScreen;
    private SignUpLocators SignUpScreen;
    private PayBillsLocators PayBillsScreen;
    private EnterYourVerificationPINLocators VerifyPINScreen;
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

//    private String firstEmail = "Email" + email;
    private String firstPhoneNumber = "0987123456";
    private String firstEmail = "qdo2@gmail.com";

    @BeforeMethod
    public void initializeTestCase() throws InterruptedException {
//        Initialize locators
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LogInLocators.class);
        TopUpScreen = AndroidPageFactory.initElements(androidDriver, TopUpLocators.class);
        WalletScreen = AndroidPageFactory.initElements(androidDriver, WalletLocators.class);
        SignUpScreen = AndroidPageFactory.initElements(androidDriver, SignUpLocators.class);
        PayBillsScreen = AndroidPageFactory.initElements(androidDriver, PayBillsLocators.class);
        VerifyPINScreen = AndroidPageFactory.initElements(androidDriver, EnterYourVerificationPINLocators.class);
        AddContactScreen = AndroidPageFactory.initElements(androidDriver, AddContactLocators.class);
        SetWalletScreen = AndroidPageFactory.initElements(androidDriver, SetWalletIDLocators.class);
        MobileReloadScreen = AndroidPageFactory.initElements(androidDriver, MobileReloadLocators.class);
        WithdrawCashScreen = AndroidPageFactory.initElements(androidDriver, WithdrawCashLocators.class);
        TransferMoneyScreen = AndroidPageFactory.initElements(androidDriver, TransferMoneyLocators.class);
        SecurePaymentPageScreen = AndroidPageFactory.initElements(androidDriver, SecurePaymentPageLocators.class);

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

//        Work around for new register new account flow
        LoginScreen.logIn("qdo1@gmail.com", "q11111");
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

    @Test(priority = 1)
    public void VerifyingTransferringMoney(){

//        Tap on Transfer money option
        WalletScreen.btn_MoneyTransfer.click();

//        Check Point: Money Transfer screen should appear
        softAssert2.assertEquals(TransferMoneyScreen.lbl_Header.getText(), "Transfer Money");

//        Tap on Contact/Email option
        TransferMoneyScreen.btn_ContactEmail.click();

//        Check Point: "Contacts" and "Email" should appear
        softAssert2.assertTrue(TransferMoneyScreen.btn_Contact.isDisplayed());
        softAssert2.assertTrue(TransferMoneyScreen.btn_Email.isDisplayed());

//        Tap on Contact option
        TransferMoneyScreen.btn_Contact.click();

//        Check Point: The list contact within phone number should appear
        softAssert2.assertEquals(TransferMoneyScreen.lbl_ContactValue.getText(), firstPhoneNumber);

//        Select contact
        TransferMoneyScreen.lbl_ContactValue.click();

//        Check Point: The phone number of selected contact should be displayed in Email/Phone Number field
        softAssert2.assertEquals(TransferMoneyScreen.txt_EmailMobileNumberReferralCode.getText(), firstPhoneNumber);

//        Tap on Contact/Email option again
        TransferMoneyScreen.btn_ContactEmail.click();

//        Tap on Email option
        TransferMoneyScreen.btn_Email.click();

//        Check Point: The list contact within email should appear
        softAssert2.assertEquals(TransferMoneyScreen.txt_EmailMobileNumberReferralCode.getText(), firstEmail);

//        Select contact
        TransferMoneyScreen.lbl_ContactValue.click();

//        Check Point: The email of selected contact should be displayed in Email/Phone Number field
        softAssert2.assertEquals(TransferMoneyScreen.txt_EmailMobileNumberReferralCode.getText(), firstEmail);

//        Enter amount
        TransferMoneyScreen.txt_Amount.sendKeys("50");

//        Tap on Next button
        TransferMoneyScreen.btn_Next.click();

//        Check Point: PIN screen should appear
        softAssert2.assertEquals(VerifyPINScreen.lbl_Header.getText(), "PIN");

//        Verify PIn
        VerifyPINScreen.verifyPIN(pin);

//        Check Point: transaction should be successful
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifyPayingBills(){

        String billName = "Astro";
        String amount = "20";
        String accountNumber = "0888990011";

//        Tap on Pay Bills option
        WalletScreen.btn_PayBills.click();

//        Check Point: Pay Bills screen should appear
        softAssert3.assertEquals(PayBillsScreen.lbl_Header.getText(), "Pay Bills");

//        Select bill
        PayBillsScreen.selectBills(billName);

//        Check Point: bill should be displayed on Bills selection
        softAssert3.assertEquals(PayBillsScreen.spn_Bill.getText(), billName);

//        Enter amount
        PayBillsScreen.txt_Amount.sendKeys(amount);

//        Check Point: Amount should be displayed in Amount field
        softAssert3.assertEquals(PayBillsScreen.txt_Amount.getText(), amount);

//        Enter Account Number
        PayBillsScreen.txt_AccountNumber.sendKeys(accountNumber);

//        Check Point: Account number should be displayed in Account Number field
        softAssert3.assertEquals(PayBillsScreen.txt_AccountNumber.getText(), accountNumber);

//        Tap Next button
        PayBillsScreen.btn_Next.click();

//        Check Point: Verify Pin screen should appear
        softAssert3.assertEquals(VerifyPINScreen.lbl_Header.getText(), "PIN");

//        Verify PIN
        VerifyPINScreen.verifyPIN(pin);

//        Check Point: transaction should be successful
        softAssert3.assertAll();
    }

    @Test(priority = 3)
    public void VerifyReloadingMobile(){

        String operatorName = "Maxis";
        String packageAmount = "RM10.00";

//        Tap on Mobile Reload option
        WalletScreen.btn_MobileReload.click();

//        Check Point: Mobile Reload screen should appear
        softAssert4.assertEquals(MobileReloadScreen.lbl_Header.getText(), "Mobile Reload");

//        Select Mobile Operator
        MobileReloadScreen.selectMobileOperator(operatorName);

//        Check Point: Mobile Operator should be displayed on Operator selection
        softAssert4.assertEquals(MobileReloadScreen.lbl_MobileOperatorValue.getText(), operatorName);

//        Select package
        MobileReloadScreen.selectPackage(packageAmount);

//        Check Point: Package should be displayed on Package selection
        softAssert4.assertEquals(MobileReloadScreen.lbl_PackageValue.getText(), packageAmount);

//        Enter phone number
        MobileReloadScreen.txt_PhoneNumber.sendKeys(randomText);

//        Check Point: Phone number should be displayed in Phone Number field
        softAssert4.assertEquals(MobileReloadScreen.txt_PhoneNumber.getText(), randomText);

//        Tap Next button
        MobileReloadScreen.btn_Next.click();

//        Check Point: Verify Pin screen should appear
        softAssert4.assertEquals(VerifyPINScreen.lbl_Header.getText(), "PIN");

//        Verify PIN
        VerifyPINScreen.verifyPIN(pin);

//        Check Point: transaction should be successful
        softAssert4.assertAll();
    }

    @Test(priority = 4)
    public void VerifyWithdrawingCash(){

        String recipientName = "test name";
        String amount = "50";
        String bankName = "HSBC BANK";
        String bankAccountNumber = "12345678";
        String nricNumber = "87654321";

//        Tap on Withdrawal option
        WalletScreen.btn_Withdrawal.click();

//        Check Point: Withdraw Cash screen should appear
        softAssert5.assertEquals(WithdrawCashScreen.lbl_Header.getText(), "Withdraw Cash");

//        Enter recipient name
        WithdrawCashScreen.txt_RecipientName.sendKeys(recipientName);

//        Check Point: Recipient name should be displayed in Recipient Name field
        softAssert5.assertEquals(WithdrawCashScreen.txt_RecipientName.getText(), recipientName);

//        Enter amount
        WithdrawCashScreen.txt_Amount.sendKeys(amount);

//        Check Point: Amount should be displayed in Amount field
        softAssert5.assertEquals(WithdrawCashScreen.txt_Amount.getText(), amount);

//        Select bank
        WithdrawCashScreen.selectBank(bankName);

//        Check Point: Bank name should be displayed on Bank selection
        softAssert5.assertEquals(WithdrawCashScreen.spn_Banks.getText(), bankName);

//        Enter Bank Account Number
        WithdrawCashScreen.txt_BankAccountNumber.sendKeys(bankAccountNumber);

//        Check Point: Bank Account Number should be displayed in Bank Account Number field
        softAssert5.assertEquals(WithdrawCashScreen.txt_BankAccountNumber.getText(), bankAccountNumber);

//        Enter NRIC Number
        WithdrawCashScreen.txt_NRICNumber.sendKeys(nricNumber);

//        Check Point: NRIC Number Number should be displayed in NRIC Number Number field
        softAssert5.assertEquals(WithdrawCashScreen.txt_NRICNumber.getText(), nricNumber);

//        Tap on Next button
        WithdrawCashScreen.btn_Next.click();

//        Check Point: Verify Pin screen should appear
        softAssert5.assertEquals(VerifyPINScreen.lbl_Header.getText(), "PIN");

//        Verify PIN
        VerifyPINScreen.verifyPIN(pin);

//        Check Point: transaction should be successful
        softAssert5.assertAll();
    }
}