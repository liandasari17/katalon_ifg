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


// Kirim request dan dapatkan response
ResponseObject response = WS.sendRequest(findTestObject('SearchUser', [('searchName') : 'Michael']))

// Cek status code
WS.verifyResponseStatusCode(response, 200)

// Parse JSON response
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Asserts untuk mengecek apakah setiap field ada dan tidak null
json.users.each { user ->
	assert user.id != null
	assert user.firstName != null
	assert user.lastName != null
	assert user.gender != null
	assert user.email != null
	assert user.phone != null
	assert user.username != null
	assert user.password != null
	assert user.birthDate != null
	assert user.image != null
	assert user.bloodGroup != null
	assert user.height != null
	assert user.weight != null
	assert user.eyeColor != null
	assert user.hair != null
	assert user.hair.color != null
	assert user.hair.type != null
	assert user.ip != null
	assert user.address != null
	assert user.address.address != null
	assert user.address.city != null
	assert user.address.state != null
	assert user.address.stateCode != null
	assert user.address.postalCode != null
	assert user.address.coordinates != null
	assert user.address.coordinates.lat != null
	assert user.address.coordinates.lng != null
	assert user.address.country != null
	assert user.macAddress != null
	assert user.university != null
	assert user.bank != null
	assert user.bank.cardExpire != null
	assert user.bank.cardNumber != null
	assert user.bank.cardType != null
	assert user.bank.currency != null
	assert user.bank.iban != null
	assert user.company != null
	assert user.company.department != null
	assert user.company.name != null
	assert user.company.title != null
	assert user.company.address != null
	assert user.company.address.address != null
	assert user.company.address.city != null
	assert user.company.address.state != null
	assert user.company.address.stateCode != null
	assert user.company.address.postalCode != null
	assert user.company.address.coordinates != null
	assert user.company.address.coordinates.lat != null
	assert user.company.address.coordinates.lng != null
	assert user.company.address.country != null
	assert user.ein != null
	assert user.ssn != null
	assert user.userAgent != null
	assert user.crypto != null
	assert user.crypto.coin != null
	assert user.crypto.wallet != null
	assert user.crypto.network != null
	assert user.role != null
}
