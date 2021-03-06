package com.senacor.hackingdays.ethereum.contracts

import org.web3j.abi.FunctionEncoder
import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Function
import org.web3j.abi.datatypes.Type
import org.web3j.abi.datatypes.Utf8String
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
class Greeter : Contract {

    private constructor(contractAddress: String, web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger) : super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit) {}

    private constructor(contractAddress: String, web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger) : super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit) {}

    fun kill(): Future<TransactionReceipt> {
        val function = Function("kill", Arrays.asList(), emptyList())
        return executeTransactionAsync(function)
    }

    fun greet(): Future<Utf8String> {
        val function = Function("greet",
                Arrays.asList(),
                Arrays.asList<TypeReference<*>>(object : TypeReference<Utf8String>() {

                }))
        return executeCallSingleValueReturnAsync(function)
    }

    fun changeGreeting(_newGreeting: Utf8String): Future<TransactionReceipt> {
        val function = Function("changeGreeting", Arrays.asList<Type<*>>(_newGreeting), emptyList())
        return executeTransactionAsync(function)
    }

    companion object {
        private val BINARY = "6060604052341561000f57600080fd5b6040516104233803806104238339810160405280805160008054600160a060020a03191633600160a060020a03161790559190910190506001818051610059929160200190610060565b50506100fb565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a157805160ff19168380011785556100ce565b828001600101855582156100ce579182015b828111156100ce5782518255916020019190600101906100b3565b506100da9291506100de565b5090565b6100f891905b808211156100da57600081556001016100e4565b90565b6103198061010a6000396000f300606060405263ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610052578063cfae321714610067578063d28c25d4146100f157600080fd5b341561005d57600080fd5b610065610142565b005b341561007257600080fd5b61007a610183565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100b657808201518382015260200161009e565b50505050905090810190601f1680156100e35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156100fc57600080fd5b61006560046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061022c95505050505050565b6000543373ffffffffffffffffffffffffffffffffffffffff908116911614156101815760005473ffffffffffffffffffffffffffffffffffffffff16ff5b565b61018b610243565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102215780601f106101f657610100808354040283529160200191610221565b820191906000526020600020905b81548152906001019060200180831161020457829003601f168201915b505050505090505b90565b600181805161023f929160200190610255565b5050565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061029657805160ff19168380011785556102c3565b828001600101855582156102c3579182015b828111156102c35782518255916020019190600101906102a8565b506102cf9291506102d3565b5090565b61022991905b808211156102cf57600081556001016102d95600a165627a7a7230582086f98f1bdf3014423cdcc38a8ef46778ba4c3ae0c4e33a5abda54a5d6cf80e7b0029"

        fun deploy(web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger, initialWeiValue: BigInteger, _greeting: Utf8String): Future<Greeter> {
            val encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.asList<Type<*>>(_greeting))
            return Contract.deployAsync(Greeter::class.java, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue)
        }

        fun deploy(web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger, initialWeiValue: BigInteger, _greeting: Utf8String): Future<Greeter> {
            val encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.asList<Type<*>>(_greeting))
            return Contract.deployAsync(Greeter::class.java, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue)
        }

        fun load(contractAddress: String, web3j: Web3j, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger): Greeter {
            return Greeter(contractAddress, web3j, credentials, gasPrice, gasLimit)
        }

        fun load(contractAddress: String, web3j: Web3j, transactionManager: TransactionManager, gasPrice: BigInteger, gasLimit: BigInteger): Greeter {
            return Greeter(contractAddress, web3j, transactionManager, gasPrice, gasLimit)
        }
    }
}
