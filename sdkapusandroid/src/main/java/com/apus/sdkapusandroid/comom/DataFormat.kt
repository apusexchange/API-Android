package com.apus.sdkapusandroid.comom

import java.lang.StringBuilder
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

fun String.toSha256():String{
    val digest: MessageDigest?
    return try {
        digest = MessageDigest.getInstance("SHA-256")
        val encodedHash = digest!!.digest(
                this.toByteArray())
        bytesToHex(encodedHash)
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
        ""
    }
}

private fun bytesToHex(hash: ByteArray): String {
    val hexString = StringBuffer()
    for (i in hash.indices) {
        val hex = Integer.toHexString(0xff and hash[i].toInt())
        if (hex.length == 1) hexString.append('0')
        hexString.append(hex)
    }
    return hexString.toString()
}

public  fun Map<String,String>.toUrl():String{
    val stringBuilder = StringBuilder()
    if(isNotEmpty()){
        stringBuilder.append("?&")
    }
    this.iterator().forEach {
      stringBuilder.append("${it.key}=${it.value}&")
    }
    return  stringBuilder.toString()
}