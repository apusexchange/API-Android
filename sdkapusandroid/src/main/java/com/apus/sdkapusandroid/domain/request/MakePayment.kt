package com.apus.sdkapusandroid.domain.request

import com.apus.sdkapusandroid.comom.toSha256
import com.apus.sdkapusandroid.domain.response.BlockChain
import com.apus.sdkapusandroid.domain.response.Currency

class MakePayment {
    lateinit var pan: String
    lateinit var password: String
    lateinit var blockchain: BlockChain.Type
    lateinit var amount: String
    lateinit var currency: Currency.Type
    lateinit var vendorKey: String

    class Builder {
        val makePayment = MakePayment()

        fun withPan(pan: String): Builder {
            makePayment.pan = pan.toSha256()
            return this

        }

        fun withPassWord(password: String): Builder {
            makePayment.password = password.toSha256()
            return this

        }

        fun withPanEncrypted(pan: String): Builder {
            makePayment.pan = pan
            return this

        }

        fun withPassWordEncrypted(password: String): Builder {
            makePayment.password = password
            return this

        }

        fun withBlockChain(blockChain: BlockChain.Type): Builder {
            makePayment.blockchain = blockChain
            return this

        }

        fun withAmount(amount: String): Builder {
            makePayment.amount = amount.replace("[a-z,A-Z]*".toRegex(),"")
            return this
        }

        fun withAmount(amount: Int): Builder {
            return withAmount(amount.toString())
        }

        fun withCurrency(currency: Currency.Type): Builder {
            makePayment.currency = currency
            return this

        }

        fun withVendorKey(vendorKey: String): Builder {
            makePayment.vendorKey = vendorKey
            return this
        }

        fun build() = makePayment
    }
}