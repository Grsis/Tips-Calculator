package com.example.layoutapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutapplication.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private  lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvPercentage.text = percentage.toString()
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeopleTable.text = numPeople.toString()

        binding.btnDone.setOnClickListener {
            finish()
        }

        println("Claudio1" + totalAmount)
    }
}