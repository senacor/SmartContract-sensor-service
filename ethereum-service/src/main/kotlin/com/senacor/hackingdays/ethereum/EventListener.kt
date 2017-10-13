package com.senacor.hackingdays.ethereum

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaListener

/**
 *
 * @author jholtkamp
 */
@Configuration
class EventListener {

    @KafkaListener(topics = arrayOf("sensor-data-test"))
    fun listen(cr: ConsumerRecord<String, String>) {
        println(cr)
        println()
    }
}