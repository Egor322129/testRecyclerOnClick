package com.example.android.testrecycleronclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    private Song song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_layout);



        getIncomingIntent();
        fillActivity();
    }

    private void getIncomingIntent() {
            int imageUrl = getIntent().getIntExtra("imageResourceId", 0);
            int songUrl = getIntent().getIntExtra("songResourceId", 0);
            String name = getIntent().getStringExtra("name");
            song = new Song(name, songUrl, imageUrl);
            Log.d("TAG", song.getName());

    }

    private void fillActivity() {

        ImageView imageView = (ImageView)findViewById(R.id.imgPlayer);
        TextView title = (TextView)findViewById(R.id.title);

        imageView.setImageResource(song.getImageResourceId());
        title.setText(song.getName());




    }
}
