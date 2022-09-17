package com.example.practical_work_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    fun login(view: View) {
        val intent = Intent(this,PatchActivity::class.java)
        startActivity(intent)
    }

    fun registration(view: View) {
        val intent = Intent(this,PatchActivity::class.java)
        startActivity(intent)
    }
}