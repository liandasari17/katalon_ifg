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

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.Properties

import org.apache.kafka.clients.producer.*
import org.apache.kafka.clients.consumer.*
import org.apache.kafka.common.serialization.*
import java.util.*
import java.time.Duration

def topic = "test-topic"
def bootstrapServers = "localhost:9093"

// === 1. PRODUCER: Kirim message ===
Properties producerProps = new Properties()
producerProps.put("bootstrap.servers", bootstrapServers)
producerProps.put("key.serializer", StringSerializer.getName())
producerProps.put("value.serializer", StringSerializer.getName())

Producer<String, String> producer = new KafkaProducer<>(producerProps)
String messageToSend = "Hello from Katalon!"
producer.send(new ProducerRecord<>(topic, messageToSend))
producer.close()

// === 2. CONSUMER: Ambil message ===
Properties consumerProps = new Properties()
consumerProps.put("bootstrap.servers", bootstrapServers)
consumerProps.put("group.id", "katalon-test-group")
consumerProps.put("key.deserializer", StringDeserializer.getName())
consumerProps.put("value.deserializer", StringDeserializer.getName())
consumerProps.put("auto.offset.reset", "earliest")  // supaya ambil dari awal

KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps)
consumer.subscribe(Arrays.asList(topic))

boolean messageFound = false
long startTime = System.currentTimeMillis()
while (!messageFound && (System.currentTimeMillis() - startTime < 5000)) {  // tunggu max 5 detik
    def records = consumer.poll(Duration.ofMillis(500))
    for (ConsumerRecord<String, String> record : records) {
        println "Diterima: ${record.value()}"
        if (record.value() == messageToSend) {
            messageFound = true
            break
        }
    }
}
consumer.close()

// === 3. Validasi ===
assert messageFound : "Pesan tidak ditemukan!"

