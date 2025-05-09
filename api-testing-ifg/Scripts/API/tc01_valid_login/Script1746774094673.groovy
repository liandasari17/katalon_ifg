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
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject


// Ambil object dari repository
RequestObject request = findTestObject('LoginRequest')

// Override body
String dynamicBody = '''
{
    "username": "michaelw",
    "password": "michaelwpass",
    "expiresInMins": 30
}
'''
request.setBodyContent(new HttpTextBodyContent(dynamicBody, "UTF-8", "application/json"))

// Kirim request
def response = WS.sendRequest(request)
WS.verifyResponseStatusCode(response, 200)

// Cek waktu respon (maks 8 detik)
assert response.getElapsedTime() < 8000

// Parse response body JSON
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Assert field yang diharapkan ada
assert json.accessToken
assert json.refreshToken
assert json.id
assert json.username
assert json.email
assert json.firstName
assert json.lastName
assert json.gender
assert json.image
