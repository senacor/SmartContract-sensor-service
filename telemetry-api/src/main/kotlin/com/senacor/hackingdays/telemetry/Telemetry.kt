package com.senacor.hackingdays.telemetry

import com.fasterxml.jackson.databind.ObjectMapper

/**
 *
 * @author jholtkamp
 */
data class Telemetry(var timestamp: Long = 0,
                     var x: Float = 0.0f,
                     var y: Float = 0.0f,
                     var z: Float = 0.0f) {

    fun serialize() = ObjectMapper().writeValueAsString(this)
}
