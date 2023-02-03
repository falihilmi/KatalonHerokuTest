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
import com.keyword.key as key
import com.kms.katalon.core.util.KeywordUtil
/** Define Variable **/
String bookDateAppointment = key.getDateTommorow('dd/MM/yyyy')
String inputComment = 'Book appointment in date : ' + bookDateAppointment


WebUI.callTestCase(findTestCase('Login/Login Success with valid data'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Book Appointment/listDropdownFacility'))
WebUI.click(findTestObject('Object Repository/Book Appointment/Checkbox.Readmission'))
WebUI.click(findTestObject('Object Repository/Book Appointment/Radiobtn.Medicare'))
WebUI.setText(findTestObject('Object Repository/Book Appointment/txt.comment'), inputComment)
WebUI.click(findTestObject('Object Repository/Book Appointment/btn.BookAppointment'))

WebUI.verifyElementNotPresent(findTestObject ('Object Repository/Book Appointment/lbl.AppointmentConfirmation'), 5)
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Book Appointment/CalenderDateTimePicker'))) {
	WebUI.comment("Date time is mandatory please select")
	KeywordUtil.markPassed("Passed, mandatory form is visible ")
}
else {
	KeywordUtil.markFailed("Failed, mandatory form NOT visible")
}