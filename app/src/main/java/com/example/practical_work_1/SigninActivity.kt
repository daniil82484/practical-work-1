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

class SigninActivity : AppCompatActivity() {

    var preff: SharedPreferences?=null
    lateinit var email:EditText
    lateinit var pass:EditText
    lateinit var check:CheckBox

    val pattern = ("[a-z]{1,100}"+"@"+"[a-z]{1,6}"+"\\."+"[a-z]{1,5}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        check = findViewById(R.id.checkBox)
        preff = getSharedPreferences("TABLEE", MODE_PRIVATE)
        check.isChecked = preff?.getBoolean("key3", false)?:false
        email.setText(preff?.getString("key1", ""))
        pass.setText(preff?.getString("key2", ""))
    }

    fun sevestate(check:Boolean)
    {
        val editor = preff?.edit()
        editor?.putBoolean("key3", check)
        editor?.apply()
    }
    fun saveData(mail:String, pass:String)
    {
        val editor = preff?.edit()
        editor?.putString("key1", mail)
        editor?.putString("key2", pass)
        editor?.apply()
    }
    fun deleteAll()
    {
        val editor = preff?.edit()
        editor?.clear()
        editor?.apply()
    }
    fun seve22(view: View)
    {
        val value:String = email.text.toString()
        val value2:String = pass.text.toString()
        val checkboxstate:Boolean = check.isChecked
        if (checkboxstate == true){
            saveData(value,value2)
            sevestate(checkboxstate)
        }
        else
        {
            deleteAll()
        }

        val inten = Intent(this, PatchActivity::class.java)
        startActivity(intent)
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
                Toast.makeText(this, "Вход", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SigninActivity,PatchActivity::class.java)
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

    fun registration(view: View) {
        val intent = Intent(this@SigninActivity,SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}