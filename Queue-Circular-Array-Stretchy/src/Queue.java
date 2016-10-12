/**
 *  Queue<E> - circular array implementation of generic Queue<E> class;
 *             max #elements storeable is 1 less than the size of array,
 *             so we can distinguish between full and empty conditions.
 *  
 * @author robertirwin
 *
 * @param <E>
 */

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")  // prevents warnings for casts in peek/pop methods 



public class Queue<E> {
	private static final int Queue = 0;
	private int front;    // one index counter-clockwise of first queue element
	private int rear;     // index of last queue element
	private Object[] ra;

	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//  Enhancement 
	////////////////////////////////////////////////////////////////////////////////////////////
	private class QueueIterator implements  AbstractQueueIterator<E> {

	    private Queue<E> q ;
		
		private int logicalIndex;
		
		QueueIterator(Queue<E> qq, int index){			
			logicalIndex = index;
			q = qq;
		}
		
		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		  // Inserts the specified element into the Queue  .
			this.add(e);
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(q.isEmpty())  return false;
			// Returns true if this list iterator has more elements when traversing the list in the forward direction.
	

			int i = (q.front + logicalIndex -1) % q.ra.length ;
			i = (i+1) % q.ra.length;
			if(i == q.rear) return false;
			return true;
		}

		@Override
		public boolean hasPrevious() {
			if(q.isEmpty())  return false;
			// TODO Auto-generated method stub
			// Returns true if this list iterator has more elements when traversing the list in the reverse direction.
			int i = (q.front + logicalIndex -1) % q.ra.length ;
			if(i == q.front) return false;
			return true;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			
			
			if ( q.isEmpty() )
				throw new NoSuchElementException("tried to retrieve element from an empty queue");
			
			// Returns the next element in the list and advances the cursor position.
           
			if(!hasNext()) throw new NoSuchElementException("NO NEXT  element exist");
            logicalIndex++;
			return (E)q.ra[(q.front + logicalIndex) % q.ra.length];
		}
	
		@Override
		public E previous() {
			// TODO Auto-generated method stub
			
			//Returns the previous element in the list and moves the cursor position backwards.
			
			if ( q.isEmpty() )
				throw new NoSuchElementException("tried to retrieve element from an empty queue");
            if(!hasPrevious()) throw new NoSuchElementException("NO PREVIOUS  element exist");
            logicalIndex--;
			return (E)q.ra[(q.front + logicalIndex) % q.ra.length];
		}
		
		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			
			// return logical index
            
			return logicalIndex+1;
		}


		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			// return logical index
			return logicalIndex-1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			// Removes from the list the last element that was returned by next() or previous() (optional operation).
           //  Removes the specified element into the Queue  .
			if(q.isEmpty()) return;
			if(hasNext()){
				
		      logicalIndex++;
		      
		   	int i = (q.front + logicalIndex  ) % q.ra.length;
		  	System.out.printf( "  queue size before remove === %d \n ", q.size() );

		  	for (;  i != (q.rear+1);  i = (i+1) % q.ra.length ){
			//	System.out.printf( "\n hasNext()  I am hellooo element === %d \n ", q.ra[i] );
                         int j = (i+1) % q.ra.length ;
                         
					q.ra[i] = q.ra[j];
			}
			   q.rear = (q.rear-1) % q.ra.length;
				System.out.printf( " queue size after remove === %d \n ", q.size() );
				
			}

		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			  // Inserts the specified element into the Queue  .

		//	Replaces the last element returned by next() or previous() with the specified element (optional operation).
			if(q.isEmpty()) return;
	           if(hasNext()){
	 		      logicalIndex++;	 			  
	 			  	int i = (q.front + logicalIndex ) % q.ra.length;
	 			  q.ra[i] = e;	  
	 			  System.out.printf( "\n %d is inserted at logical position  === %d \n ", e, logicalIndex );

			}

		}
		
	}
	
	public QueueIterator queueIterator(int index) {
        return new QueueIterator(this,index);
   }
	///////////////////////////////////////////////////////////////////////////
	public Queue() {
		this.ra = new Object[10+1]; 
		this.front = 0;
		this.rear = 0;
	}

	public Queue(int initialCapacity) throws IllegalArgumentException {
		if ( initialCapacity < 1 )
			throw new IllegalArgumentException();
		// the +1 below makes up for not using one element of the object array
		this.ra = new Object[initialCapacity+1];   
		this.front = 0;
		this.rear = 0;
	}

	public void clear() {
		this.front = 0;
		this.rear = 0;
	}

	public boolean isEmpty() {
		return this.front == this.rear;
	}

	public boolean add(E e) {
		this.rear = (this.rear+1) % this.ra.length;
		if ( this.rear == this.front )
		{
			// queue is full, double its capacity
			Object [] tmp = new Object[2*this.ra.length];;
	   		int j = 1;
    		for ( int i = (this.front + 1) % this.ra.length;  i != this.rear;  i = (i+1) % this.ra.length )
    			tmp[j++] = this.ra[i];
    		this.ra = tmp;
    		this.front = 0;
    		this.rear = j;
		}
		this.ra[this.rear] = e;
		return true;
	}

	public boolean offer(E e) {
		this.rear = (this.rear+1) % this.ra.length;
		if ( this.rear == this.front )
		{
			// queue is full, double its capacity
			Object [] tmp = new Object[2*this.ra.length];;
	   		int j = 1;
    		for ( int i = (this.front + 1) % this.ra.length;  i != this.rear;  i = (i+1) % this.ra.length )
    			tmp[j++] = this.ra[i];
    		this.ra = tmp;
    		this.front = 0;
    		this.rear = j;
		}
		this.ra[this.rear] = e;
		return true;
	}

	public E element() {
		if ( this.isEmpty() )
			throw new NoSuchElementException("tried to retrieve element from an empty queue");
		return (E)this.ra[(this.front+1) % this.ra.length];
	}

	public E peek() {
		if ( this.isEmpty() )
			return null;
		return (E)this.ra[(this.front+1) % this.ra.length];
	}

	public E peekLast() {
		if ( this.isEmpty() )
			return null;
		return (E)this.ra[this.rear];
	}

	public E remove() {
		if ( this.isEmpty() )
			throw new NoSuchElementException("tried to remove element from an empty queue");
		return (E)this.ra[this.front = (this.front+1) % this.ra.length];
	}

	public E poll() {
		if ( this.isEmpty() )
			return null;
		return (E)this.ra[this.front = (this.front+1) % this.ra.length];
	}

	public int size() {
		int d = this.rear - this.front;
		return d >= 0 ? d
				      : this.ra.length - d;
	}
	
	public String toString() {
		String s = "";
		for ( int i = (this.front + 1) % this.ra.length;  i != this.rear;  i = (i+1) % this.ra.length )
			s += String.format("%s%n", ((E)this.ra[i]).toString());
		s += String.format("%s%n", ((E)this.ra[this.rear]).toString());		
		return s;
	}
}
