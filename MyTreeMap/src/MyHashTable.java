/**
 *  MyHashTable - implementation of generic Hash Table class, 
 *                similar to Java HashMap<K,V> class.

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

interface KeyedValue<K>
{
    public K getKey();
}

@SuppressWarnings("unchecked")  // prevents warnings for casts 

public class MyHashTable<Key extends Comparable<Key>,Item extends KeyedValue<Key>>
{
  private int tableSize = 0;
  private int count = 0;
  private Object[] table;

/*********************************************************************
 * Constructors
*********************************************************************/

  MyHashTable() {
      this.table = new Object[16];
      this.tableSize = 16;
      this.count = 0;
    for(int i = 0; i < this.tableSize; ++i)
        this.table[i] = null;
  }
  
  MyHashTable(int initialCapacity) throws IllegalArgumentException {
      if ( initialCapacity < 0 )
          throw new IllegalArgumentException();
      this.table = new Object[initialCapacity];        
      this.tableSize = initialCapacity;
      this.count = 0;
    for(int i = 0; i < this.tableSize; ++i)
        this.table[i] = null;
  }
  
  public Item search(Key k) 
  {
      int i = Math.abs(k.hashCode() % this.tableSize);  // hash key to get chain to search
      if ( this.table[i] == null )
         return null;
      ListIterator<Item> li = 
          ((LinkedList<Item>)this.table[i]).listIterator(0);
      while ( li.hasNext() ) {
        Item it;
        it = li.next();
        if ( k.compareTo(it.getKey()) == 0 )
          return it;
      }
      return null;
  }    

  public Item insert(Item x) 
  {
    int i = Math.abs(x.getKey().hashCode() % this.tableSize);  // hash item's key

    Item y=null;
    // create chain, if needed
    if ( this.table[i] == null ){
    	y = null;
       this.table[i] = new LinkedList<Item>();
    }else{
    	
    	ListIterator<Item> li = 
            ((LinkedList<Item>)this.table[i]).listIterator(0);
        while ( li.hasNext() ) {
          Item it;
          it = li.next();
          if ( x.getKey().compareTo(it.getKey()) == 0 )
            y = it;
        }
    	//y =  ((LinkedList<Item>)this.table[i]).getFirst(); 
    }

    ((LinkedList<Item>)this.table[i]).addFirst(x);  // insert at head of list (O(1))
    ++this.count;
    
    return y;
  }    
  
  public void delete(Item x) 
  {
    int i = Math.abs(x.getKey().hashCode() % this.tableSize);  // hash item's key

    if ( this.table[i] == null )
       return;

    if ( ((LinkedList<Item>)this.table[i]).remove(x) )  // O(n/m)
        --this.count;
  }  
  
//add method with header void clear(), removing all the items from the structure
  public void clear(){
	  int count = 0;
	  //  System.out.println( " I am here clear check "  ); 

	  
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	
   		      
      		  ((LinkedList<Item>)this.table[i]).clear();
   		   
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
		  }
   }
	  this.count = 0; 
  }
  
  
//  //  add method with header Object[] keyArray(), returning an array containing all the keys of the items currently in the structure

  
  
  public Object[] keyArray(){
	  Object[] arrayRefVar = new Object[this.count];
	  
	  int arraytrack = 0;
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	   ListIterator<Item> li = 
   		          ((LinkedList<Item>)this.table[i]).listIterator(0);
   		      while ( li.hasNext() ) {
   		        Item it;
   		        it = li.next();
      		    //System.out.println( "size check " + it ); 

   		        if(it !=null){
   		        	Key kkk = it.getKey();
   		        
   		        	arrayRefVar[arraytrack] = kkk;
   		        	
   		        	arraytrack++;
   		        }
   		        	
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
   		      }
		  }
      }
	  Set<Object> strSet = Arrays.stream(arrayRefVar).collect(Collectors.toSet());  
	  Object[] array = strSet.toArray(new Object[0]);
	  return array;
  }
