package com.example.asus.submission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MovieAdapter movieAdapter;
    private String[] dataMovie;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        movieAdapter =  new MovieAdapter(this);
        listView.setAdapter(movieAdapter);


        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d("TAG", "onItemClick: " + movies.get(i).getPhoto());
//                Movie movie = new Movie();
//                movie.setDesc(movies.get(i).getDesc());
//                movie.setMovie(movies.get(i).getMovie());
//                movie.setPhoto(movies.get(i).getPhoto());
                Intent intent = new Intent(MainActivity.this, DetailMovie.class);
                intent.putExtra(DetailMovie.EXTRA_PERSON, movies.get(i));
                startActivity(intent);
            }
        });
    }
    private  void prepare(){
        dataMovie = getResources().getStringArray(R.array.movie);
        dataDesc = getResources().getStringArray(R.array.desc_movie);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private  void addItem(){
        movies = new ArrayList<>();
        for (int i = 0; i < dataMovie.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setDesc(dataDesc[i]);
            movie.setMovie(dataMovie[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

}
