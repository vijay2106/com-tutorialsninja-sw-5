package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.AccountRegisterPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


    @Listeners(CustomListeners.class)
    public class AccountRegisterPageTest extends BaseTest {
        HomePage homePage;
        AccountRegisterPage accountRegisterPage;
        MyAccountPage accountPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            homePage = new HomePage();
            accountPage = new MyAccountPage();
            accountRegisterPage = new AccountRegisterPage();
        }

        @Test(groups = {"sanity", "regression"})
        public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
            homePage.clickOnMyQAccountTab();
            homePage.selectMyAccountOptions("Register");
            Assert.assertEquals(accountRegisterPage.getRegisterAccountText(),
                    "Register Account", "Register page not displayed");
        }

        @Test(groups = {"smoke", "regression"})
        public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
            homePage.clickOnMyQAccountTab();
            homePage.selectMyAccountOptions("Register");
            accountRegisterPage.enterFirstName("Bha");
            accountRegisterPage.enterLastName("Kam");
            accountRegisterPage.enterEmail("Vijayr@gmail.com");
            accountRegisterPage.enterTelephone("7896541230");
            accountRegisterPage.enterPassword("Bha123");
            accountRegisterPage.enterConfirmPassword("Bha@123");
            accountRegisterPage.selectSubscription("Yes");
            accountRegisterPage.clickOnPrivacyPolicyCheckBox();
            accountRegisterPage.clickOnContinueButton();
            Assert.assertEquals(accountPage.getYourAccountHasBeenCreatedText(), "Your Account Has Been Created!",
                    "Account not created");
            accountPage.clickOnContinueButton();
            homePage.clickOnMyQAccountTab();
            homePage.selectMyAccountOptions("Logout");
            Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
            accountPage.clickOnContinueButton();
        }


    }

