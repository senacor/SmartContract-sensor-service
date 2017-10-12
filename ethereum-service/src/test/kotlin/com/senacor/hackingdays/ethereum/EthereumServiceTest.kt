package com.senacor.hackingdays.ethereum

import org.junit.Before
import org.junit.Test

/**
 * @author jholtkamp
 */
internal class EthereumServiceTest {

    private lateinit var service: EthereumService

    @Before
    fun setUp() {
        service = EthereumService()
    }

    @Test
    fun name() {
        service.test()
    }
}