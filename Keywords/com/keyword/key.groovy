package com.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class key {

	@Keyword
	public static String getDateToday (String format) {
		Date date = new Date()
		DateFormat dateFormat = new SimpleDateFormat(format)
		String formattedDate= dateFormat.format(date)
		return formattedDate
	}

	@Keyword
	public static String getDateTommorow (String format) {
		Date date = new Date().plus(1)
		DateFormat dateFormat = new SimpleDateFormat(format)
		String formattedDate= dateFormat.format(date)
		return formattedDate
	}

	@Keyword
	public static void compareValue (String currentValue, String expectedValue) {

		if (currentValue == expectedValue) {
			KeywordUtil.markPassed("Passed, Value : " + currentValue + ' & ' + expectedValue + ' is Match')
		}
		else {
			KeywordUtil.markFailed("Failed, value" + currentValue + ' & ' + expectedValue + ' is Not Match')
		}
	}
}
