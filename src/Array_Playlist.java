
public class Array_Playlist {

  private String playlistName = "";
  private MyList_Array playlist = new MyList_Array();
  private Song placeholder = new Song("", "", 0f);
  
  
  public Array_Playlist(String Name) { //defines the name of the playList
    playlistName = Name;
  } 
  
  String playlistName() { //returns the name of the playlist
    return playlistName;
  }
  
  boolean addSong(Song s) { //Adds a song to the playlist
    playlist.add(s);
    return true;
  }
  
  boolean addSong(Song s, int index) { //Adds a song to a specific spot in the playlist
    playlist.add(index, s);
    return true;
  }
  
  Song getSongAt(int index) { //returns a song at a specific index
    Song s = new Song("", "", 0f);
    playlist.get(index);
    return s;
  }
  
  MyList_Array getList() { //returns the playlist
    return playlist;
  }
  
  boolean removeSong(Song s) { //removes a song from the playlist
    playlist.remove(s);
    return true;
  }
  
  int totalSongs() { //returns total number of song in the playlist
    return playlist.size();
  }
  
  float playlistTime(Song s) {  //returns duration of the entire playlist
    float totalTime = 0f;
     
     for(int i = 0; i < totalSongs(); i++) { //gets playtime of each song and adds them together
       playlist.get(i);
       totalTime = totalTime + s.getPlayTime();
     }
     return totalTime;
  }
  
  boolean isSongInPlaylist(String name, String artist) { //returns true if there is a song in the playlist
    for(int i = 0; i < playlist.size(); i++) {           //that contains the specified Artist and Song Name
      if(playlist.contains(artist) && playlist.contains(name)) {
        return true;
      }
    }
    return false;
  }
  
  void songsByArtist(String artist) { //prints songs that contain a specified artist
    Song placeholder = new Song("", "", 0f);
    
    for (int i = 0; i < totalSongs(); i++) {
      if(placeholder.getArtist().toLowerCase().equals(artist.toLowerCase())) {
        System.out.println(placeholder.getSongName());
        placeholder = (Song) playlist.get(i + 1);
     }else {
        System.out.println("No songs by that artist. Please check spelling."); //prints if no aritist exists
      }
    }
  }
  
  boolean addSongsFrom(Array_Playlist p) { //adds songs to playlist from another playlist
    for(int i = 0; i < p.totalSongs(); i++) {
      playlist.add(p.getSongAt(i + 1));
    }
    return true;
  }
  
  boolean moveSong(Song s, int position){ //moves a song from a specific index, removes that index, and places it in another index
    int OriginalIndex = 0;
    OriginalIndex = playlist.indexOf(s);
    
    if(position < 1 || position > totalSongs()) {
      System.out.println("Invalid index.");
      return false;
   }else {
      playlist.add(position, s);
      playlist.remove(OriginalIndex);
      playlist.set(position, s);
      OriginalIndex = 0;
      return true;
    }
  }
  
  void moveAllSongs(int positions){ //moves all songs by a specified amount
    playlist.shift(positions);
  }
  
  
}