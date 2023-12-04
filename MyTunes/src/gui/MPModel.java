package gui;


import be.Song;
import bll.SongManager;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class MPModel {
    private final static MPModel instance = new MPModel(); //ensures that by using Singelton all controllers use the same model
    private SongManager playerLogic;
    private MPController observerController;



    public MPModel() {
        this.playerLogic = new SongManager();
    }

    public static MPModel getInstance(){
        return instance;
    }

    public void createSong(String title, String artist, String category, Double time, String path){
        playerLogic.createSong(title, artist, category, time, path);
        //observerController.initialize(playerLogic.returnSongList());


    }
    public void deleteSong(ObservableList<Song> songsToDelete) throws SQLException {
        playerLogic.deleteSelectedSongs(songsToDelete);
    }


    public ObservableList<Song> returnSongList() throws SQLException {
        return playerLogic.returnSongList();

    }

    public void updateSong(Song songToEdit, String title, String artist, String category, Double time, String path) throws SQLException {
        playerLogic.updateSong(songToEdit, title, artist, category, time, path);
    }


}
