package com.example.android.musicalstructureapp;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //global variables for the count of hits, so it can be reached form other activities
    public int song1hit = 0;
    public int song2hit = 0;
    public int song3hit = 0;
    public int song4hit = 0;

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_menu);
        setSupportActionBar(myToolbar);

//launching song detail activities
        RelativeLayout song1detail = (RelativeLayout) findViewById(R.id.song1);

        song1detail.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, song1detailActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout song2detail = (RelativeLayout) findViewById(R.id.song2);

        song2detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, song2detail2Activity.class);
                startActivity(i);
            }
        });

        RelativeLayout song3detail = (RelativeLayout) findViewById(R.id.song3);

        song3detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, song3detailActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout song4detail = (RelativeLayout) findViewById(R.id.song4);

        song4detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, song4detailActivity.class);
                startActivity(i);
            }
        });

//functions for the favourite buttons
        final ImageButton song1fav = (ImageButton) findViewById(R.id.song1fav);
        //new variable which is false by default
        boolean song1faved = false;
        song1fav.setTag(song1faved);
        //on click listener for the button
        song1fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //if the button is clicked the song will be appeared on the favourites list
                if (((Boolean)song1fav.getTag()) == false){
                    //changes the icon to favourited
                    song1fav.setImageResource(R.drawable.favorited);
                    song1fav.setTag(true);
                }
                else {
                    song1fav.setImageResource(R.drawable.favorite);
                    song1fav.setTag(false);
                }
            }
        });

        final ImageButton song2fav = (ImageButton) findViewById(R.id.song2fav);
        //new variable which is false by default
        boolean song2faved = false;
        song2fav.setTag(song2faved);
        //on click listener for the button
        song2fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //if the button is clicked the song will be appeared on the favourites list
                if (((Boolean)song2fav.getTag()) == false){
                    //changes the icon to favourited
                    song2fav.setImageResource(R.drawable.favorited);
                    song2fav.setTag(true);
                }
                else {
                    song2fav.setImageResource(R.drawable.favorite);
                    song2fav.setTag(false);
                }
            }
        });

        final ImageButton song3fav = (ImageButton) findViewById(R.id.song3fav);
        //new variable which is false by default
        boolean song3faved = false;
        song3fav.setTag(song3faved);
        //on click listener for the button
        song3fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //if the button is clicked the song will be appeared on the favourites list
                if (((Boolean)song3fav.getTag()) == false){
                    //changes the icon to favourited
                    song3fav.setImageResource(R.drawable.favorited);
                    song3fav.setTag(true);
                }
                else {
                    song3fav.setImageResource(R.drawable.favorite);
                    song3fav.setTag(false);
                }
            }
        });

        final ImageButton song4fav = (ImageButton) findViewById(R.id.song4fav);
        //new variable which is false by default
        boolean song4faved = false;
        song4fav.setTag(song4faved);
        //on click listener for the button
        song4fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //if the button is clicked the song will be appeared on the favourites list
                if (((Boolean)song4fav.getTag()) == false){
                    //changes the icon to favourited
                    song4fav.setImageResource(R.drawable.favorited);
                    song4fav.setTag(true);
                }
                else {
                    song4fav.setImageResource(R.drawable.favorite);
                    song4fav.setTag(false);
                }
            }
        });

//functions for the play buttons
        //variables for the hit counts



        //Find the view that shows the play button of the first song
        final ImageButton song1play = (ImageButton) findViewById(R.id.song1play);
        //make a new variable which is false by default
        boolean song1playing = false;
        song1play.setTag(song1playing);
        //on click listener for the play button of the first song
        song1play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the button haven't pressed, it means it's not started. When it gets pressed..
                if( ((Boolean)song1play.getTag())== false ){
                    //...the icon will be replaced and a stop icon will be appeared
                    song1play.setImageResource(R.drawable.stop);
                    song1play.setTag(true);
                    mp.reset();
                    mp = MediaPlayer.create(MainActivity.this, R.raw.beatles_yellow_submarine);
                    mp.start();
                    song1hit += 1;
                    incSong1Hit(song1hit);
                }
                else {
                    song1play.setImageResource(R.drawable.play);
                    song1play.setTag(false);
                    mp.stop();
                }
            }
        });

