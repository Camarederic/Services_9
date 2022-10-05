package com.example.services_9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStartService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
            textViewServiceInfo.text = "Service running"
        }

        buttonStopService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
            textViewServiceInfo.text = "Service stopped"
        }

        buttonSendData.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            val dataString = editTextData.text.toString()
            intent.putExtra("EXTRA_DATA", dataString)
            startService(intent)
        }
    }
}