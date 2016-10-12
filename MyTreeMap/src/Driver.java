import java.util.Collection;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class Driver {

	public static <K, V> void main(String[] args) {
		System.out.println( " \n\n\n **** Testing Started  ****\n\n\n" );
		
		System.out.println( "  **** Calling TreeMap() **** " );
		MyTreeMap<String,Integer> map1= new MyTreeMap<String,Integer>();
		
		System.out.println( "  **** Storing Four value_pairs by using V put(K key, V value) **** " );
		 try{
		map1.put("Gita" , 2); 
		map1.put("Harry" , 1); 
		map1.put("Kajol" , 4); 
		map1.put("Ram" , 5); 
		}
	   catch (Exception ex) {
		System.out.println( "Problem firstEntry : " + ex );
	  }
		
		System.out.println( "  **** Testing Map Size  **** " );
		System.out.printf( "  Map  Size == %d  %n", map1.size());
		
		System.out.println( "  **** Testing ContainsKey And ContainsValue **** " );
         
		System.out.println( "  **** By giving Correct Key **** " );
		Boolean val1 = map1.containsKey("Harry");
		if(val1){
			System.out.println( "  Contains Key is true " );
		}else{
			System.out.println( "  Doesnot Contain Key  " );
		}
		
		System.out.println( "  **** By giving false Key **** " );
		Boolean val2 = map1.containsKey("Radha");
		if(val2){
			System.out.println( "  Contains Key is true " );
		}else{
			System.out.println( "  Doesnot Contain Key  " );
		}
		
		System.out.println( "  **** By giving Correct Value **** " );
		Boolean val4 = map1.containsValue(5);
		if(val4){
			System.out.println( "  Contains Value is true " );
		}else{
			System.out.println( "  Doesnot Contain Value  " );
		}
		
		System.out.println( "  **** By giving false Value **** " );
		Boolean val5 = map1.containsValue(10);
		if(val2){
			System.out.println( "  Contains value is true " );
		}else{
			System.out.println( "  Doesnot Contain value  " );
		}
		
		System.out.println( "  **** Testing Get() Method **** " );

		System.out.printf( "  Value for Ram = %d  %n", map1.get("Ram"));
		System.out.printf( "  Value for Kajol = %d  %n", map1.get("Kajol"));
		System.out.printf( "  Value for Ram = %d %n", map1.get("Ram"));
 
		System.out.println( "  **** Testing toSting() **** " );

		System.out.println( map1.toString());
		
		System.out.println( "  **** Testing firstEntry() **** " );
              
		try{
		Map.Entry<K,V> val12 = (Entry<K, V>) map1.firstEntry();
		System.out.println( "  First Enter is  = " + val12.getKey());

	   }
	   catch (Exception ex) {
		System.out.println( "Problem firstEntry : " + ex );
	  }
		

		System.out.println( "  **** Testing LastEntry() **** " );
        try{
		Map.Entry<K,V> val14 = (Entry<K, V>) map1.lastEntry();
		
		System.out.println( "  Last Enter is  = " + val14.getKey());
		
	 }
	   catch (Exception ex) {
		System.out.println( "Problem LastEntry : " + ex );
	  }
		System.out.println( "  **** Testing ceilingEntry() by putting map2.put(2,100) map2.put(5,100) and entering ceilingEntry(3) **** " );
		MyTreeMap<Integer,Integer> map2= new MyTreeMap<Integer,Integer>();
		try{
		map2.put(2,100);
		map2.put(5,100);
		
	    }
	   catch (Exception ex) {
		System.out.println( "Problem Putting in map : " + ex );
	  }
		System.out.println( "  ceilingEntry Enter is  = " + map2.ceilingEntry(3));
		
		System.out.println( "  **** Testing Remove(object Key) by Removing Key Harry and then finding with containsKey() **** " );

		 map1.remove("Harry");
		 Boolean val10 = map1.containsKey("Harry");
			if(val10){
				System.out.println( "  Contains Key is true " );
			}else{
				System.out.println( "  Doesnot Contain Key  " );
			}
			System.out.printf( "  Map  Size %d = %n", map1.size());
			
      System.out.println( "  **** Testing Clone() **** " );
      
     
      try{
    	  MyTreeMap<Integer,Integer>  map3 = (MyTreeMap<Integer, Integer>) map2.clone();
      System.out.printf( "  Map second Size %d = %n", map2.size());
      System.out.printf( "  Map third  Size %d = %n", map3.size());

	}
	   catch (Exception ex) {
		System.out.println( "Problem Cloning : " + ex );
	  }
      

		System.out.println( "  **** Testing Collection<V> values() on Map1 **** " );
		Collection<Integer> vs;
		try{
		 vs = map1.values();
		 for (Integer iterable_element : vs) {
				System.out.printf( "  Value = %d %n", iterable_element);
			 }
	   }
	   catch (Exception ex) {
		System.out.println( "Problem Testing Collectio : " + ex );
	   }
		
		System.out.println( "  **** Testing Clear() method  **** " );
		try{
        map1.clear();
		 }
		catch (Exception ex) {
			System.out.println( "Problem Testing CLear : " + ex );
		 }
		System.out.printf( "  Map  Size = %d  %n", map1.size());

		System.out.println( "\n\n\n **** Testing Completed *****" );		
	}

}
