package com.apus.sdkapusandroid.rest

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.apus.sdkapusandroid.comom.toJson
import com.apus.sdkapusandroid.comom.toResponse
import com.apus.sdkapusandroid.domain.response.ApusResponse
import org.json.JSONObject
import java.net.URL
import android.widget.Toast
import com.android.volley.NetworkResponse
import com.android.volley.VolleyError
import com.apus.sdkapusandroid.comom.toUrl
import com.apus.sdkapusandroid.domain.response.PaymentResponse
import com.android.volley.AuthFailureError
import java.nio.charset.Charset
import com.android.volley.VolleyLog
import com.android.volley.ParseError
import com.android.volley.toolbox.*
import com.google.gson.JsonSyntaxException
import com.google.gson.Gson
import java.net.HttpURLConnection
import com.android.volley.toolbox.HttpStack
import java.io.*


class RestService(val url: String) {
    public var extraPath: String = ""


    fun <REQ, RES : ApusResponse> post(context: Context, request: REQ, responseType: Class<RES>, callback: (ApusResponse) -> Unit) {
        val requestQueue = Volley.newRequestQueue(context)
        val jsonRequest = object : JsonObjectRequest(Request.Method.POST, url + extraPath, JSONObject(request!!.toJson()),
                Response.Listener { response ->

                    callback.invoke(response.toResponse(responseType))
                },
                Response.ErrorListener { error ->
                    callback.invoke(error.toResponse())

                }
        ) {
        }
        requestQueue.add(jsonRequest)
    }

    fun <RES : ApusResponse> get(context: Context, params: Map<String, String>, responseType: Class<RES>, callback: (ApusResponse) -> Unit) {

        val requestQueue = Volley.newRequestQueue(context)

        val strRequest = object : StringRequest(Request.Method.GET, url + extraPath + params.toUrl(),
                Response.Listener { response -> callback.invoke(response.toResponse(responseType)) },
                Response.ErrorListener { error ->
                    callback.invoke(error.toResponse())

                }) {
            override fun getParams(): Map<String, String> = params
        }

        requestQueue.add(strRequest)

    }

    fun <REQ, RES : ApusResponse> delete(context: Context, request: REQ, responseType: Class<RES>, callback: (ApusResponse) -> Unit) {


        val toJson = Gson().toJson(request)
        Thread {
            val url = URL(url + extraPath)
            val httpCon = url.openConnection() as HttpURLConnection
            httpCon.doOutput = true
            httpCon.setRequestProperty(
                    "Content-Type", "application/json")
            httpCon.setRequestProperty(
                    "Content-Length", toJson!!.toByteArray(Charsets.UTF_8).size.toString())
            httpCon.requestMethod = "DELETE"
            val out = OutputStreamWriter(
                    httpCon.outputStream)
            out.write(toJson)
            out.close()
            if (httpCon.responseCode == 200) {
                callback.invoke(Gson().fromJson(httpCon.inputStream.bufferedReader().readText(), responseType))
            } else {
                callback.invoke(httpCon.toResponse())
            }
            println()
        }.start()


    }

}




