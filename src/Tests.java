
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

	public static void main (String args[]) {

		Random rand = new Random();	
		String aTimes = "";
		Array_Playlist A_Playlist = new Array_Playlist("A_PLaylist");
		Song song = new Song("", "", 0f);
		for (int i = 0; i < 1000000; i++) { //add 1 million songs to playlist
				
			A_Playlist.addSong(song);
			System.out.println("Initial: " + (i + 1));
			
		}
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) { //retrieve random song 500000 times
			
			int n = (rand.nextInt(500000) + 1);
			
			A_Playlist.getSongAt(song, n);
			System.out.println("Retrieve: " + (i + 1));
		
		}
		
		long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    aTimes = "Time for retrieving Array elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) { //swap 500000 times
		  
		  int n = (rand.nextInt(500000) + 1);
			int n2 = ((ThreadLocalRandom.current().nextInt(n, 500000 + 1)) + 1); //picks a random int from (n + 1) to 500000
			A_Playlist.getList().swap(n, n2);
			System.out.println("Swap: " + (i + 1));
			
		}
		
		endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for swapping Array elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //shift songs 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = rand.nextInt(1); //yes/no flag for making shift positions negative
      
      if (n2 == 0) {
        
        n = n - (n * 2);
        
      }
      
      A_Playlist.MoveAllSongs(n);
      System.out.println("Shift: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for shifting Array elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
		
    for (int i = 0; i < 500000; i++) { //add song in random position 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      A_Playlist.addSong(song);
      System.out.println("Add: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for adding LinkedList elements: " + totalTime + " miliseconds.";
    
    //do this code after running all three blocks of tests for each implementation
    
    System.out.println(aTimes); //where aTimes takes the place of llTimes in the array tests
    //System.out.println(llTimes);
    //System.out.println(cllTimes); where cllTimes takes the place of llTimes in the circular linked list tests

	}
	
	
}