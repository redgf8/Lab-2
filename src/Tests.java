import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

	public static void main (String args[]) {

		Random rand = new Random();
		
		/**Array_Playlist arrayPlaylist = new Array_Playlist();
		
		for (int i = 0; i < 1000000; i++) {
			
			
			
		}**/
		
		CircularLinkedList_Playlist p = new CircularLinkedList_Playlist("test");
		Song s1 = new Song("song1", "Cold Play", 2.4f);
		Song s2 = new Song("song2", "Cold Play", 3.56f);
		Song s3 = new Song("song3", "Cold Play", 3.56f);
		Song s4 = new Song("song4", "Cold Play", 3.56f);
		Song s5 = new Song("song5", "Cold Play", 3.56f);
		System.out.println(p.addSong(s1));
		System.out.println(p.addSong(s2));
		System.out.println(p.addSong(s3));
		System.out.println(p.addSong(s4));
		System.out.println(p.addSong(s5, 5));
		System.out.println(p.getSongAt(3));
		System.out.println(p.totalSongs());
		System.out.println(p.playlistTime());
		p.songsByArtist("Cold play");
		System.out.println(p.removeSong(s2));
		System.out.println(p.totalSongs());
		//System.out.println(p.addSong(s2));
		System.out.println(p.getList().swap(1, 4));
		System.out.println(p.isSongInPlaylist(s2));
		p.songsByArtist("Cold play");
		p.songsByArtist("Grease Monkey");
		Song s6 = new Song("Around the Sun", "REM", 4.30f);
		CircularLinkedList_Playlist favorites = new CircularLinkedList_Playlist("favorites");
		System.out.println(favorites.addSong(s6));
		System.out.println(favorites.addSong(s1));
		System.out.println(favorites.addSongsFrom(p));
		favorites.songsByArtist("Cold play");
		favorites.songsByArtist("rem");
		System.out.println(favorites.getList());
		System.out.println(p.getList().toArray()[0]);
		System.out.println(p.getList().subList(1, 3).get(1));
		System.out.println(p.getList().remove(4));
		p.songsByArtist("Cold play");
		
		long startTime = System.currentTimeMillis();
		LinkedList_Playlist llPlaylist = new LinkedList_Playlist("llPLaylist");
		Song song = new Song("", "", 0f);
		for (int i = 0; i < 1000; i++) {
				
			llPlaylist.addSong(song);
			System.out.println(i);
			
		}
		for (int i = 0; i < 1000; i++) {
			
			int n = (rand.nextInt(1000) + 1);
			int n2 = ThreadLocalRandom.current().nextInt(n, 1000 + 1);
			int n3 = rand.nextInt(1);
			
			llPlaylist.addSong(song, n);
			
			llPlaylist.getList().swap(n, n2);
			if (n3 == 0) {
				
				n = n - (n * 2);
				
			}
			System.out.println(n);
			llPlaylist.MoveAllSongs(n);
			System.out.println(i);
			
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Runtime for LinkedList implementation: " + totalTime + " miliseconds");
		
	}
	
	
}