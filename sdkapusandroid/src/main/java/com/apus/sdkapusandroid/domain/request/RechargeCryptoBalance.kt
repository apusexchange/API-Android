package com.apus.sdkapusandroid.domain.request

import com.apus.sdkapusandroid.comom.toSha256
import com.apus.sdkapusandroid.domain.response.BlockChain
import com.apus.sdkapusandroid.domain.response.Currency

class RechargeCryptoBalance{
    lateinit var pan: String
    lateinit var password: String
    lateinit var blockchain: BlockChain.Type
    lateinit var amount: String
    lateinit var currency: Currency.Type
    lateinit var vendorKey: String



    class Builder {
        val rechargeCryptoBalance = RechargeCryptoBalance()

        fun withPan(pan: String): Builder {
            rechargeCryptoBalance.pan = pan.toSha256()
            return this

        }

        fun withPassWord(password: String): Builder {
            rechargeCryptoBalance.password = password.toSha256()
            return this

        }

        fun withPanEncrypted(pan: String): Builder {
            rechargeCryptoBalance.pan = pan
            return this

        }

        fun withPassWordEncrypted(password: String): Builder {
            rechargeCryptoBalance.password = password
            return this

        }

        fun withBlockChain(blockChain: BlockChain.Type): Builder {
            rechargeCryptoBalance.blockchain = blockChain
            return this

        }

        fun withAmount(amount: String): Builder {
            rechargeCryptoBalance.amount = amount.replace("[1-9]*".toRegex(),"")
            return this
        }

        fun withAmount(amount: Int): Builder {
            return withAmount(amount.toString())
        }

        fun withCurrency(currency: Currency.Type): Builder {
            rechargeCryptoBalance.currency = currency
            return this

        }

        fun withVendorKey(vendorKey: String): Builder {
            rechargeCryptoBalance.vendorKey = vendorKey
            return this
        }

        fun build() = rechargeCryptoBalance
    }
}