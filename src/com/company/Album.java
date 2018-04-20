package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

public Album(String name, String artist){
    this.name = name;
    this.artist = artist;
    this.songs = new ArrayList<Song>();

    }

    public boolean addSong(String title, double duration){
    if(findSong(title) == null) {
        //if we get null, song doesn't exist so we can add it
        this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        //checking for not duplicating songs
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public Song findSong(int trackNumber){
    int index = trackNumber -1;
        if ((index >= 0)&&(index < songs.size())){
            return songs.get(index);
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
//every song in album has a track number in order as we adding them. Own index position
    int index = trackNumber -1;
//List are starting from 0 position, humans usually from 1, so to start from 0 - we are going -1 in the List
//Index always starts from 0, so if we enter trackNumber 1, indexValue will be 0 (1-1=0), and If statement will be false
        if ((index >= 0) &&(index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkSong = findSong(title);
        if (checkSong != null){
            playList.add(checkSong);
            return true;
//if we successfully found it and add it to our playList
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
