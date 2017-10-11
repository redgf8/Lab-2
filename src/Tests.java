
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tests {

  public static void main (String args[]) {
    
    Random rand = new Random(); //create a new random number generator and three playlists
    String aTimes = ""; //string to hold runtimes
    String llTimes = "";
    String cllTimes = "";
    Array_Playlist aPlaylist = new Array_Playlist("aPlaylist");
    LinkedList_Playlist llPlaylist = new LinkedList_Playlist("llPLaylist");
    CircularLinkedList_Playlist cllPlaylist = new CircularLinkedList_Playlist("cllPlaylist");
    Song song = new Song("", "", 0f); //empty song to populate playlists with
    
    //begin array test
    
    for (int i = 0; i < 1000000; i++) { //add 1 million songs to playlist
        
      aPlaylist.addSong(song);
      System.out.println("Initial: " + (i + 1));
      
    }
    
    long startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //retrieve random song 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      
      aPlaylist.getSongAt(n);
      System.out.println("Retrieve: " + (i + 1));
    
    }
    
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    aTimes = "Time for retrieving Array elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //swap 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = ((ThreadLocalRandom.current().nextInt(n, 500000 + 1)) + 1); //picks a random int from (n + 1) to 500000
      aPlaylist.getList().swap(n, n2);
      System.out.println("Swap: " + (i + 1));
      
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for swapping Array elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //shift songs 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = rand.nextInt(1); //yes/no flag for making shift positions negative
      
      if (n2 == 0) {
        
        n = n - (n * 2);
        
      }
      
     aPlaylist.moveAllSongs(n);
      System.out.println("Shift: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for shifting Array elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //add song in random position 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      aPlaylist.addSong(song, n);
      System.out.println("Add: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    aTimes = aTimes + "\nTime for adding Array elements: " + totalTime + " milliseconds.";
    
    //being linked list test
    
    for (int i = 0; i < 1000000; i++) { //add 1 million songs to playlist
        
      llPlaylist.addSong(song);
      System.out.println("Initial: " + (i + 1));
      
    }
    
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //retrieve random song 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      
      llPlaylist.getSongAt(n);
      System.out.println("Retrieve: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = "Time for retrieving LinkedList elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //swap 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = ((ThreadLocalRandom.current().nextInt(n, 500000 + 1)) + 1); //picks a random int from (n + 1) to 500000
      llPlaylist.getList().swap(n, n2);
      System.out.println("Swap: " + (i + 1));
      
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = llTimes + "\nTime for swapping LinkedList elements: " + totalTime + " milliseconds.";
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
    llTimes = llTimes + "\nTime for shifting LinkedList elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //add song in random position 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      llPlaylist.addSong(song, n);
      System.out.println("Add: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    llTimes = llTimes + "\nTime for adding LinkedList elements: " + totalTime + " milliseconds.";
    
    //begin circular linked list test
    
    for (int i = 0; i < 1000000; i++) { //add 1 million songs to playlist
      
      cllPlaylist.addSong(song);
      System.out.println("Initial: " + (i + 1));
      
    }
    
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //retrieve random song 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      
      cllPlaylist.getSongAt(n);
      System.out.println("Retrieve: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    cllTimes = "Time for retrieving CircularLinkedList elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //swap 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = ((ThreadLocalRandom.current().nextInt(n, 500000 + 1)) + 1); //picks a random int from (n + 1) to 500000
      cllPlaylist.getList().swap(n, n2);
      System.out.println("Swap: " + (i + 1));
      
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    cllTimes = cllTimes + "\nTime for swapping CircularLinkedList elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //shift songs 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      int n2 = rand.nextInt(1); //yes/no flag for making shift positions negative
      
      if (n2 == 0) {
        
        n = n - (n * 2);
        
      }
      
      cllPlaylist.moveAllSongs(n);
      System.out.println("Shift: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    cllTimes = cllTimes + "\nTime for shifting CircularLinkedList elements: " + totalTime + " milliseconds.";
    startTime = System.currentTimeMillis();
    
    for (int i = 0; i < 500000; i++) { //add song in random position 500000 times
      
      int n = (rand.nextInt(500000) + 1);
      cllPlaylist.addSong(song, n);
      System.out.println("Add: " + (i + 1));
    
    }
    
    endTime   = System.currentTimeMillis();
    totalTime = endTime - startTime;
    cllTimes = cllTimes + "\nTime for adding CircularLinkedList elements: " + totalTime + " milliseconds.";
    
    //do this code after running all three blocks of tests for each implementation
    
    System.out.println(aTimes);
    System.out.println(llTimes);
    System.out.println(cllTimes);

  }
  
}