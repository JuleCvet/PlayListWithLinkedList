package com.company;

public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
      //output the contents of an actual object
        return "Song{" +
                "title='" + this.title + ':' +
                ", duration=" + this.duration +
                '}';
    }
}