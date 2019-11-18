package com.example.asus.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable{
    private int photo;
    private String movie;
    private String desc;

    public Movie() {

    }

    protected Movie(Parcel in) {
        photo = in.readInt();
        movie = in.readString();
        desc = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(movie);
        dest.writeString(desc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
