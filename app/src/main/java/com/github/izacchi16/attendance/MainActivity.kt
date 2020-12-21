package com.github.izacchi16.attendance

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.izacchi16.attendance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listener = object : MainController.Listener {
        override fun onClick() {
            Log.d("tag", "clicked")
        }
    }
    private val controller: MainController by lazy {
        MainController(listener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.also {
            it.setController(controller)
        }
        binding.fab.setOnClickListener {
            Log.d("tag", "clicked")
        }
        val sampleData: List<Room> = listOf(
            Room("0120", "プロジェクト演習２"),
            Room("5518", "データベースプログラミング"),
            Room("3926", "Webアニメーション実習"),
            Room("8201", "IT活用技法２"),
            Room("1341", "Linuxサーバ構築実習"),
            Room("3981", "キャリア形成B"),
            Room("7777", "デザインパターン概論")
        )

        controller.setData(sampleData)
    }
}
