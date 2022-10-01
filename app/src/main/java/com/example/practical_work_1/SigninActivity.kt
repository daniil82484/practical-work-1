package com.example.practical_work_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SigninActivity : AppCompatActivity() {

    lateinit var email:EditText
    lateinit var pass:EditText

    val pattern = ("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
    }
    fun emailValid(text: String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun login(view: View) {
        if (email.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty())
        {
            if (emailValid(email.text.toString()))
            {
                val intent = Intent(this@SigninActivity,PatchActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовое поля")
                .setPositiveButton("OK",  null)
                .create()
                .show()
        }

    }

    fun registration(view: View) {
        val intent = Intent(this@SigninActivity,SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}