
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

	public static void main (String args[]) {

		Random rand = new Random();	
		String llTimes = "";
		LinkedList_Playlist llPlaylist = new LinkedList_Playlist("llPLaylist");
		Song song = new Song("", "", 0f);
		for (int i = 0; i < 1000000; i++) { //add 1 million songs to playlist
				
			llPlaylist.addSong(song);
			System.out.println("Initial: " + (i + 1));
			
		}
		
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) { //retrieve random song 500000 times
			
			int n = (rand.nextInt(500000) + 1);
			
			llPlaylist.getSongAt(n);
			System.out.println("Retrieve: " + (i + 1));
		
		}
		
		long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    llTimes = "Time for retrieving LinkedList elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) { //swap 500000 times
		  
		  int n = (rand.nextInt(500000) + 1);
			int n2 = ((ThreadLocalRandom.current().nextInt(n, 500000 + 1)) + 1); //picks a random int from (n + 1) to 500000
			llPlaylist.getList().swap(n, n2);
			System.out.println("Swap: " + (i + 1));
			
		}
		
		endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = llTimes + "\nTime for swapping LinkedList elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //shift songs 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = rand.nextInt(1); //yes/no flag for making shift positions negative
      
      if (n2 == 0) {
        
        n = n - (n * 2);
        
      }
      
      llPlaylist.moveAllSongs(n);
      System.out.println("Shift: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = llTimes + "\nTime for shifting LinkedList elements: " + totalTime + " miliseconds.";
    startTime = System.currentTimeMillis();
		
    for (int i = 0; i < 500000; i++) { //add song in random position 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      llPlaylist.addSong(song, n);
      System.out.println("Add: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = llTimes + "\nTime for adding LinkedList elements: " + totalTime + " miliseconds.";
    
    //do this code after running all three blocks of tests for each implementation
    
    //System.out.println(aTimes); where aTimes takes the place of llTimes in the array tests
    System.out.println(llTimes);
  //System.out.println(cllTimes); where cllTimes takes the place of llTimes in the circular linked list tests

	}
	
	
}