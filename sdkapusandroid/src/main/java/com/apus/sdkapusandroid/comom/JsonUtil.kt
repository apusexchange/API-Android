package com.apus.sdkapusandroid.comom

import com.android.volley.Response
import com.android.volley.VolleyError
import com.apus.sdkapusandroid.domain.response.ApusResponse
import com.google.gson.Gson
import org.json.JSONObject
import java.net.HttpURLConnection
import kotlin.reflect.KClass

fun Any.toJson(): String? {
    return Gson().toJson(this)
}

fun VolleyError.toResponse():ApusResponse{
    val apusResponse = ApusResponse()
    apusResponse.status = ApusResponse.Status()
    apusResponse.status.code = this.networkResponse.statusCode
    apusResponse.status.message = "Connection error"
    return  apusResponse
}

fun HttpURLConnection.toResponse():ApusResponse{
    val apusResponse = ApusResponse()
    apusResponse.status = ApusResponse.Status()
    apusResponse.status.code = this.responseCode
    apusResponse.status.message = "Connection error"
    return  apusResponse
}


fun <T : Any> JSONObject.toResponse(type: Class<T>): ApusResponse {
    return Gson().fromJson<T>(toString(0), type) as ApusResponse
}

fun <T : Any> String.toResponse(type: Class<T>): ApusResponse {
    return Gson().fromJson<T>(toString(), type) as ApusResponse
}

