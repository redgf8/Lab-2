
public class LinkedList_Playlist {
	
	private String name = "";
	private MyList_LinkedList playlist = new MyList_LinkedList();

	public LinkedList_Playlist(String name) {
		
		this.setName(name);
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String playlistName() {
		
		return this.name;
		
	}
	
	boolean addSong(Song s) {
		
		playlist.add(s);
		return true;
		
	}
	
	boolean addSong(Song s, int index) {
		
		playlist.add(index, s);
		return true;
		
	}
	
	Song getSongAt(int index) { //why is a song a parameter here in the insturctions?
		
		Song song = new Song("", "", 0);
		song = (Song) playlist.get(index);
		return song;
		
	}
	
	MyList_LinkedList getList() {
		
		return playlist;
		
	}
	
	boolean removeSong(Song s) {
		
		playlist.remove(s);
		return true;
		
	}
	
	int totalSongs() {
		
		return playlist.getSize();
		
	}
	
	float playlistTime() {
		
		//need to do this one
		return 0;
		
	}
	
	boolean isSongInPlaylist(Song s) { //changed this to just song, not sure how to implement accepting just name or just name and artist as in instructions
		
		//Song song = new Song(name, artist, 0); //will probably always return false because we're not given the playtime? should this just be a song parameter?
		return playlist.contains(s);
		
	}
	
	void songsByArtist(String name) {
		
		Song currentSong = new Song("", "", 0);
		int check = 0;
		
		for (int i = 0; i < this.totalSongs(); i++) {
			
			currentSong = (Song) playlist.get(i + 1);
			if (currentSong.getArtist() == name) { //need to make this case insensitive
				
				System.out.println(currentSong.getSongName());
				check = 1;
				
			}
			
		}
		
		if (check == 0) {
			
			System.out.println("No songs by the specified artist in playlist.");
			
		}
		
	}
	
	boolean addSongsFrom(LinkedList_Playlist p) {

		for (int i = 0; i < p.totalSongs(); i++) {
			
			playlist.add(p.getSongAt(i + 1));
			
		}
		
		return true;
		
	}
	
	boolean MoveSong(Song s, int position) {
		
		if (position < 1 || position > this.totalSongs()) {
			
			System.out.println("Error: Invalid index value specified.");
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	boolean MoveAllSongs(int positions) {
		
		return false;
		
	}
	
}
