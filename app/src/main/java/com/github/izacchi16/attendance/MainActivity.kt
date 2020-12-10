package com.github.izacchi16.attendance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.izacchi16.attendance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        controller = MainController()
        binding.recyclerView.also {
            it.setController(controller)
        }
        val sampleData: List<Room> = listOf()
        Room("0120", "講義1")
        Room("5518", "講義5")
        Room("3926", "講義9")
        Room("8201", "講義2")
        controller.setData(sampleData)
    }
}
