
public class Driver {

	public static void main(String[] args) {
		System.out.println( " \n\n\n **** Testing Started  ****\n\n\n" );
		
		System.out.printf( "\n**** Calling MyLinkedList()   default constructor and Then Calling int size() ****\n");
		MyLinkedList<Integer> a= new MyLinkedList<Integer>();
		MyLinkedList<Integer> b= new MyLinkedList<Integer>();
		Integer c;
		System.out.printf( "(Size) of MyLinkedList a: (%d)%n", a.size());
		System.out.printf( "(Size) of MyLinkedList b: (%d)%n", b.size());
		
		System.out.printf( "\n**** Calling boolean add(E element) ****\n");
		for ( int i = 0;  i < 10;  ++i ){
			a.add(i);
			System.out.printf( "Added %d,Size of MyLinkedList a: (%d)%n", i, a.size());			
		}
		
		System.out.printf( "\n ****** Remove a.remove(5); ****** \n\n");

		
		Integer k = a.remove(5);
		System.out.printf( "Removed item at index %d, (Size,Capacity) of MyLinkedList a: (%d)%n", k, a.size());
		
		System.out.printf( "\n ****** Printing Linklist a.get(int index) ****** \n\n");
		for ( int i = 0;  i < a.size();  ++i ) 
			System.out.printf( "Item at index %d = %d%n", i, a.get(i) );
		
		System.out.printf( "\n ****** insert an item at a particular position in MyArrayList void add(int index, E element)  a.add(7, 999) ****** \n\n");
		// insert an item at a particular position in MyArrayList a 
		a.add(7, 999);
		System.out.printf( "Added %d at index %d, (Size,Capacity) of MyLinkedList a: (%d)%n", 999, 7, a.size());
		for ( int i = 0;  i < a.size();  ++i ) 
			System.out.printf( "Item at index %d = %d%n", i, a.get(i) );
		
		System.out.printf("\n ****** Removing first element of MyLinkedList a.remove(); *****\n");
		a.remove();
		for ( int i = 0;  i < a.size();  ++i ) 
			System.out.printf( "Item at index %d = %d%n", i, a.get(i) );
		
		
		System.out.printf("\n ****** Removing first element of MyLinkedList boolean remove(Object o) === a.remove(a.get(8));; *****\n");
		a.remove(a.get(8));
		for ( int i = 0;  i < a.size();  ++i ) 
			System.out.printf( "Item at index %d = %d%n", i, a.get(i) );
		
		

		System.out.printf("\n ****** Calling  int indexOf(Object o) *****\n");
		
			System.out.printf( " Index of value 3 is === %d ", a.indexOf(a.get(3)) );
		
	//	System.out.printf("Size of MyLinkedList a: (%d) %n",a.size() );
		
		
		System.out.printf("\n\n ****** Calling  E element() *****\n");
		c = a.element();
		System.out.printf( "Item === %d", c );
		
		System.out.printf("\n\n ****** Calling  E set(int index, E element) ===   a.set(2,a.get(6));*****\n");

	         a.set(2,a.get(6));
	         
	         for ( int i = 0;  i < a.size();  ++i ) 
	 			System.out.printf( "Item at index %d = %d%n", i, a.get(i) );
	 		
		
		System.out.printf("\n\n ******look for items in MyArrayList a (one should be found, one not) a.contains(999) a.contains(777) *****\n");

		// look for items in MyArrayList a (one should be found, one not)
				if ( a.contains(999) )
					System.out.println( "999 is contained in MyLinkedList a" );
				else
					System.out.println( "999 is not contained in MyLinkedList a" );
				if ( a.contains(777) )
					System.out.println( "777 is contained in MyLinkedList a" );
				else
					System.out.println( "777 is not contained in MyLinkedList a" );
				
				System.out.printf("\n ****** Calling	a.clear(); *****\n");

				a.clear();
				System.out.printf( "Cleared MyArrayList a, (Size,Capacity) of MyArrayList a: (%d)%n", a.size());
				
				System.out.printf("\n ****** Calling	 a.isEmpty() *****\n");

				if ( a.isEmpty() )
					System.out.println( "MyArrayList a is now empty" );
				else
					System.out.printf( "MyArrayList a now contains %d items%n", a.size() );
				
				// Exception testing
				System.out.printf("\n ****** try to insert 7 at out-of-bounds index *****\n");
				try {
					a.add(999, 7);  // try to insert 7 at out-of-bounds index
				}
				catch (Exception ex) {
					System.out.println( "Problem attempting to add 7 at index 999 in MyLinkedList a: " + ex );
				}
				
				System.out.printf("\n ****** try to retrieve a.get(999) *****\n");

				try {
					a.get(999);  // try to retrieve item from out-of-bounds index
					//System.out.println( "get item at index 999 in MyLinkedList a: " + ex );
				}
				catch (Exception ex) {
					System.out.println( "Problem attempting to get item at index 999 in MyLinkedList a: " + ex );
				}
				
				System.out.printf("\n ****** try to retrieve a.remove(999) *****\n");
				try {
					a.remove(999);  // try to remove item at out-of-bounds index
				}
				catch (Exception ex) {
					System.out.println( "Problem attempting to remove item at index 999 in MyLinkedList a: " + ex );
				}
				
				
				System.out.println( "\n\n\n **** Testing Completed *****" );		
	}

}
