package com.example.espiaodocoin

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.util.concurrent.TimeUnit
import com.example.espiaodocoin.ParserJson


object OkHttpRequests {

    fun hasConnection(ctx: Context): Boolean{

        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.activeNetworkInfo
        return info != null && info.isConnected
    }

    fun getLastValue(): Double? {

        val url = "https://www.mercadobitcoin.net/api/BTC/ticker/"

        val client = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url(url)
            .build()

        val response = client.newCall(request).execute()

        val jsonString = response.body?.string()

        val json = JSONObject(jsonString)

        return ParserJson.readLast(json)
    }
}