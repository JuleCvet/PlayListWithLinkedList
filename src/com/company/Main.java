package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("JL-new", "JL");
        album.addSong("Stormbringer", 4.06);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 4.06);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("I am not your mama", 3.06);
        album.addSong("You can not do it right", 3.16);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);

        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("I put the finger on you", 3.13);
        album.addSong("For those about to rock", 5.44);
        album.addSong("Let's go", 3.44);
        album.addSong("Inject the venom", 4.36);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 5.9);
        album.addSong("C.O.D.", 4.44);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.14);

        albums.add(album);
//add some songs to the playlist
        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can not do it right", playList);  //the first album we added
        albums.get(0).addToPlayList("Lady double dealer", playList);
        albums.get(0).addToPlayList("The gypsy", playList);
        albums.get(0).addToPlayList("Soldier of fortune", playList);
        albums.get(0).addToPlayList("Soldier of the past", playList);//Does not exist

        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(6, playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(24, playList);//There is no track for 24

        play(playList);

    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;//in which direction we are going in
        ListIterator<Song> listIterator = playList.listIterator();
            if (playList.size() == 0 ){
                System.out.println("No songs in playlist");
                return;
            }else {
                System.out.println("Now playing " + listIterator.next().toString());
                printMenu();
            }

            while(!quit){
                int action = scanner.nextInt();
                scanner.nextLine();

                switch(action){
                    case 0:
                        System.out.println("Play list complete.");
                        quit = true;
                        break;
                    case 1:
                        if (!forward){//just if there is next - go forward
                            if (listIterator.hasNext()){
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }else{
                            System.out.println("We have reached the end of the playlist");
                            forward = false;
                        }
                        break;
                    case 2:
                        if (forward){//just if there is previous - go backwards
                            if (listIterator.hasPrevious()){
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }else {
                            System.out.println("We are at the start of the playlist");
                            forward = true;
                        }
                        break;
                    case 3:
                        if (forward){
                            if(listIterator.hasPrevious()){
                                System.out.println("Now replaying " + listIterator.previous().toString());
                                forward = false;//for going backwards
                            }else{
                                System.out.println("We are at the start of the list");
                            }
                        }else{
                            if (listIterator.hasNext()){
                                System.out.println("Now replaying " + listIterator.next().toString());
                                forward = true; //we have to go forward in order to replay the song again
                            }else{
                                System.out.println("We have reached the end of the list");
                            }
                        }
                        break;
                    case 4:
                        printList(playList);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playList.size() >0 ){
                            listIterator.remove();//removing the current one
                            if (listIterator.hasNext()){
                                System.out.println("Now playing " + listIterator.next().toString());
                            }else if (listIterator.hasPrevious()){
                                System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }//making sure that one if - is true so we will catch the exception and next song automatically starts to play
                        break;
                }
            }
        }

    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
        "1 - to play next song\n" +
        "2 - to play previous song\n" +
        "3 - to replay the currant song\n" +
        "4 - List songs in the playlist\n" +
        "5 - print available actions.\n" +
        "6 - Delete current song from playlist" );
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("===========================================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("===========================================================");
    }
}
