package com.example.talktome;


import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.layotu_parent);//to link the id from xml relative layout to object of relative layout so we can use the object for changes


        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();//animation using drawable resources
        animationDrawable.setEnterFadeDuration(3000);//entry duration
        animationDrawable.setExitFadeDuration(1000);//exit
        animationDrawable.start();


    }


    public void  play_btn(View view) {
        final Button sound = (Button) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,getResources().getIdentifier((String) sound.getTag(),"raw",getPackageName()));//capture resources from where,tag that is name of mp3 files,from which file ie raw
        mediaPlayer.start();

        if (mediaPlayer.isPlaying()) {
            sound.setBackgroundColor(Color.RED);//while sound playing change color of button to red
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {//after complete sound played what to do method
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound.setBackgroundColor(Color.GREEN);//set background color of button to green
                sound.setTextColor(Color.WHITE);//text color white
            }
        });

    }
}

