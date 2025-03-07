//package customer;
//
//import base.BaseTests;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.*;
//
//import java.time.Duration;
//
//public class TransactionTests extends BaseTests {
//
//    @BeforeMethod
//    public void setUpTest() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        System.out.println("Initializing Chrome Browser...");
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
//
//        homePage = new HomePage(driver);
//        customerAuthenticationPage = new CustomerAuthenticationPage(driver);
//    }
//
//    @AfterMethod
//    public void tearDownTest() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//            System.out.println("Browser session closed.");
//        }
//    }
//
//    @Test
//    public void testInsufficientBalance() {
//        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
//                .selectCustomerName("Harry Potter")
//                .clickLoginButton();
//
//        WithdrawPage withdrawPage = customerDashboard.clickWithdraw();
//        withdrawPage.enterAmount("1000000");
//        withdrawPage.clickWithdrawButton();
//
//        Assert.assertTrue(withdrawPage.isTransactionFailed(), "Transaction did not fail for insufficient balance!");
//    }
//
//    @Test
//    public void testNegativeDeposit() {
//        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
//                .selectCustomerName("Harry Potter")
//                .clickLoginButton();
//
//        DepositPage depositPage = customerDashboard.clickDeposit();
//        depositPage.enterAmount("-100");
//        depositPage.clickDepositButton();
//
//        Assert.assertFalse(depositPage.isDepositSuccessful(), "Negative deposit was incorrectly processed!");
//    }
//
//    @Test
//    public void testZeroDeposit() {
//        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
//                .selectCustomerName("Harry Potter")
//                .clickLoginButton();
//
//        DepositPage depositPage = customerDashboard.clickDeposit();
//        depositPage.enterAmount("0");
//        depositPage.clickDepositButton();
//
//        Assert.assertFalse(depositPage.isDepositSuccessful(), "Zero deposit was incorrectly processed!");
//    }
//
//    @Test
//    public void testNegativeWithdrawal() {
//        CustomerDashboard customerDashboard = homePage.clickCustomerLogin()
//                .selectCustomerName("Harry Potter")
//                .clickLoginButton();
//
//        WithdrawPage withdrawPage = customerDashboard.clickWithdraw();
//        withdrawPage.enterAmount("-50");
//        withdrawPage.clickWithdrawButton();
//
//        Assert.assertFalse(withdrawPage.isWithdrawalSuccessful(), "Negative withdrawal was incorrectly processed!");
//    }
//}
