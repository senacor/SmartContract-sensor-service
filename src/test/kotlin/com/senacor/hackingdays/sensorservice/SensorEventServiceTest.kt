package com.senacor.hackingdays.sensorservice

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
internal class SensorEventServiceTest {

    @Autowired
    private lateinit var kafka: KafkaTemplate<String, String>

    lateinit var service: SensorEventService

    @Before
    internal fun setUp() {
        service = SensorEventService(kafka)
    }

    @Test
    fun name() {
        val data = SensorEntity(12345)
        service.send(data)
    }
}