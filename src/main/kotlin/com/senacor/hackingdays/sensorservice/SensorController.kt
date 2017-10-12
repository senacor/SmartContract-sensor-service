package com.senacor.hackingdays.sensorservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author jholtkamp
 */
@RestController
class SensorController(val service: SensorEventService) {

    @PostMapping("/telemetries", consumes = arrayOf("application/json;charset=UTF-8"))
    fun findByLastName(@RequestBody entity: SensorEntity): ResponseEntity<String> {
        service.send(entity)

        return ResponseEntity.ok().build<String>()
    }
}
