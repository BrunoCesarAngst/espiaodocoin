package com.example.espiaodocoin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ValToConvert.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
//                Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
//                textView.text = ValToConvert.text
//                ValToConvert.text.clear()
                val reais = ValToConvert.text.toString().toDouble()
                CalcTask(reais).execute()
                true
            } else {
                false
            }
        }
    }

    inner class CalcTask(var ValToConvert: Double): AsyncTask<Void, Void, Double?>() {
        override fun doInBackground(vararg params: Void?): Double? {
            return OkHttpRequests.getLastValue()
        }

        override fun onPostExecute(result: Double?) {
            super.onPostExecute(result)
            var value = ValueToConvert / result!!
            Log.e("Calculado", "Com R$ ${ValToConvert} compra ${value}")
        }

    }
}