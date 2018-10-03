package com.apus.sdkapus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apus.sdkapusandroid.controller.ApusPaymentAPI
import com.apus.sdkapusandroid.domain.request.*
import com.apus.sdkapusandroid.domain.response.BlockChain
import com.apus.sdkapusandroid.domain.response.Currency
import com.apus.sdkapusandroid.domain.response.Period
import com.apus.sdkapusandroid.domain.response.SearchResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apusPaymentAPI = ApusPaymentAPI(true)
        apusPaymentAPI.callback = { response ->

        }


        //makePayment(apusPaymentAPI)
        //rechargeCryptoBalance(apusPaymentAPI)
        //recurringPayment(apusPaymentAPI)
        //searchPayment(apusPaymentAPI)
        //cancelPayment(apusPaymentAPI)
    }

    private fun cancelPayment(apusPaymentAPI: ApusPaymentAPI) {
        apusPaymentAPI.start(CancelPayment.Builder()
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
                .build(),
                this)
    }

    private fun searchPayment(apusPaymentAPI: ApusPaymentAPI) {
        apusPaymentAPI.start(SearchPayment.Builder()
                .withBlockchain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withTxId("2bf779e2a311c2629df977b0bb105879411fd71f5839972c4ed1d3278f80170f")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
    }

    private fun rechargeCryptoBalance(apusPaymentAPI: ApusPaymentAPI) {
        apusPaymentAPI.start(RechargeCryptoBalance.Builder()
                .withAmount(10)
                .withBlockChain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
    }

    private fun recurringPayment(apusPaymentAPI: ApusPaymentAPI) {
        apusPaymentAPI.start(RecurringPayment.Builder()
                .withAmount(10)
                .withBlockChain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withPeriod(Period.M)
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                .withPassWordEncrypted("03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
    }

    private fun makePayment(apusPaymentAPI: ApusPaymentAPI) {
        apusPaymentAPI.start(MakePayment.Builder()
                .withAmount(10)
                .withBlockChain(BlockChain.Type.LTC)
                .withCurrency(Currency.Type.BRL)
                .withPanEncrypted("0866a6eaea5cb085e4cf6ef19296bf19647552dd5f96f1e530db3ae61837efe7")
                .withPassWordEncrypted("c66f1f34f49381e467d3abd43c77947f5d1dd362fd0eec6c2c1f27233ae9adf9")
                .withVendorKey("5f5bdaed-f82b-4b82-b3f5-1d562633da5b")
                .build(),
                this)
    }
}
