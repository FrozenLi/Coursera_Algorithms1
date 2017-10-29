import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;




public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
        int totalLength=Integer.parseInt(args[0]);
        // read strings from std input:
        while (!StdIn.isEmpty())
        {
             String s = StdIn.readString();
             randomQueue.enqueue(s);
        }

        
        for (int i = 0; i < totalLength; i++) {
            StdOut.println(randomQueue.dequeue());
        }
    }
}