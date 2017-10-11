
public class Song {
	
	private String name;
	private String artist;
	private float playtime;
	
	public Song(String N, String A, float PT) {
		name = N;
		artist = A;
		playtime = PT;
	}
	
	public String toString() {
		String SongInfo = "";
		SongInfo = 
				"Song Name: " + getSongName() + ", " + 
				"Artist: " + getArtist() + ", " + 
				"Play Time: " + getPlayTime();
		return SongInfo;
	}
	
	public float getPlayTime() {
		return playtime;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getSongName() {
		return name;
	}
	
	public boolean equals(Song s) {
		
	  if(s.getPlayTime() == this.getPlayTime() &&
				s.getSongName().equals(this.getSongName()) &&
				s.getArtist().equals(this.getArtist()))
		{
		return true;
			
	  }else{
			return false;
		}
	}
}
