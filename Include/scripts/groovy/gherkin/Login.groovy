package gherkin
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I want to navigates to login page")
	def goToPageLogin() {
		WebUI.openBrowser("https://katalon-demo-cura.herokuapp.com/")
		WebUI.click(findTestObject('Object Repository/Login/HumburgerMenu'))
		WebUI.click(findTestObject('Object Repository/Login/btn.SelectMenuLogin'))
	}

	@When("I input credential (.*) and (.*)")
	def inputCredential(String username, String password) {
		WebUI.setText(findTestObject ('Object Repository/Login/txt.username'), username)
		WebUI.setText(findTestObject ('Object Repository/Login/txt.Password'), password)
	}
	

	
	@And("click button login")
	def clickBtnLogin() {
		WebUI.click(findTestObject('Object Repository/Login/btn.SubmitLogin'))
	}

	@Then("I navigated to form page appointment")
	def validateFormPageAfterLogin() {
		String getCurrentURL = WebUI.getUrl()
		String expectedURL = 'https://katalon-demo-cura.herokuapp.com/#appointment'
		if(getCurrentURL==expectedURL) {
			KeywordUtil.markPassed("Passed, URL is match and success direct Page")
			'Check UI Book Appointment visible'
			if(WebUI.verifyElementPresent(findTestObject('Object Repository/Login/btn.BookAppointment'), 5))
				{
					KeywordUtil.markPassed("Passed, UI Book appointment is Visible")
				}
			else {
				KeywordUtil.markFailed("Failed, UI Book appointment is NOT Visible")
			}
		}
		else {
			KeywordUtil.markFailed("Failed, URL not matched or failed direct page")
		}
		
	}
	
	@Then("I see failed credential")
	def seeFailedCredential() {
		
		if(WebUI.verifyElementPresent(findTestObject('Object Repository/Login/toast.WordingFailedLogin'), 5))
		{
			KeywordUtil.markPassed("Passed, Scenario Invalid account is expected")
		}
		else {
		KeywordUtil.markFailed("Failed, Scenario Invalid account NOT expected")
		}
		
		'Check direct Page make sure not direct page if account user failed login'
		String getCurrentURL = WebUI.getUrl()
		String expectedURL = 'https://katalon-demo-cura.herokuapp.com/profile.php#login'  //URL Page Login
		if(getCurrentURL == expectedURL) {
			KeywordUtil.markPassed("Scenario Is Passed, User invalid not direct page ")
		}
		else {
			KeywordUtil.markFailed("Scenario is Failed, User invalid and then direct another page")
		}
		
		
		
	}
	
	
}