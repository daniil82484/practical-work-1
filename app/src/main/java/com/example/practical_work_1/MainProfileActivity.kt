package com.example.practical_work_1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainProfileActivity : AppCompatActivity() {
    lateinit var tb: Toolbar
    var preff: SharedPreferences?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_profile)

        preff = getSharedPreferences("TABLEE2", MODE_PRIVATE)

        tb = findViewById(R.id.toolbar)
        setSupportActionBar(this.tb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title=preff?.getString("key4", "")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                val intent = Intent(this, SigninActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.icHome->{
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            }
            R.id.icPod->{
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
            }
            R.id.icCol->{
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}