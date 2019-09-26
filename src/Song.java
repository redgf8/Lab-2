/**
 * Song class to be used in a playlist
 * @author Daniel Haluszka
 */
public class Song {
  
	private String name;
	private String artist;
	private float playtime;

	/**
	 * Constructor for a new song, all parameters must be specified
	 * @param name The name of the new song
	 * @param artist The artist of the new song
	 * @param playtime The playtime of the new song
	 */
	public Song(String name, String artist, float playtime) {
		
	  	this.name = name;
		this.artist = artist;
		this.playtime = playtime;
		
	}

	/**
	 * Returns the info of the current song as a String
	 * @return String containing the name, artist, and playtime of the current song
	 */
	public String toString() {
		
	  	String songInfo =
				"Song Name: " + getName() + ", " +
				"Artist: " + getArtist() + ", " + 
				"Play Time: " + getPlayTime();
		
	  	return songInfo;
		
	}

	/**
	 * Returns the playtime of the current song
	 * @return Float playtime of current song
	 */
	public float getPlayTime() {
		
	  return playtime;
	  
	}

	/**
	 * Returns the artist of the current song
	 * @return String artist of the current song
	 */
	public String getArtist() {
	  
		return artist;
		
	}

	/**
	 * Returns the name of the current song
	 * @return String name of the current song
	 */
	public String getName() {
	  
		return name;
		
	}

	/**
	 * Overloaded equals method for two songs
	 * @param s Song to be compared for equality against the current song
	 * @return Boolean true when current song is equal to parameter
	 */
	public boolean equals(Song s) {
	  
		return (s.getPlayTime() == this.playtime &&
				s.getName().equals(this.name) &&
				s.getArtist().equals(this.artist)) ? true : false;
		
	}
	
}