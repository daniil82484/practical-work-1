package com.example.practical_work_1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
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

    var preff: SharedPreferences?= null

    val pattern = ("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        name = findViewById(R.id.editTextTextPersonName2)
        surname = findViewById(R.id.editTextTextPersonName4)
        email = findViewById(R.id.editTextTextPersonName5)
        pass = findViewById(R.id.editTextTextPersonName6)
        pass2 = findViewById(R.id.editTextTextPersonName7)

        preff = getSharedPreferences("TABLEE2", MODE_PRIVATE)
/*
        email.setText(preff?.getString("key1", ""))
        pass.setText(preff?.getString("key2", ""))
        name.setText(preff?.getString("key4", ""))
        surname.setText(preff?.getString("key5", ""))
*/
    }

    fun saveData(mail:String, pass:String, name:String, surname:String)
    {
        val editor = preff?.edit()
        editor?.putString("key-login-email", mail)
        editor?.putString("key-login-pass", pass)
        editor?.putString("key4", name)
        editor?.putString("key5", surname)
        editor?.apply()
    }
    fun login1(view: View)
    {
        val value:String = email.text.toString()
        val value2:String = pass.text.toString()
        val value3:String = name.text.toString()
        val value4:String = surname.text.toString()

        saveData(value,value2,value3,value4)


        val intent = Intent(this,PatchActivity::class.java)
        startActivity(intent)
    }

    fun emailValid(text: String):Boolean
    {
        return Pattern.compile(pattern).matcher(text).matches()
    }

    fun login(view: View) {
        val value:String = email.text.toString()
        val value2:String = pass.text.toString()
        val value3:String = name.text.toString()
        val value4:String = surname.text.toString()

        if (email.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && pass2.text.toString().isNotEmpty() && name.text.toString().isNotEmpty() && surname.text.toString().isNotEmpty())
        {
            if (emailValid(email.text.toString()))
            {
                saveData(value,value2,value3,value4)

                Toast.makeText(this, "Регистрация", Toast.LENGTH_LONG).show()
                val intent = Intent(this@SignupActivity,SigninActivity::class.java)
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