package com.senacor.hackingdays.sensorservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SensorServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(SensorServiceApplication::class.java, *args)
}
