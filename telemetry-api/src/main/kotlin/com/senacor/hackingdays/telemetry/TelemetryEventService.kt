package com.senacor.hackingdays.telemetry

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import org.springframework.util.concurrent.ListenableFuture

/**
 *
 * @author jholtkamp
 */
@Service
class TelemetryEventService(var kafka: KafkaTemplate<String, String>) {

    private val topic = "sensor-data-test"

    fun send(entity: Telemetry): ListenableFuture<SendResult<String, String>>? {
        return kafka.send(topic, entity.serialize())
    }
}
