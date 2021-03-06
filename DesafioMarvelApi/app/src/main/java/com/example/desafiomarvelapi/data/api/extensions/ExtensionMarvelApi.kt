package com.example.desafiomarvelapi.data.api.extensions

import com.example.desafiomarvelapi.data.api.PRIVATE_API_KEY
import com.example.desafiomarvelapi.data.api.PUBLIC_API_KEY
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class ExtensionMarvelApi {
    companion object {
        private val HEXCHARS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
        private fun hexEncode(bytes: ByteArray): String {
            val result = CharArray(bytes.size * 2)
            var b: Int
            var i = 0
            var j = 0
            while (i < bytes.size) {
                b = bytes[i].toInt() and 0xff
                result[j++] = HEXCHARS[b shr 4]
                result[j++] = HEXCHARS[b and 0xf]
                i++
            }
            return String(result)
        }
        fun md5(s: String): String {
            try { // Create MD5 Hash
                val digest = MessageDigest.getInstance("MD5")
                digest.update(s.toByteArray())
                return hexEncode(digest.digest())
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            return ""
        }
    }
}
fun getTimeStamp(): String {
    val ts = Calendar.getInstance().timeInMillis / 1000
    return ts.toString()
}

fun getHash(): String? {
    return ExtensionMarvelApi.md5(getTimeStamp() + PRIVATE_API_KEY + PUBLIC_API_KEY)
}
