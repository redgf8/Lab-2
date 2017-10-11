
public class Song {
  
	private String name;
	private String Artist;
	private float playtime;
	
	//construct a song with the supplied information
	public Song(String N, String A, float PT) {
		
	  name = N;
		Artist = A;
		playtime = PT;
		
	}
	
	//output song information to a string
	public String toString() {
		
	  String SongInfo = "";
		
		SongInfo = 
				"Song Name: " + getSongName() + ", " + 
				"Artist: " + getArtist() + ", " + 
				"Play Time: " + getPlayTime();
		
		return SongInfo;
		
	}
	
	//return the playtime of the current song
	public float getPlayTime() {
		
	  return playtime;
	  
	}
	
	//return the artist of the current song
	public String getArtist() {
	  
		return Artist;
		
	}
	
	//return the name of the current song
	public String getSongName() {
	  
		return name;
		
	}
	
	//overload equals for comparing two songs
	public boolean equals(Song s) {
	  
		if(s.getPlayTime() == this.getPlayTime() &&
				s.getSongName().equals(this.getSongName()) &&
				s.getArtist().equals(this.getArtist()))
		{
		  
			return true;
			
		} else {
		  
			return false;
			
		}
		
	}
	
}