package com.senacor.hackingdays.telemetry

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author jholtkamp
 */
@RestController
class TelemetryController(val service: TelemetryEventService) {

    @PostMapping("/telemetries", consumes = arrayOf("application/json;charset=UTF-8"))
    fun findByLastName(@RequestBody entity: Telemetry): ResponseEntity<String> {
        service.send(entity)

        return ResponseEntity.ok().build<String>()
    }
}
