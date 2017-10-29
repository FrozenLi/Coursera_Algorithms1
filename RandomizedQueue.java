import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;





public class RandomizedQueue<Item> implements Iterable<Item> {
   private Item[] a; // queue entries
   private int N;
   private void resize(int max){
   Item[] temp=(Item[]) new Object[max];
   for (int i=0;i<N;i++){
   temp[i]=a[i];
   }
   a=temp;
   } 
   
   public RandomizedQueue(){
   N=0;
   a=(Item[]) new Object[0];
   
   }                 // construct an empty randomized queue
   
   public boolean isEmpty(){
       return N==0;
   }                 // is the randomized queue empty?
   public int size(){
   return N;
   }                        // return the number of items on the randomized queue
   public void enqueue(Item item){
       
       if (item==null){
       throw new java.lang.IllegalArgumentException();
       }
       if (N==0) resize (1);
       if (N==a.length) resize(2*a.length);
       a[N++]=item;
   
   }           // add the item
   public Item dequeue(){
       if (isEmpty()){
       throw new java.util.NoSuchElementException();
       }
       int randomIndex=StdRandom.uniform(N);
       Item result=a[randomIndex];
       a[randomIndex]=a[N-1];
       a[N-1]=null;
   if (N>0 &&N==a.length/4) resize(a.length/2);
   N--;
   return result;
   
   
   }                    // remove and return a random item
   public Item sample(){
       if (isEmpty()){
       throw new java.util.NoSuchElementException();
       }
   return a[StdRandom.uniform(N)];
   }                     // return a random item (but do not remove it)
   public Iterator<Item> iterator(){
   return new RandomizedQueueIterator();
   }         // return an independent iterator over items in random order
   private class RandomizedQueueIterator implements Iterator<Item>{
       private Item[] copyArray=a;
       private int copyN=N;
       public RandomizedQueueIterator(){
       StdRandom.shuffle(copyArray);
       }
       public boolean hasNext(){
       return copyN>0;
       }
       public Item next(){
           if (copyN==0){
           throw new java.util.NoSuchElementException();}
           
           
       return copyArray[--copyN];
       }
       public void remove(){
       throw new java.lang.UnsupportedOperationException();
       
       }
       
       
   
   
   }
   
   
   
   public static void main(String[] args){
   
   
   
   
   
   
   
   
   
   
   }   // unit testing (optional)
}
