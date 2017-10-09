
public class Array_Playlist {

	private String playlistName = "";
	private MyList_Array playlist = new MyList_Array();
	
	
	public Array_Playlist(String Name) {
		
		playlistName = Name;
		
		
	} 
	
	String playlistName() {
		
		return playlistName;
		
	}
	
	boolean addSong(Song s) {
		
		playlist.add(s);
		return true;
		
	}
	
	boolean addSongAt(Song s, int index) {
		
		playlist.add(index, s);
		return true;
		
	}
	
	Song getSongAt(Song s, int index) {
		
		s = new Song("", "", 0);
		s = (Song) playlist.get(index);
		return s;
		
	}
	
	MyList_Array getList() {
		
		return playlist;
		
	}
	
	boolean removeSong(Song s) {
		
		playlist.remove(s);
		return true;
		
	}
	
	int totalSongs() {
		
		return playlist.size();
		
	}
	
	float playlistTime() {
		
		float totalTime = 0f;
		 Song placeholder = new Song("", "", 0);
		 
		 for(int i = 0; i < totalSongs(); i++) {
			 placeholder = (Song) playlist.get(i + 1);
			 totalTime = (totalTime + placeholder.getPlayTime());
		 }
		 
		 return totalTime;
		
	}
	
	boolean isSongInPlaylist(String name, String artist) {
		
		for(int i = 0; i < playlist.size(); i++) {
			
			if(playlist.contains(artist) && playlist.contains(name)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	void songsByArtist(String name) {
		
		Song placeholder = new Song("", "", 0);
		
		
		for (int i = 0; i < totalSongs(); i++) {
			
			if(placeholder.getArtist().toLowerCase().equals(name.toLowerCase())) {
				
				System.out.println(placeholder.getSongName());
				placeholder = (Song) playlist.get(i + 1);
				
			}
			else {
				System.out.println("No songs by that artist. Please check spelling.");
			}
		}
		
	}
	
	boolean addSongsFrom(Array_Playlist p) {
		Song placeholder = new Song("", "", 0);
		
		for(int i = 0; i < p.totalSongs(); i++) {
			playlist.add(p.getSongAt(placeholder, i + 1));
		}
		
	}
	
	boolean MoveSong(Song s, int position){
		
		int OriginalIndex = 0;
		OriginalIndex = playlist.indexOf(s);
		
		if(position < 1 || position > totalSongs()) {
			System.out.println("Invalid index.");
			return false;
		}
		else {
			playlist.addAt(position, s);
			playlist.removeAt(OriginalIndex);
			playlist.set(position, s);
			OriginalIndex = 0;
			return true;
		}
	}
	
	void MoveAllSongs(int positions){
		
		playlist.shift(positions);
		
	}
	
	
}
