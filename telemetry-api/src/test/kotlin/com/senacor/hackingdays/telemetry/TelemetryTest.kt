package com.senacor.hackingdays.telemetry

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * @author jholtkamp
 */
class TelemetryTest {

    @Test
    fun `test initialization`() {
        val entity = Telemetry(System.currentTimeMillis())

        assertThat(entity.timestamp).isNotEqualTo(0)
        assertThat(entity.x).isEqualTo(0.0f)
    }

    @Test
    fun `test serialization`() {
        val data = Telemetry(System.currentTimeMillis(), getRandomCoordinate(), getRandomCoordinate(), getRandomCoordinate())

        println(data.serialize())
    }

    private fun getRandomCoordinate() =
            (Math.random() * 80).toFloat()
}