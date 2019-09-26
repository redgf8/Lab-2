/**
 * Playlist wrapper class built on a linked list implementation
 * @author Daniel Haluszka
 */
public class LinkedList_Playlist {

    //TODO: maybe add a few different sort functions?
    private String name = "";
    private MyList_LinkedList playlist = new MyList_LinkedList();

    /**
     * Constructor for a new playlist
     * @param name String name of the new playlist
     */
    public LinkedList_Playlist(String name) {

        this.name = name;

    }

    /**
     * Set the name of the current playlist
     * @param name String new name of current playlist
     */
    public void setName(String name) {

        this.name = name;

    }

    /**
     * Get the name of the current playlist
     * @return String name of the current playlist
     */
    public String playlistName() {

        return this.name;

    }

    /**
     * Add a new song to the end of the current playlist
     * @param s Song to be added to the current playlist
     * @return Boolean true if successful
     */
    public boolean addSong(Song s) {

        return playlist.add(s);

    }

    /**
     * Add a new song at the specified index of the current playlist
     * @param s Song to be added to the current playlist
     * @param index Int index at which new song is to be added to the current playlist
     * @return Boolean true if successful
     */
    public boolean addSong(Song s, int index) {

        try {

            return this.playlist.add(index, s);

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    /**
     * Get the song at the specified index of the current playlist
     * @param index Int index at which to get song from the current playlist
     * @return Song at the specified index of the current playlist
     */
    public Song getSongAt(int index) {

        try {

            return (Song) this.playlist.get(index);

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }

    }

    /**
     * Get the list object of the current playlist
     * @return The linked list object used as the current playlist
     */
    public MyList_LinkedList getList() {

        return this.playlist;

    }

    /**
     * Remove specified song from the current playlist
     * @param s Song to be removed from the current playlist
     * @return Boolean true if successful
     */
    public boolean removeSong(Song s) {

        try {

            this.playlist.remove(s);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    /**
     * Get the size of the current playlist
     * @return Int number of songs in the current playlist
     */
    public int totalSongs() {

        return this.playlist.size();

    }

    /**
     * Get the total playtime of the current playlist
     * @return Int total playtime of all songs in the current playlist
     */
    public float playlistTime() {

        try {

            float totalTime = 0f;

            for (int i = 0; i < this.totalSongs(); i++) {

                totalTime = (totalTime + ((Song) playlist.get(i)).getPlayTime());

            }

            return totalTime;

        } catch (Exception e) {

            e.printStackTrace();
            return 0f;

        }

    }

    /**
     * Check if a song with the specified name and artist is present in the current playlist
     * @param name String name of the song to check the current playlist for
     * @param artist String artist of the song to check the current playlist for
     * @param playtime Float playtime of the song to check the current playlist for
     * @return Boolean true if a song with the specified name and artist is present in the current playlist
     */
    public boolean isSongInPlaylist(String name, String artist, float playtime) {

        try {

            Song song = new Song(name, artist, playtime);
            return playlist.contains(song);

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    /**
     * Print all songs by specified artist in the current playlist
     * @param artist String artist to search for in the current playlist
     */
    public void songsByArtist(String artist) {

        try {

            boolean check = false;

            for (int i = 0; i < this.totalSongs(); i++) {

                Song currSong = (Song) this.playlist.get(i);

                if (currSong.getArtist() == artist) {

                    check = true;
                    System.out.println(currSong.getName());

                }

            }

            if (check == false) System.out.println("No songs by the specified artist in current playlist");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * Add songs from the specified playlist to the end of the current playlist
     * @param p Playlist to be added to the end of the current playlist
     * @return Boolean true if successful
     */
    public boolean addSongsFrom(LinkedList_Playlist p) {

        try {

            for (int i = 0; i < p.totalSongs(); i++) {

                this.playlist.add(p.getSongAt(i));

            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    /**
     * Move song in the current playlist to the specified index
     * @param s Song from the current playlist to be moved
     * @param index Int index to move specified song to in current playlist
     * @return Boolean true if successful
     */
    public boolean moveSong(Song s, int index) {

        try {

            this.playlist.remove(playlist.indexOf(s));
            this.playlist.add(index, s);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

    /**
     * Shift all songs in the current playlist by the specified number of positions
     * @param numPos Int number of positions to move all elements of the current playlist by
     * @return Boolean true if successful
     */
    public boolean moveAllSongs(int numPos) {

        try {

            this.playlist.shift(numPos);
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

}
