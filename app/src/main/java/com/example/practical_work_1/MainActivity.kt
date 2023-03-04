package com.example.practical_work_1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    var preff: SharedPreferences?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)

        if (preff?.getBoolean("key3", true) == true){
            val intent = Intent(this,MainProfileActivity::class.java)
            startActivity(intent)
            finish()

        }
        else{
            val intent = Intent(this,SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
        // val timer = object : CountDownTimer(4000,1000){
        //     override fun  onTick(millisUntilFinished: Long){
        //
        //     }
        //
        //     override fun onFinish(){
        //         val intent = Intent(this@MainActivity,SigninActivity::class.java)
        //         startActivity(intent)
        //         finish()
        //     }
        // }
        // timer.start()

    }
}