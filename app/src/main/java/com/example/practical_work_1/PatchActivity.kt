package com.example.practical_work_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.widget.Toolbar

class PatchActivity : AppCompatActivity() {

    lateinit var tb:Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patch)

        val video:VideoView=findViewById(R.id.videoView)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(video)
        val onLineurl = Uri.parse("https://rr3---sn-25ge7nzd.googlevideo.com/videoplayback?expire=1671038319&ei=D7GZY42gGo6L6dsP_7GxuAk&ip=185.147.212.18&id=o-ALB2_2a8QS1d8guABM4x1RCFL78MzCMu-BPyym2nZFmM&itag=18&source=youtube&requiressl=yes&mh=pm&mm=31%2C26&mn=sn-25ge7nzd%2Csn-h5qzened&ms=au%2Conr&mv=m&mvi=3&pl=24&initcwndbps=702500&spc=zIddbCVt1AqOUpQt9mWJGT01jjnMcws&vprv=1&mime=video%2Fmp4&ns=H7pnqCuW5loMz_b62l6hRTwK&cnr=14&ratebypass=yes&dur=165.720&lmt=1664315358357458&mt=1671015922&fvip=1&fexp=24001373%2C24007246&c=WEB&txp=5538434&n=Uwrf6OHMHatKEQ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Cmime%2Cns%2Ccnr%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgXryJbfZstp62DU1bSqDeOvqjy7eMLxfzjxcFF_xb1tYCIAD7M7OucMuCqmBG7fvCsgkRcST46b1UaTia8SaUjOus&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgGD7WKFXwscjZbqKPXvkal3NE-lvzPplJGZfSh_JUqbACIDH5N2KxxcpQ99q2S-fUP78mVR1Q7uZ9kyIjbyj8RsTu")
        video.setMediaController(mediaController)
        video.setVideoURI(onLineurl)
        video.requestFocus()
        video.start()

        tb = findViewById(R.id.toolbar)
        setSupportActionBar(this.tb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Кино"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }

        return true
    }

}