//Find the view that shows the play button of the second song
        final ImageButton song2play = (ImageButton) findViewById(R.id.song2play);
        //make a new variable which is false by default
        boolean song2playing = false;
        song2play.setTag(song2playing);
        //on click listener for the play button of the second song
        song2play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the button haven't pressed, it means it's not started. When it gets pressed..
                if( ((Boolean)song2play.getTag())== false ){
                    //...the icon will be replaced and a stop icon will be appeared
                    song2play.setImageResource(R.drawable.stop);
                    song2play.setTag(true);
                    mp.reset();
                    mp = MediaPlayer.create(MainActivity.this,R.raw.beatles_hard_days_night);
                    mp.start();
                    song2hit += 1;
                    incSong2Hit(song2hit);
                }
                else {
                    song2play.setImageResource(R.drawable.play);
                    song2play.setTag(false);
                    mp.stop();
                }
            }
        });

//Find the view that shows the play button of the third song
        final ImageButton song3play = (ImageButton) findViewById(R.id.song3play);
        //make a new variable which is false by default
        boolean song3playing = false;
        song3play.setTag(song3playing);
        //on click listener for the play button of the third song
        song3play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the button haven't pressed, it means it's not started. When it gets pressed..
                if( ((Boolean)song3play.getTag())== false ){
                    //...the icon will be replaced and a stop icon will be appeared
                    song3play.setImageResource(R.drawable.stop);
                    song3play.setTag(true);
                    mp.reset();
                    mp = MediaPlayer.create(MainActivity.this,R.raw.beatles_twist_and_shout);
                    mp.start();
                    song3hit += 1;
                    incSong3Hit(song3hit);
                }
                else {
                    song3play.setImageResource(R.drawable.play);
                    song3play.setTag(false);
                    mp.stop();
                }
            }
        });

//Find the view that shows the play button of the fourth song
        final ImageButton song4play = (ImageButton) findViewById(R.id.song4play);
        final MediaPlayer song4mp = MediaPlayer.create(this, R.raw.beatles_let_it_be);
        //make a new variable which is false by default
        boolean song4playing = false;
        song4play.setTag(song4playing);
        //on click listener for the play button of the fourth song
        song4play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the button haven't pressed, it means it's not started. When it gets pressed..
                if( ((Boolean)song4play.getTag())== false ){
                    //...the icon will be replaced and a stop icon will be appeared
                    song4play.setImageResource(R.drawable.stop);
                    song4play.setTag(true);
                    mp.reset();
                    mp = MediaPlayer.create(MainActivity.this,R.raw.beatles_let_it_be);
                    mp.start();
                    song4hit += 1;
                    incSong4Hit(song4hit);
                }
                else {
                    song4play.setImageResource(R.drawable.play);
                    song4play.setTag(false);
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
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        startActivity(i);
    }
    private void favouritesActivity() {
        Intent i = new Intent(MainActivity.this, favsActivity.class);
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

//functions that update the Hits: texts
    public void incSong1Hit(int number){
        TextView getView = (TextView) findViewById(R.id.song1hits);
        getView.setText("Hits: " + String.valueOf(song1hit));
    }

    public void incSong2Hit(int number){
        TextView getView = (TextView) findViewById(R.id.song2hits);
        getView.setText("Hits: " + String.valueOf(song2hit));
    }

    public void incSong3Hit(int number){
        TextView getView = (TextView) findViewById(R.id.song3hits);
        getView.setText("Hits: " + String.valueOf(song3hit));
    }

    public void incSong4Hit(int number){
        TextView getView = (TextView) findViewById(R.id.song4hits);
        getView.setText("Hits: " + String.valueOf(song4hit));
    }

    boolean dialog_showed = false;
//here we make a pop up dialog with informations for the user on app start
    @Override
    protected void onStart()
    {
        super.onStart();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        //title of the pop up
        dialog.setTitle("Welcome User!");

        Button button = (Button) dialog.findViewById(R.id.ButtonOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                dialog_showed = true;
            }
        });
        //and we display the pop up
        if (dialog_showed == false){
            dialog.show();
        }
        else{}

    }
}
