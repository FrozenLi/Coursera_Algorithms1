import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
   private Node first;
   private Node last;
   private int N;
   private class Node{
   Item item;
   Node next;
   Node before;
   }
    
    
   public Deque(){
    this.N=0;
    first=null;
    last=null;
   }                           // construct an empty deque
   public boolean isEmpty(){
   return first==null;
   }                 // is the deque empty?
   public int size(){
   return N;
   }                        // return the number of items on the deque
   public void addFirst(Item item)          // add the item to the front
   {
       if (item==null){throw new java.lang.IllegalArgumentException();}
       Node oldFirst=first;
       first=new Node();
       first.item=item;
       first.next=oldFirst;
       first.before=null;
       if(N==0){last=first;}
       else{oldFirst.before=first;}
       N++;
   }
   public void addLast(Item item)           // add the item to the end
   {
       if (item==null){
           throw new java.lang.IllegalArgumentException();}
       Node oldLast=last;
       last=new Node();
       last.item=item;
       last.before=oldLast;
       last.next=null;
       if (N==0){first=last;}else{
       oldLast.next=last;}
       N++; 
   }
   public Item removeFirst()                // remove and return the item from the front
   {
       if (N == 0){
           throw new java.util.NoSuchElementException();}
       Item item=first.item;
       first=first.next;
       
       N--;
       if(N==0){last=first;}else{first.before=null;}
       return item;
   }
   public Item removeLast(){
       if (N==0){
           throw new java.util.NoSuchElementException();}
       Item item = last.item;
       last = last.before;
       
       N--;
       if(N==0){first=last;}else{last.next=null;}
       return item;
   }                 // remove and return the item from the end
   public Iterator<Item> iterator(){
         return new DequeIterator();
   }         // return an iterator over items in order from front to end
   private class DequeIterator implements Iterator<Item>{
   
   private Node current=first;    
   
   public boolean hasNext(){ return current != null;  }
   public Item next(){
       
       if(current==null){
       throw new java.util.NoSuchElementException();
       }
   Item item = current.item;
   current = current.next;
   return item;
   }   
   public void remove(){
       
   throw new java.lang.UnsupportedOperationException();
   
   }
   
   
   
   }
   
   
   
   
   public static void main(String[] args) {
       
       
       
   }  // unit testing (optional)
}
