
/**
 * Driver - for Queue<E> generic class.
 * 

 *
 */

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Queue<Integer> q = new Queue<Integer>(2);

		System.out.printf( "Queue q is %s%n", q.isEmpty() ? "empty" : "not empty" );
		q.add(5);
		System.out.printf( "Queue q added element: %d%n", 5 );	
		System.out.printf( "Queue q first element: %d%n", q.element() );	
		q.add(10);
		System.out.printf( "Queue q added element: %d%n", 10 );	
		System.out.printf( "Queue q first element: %d%n", q.element() );	
		q.add(15);
		System.out.printf( "Queue q added element: %d%n", 15 );	
		System.out.printf( "Queue q first element: %d%n", q.element() );
		System.out.printf( "Queue q removed first element: %d%n", q.remove() );	
		System.out.printf( "Queue q first element is %d%n", q.element() );	
		System.out.printf( "Queue q is %s%n", q.isEmpty() ? "empty" : "not empty" );

		//for (int i = 0;  i < 100;  ++i )
		//	q.add(20 + i*5);
		System.out.printf( "Queue q first element: %d%n", q.peek() );		
		System.out.printf( "Queue q last element: %d%n", q.peekLast() );		
		System.out.printf( "Queue q size is %d%n", q.size() );
		System.out.printf( "Queue q: %n%s", q.toString() );

		try {
			q.clear();
			q.remove();
		}
		catch (Exception ex) {
			System.out.println( ex );
		}
		
    System.out.println( " \n\n\n **** Testing Extra Function Implemented ****" );
	System.out.println( " \n **** I have considered Logical index start from 1 eg. 1 as front element, 2 as next  ****" );

	try {
	    System.out.println( " \n **** Adding three Element 5 at logical position first, 10 at logical position second and 15 at logical positon third ****" );

		q.add(5);
		q.add(10);
		q.add(15);
	}
	catch (Exception ex) {
			System.out.println( ex );
	}
	
	System.out.println( " \n **** Testing  QueueItr.hasNext() and QueueItr.hasPrevious() by setting at logical position 1  ****\n" );

	AbstractQueueIterator<Integer> QueueItr =  q.queueIterator(1);
	
	if(QueueItr.hasNext())
	System.out.printf( "\n hasNext is true %n" );
	else
    System.out.printf( "\n hasNext is false %n" );

	if(QueueItr.hasPrevious())
	System.out.printf( "hasPrevious is true %n" );
		else
    System.out.printf( " hasPrevious is false %n" );

	System.out.println( " \n **** Testing  QueueItr.hasNext() and QueueItr.hasPrevious() by setting at logical position 2  ****\n" );

      QueueItr =  q.queueIterator(2);
	
	if(QueueItr.hasNext())
	System.out.printf( " hasNext is true %n" );
	else
    System.out.printf( " hasNext is false %n" );

	if(QueueItr.hasPrevious())
	System.out.printf( " hasPrevious is true %n" );
		else
    System.out.printf( " hasPrevious is false %n" );
	
	System.out.println( " \n **** Testing  QueueItr.hasNext() and QueueItr.hasPrevious() by setting at logical position 3  ****\n" );

    QueueItr =  q.queueIterator(3);
	
	if(QueueItr.hasNext())
	System.out.printf( " hasNext is true %n" );
	else
  System.out.printf( " hasNext is false %n" );

	if(QueueItr.hasPrevious())
	System.out.printf( " hasPrevious is true %n" );
		else
  System.out.printf( " hasPrevious is false %n" );
	
	System.out.println( " \n **** Testing  QueueItr.nextIndex() and QueueItr.next() by setting at logical position 2  ****\n" );

    QueueItr =  q.queueIterator(2);
	
    try {
    	System.out.printf( "\n NEXT  LOGICAL INDEX==  %d %n", QueueItr.nextIndex() );

    	Integer valInt      = (Integer) QueueItr.next();
    
    	System.out.printf( "\n Element ==  %d %n", valInt );
	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
	System.out.println( " \n **** Testing  QueueItr.nextIndex() and QueueItr.next() by setting at logical position 3  ****\n" );

    QueueItr =  q.queueIterator(3);
	
    try {
    	System.out.printf( "\n NEXT  LOGICAL INDEX==  %d %n", QueueItr.nextIndex() );

    	Integer valInt      = (Integer) QueueItr.next();
    
    	System.out.printf( "\n Element ==  %d %n", valInt );
	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
    
    
	System.out.println( " \n **** Testing  QueueItr.previousIndex() and QueueItr.previous() by setting at logical position 2  ****\n" );

    
    QueueItr =  q.queueIterator(2);
	
    try {
    	System.out.printf( " PREVIOUS LOGICAL INDEX  ==  %d %n", QueueItr.previousIndex() );

    	Integer valInt      = (Integer) QueueItr.previous();

    	System.out.printf( " Element ==  %d %n", valInt );
	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
    
    
	System.out.println( " \n **** Testing  QueueItr.previousIndex() and QueueItr.previous() by setting at logical position 1  ****\n" );

    
    QueueItr =  q.queueIterator(1);
	
    try {
    	System.out.printf( " PREVIOUS LOGICAL INDEX  ==  %d %n", QueueItr.previousIndex() );

    	Integer valInt      = (Integer) QueueItr.previous();

    	System.out.printf( " Element ==  %d %n", valInt );
	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
	System.out.println( " \n **** QueueItr.set(75) :  Replaces the element returned by next() with the specified element . replacing 10 by 75  ****\n" );

    QueueItr =  q.queueIterator(1);
    QueueItr.set(75);
    
    QueueItr =  q.queueIterator(3);
	
    try {
    	System.out.printf( " PREVIOUS LOGICAL INDEX  ==  %d %n", QueueItr.previousIndex() );

    	Integer valInt      = (Integer) QueueItr.previous();

    	System.out.printf( " Element ==  %d %n", valInt );
	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
	//	Replaces the last element returned by next() or previous() with the specified element (optional operation).

    
	System.out.println( " \n **** Testing  QueueItr.remove() by setting at logical position 1  ****\n" );

    
    QueueItr =  q.queueIterator(1);
	
    try {
    	 QueueItr.remove();	
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
    QueueItr =  q.queueIterator(1);

    try {
    	System.out.printf( " NEXT  LOGICAL INDEX==  %d %n", QueueItr.nextIndex() );

    	Integer valInt      = (Integer) QueueItr.next();
    
    	System.out.printf( " Element ==  %d %n", valInt );
    	
    	System.out.printf( " PREVIOUS LOGICAL INDEX  ==  %d %n", QueueItr.previousIndex() );

    	 valInt      = (Integer) QueueItr.previous();

    	System.out.printf( " Element ==  %d %n", valInt );
    	
       	System.out.printf( " NEXT  LOGICAL INDEX==  %d %n", QueueItr.nextIndex() );

    	 valInt      = (Integer) QueueItr.next();
    
    	System.out.printf( " Element ==  %d %n", valInt );
      	System.out.printf( " NEXT  LOGICAL INDEX==  %d %n", QueueItr.nextIndex() );

   	 valInt      = (Integer) QueueItr.next();
   
   	System.out.printf( " Element ==  %d %n", valInt );
    }catch (Exception ex) {
		System.out.println( ex );
     }
    
		
	System.out.println( "\n\n **** Testing Completed *****" );
		
		
		
	}	
}
