package com.example.practical_work_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignupActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var pass2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        name = findViewById(R.id.editTextTextPersonName2)
        surname = findViewById(R.id.editTextTextPersonName4)
        email = findViewById(R.id.editTextTextPersonName5)
        pass = findViewById(R.id.editTextTextPersonName6)
        pass2 = findViewById(R.id.editTextTextPersonName7)
    }

    fun login(view: View) {
        if (email.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && pass2.text.toString().isNotEmpty() && name.text.toString().isNotEmpty() && surname.text.toString().isNotEmpty())
        {
            val intent = Intent(this@SignupActivity,PatchActivity::class.java)
            startActivity(intent)
            finish()
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