package com.bibitdev.barvolume

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidht: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        edtWidht = findViewById(R.id.edt_widht)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_lenght)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidht = edtWidht.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false
            /*
            Validasi apakah inputan masih ada yang kosong
             */
            if (inputLength.isEmpty()) {
                isEmptyField = true
                edtLength.error = "Field Panjang Tidak Boleh Kosong"
            }
            if (inputWidht.isEmpty()) {
                isEmptyField = true
                edtLength.error = "Field Lebar Tidak Boleh Koson"
            }
            if (inputHeight.isEmpty()) {
                isEmptyField = true
                edtLength.error = "Field Tinggi Tidak Boleh Koson"
            }

            /*
            Jika semua inputan valid maka tampilkan hasilnya
           */
            if (!isEmptyField) {
                val volume = inputLength.toDouble() * inputWidht.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}
