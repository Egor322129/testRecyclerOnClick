package com.example.android.testrecycleronclick;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private OnSongListener mOnSongListener;
    private ArrayList<Song> mSongs = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<Song> songs, OnSongListener onSongListener) {
        mSongs = songs;
        mOnSongListener = onSongListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, mOnSongListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = mSongs.get(position).getName();
        holder.title.setText(name);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        OnSongListener mOnSongListener;

        public ViewHolder(View itemView, OnSongListener onSongListener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            mOnSongListener = onSongListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnSongListener.onSongClick(getAdapterPosition());
        }
    }


    @Override
    public int getItemCount(){
        return mSongs.size();
    }

    public interface OnSongListener{
        void onSongClick(int position);
    }
}
