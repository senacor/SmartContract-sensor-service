package com.senacor.hackingdays.telemetry

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * @author jholtkamp
 */
class TelemetryTest {

    @Test
    fun `test initialization`() {
        val entity = Telemetry(System.currentTimeMillis().toFloat(), AccelerometerData(), SupersonicData())

        assertThat(entity.timestamp).isNotEqualTo(0)
        assertThat(entity.ultrasonic_data).isEqualTo(listOf(SupersonicData()))
    }

    @Test
    fun `test serialization`() {
        val data = TestData.getTestData()

        assertThat(data.serialize()).isNotEmpty()
        println(data.serialize())
    }

    private fun getRandomCoordinate() =
            (Math.random() * 80).toFloat()
}