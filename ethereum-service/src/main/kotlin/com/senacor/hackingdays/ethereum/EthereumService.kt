package com.senacor.hackingdays.ethereum

import org.springframework.stereotype.Service
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService

/**
 *
 * @author jholtkamp
 */
@Service
class EthereumService {

    fun test() {
        val web3 = Web3j.build(HttpService())
        web3.web3ClientVersion().observable().subscribe { x ->
            println(x.web3ClientVersion)
        }
    }
}
