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

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

// ID produk yang ingin dihapus, misalnya ID = 1
int productId = 1

// URL endpoint DELETE, ganti placeholder {id} dengan productId secara dinamis
String baseUrl = 'https://dummyjson.com/products/'
String productUrl = baseUrl + productId.toString()

// Membuat TestObject DELETE request
TestObject deleteProductTestObject = new TestObject('DeleteProduct')
deleteProductTestObject.setRestUrl(productUrl) // Set URL dinamis

// Set method untuk DELETE
deleteProductTestObject.setRestRequestMethod('DELETE')

// Kirim request DELETE ke endpoint
def response = WS.sendRequestAndVerify(deleteProductTestObject)

// Verifikasi status code, misalnya 200 atau 204 tergantung response yang diharapkan
WS.verifyResponseStatusCode(response, 200)

// Verifikasi response body jika ada
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Assert bahwa response body sesuai dengan harapan
assert json.message == 'Product deleted successfully'

// Log info
println("Product with ID ${productId} successfully deleted!")




