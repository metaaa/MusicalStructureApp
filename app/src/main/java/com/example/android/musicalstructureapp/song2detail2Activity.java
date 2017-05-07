package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class song2detail2Activity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song2detail2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_menu);
        setSupportActionBar(myToolbar);

        //functions for the mediaplayer buttons
        ImageButton prev = (ImageButton) findViewById(R.id.song2prev);
        //on click listener for the prev button of the first song
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previous = new Intent(song2detail2Activity.this, song1detailActivity.class);
                startActivity(previous);
            }
        });

        ImageButton next = (ImageButton) findViewById(R.id.song2next);
        //on click listener for the next button of the first song
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(song2detail2Activity.this, song3detailActivity.class);
                startActivity(next);
            }
        });

        final ImageButton play = (ImageButton) findViewById(R.id.song2dplay);
        boolean song2playing = false;
        play.setTag(song2playing);
        //on click listener for the play button of the first song
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the button haven't pressed, it means it's not started. When it gets pressed..
                if( ((Boolean)play.getTag())== false ){
                    //...the icon will be replaced and a stop icon will be appeared
                    play.setImageResource(R.drawable.stop);
                    play.setTag(true);
                    mp.reset();
                    mp = MediaPlayer.create(song2detail2Activity.this, R.raw.beatles_hard_days_night);
                    mp.start();
                }
                else {
                    play.setImageResource(R.drawable.play);
                    play.setTag(false);
                    mp.stop();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //lanunching the activities from the menu
    private void homeActivity() {
        Intent i = new Intent(song2detail2Activity.this, MainActivity.class);
        startActivity(i);
    }
    private void favouritesActivity() {
        Intent i = new Intent(song2detail2Activity.this, favsActivity.class);
        startActivity(i);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                homeActivity();
                return true;
            case R.id.favourites:
                favouritesActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
