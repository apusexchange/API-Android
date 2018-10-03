package com.apus.sdkapusandroid.domain.response

class SearchResponse:ApusResponse(){
    val data:Array<Data>?= null
}

class Data{
    var buyer:Buyer? =  null
    var coin:BlockChain? = null
    var currency:Currency? = null
    var seller:Seller?=null
    var txId:String?=null
}