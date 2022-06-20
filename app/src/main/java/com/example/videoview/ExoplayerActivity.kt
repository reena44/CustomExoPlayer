package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector

import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory


class ExoplayerActivity : AppCompatActivity() {
    // creating a variable for exoplayerview.
    var exoPlayerView: SimpleExoPlayerView? = null

    // creating a variable for exoplayer
    var exoPlayer: SimpleExoPlayer? = null

    // url of video which we are loading.
    var videoURL =
        "https://media.geeksforgeeks.org/wp-content/uploads/20201217163353/Screenrecorder-2020-12-17-16-32-03-350.mp4"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exoplayer)
        exoPlayerView = findViewById(R.id.videoView2)
        try {

            // bandwisthmeter is used for
            // getting default bandwidth
            val bandwidthMeter =  DefaultBandwidthMeter();

            // track selector is used to navigate between
            // video using a default seekbar.
            val trackSelector =  DefaultTrackSelector( AdaptiveTrackSelection.Factory(bandwidthMeter));

            // we are adding our track selector to exoplayer.
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);

            // we are parsing a video url
            // and parsing its video uri.
            val videouri = Uri.parse(videoURL);

            // we are creating a variable for datasource factory
            // and setting its user agent as 'exoplayer_view'
            val dataSourceFactory =  DefaultHttpDataSourceFactory("exoplayer_video")
            // we are creating a variable for extractor factory
            // and setting it to default extractor factory.
            val extractorsFactory =  DefaultExtractorsFactory();

            // we are creating a media source with above variables
            // and passing our event handler as null,
            val mediaSource =  ExtractorMediaSource(videouri, dataSourceFactory, extractorsFactory, null, null);

            // inside our exoplayer view
            // we are setting our player
            exoPlayerView!!.player = exoPlayer;

            // we are preparing our exoplayer
            // with media source.
            exoPlayer!!.prepare(mediaSource);

            // we are setting our exoplayer
            // when it is ready.
            exoPlayer!!.playWhenReady = true;

        } catch ( e:Exception) {
            // below line is used for
            // handling our errors.
            Log.e("TAG", "Error : $e");
        }
    }
}