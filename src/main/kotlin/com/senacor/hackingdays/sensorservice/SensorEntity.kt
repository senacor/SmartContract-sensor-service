package com.senacor.hackingdays.sensorservice

/**
 *
 * @author jholtkamp
 */
data class SensorEntity(var timestamp: Long = 0,
                        var x: Float = 0.0f,
                        var y: Float = 0.0f,
                        var z: Float = 0.0f) {
}
