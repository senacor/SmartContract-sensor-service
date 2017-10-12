package com.senacor.hackingdays.ethereum

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class EthereumServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(EthereumServiceApplication::class.java, *args)
}
