package com.example.asus.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemview = view;
        if(itemview == null){
            itemview = LayoutInflater.from(context).inflate(R.layout.activity_list, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemview);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemview;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.movie);
            txtDescription = view.findViewById(R.id.desc);
            imgPhoto = view.findViewById(R.id.photo);
        }
        void bind(Movie movie) {
            txtName.setText(movie.getMovie());
            txtDescription.setText(movie.getDesc());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
