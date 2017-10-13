package com.senacor.hackingdays.ethereum.contracts

import org.web3j.abi.datatypes.Function
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.Contract
import org.web3j.tx.TransactionManager
import java.math.BigInteger
import java.util.*
import java.util.concurrent.Future

/**
 * Auto generated code.<br></br>
 * **Do not modify!**<br></br>
 * Please use the [web3j command line tools](https://docs.web3j.io/command_line.html), or [org.web3j.codegen.SolidityFunctionWrapperGenerator] to update.
 *
 *
 * Generated with web3j version 2.3.0.
 */
class Mortal : Contract {

    private constructor(contractAddress: String, web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger) : super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit) {}

    private constructor(contractAddress: String, web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger) : super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit) {}

    fun kill(): Future<TransactionReceipt> {
        val function = Function("kill", Arrays.asList(), emptyList())
        return executeTransactionAsync(function)
    }

    companion object {
        private val BINARY = "6060604052341561000f57600080fd5b60008054600160a060020a033316600160a060020a031990911617905560b98061003a6000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114603b57600080fd5b3415604557600080fd5b604b604d565b005b6000543373ffffffffffffffffffffffffffffffffffffffff90811691161415608b5760005473ffffffffffffffffffffffffffffffffffffffff16ff5b5600a165627a7a72305820c5ee3a3ddb496095139658c3d21550d3908a6d3f65fe51283ee1e210adf93f330029"

        fun deploy(web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger, initialWeiValue: BigInteger): Future<Mortal> {
            return Contract.deployAsync(Mortal::class.java, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue)
        }

        fun deploy(web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger, initialWeiValue: BigInteger): Future<Mortal> {
            return Contract.deployAsync(Mortal::class.java, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue)
        }

        fun load(contractAddress: String, web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger): Mortal {
            return Mortal(contractAddress, web3j, credentials, gasPrice, gasLimit)
        }

        fun load(contractAddress: String, web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger): Mortal {
            return Mortal(contractAddress, web3j, transactionManager, gasPrice, gasLimit)
        }
    }
}
