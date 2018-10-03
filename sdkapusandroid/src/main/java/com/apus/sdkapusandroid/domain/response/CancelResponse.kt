package com.apus.sdkapusandroid.domain.response

class CancelResponse:ApusResponse(){
    var currency:Currency? = null
    var coin:BlockChain? = null
    var transaction: Transaction? = null
}