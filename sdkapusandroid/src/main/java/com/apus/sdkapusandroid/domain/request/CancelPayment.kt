package com.apus.sdkapusandroid.domain.request

import com.apus.sdkapusandroid.comom.toSha256
import com.apus.sdkapusandroid.domain.response.Currency

class CancelPayment{
    lateinit var password: String
    lateinit var txId: String
    lateinit var vendorKey: String

    class Builder {
        val cancelPayment = CancelPayment()



        fun withPassWord(password: String): Builder {
            cancelPayment.password = password.toSha256()
            return this

        }



        fun withPassWordEncrypted(password: String): Builder {
            cancelPayment.password = password
            return this

        }

        fun withTxId(txId: String): Builder {
            cancelPayment.txId = txId
            return this

        }






        fun withVendorKey(vendorKey: String): Builder {
            cancelPayment.vendorKey = vendorKey
            return this
        }

        fun build() = cancelPayment
    }
}