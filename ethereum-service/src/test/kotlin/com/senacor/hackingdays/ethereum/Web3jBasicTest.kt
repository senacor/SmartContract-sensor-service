package com.senacor.hackingdays.ethereum

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.http.HttpService
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal

/**
 * @author jholtkamp
 */
internal class Web3jBasicTest {

    private val ADDRESS = "0x7e11511c14bec79e9f00d036206044387a38526f"

    @Test
    fun `read credentials`() {
        val address = credentials()?.address

        assertThat(address).isEqualTo(ADDRESS)
        println("Address: $address")
    }

    @Test
    fun `read accounts`() {
        val web3 = Web3j.build(HttpService())
        web3.web3ClientVersion().observable().subscribe { x ->
            println("Client version: ${x.web3ClientVersion}")
        }

        web3.ethAccounts().observable()
                .subscribe { t -> println("Accounts: ${t.accounts}") }
    }

    @Test
    fun `read balance`() {
        val web3 = Web3j.build(HttpService())
        web3.ethGetBalance(credentials()?.address, DefaultBlockParameterName.LATEST).observable()
                .subscribe { t -> println("Balance: ${t.balance}") }
    }

    @Test
    @Ignore
    fun `send transaction`() {
        val web3 = Web3j.build(HttpService())

        val transactionReceipt = Transfer.sendFunds(
                web3, credentials(), ADDRESS, BigDecimal.valueOf(1.0), Convert.Unit.ETHER)

        println("Transaction hash: ${transactionReceipt.transactionHash}")
    }

    private fun credentials(): Credentials? {
        return WalletUtils.loadCredentials(
                "test",
                "/Users/jholtkamp/Library/Ethereum/rinkeby/keystore/UTC--2017-10-12T16-04-43.978476191Z--7e11511c14bec79e9f00d036206044387a38526f")
    }
}