package com.senacor.hackingdays.sensorservice

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture

/**
 *
 * @author jholtkamp
 */
@Service
class SensorEventService(var kafka: KafkaTemplate<String, String>) {

    private val topic = "test5"

    fun send(entity: SensorEntity): ListenableFuture<SendResult<String, String>>? {
        return kafka.send(topic, ObjectMapper().writeValueAsString(entity))
    }
}
