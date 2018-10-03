package com.apus.sdkapusandroid.controller

import android.content.Context
import android.util.Log
import com.apus.sdkapusandroid.BuildConfig
import com.apus.sdkapusandroid.domain.request.*
import com.apus.sdkapusandroid.domain.response.*
import com.apus.sdkapusandroid.rest.RestService

class ApusPaymentAPI(isSandBox: Boolean) {
    private val restService = RestService(if (isSandBox) BuildConfig.SANDBOX_URL else BuildConfig.PRODUCTION_URL)
    var callback: (ApusResponse) -> (Unit) =
            {
                Log.e("APUS", "Callback not implemented")
            }

    fun start(makePayment: MakePayment, context: Context) {
        restService.extraPath = "checkout/"
        restService.post(context, makePayment, PaymentResponse::class.java, callback)
    }

    fun start(cancelPayment: CancelPayment, context: Context) {
        restService.extraPath = "checkout/"

        restService.delete(context, cancelPayment, CancelResponse::class.java, callback)
    }

    fun start(rechargeCryptoBalance: RechargeCryptoBalance, context: Context) {
        restService.extraPath = "checkin/"

        restService.post(context, rechargeCryptoBalance, RechargeResponse::class.java, callback)
    }

    fun start(recurringPayment: RecurringPayment, context: Context) {
        restService.extraPath = "checkout/recurrent"

        restService.post(context, recurringPayment, RechargeResponse::class.java, callback)
    }

    fun start(searchPayment: SearchPayment, context: Context) {
        restService.extraPath = "checkout/" + searchPayment.vendorKey

        restService.get(context,searchPayment.toParam(), SearchResponse::class.java, callback)
    }
}
