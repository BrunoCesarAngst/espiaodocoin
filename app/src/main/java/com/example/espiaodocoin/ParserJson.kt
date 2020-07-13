package com.example.espiaodocoin

import android.util.Log
import org.json.JSONException
import org.json.JSONObject

object ParserJson {
    fun readLast(jsonObject: JSONObject): Double? {
        var last: Double? = null
        var ticker: JSONObject? = null
        try {
            ticker = jsonObject.getJSONObject("ticker")
            last = ticker.getDouble("last")

            Log.e("Preco da moeda: ", "$last")

        } catch (e: JSONException) {

            Log.e("Erro:", "$e")

        }

        return last
    }
}