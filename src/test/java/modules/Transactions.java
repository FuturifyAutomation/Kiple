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
    private EnterPinLocators EnterPinScreen;
    private AddContactLocators AddContactScreen;
    private MobileReloadLocators MobileReloadScreen;
    private WithdrawCashLocators WithdrawCashScreen;
    private TransferMoneyLocators TransferMoneyScreen;
    private CreateWalletIdLocators CreateWalletIdScreen;
    private PaymentReceiptLocators PaymentReceiptScreen;
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
        EnterPinScreen = AndroidPageFactory.initElements(androidDriver, EnterPinLocators.class);
        AddContactScreen = AndroidPageFactory.initElements(androidDriver, AddContactLocators.class);
        MobileReloadScreen = AndroidPageFactory.initElements(androidDriver, MobileReloadLocators.class);
        WithdrawCashScreen = AndroidPageFactory.initElements(androidDriver, WithdrawCashLocators.class);
        TransferMoneyScreen = AndroidPageFactory.initElements(androidDriver, TransferMoneyLocators.class);
        CreateWalletIdScreen = AndroidPageFactory.initElements(androidDriver, CreateWalletIdLocators.class);
        PaymentReceiptScreen = AndroidPageFactory.initElements(androidDriver, PaymentReceiptLocators.class);
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

    /*@Test
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
    }*/

    @Test(priority = 1)
    public void VerifyingTransferringMoney(){

        String receiver = "sit20@mailinator.com";
        String amount = "1.10";

//        Tap on Transfer money option
        WalletScreen.btn_TransferMoney.click();

//        Check Point: Money Transfer screen should appear
        softAssert2.assertEquals(TransferMoneyScreen.ttl_TransferMoney.getText(), "Transfer Money");

//        Enter receiver
        TransferMoneyScreen.txt_SelectDestination.sendKeys(receiver);

//        Enter amount
        TransferMoneyScreen.txt_Amount.sendKeys(amount);

//        Tap on Proceed button
        TransferMoneyScreen.btn_Proceed.click();

//        CheckPoint: Transfer Confirmation popup should appear
        softAssert2.assertEquals(TransferMoneyScreen.ttl_TransferConfirmation.getText(), "TRANSFER CONFIRMATION");

//        Tap ok button
        TransferMoneyScreen.btn_Ok.click();

//        Check Point: PIN screen should appear
        softAssert2.assertEquals(EnterPinScreen.ttl_EnterVerificationPin.getText(), "Enter Verification Pin");

//        Enter PIn
        EnterPinScreen.txt_PIN.sendKeys(pin);

//        Tap ok button
        EnterPinScreen.btn_Ok.click();

//        Check Point: transaction should be successful
        softAssert2.assertEquals(PaymentReceiptScreen.ttl_PaymentReceipt.getText(), "Transfer Receipt");
        softAssert2.assertEquals(PaymentReceiptScreen.lbl_PaymentType.getText(), receiver);
        softAssert2.assertEquals(PaymentReceiptScreen.lbl_Amount.getText(), amount);

//        Go back Wallet
        TransferMoneyScreen.btn_Back.click();
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