package com.example.practical_work_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var pass2: EditText

    val pattern = ("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        name = findViewById(R.id.editTextTextPersonName2)
        surname = findViewById(R.id.editTextTextPersonName4)
        email = findViewById(R.id.editTextTextPersonName5)
        pass = findViewById(R.id.editTextTextPersonName6)
        pass2 = findViewById(R.id.editTextTextPersonName7)
    }

    fun emailValid(text: String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun login(view: View) {
        if (email.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && pass2.text.toString().isNotEmpty() && name.text.toString().isNotEmpty() && surname.text.toString().isNotEmpty())
        {
            if (emailValid(email.text.toString()))
            {
                Toast.makeText(this, "Регистрация", Toast.LENGTH_LONG).show()
                val intent = Intent(this@SignupActivity,PatchActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this, "Поле E-mail некорректно заполнено", Toast.LENGTH_SHORT).show()
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

    fun back(view: View) {
        val intent = Intent(this@SignupActivity,SigninActivity::class.java)
        startActivity(intent)
        finish()
    }
}