package com.apus.sdkapusandroid.domain.request

import com.apus.sdkapusandroid.domain.response.BlockChain
import com.apus.sdkapusandroid.domain.response.Currency
import java.util.*
import kotlin.collections.HashMap

class SearchPayment {
    var vendorKey: String? = null
    var txId: String? = null
    var timestamp: String? = null
    var blockchain: BlockChain.Type? = null
    var currency: Currency.Type? = null
    var currencyAmount: String? = null
    var coinAmount: String? = null
    var buyer: String? = null


    class Builder {
        val searchPayment = SearchPayment()

        fun withVendorKey(vendorKey: String): Builder {
            searchPayment.vendorKey = vendorKey
            return this
        }

        fun withTxId(txId: String): Builder {
            searchPayment.txId = txId
            return this
        }

        fun withTimestamp(timestamp: Long): Builder {
            searchPayment.timestamp = timestamp.toString()
            return this
        }

        fun withDate(date: Date): Builder {
            searchPayment.timestamp = date.time.toString()
            return this
        }

        fun withBlockchain(blockChain: BlockChain.Type): Builder {
            searchPayment.blockchain = blockChain
            return this
        }

        fun withCurrency(currency: Currency.Type): Builder {
            searchPayment.currency = currency
            return this
        }

        fun withCurrencyAmount(currencyAmount: String): Builder {
            searchPayment.currencyAmount = currencyAmount
            return this
        }

        fun withCoinAmount(coinAmount: String): Builder {
            searchPayment.coinAmount = coinAmount
            return this
        }

        fun build() = searchPayment

    }


}

fun SearchPayment.toParam(): Map<String, String> {
    val map: HashMap<String, String> = hashMapOf()
    txId?.let { map["txId"] = it }
    timestamp?.let { map["timestamp"] = it }
    blockchain?.let { map["blockchain"] = it.toString() }
    currency?.let { map["currency"] = it.toString() }
    currencyAmount?.let { map["currencyAmount"] = it }
    coinAmount?.let { map["coinAmount"] = it }
    buyer?.let { map["buyer"] = it }

    return map
}