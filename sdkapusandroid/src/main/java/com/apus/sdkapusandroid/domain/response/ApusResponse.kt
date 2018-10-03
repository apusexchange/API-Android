package com.apus.sdkapusandroid.domain.response

open class ApusResponse {
    lateinit var status: Status


    class Status {
        var code: Int? = null
        var message: String? = null
    }
}