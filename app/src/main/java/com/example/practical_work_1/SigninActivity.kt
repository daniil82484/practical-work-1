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

    var preff: SharedPreferences?= null
    var preff2: SharedPreferences?= null
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
        preff2 = getSharedPreferences("TABLEE2", MODE_PRIVATE)
        check.isChecked = preff2?.getBoolean("key3", false)?:false
        email.setText(preff2?.getString("key-login-email", ""))
        pass.setText(preff2?.getString("key-login-pass", ""))

    }

    fun sevestate(check:Boolean)
    {
        val editor = preff2?.edit()
        editor?.putBoolean("key3", check)
        editor?.apply()
    }
    fun saveData(mail:String, pass:String)
    {
        val editor = preff2?.edit()
        editor?.putString("key-login-email", mail)
        editor?.putString("key-login-pass", pass)
        editor?.apply()
    }
    fun deleteAll()
    {
        val editor = preff2?.edit()
        editor?.clear()
        editor?.apply()
    }
    fun login1(view: View)
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

        val intent = Intent(this,PatchActivity::class.java)
        startActivity(intent)
    }

    fun login(view: View) {
        val value:String = email.text.toString()
        val value2:String = pass.text.toString()
        val checkboxstate:Boolean = check.isChecked

        if (value != "" && value2 != "")
        {
            if(value == preff?.getString("key1", "")  && value2 == preff?.getString("key2", "")){
                if (checkboxstate == true){
                    saveData(value,value2)
                    sevestate(checkboxstate)
                }
                else
                {
                    deleteAll()
                }

                Toast.makeText(this, "Вход", Toast.LENGTH_SHORT).show()

                val intent = Intent(this,MainProfileActivity::class.java)
                startActivity(intent)

                /*
                    val intent = Intent(this@SigninActivity,PatchActivity::class.java)
                    startActivity(intent)
                    finish()
                */

            }
            else{
                Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show()
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