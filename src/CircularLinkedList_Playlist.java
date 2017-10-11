
public class CircularLinkedList_Playlist {

  private String name = "";
  private MyList_CircularLinkedList playlist = new MyList_CircularLinkedList();

  //create a new playlist
  public CircularLinkedList_Playlist(String name) {
    
    this.setName(name);
    
  }
  
  //set the name of current playlist
  public void setName(String name) {
    
    this.name = name;
    
  }
  
  //return name of current playlist
  public String playlistName() {
    
    return this.name;
    
  }
  
  //add song to end of current playlist 
  public boolean addSong(Song s) {
    
    playlist.add(s);
    return true;
    
  }
  
  //add song to current playlist at specified index
  public boolean addSong(Song s, int index) {
    
    playlist.add(index, s);
    return true;
    
  }
  
  //get song at specified index of current playlist
  public Song getSongAt(int index) { //why is a song a parameter here in the instructions?
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
      Song song = new Song("", "", 0);
      song = (Song) playlist.get(index);
      return song;
      
    }
    
  }
  
  //return the current list object that current playlist is using
  public MyList_CircularLinkedList getList() {
    
    return playlist;
    
  }
  
  //remove specified song from playlist
  public boolean removeSong(Song s) {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return false;
      
    } else {
      
      playlist.remove(s);
      return true;
      
    }
    
    
  }
  
  //return size of playlist
  public int totalSongs() {
    
    return playlist.getSize();
    
  }
  
  //return playtime of all songs in playlist
  public float playlistTime() {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return 0f;
      
    } else {
      
      Song currentSong = new Song("", "", 0);
      float totalTime = 0f;
      
      for (int i = 0; i < this.totalSongs(); i++) {
        
        currentSong = (Song) playlist.get(i + 1);
        totalTime = (totalTime + currentSong.getPlayTime());
        
      }
      
      return totalTime;
      
    }
    
  }
  
  //return if song with specified name and artist is in playlist
  public boolean isSongInPlaylist(String name, String artist) {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return false;
      
    } else {
      
      Song song = new Song(name, artist, 0);
      return playlist.contains(song);
      
    }
    
  }
  
  //return data of all songs by specified artist in playlist
  public void songsByArtist(String name) {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      
    } else {
      
      Song currentSong = new Song("", "", 0);
      int check = 0;
      
      for (int i = 0; i < this.totalSongs(); i++) {
        
        currentSong = (Song) playlist.get(i + 1);
        if (currentSong.getArtist().toLowerCase().equals(name.toLowerCase())) {
          
          System.out.println(currentSong.getSongName());
          check = 1;
          
        }
        
      }
      
      if (check == 0) {
        
        System.out.println("No songs by the specified artist in current playlist.");
        
      }
      
    }
    
  }
  
  //add songs from new playlist to end of current playlist
  public boolean addSongsFrom(CircularLinkedList_Playlist p) {

    for (int i = 0; i < p.totalSongs(); i++) {
      
      playlist.add(p.getSongAt(i + 1));
      
    }
    
    return true;
    
  }
  
  //move song in current playlist to specified position
  public boolean moveSong(Song s, int position) {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return false;
      
    } else {
      
      if (position < 1 || position > this.totalSongs()) {
        
        System.out.println("Error: Invalid index value specified in moveSong method of LinkedList_Playlist.");
        return false;
        
      } else if (playlist.contains(s) == false) {
        
        System.out.println("Error: The song specified to move was not present in the current playlist.");
        return false;
        
      } else {
        
        playlist.remove(playlist.indexOf(s));
        playlist.add(position, s);
        return true;
        
      }
      
    }
    
  }
  
  //shift all songs in playlist by specified number of positions
  public boolean moveAllSongs(int positions) {
    
    if (playlist.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return false;
      
    } else {
      
      playlist.shift(positions);
      return true;
      
    }
    
  }
  
}