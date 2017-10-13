package com.senacor.hackingdays.ethereum

import com.senacor.hackingdays.ethereum.contracts.Greeter
import org.junit.Test
import org.web3j.abi.datatypes.Utf8String
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import java.math.BigInteger


/**
 * @author jholtkamp
 */
internal class SmartContractTest {

    @Test
    fun `execute contract`() {
        val web3 = Web3j.build(HttpService())

        val contract = Greeter.deploy(
                web3, credentials(),
                BigInteger.ZERO, BigInteger.ZERO,
                BigInteger.ZERO, Utf8String("someone to greet")).get()

        contract.greet()
    }

    private fun credentials(): Credentials? {
        return WalletUtils.loadCredentials(
                "test",
                "/Users/jholtkamp/Library/Ethereum/rinkeby/keystore/UTC--2017-10-12T16-04-43.978476191Z--7e11511c14bec79e9f00d036206044387a38526f")
    }
}