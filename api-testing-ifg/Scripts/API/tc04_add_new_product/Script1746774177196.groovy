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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.util.KeywordUtil

// Ambil test object dasar dari Object Repository
TestObject requestObj = findTestObject('AddProduct')

// Override body secara dinamis
String dynamicBody = '''
{
  "title": "Velvet Matte Lip Cream",
  "description": "Velvet Matte Lip Cream delivers rich color with a smooth, soft-matte finish. Lightweight and non-drying, it glides effortlessly and stays put for hours, making it perfect for any occasion.",
  "category": "beauty",
  "price": 14.50,
  "discountPercentage": 12.00,
  "rating": 4.25,
  "stock": 75,
  "tags": [
    "beauty",
    "lipstick",
    "matte"
  ],
  "brand": "LushTone",
  "sku": "BEA-LUS-LIP-003",
  "weight": 3.5,
  "dimensions": {
    "width": 2.1,
    "height": 11.0,
    "depth": 2.1
  },
  "warrantyInformation": "No warranty",
  "shippingInformation": "Ships within 24 hours",
  "availabilityStatus": "In Stock",
  "reviews": [
    {
      "rating": 5,
      "comment": "Absolutely love the texture and color!",
      "date": "2025-04-28T14:30:00.000Z",
      "reviewerName": "Ariana Blake",
      "reviewerEmail": "ariana.blake@x.dummyjson.com"
    },
    {
      "rating": 3,
      "comment": "Nice shade but fades a bit quickly.",
      "date": "2025-04-29T10:15:00.000Z",
      "reviewerName": "Maya Singh",
      "reviewerEmail": "maya.singh@x.dummyjson.com"
    },
    {
      "rating": 4,
      "comment": "Great formula, wish it had more shades.",
      "date": "2025-05-01T08:45:00.000Z",
      "reviewerName": "Emily Tan",
      "reviewerEmail": "emily.tan@x.dummyjson.com"
    }
  ],
  "returnPolicy": "Returnable within 14 days",
  "minimumOrderQuantity": 10,
  "meta": {
    "createdAt": "2025-05-01T12:00:00.000Z",
    "updatedAt": "2025-05-01T12:00:00.000Z",
    "barcode": "8934812038471",
    "qrCode": "https://cdn.dummyjson.com/public/qr-code.png"
  },
  "images": [
    "https://cdn.dummyjson.com/product-images/beauty/velvet-matte-lip-cream/1.webp"
  ],
  "thumbnail": "https://cdn.dummyjson.com/product-images/beauty/velvet-matte-lip-cream/thumbnail.webp"
}
'''

// Set dynamic body ke request
requestObj.setBodyContent(new HttpTextBodyContent(dynamicBody, "UTF-8", "application/json"))

// Kirim request POST
def response = WS.sendRequest(requestObj)

// Verifikasi status code
WS.verifyResponseStatusCode(response, 201)

// Parsing response body
def json = new JsonSlurper().parseText(response.getResponseBodyContent())

// Assertion terhadap field penting
assert json.title == 'Velvet Matte Lip Cream'
assert json.brand == 'LushTone'
assert json.price == 14.50
assert json.category == 'beauty'
assert json.stock == 75

// Pastikan ID otomatis terbentuk
assert json.id instanceof Integer
KeywordUtil.logInfo("✅ Produk berhasil ditambahkan dengan ID: ${json.id}")

