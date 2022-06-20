package com.example.videoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri

import android.widget.VideoView
import android.os.Environment
import android.widget.MediaController


class MainActivity : AppCompatActivity() {
    var videoUrl =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView1)

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //specify the location of media file
        val uri: Uri = Uri.parse(videoUrl)

        //Setting MediaController and URI, then starting the videoView
        //videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}