package com.example.practical_work_1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainScreenActivity : AppCompatActivity() {


    lateinit var tl: TabLayout
    lateinit var bn: BottomNavigationView
    lateinit var vp: ViewPager2
    lateinit var body: FrameLayout
    private val fraglist = listOf(Fragment1(), Fragment2(), Fragment3())
    private val fraglist2 = listOf(FragmentScreen1(), FragmentScreen2(), FragmentScreen3(), FragmentScreen4())
    private val tablist = listOf("В тренде", "Новинки", "Для Вас")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        tl = findViewById(R.id.tabLayout)
        vp = findViewById(R.id.fragmentHolder)
        val adapter = viewadapter(this, fraglist)
        vp.adapter = adapter
        TabLayoutMediator(tl, vp) { tab, pos ->
            tab.text = tablist[pos]
        }.attach()

        bn = findViewById(R.id.navi)
        body = findViewById(R.id.body)
        bn.setOnItemSelectedListener{
            when (it.itemId)
            {
                R.id.icHome -> {
                    supportFragmentManager.beginTransaction().replace(R.id.body, fraglist2[0]).commit()
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                }
                R.id.icPod -> {
                    supportFragmentManager.beginTransaction().replace(R.id.body, fraglist2[1]).commit()
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
                }
                R.id.icCol -> {
                    supportFragmentManager.beginTransaction().replace(R.id.body, fraglist2[2]).commit()
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
                }
                R.id.icSet -> {
                    supportFragmentManager.beginTransaction().replace(R.id.body, fraglist2[3]).commit()
                    Toast.makeText(this, "4", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        val video: VideoView =findViewById(R.id.videoView)
        val mediaController= MediaController(this)
        mediaController.setAnchorView(video)
        val onLine = Uri.parse("android.resource://$packageName/${R.raw.klaus2}")
        video.setMediaController(mediaController)
        video.setVideoURI(onLine)
        video.requestFocus()
        video.start()
    }
}