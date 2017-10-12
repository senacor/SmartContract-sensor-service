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

    @KafkaListener(topics = arrayOf("test5"))
    fun listen(cr: ConsumerRecord<*, *>) {
        println(cr)
        println()
    }
}