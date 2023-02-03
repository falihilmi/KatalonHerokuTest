import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

/** Define Variable Invalid User Account **/
String Username= 'UserIsInvalid'
String Password = 'ThisIsInvalid'


WebUI.openBrowser("https://katalon-demo-cura.herokuapp.com/")
WebUI.click(findTestObject('Object Repository/Login/HumburgerMenu'))
WebUI.click(findTestObject('Object Repository/Login/btn.SelectMenuLogin'))
WebUI.setText(findTestObject ('Object Repository/Login/txt.username'), Username)
WebUI.setText(findTestObject ('Object Repository/Login/txt.Password'), Password)
WebUI.click(findTestObject('Object Repository/Login/btn.SubmitLogin'))

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
