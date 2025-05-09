<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>AddProduct</name>
   <tag></tag>
   <elementGuidId>bf44e2b3-adf2-4a77-8e07-4d844dd76a0f</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n      \&quot;title\&quot;: \&quot;Essence Mascara Lash Princess\&quot;,\n      \&quot;description\&quot;: \&quot;The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.\&quot;,\n      \&quot;category\&quot;: \&quot;beauty\&quot;,\n      \&quot;price\&quot;: 9.99,\n      \&quot;discountPercentage\&quot;: 10.48,\n      \&quot;rating\&quot;: 2.56,\n      \&quot;stock\&quot;: 99,\n      \&quot;tags\&quot;: [\n        \&quot;beauty\&quot;,\n        \&quot;mascara\&quot;\n      ],\n      \&quot;brand\&quot;: \&quot;Essence\&quot;,\n      \&quot;sku\&quot;: \&quot;BEA-ESS-ESS-001\&quot;,\n      \&quot;weight\&quot;: 4,\n      \&quot;dimensions\&quot;: {\n        \&quot;width\&quot;: 15.14,\n        \&quot;height\&quot;: 13.08,\n        \&quot;depth\&quot;: 22.99\n      },\n      \&quot;warrantyInformation\&quot;: \&quot;1 week warranty\&quot;,\n      \&quot;shippingInformation\&quot;: \&quot;Ships in 3-5 business days\&quot;,\n      \&quot;availabilityStatus\&quot;: \&quot;In Stock\&quot;,\n      \&quot;reviews\&quot;: [\n        {\n          \&quot;rating\&quot;: 3,\n          \&quot;comment\&quot;: \&quot;Would not recommend!\&quot;,\n          \&quot;date\&quot;: \&quot;2025-04-30T09:41:02.053Z\&quot;,\n          \&quot;reviewerName\&quot;: \&quot;Eleanor Collins\&quot;,\n          \&quot;reviewerEmail\&quot;: \&quot;eleanor.collins@x.dummyjson.com\&quot;\n        },\n        {\n          \&quot;rating\&quot;: 4,\n          \&quot;comment\&quot;: \&quot;Very satisfied!\&quot;,\n          \&quot;date\&quot;: \&quot;2025-04-30T09:41:02.053Z\&quot;,\n          \&quot;reviewerName\&quot;: \&quot;Lucas Gordon\&quot;,\n          \&quot;reviewerEmail\&quot;: \&quot;lucas.gordon@x.dummyjson.com\&quot;\n        },\n        {\n          \&quot;rating\&quot;: 5,\n          \&quot;comment\&quot;: \&quot;Highly impressed!\&quot;,\n          \&quot;date\&quot;: \&quot;2025-04-30T09:41:02.053Z\&quot;,\n          \&quot;reviewerName\&quot;: \&quot;Eleanor Collins\&quot;,\n          \&quot;reviewerEmail\&quot;: \&quot;eleanor.collins@x.dummyjson.com\&quot;\n        }\n      ],\n      \&quot;returnPolicy\&quot;: \&quot;No return policy\&quot;,\n      \&quot;minimumOrderQuantity\&quot;: 48,\n      \&quot;meta\&quot;: {\n        \&quot;createdAt\&quot;: \&quot;2025-04-30T09:41:02.053Z\&quot;,\n        \&quot;updatedAt\&quot;: \&quot;2025-04-30T09:41:02.053Z\&quot;,\n        \&quot;barcode\&quot;: \&quot;5784719087687\&quot;,\n        \&quot;qrCode\&quot;: \&quot;https://cdn.dummyjson.com/public/qr-code.png\&quot;\n      },\n      \&quot;images\&quot;: [\n        \&quot;https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp\&quot;\n      ],\n      \&quot;thumbnail\&quot;: \&quot;https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>fdaa767d-81c9-40aa-86f3-f10714540b76</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>10.1.1</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://dummyjson.com/products/add</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
