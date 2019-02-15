package com.example.android.testrecycleronclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnSongListener  {

    private RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    private ArrayList<Song> mSongs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview1);

        initSongs();
        initRecyclerView();
    }

    public void onSongClick(int position) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", mSongs.get(position).getName());
        intent.putExtra("imageResourceId",mSongs.get(position).getImageResourceId());
        intent.putExtra("audioResourceId", mSongs.get(position).getAudioResourceId());
        startActivity(intent);
    }

    private void initSongs() {
        mSongs.add( new Song("50cent", R.raw.bezslov, R.drawable.asp));
        mSongs.add( new Song("Eminem", R.raw.zvezda, R.drawable.php));
        mSongs.add( new Song("DrDre", R.raw.kamch, R.drawable.wp));
    }

    private void initRecyclerView() {

        adapter = new RecyclerViewAdapter(mSongs, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
