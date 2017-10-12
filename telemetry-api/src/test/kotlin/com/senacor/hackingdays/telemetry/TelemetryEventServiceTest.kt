package com.senacor.hackingdays.telemetry

import com.senacor.hackingdays.telemetry.Telemetry
import com.senacor.hackingdays.telemetry.TelemetryEventService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author jholtkamp
 */
@RunWith(SpringRunner::class)
@SpringBootTest
internal class TelemetryEventServiceTest {

    @Autowired
    private lateinit var kafka: KafkaTemplate<String, String>

    lateinit var service: TelemetryEventService

    @Before
    internal fun setUp() {
        service = TelemetryEventService(kafka)
    }

    @Test
    fun name() {
        service.send(Telemetry(12345))
    }
}