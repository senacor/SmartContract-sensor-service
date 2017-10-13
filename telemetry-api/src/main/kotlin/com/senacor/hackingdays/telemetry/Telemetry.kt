package com.senacor.hackingdays.telemetry

import com.fasterxml.jackson.databind.ObjectMapper

/**
 *
 * @author jholtkamp
 */
data class Telemetry(var timestamp: Float = System.currentTimeMillis().toFloat(),
                     var accelerometer_data: List<AccelerometerData> = listOf(AccelerometerData()),
                     var ultrasonic_data: List<SupersonicData> = listOf(SupersonicData())) {

    constructor(timestamp: Float = System.currentTimeMillis().toFloat(),
                accelerometerData: AccelerometerData = AccelerometerData(),
                ultrasonicData: SupersonicData = SupersonicData()) :
            this(timestamp, listOf(accelerometerData), listOf(ultrasonicData))

    fun serialize() = ObjectMapper().writeValueAsString(this)
}

data class AccelerometerData(var x: Float = 0.0f,
                             var y: Float = 0.0f,
                             var z: Float = 0.0f)

data class SupersonicData(var distance: Float = 0.0f)
