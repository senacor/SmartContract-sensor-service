package com.senacor.hackingdays.telemetry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TelemetryApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(TelemetryApiApplication::class.java, *args)
}
