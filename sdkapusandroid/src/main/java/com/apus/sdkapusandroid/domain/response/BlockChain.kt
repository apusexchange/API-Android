package com.apus.sdkapusandroid.domain.response

class BlockChain{
    var name:String? = null
    var amount:String? = null
    var fee:String? = null

    enum class Type {
        BTC, LTC, ETH, DCR
    }
}