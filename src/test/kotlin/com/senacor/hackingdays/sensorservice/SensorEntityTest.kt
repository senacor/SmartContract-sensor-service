package com.senacor.hackingdays.sensorservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * @author jholtkamp
 */
internal class SensorEntityTest {

    @Test
    fun `test initialization`() {
        val entity = SensorEntity(System.currentTimeMillis())

        assertThat(entity.timestamp).isNotEqualTo(0)
        assertThat(entity.x).isEqualTo(0.0f)
    }
}