package com.apus.sdkapusandroid.domain.request

import com.apus.sdkapusandroid.comom.toSha256
import com.apus.sdkapusandroid.domain.response.BlockChain
import com.apus.sdkapusandroid.domain.response.Currency
import com.apus.sdkapusandroid.domain.response.Period

class RecurringPayment {
    lateinit var pan: String
    lateinit var password: String
    lateinit var blockchain: BlockChain.Type
    lateinit var amount: String
    lateinit var currency: Currency.Type
    lateinit var period: Period
    var frequency: Int = 0
    var execute: Boolean = false
    lateinit var vendorKey: String




    class Builder {
        val recurringPayment = RecurringPayment()

        fun withPeriod(period: Period):Builder{
            recurringPayment.period =  period
            return this
        }

        fun withFrequency(frequency:Int):Builder{
            recurringPayment.frequency = frequency
            return this
        }

        fun withExecute(execute:Boolean):Builder{
            recurringPayment.execute = execute
            return this
        }



        fun withPan(pan: String): Builder {
            recurringPayment.pan = pan.toSha256()
            return this

        }

        fun withPassWord(password: String): Builder {
            recurringPayment.password = password.toSha256()
            return this

        }

        fun withPanEncrypted(pan: String): Builder {
            recurringPayment.pan = pan
            return this

        }

        fun withPassWordEncrypted(password: String): Builder {
            recurringPayment.password = password
            return this

        }

        fun withBlockChain(blockChain: BlockChain.Type): Builder {
            recurringPayment.blockchain = blockChain
            return this

        }

        fun withAmount(amount: String): Builder {
            recurringPayment.amount = amount.replace("[1-9]*".toRegex(),"")
            return this
        }

        fun withAmount(amount: Int): Builder {
            return withAmount(amount.toString())
        }

        fun withCurrency(currency: Currency.Type): Builder {
            recurringPayment.currency = currency
            return this

        }

        fun withVendorKey(vendorKey: String): Builder {
            recurringPayment.vendorKey = vendorKey
            return this
        }

        fun build() = recurringPayment
    }
}