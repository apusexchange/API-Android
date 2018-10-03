package com.apus.sdkapusandroid.domain.response

class Currency {
    lateinit var name :String
    lateinit var amount: String
    enum class Type {
        BRL, CAD, CNY, EUR, JPY, USD
    }

}