//add method with header boolean isEmpty(), returning true iff no items are currently stored in the structure
  public Boolean isEmpty(){

	  int count = 0;
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	   ListIterator<Item> li = 
   		          ((LinkedList<Item>)this.table[i]).listIterator(0);
   		      while ( li.hasNext() ) {
   		        Item it;
   		        it = li.next();
   		        
   		        if(it !=null)
   		        	count++;
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
   		      }
		  }
   }
	  if(count == 0){
		  return true;
	  }
	 return false; 
  }
  
//add method with header int size(), returning the number of items currently in the structure

  public int size(){

	  int count = 0;
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	   ListIterator<Item> li = 
   		          ((LinkedList<Item>)this.table[i]).listIterator(0);
   		      while ( li.hasNext() ) {
   		        Item it;
   		        it = li.next();
      		  //  System.out.println( "size check " + it ); 

   		        if(it !=null)
   		        	count++;
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
   		      }
		  }
   }
	  
	 return count; 
  }
  
  
  public Item max(){
	  Item x = null;
	  if(this.count == 0){
		  return null;
	  }
	  
      Object[] arrayRefVar = new Object[this.count];
	  
	  int arraytrack = 0;
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	   ListIterator<Item> li = 
   		          ((LinkedList<Item>)this.table[i]).listIterator(0);
   		      while ( li.hasNext() ) {
   		        Item it;
   		        it = li.next();
      		    //System.out.println( "size check " + it ); 

   		        if(it !=null){
   		        	Key kkk = it.getKey();
   		        
   		        	arrayRefVar[arraytrack] = kkk;
   		        	
   		        	arraytrack++;
   		        }
   		        	
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
   		      }
		  }
      }
	  
	  
	  Object nnn = arrayRefVar[0];

	  for (int i = 0; i < arrayRefVar.length; i++) {
		  Object nnn2    = arrayRefVar[i];
		  Key kll4 = (Key) nnn2;
		  Key kl5 = (Key) nnn; 
		  if(kll4.compareTo(kl5) > 0){
			  nnn = nnn2;
		  }
	  }
	  
	  Key kll = (Key) nnn;
	  
	return search(kll);
  }
 
  
  public Item min(){
	  Item x = null;
	  if(this.count == 0){
		  return null;
	  }
	  
      Object[] arrayRefVar = new Object[this.count];
	  
	  int arraytrack = 0;
	  for(int i = 0; i < this.tableSize; ++i){
	    	
		  if(  ((LinkedList<Item>)this.table[i]) != null){
   	   ListIterator<Item> li = 
   		          ((LinkedList<Item>)this.table[i]).listIterator(0);
   		      while ( li.hasNext() ) {
   		        Item it;
   		        it = li.next();
      		    //System.out.println( "size check " + it ); 

   		        if(it !=null){
   		        	Key kkk = it.getKey();
   		        
   		        	arrayRefVar[arraytrack] = kkk;
   		        	
   		        	arraytrack++;
   		        }
   		        	
   		      //   System.out.println( "The value of r+s is " + val );       // binary add operation
   		      }
		  }
      }
	  
	  
	  Object nnn = arrayRefVar[0];

	  for (int i = 0; i < arrayRefVar.length; i++) {
		  Object nnn2    = arrayRefVar[i];
		  Key kll4 = (Key) nnn2;
		  Key kl5 = (Key) nnn; 
		  if(kll4.compareTo(kl5) < 0){
			  nnn = nnn2;
		  }
	  }
	  
	  Key kll = (Key) nnn;
	  
	return search(kll);
  }
  
  
//  dd method with header Item max(), returning the greatest item, with respect to the ordering
//  add method with header Item min(), returning the least item, with respect to the ordering
//  add method with header void clear(), removing all the items from the structure
//  add method with header boolean isEmpty(), returning true iff no items are currently stored in the structure
} // public class MyHashTable
