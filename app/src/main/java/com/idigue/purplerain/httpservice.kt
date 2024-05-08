package com.idigue.purplerain

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Response
import okio.IOException
class httpservice {


    val url = "http://idigue.com/api/apipurplerainusernew.php"
    fun okpostuser(
        user: user
    ) {
        val client = OkHttpClient()
        val request = okhelper(client)
        request.POST(url, user, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("request failed -> ${e.stackTraceToString()}")
            }

            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body.string()
                println("insert user called -> $responseData")
//                Handler(Looper.getMainLooper()).post {
//                    if (responseData.isNotEmpty()) {
//                        updateresponse(responseData)
//                    }
//                }
            }
        })
    }


    class okhelper(private val client: OkHttpClient) {

        fun POST(url: String, user: user, callback: Callback): Call {
            val body = FormBody.Builder()
                .add("id", user.id.toString())
                .add("name", user.name).build()
            val request = okhttp3.Request.Builder()
                .addHeader("User-Agent", "OkHttp Bot")
                .url(url).post(body)
                .build()
            val call = client.newCall(request)
            call.enqueue(callback)
            return call
        }

    }
}