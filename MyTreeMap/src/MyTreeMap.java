import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;




public class MyTreeMap<K,V>
     extends AbstractMap<K,V>
     implements Map<K,V>,Cloneable 
{
   
	private final Comparator<? super K> comparator;
	
    private transient Entry<K,V> root = null;
    private transient int size = 0;
    
    static final class Entry<K,V> implements Map.Entry<K,V> {
    	        K key;
    	        V value;
    	        Entry<K,V> left = null;
    	        Entry<K,V> right = null;
    	        Entry<K,V> parent;

    	        Entry(K key, V value, Entry<K,V> parent) {
    	            this.key = key;
    	            this.value = value;
    	            this.parent = parent;
    	       }
               public K getKey() {
    	            return key;
              }
               
               public V getValue() {
    	            return value;
    	        }

    	        
               public V setValue(V value) {
    	            V oldValue = this.value;
    	            this.value = value;
    	            return oldValue;
    	        }
    	
    	        public boolean equals(Object o) {
    	            if (!(o instanceof Map.Entry))
    	                return false;
    	            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
    	            if(key == e.getKey() && value == e.getValue())
    	            	return true;
    	
    	            return false;
    	        }
    	
    	        public String toString() {
    	            return key + "=" + value;
    	        }
    	   }

    
    
    public MyTreeMap() {
    	comparator = null;
    }

    public MyTreeMap(Map<? extends K, ? extends V> m) {
    	        comparator = null;
    	       putAll(m);
     }
    
 
    
    public void putAll(Map<? extends K, ? extends V> map) {
    	         int mapSize = map.size();
    	         if (size==0 && mapSize!=0 ) {
    	             
    	                 try {
    	                     buildFromSorted(mapSize, map.entrySet().iterator(),
    	                                     null, null);
    	                 } catch (java.io.IOException cannotHappen) {
    	                 } catch (ClassNotFoundException cannotHappen) {
    	                 return;
    	             }
    	         }
    	         super.putAll(map);
    }

    private void buildFromSorted(int size, Iterator it,
            java.io.ObjectInputStream str,
            V defaultVal)
            		throws  java.io.IOException, ClassNotFoundException {
    					this.size = size;
    						root = buildFromSorted(0, 0, size-1,
          it, str, defaultVal);
    }
    
    private final Entry<K,V> buildFromSorted(int level, int lo, int hi,
    		                                             Iterator it,
    		                                             java.io.ObjectInputStream str,
    		                                             V defaultVal)
    		        throws  java.io.IOException, ClassNotFoundException {
    		
    		
    		        if (hi < lo) return null;
    		
    		        int mid = (lo + hi) >>> 1;
    		
    		        Entry<K,V> left  = null;
    		        if (lo < mid)
    		            left = buildFromSorted(level+1, lo, mid - 1,
    		                                   it, str, defaultVal);
    		
    		        K key;
    		        V value;
    		        if (it != null) {
    		            if (defaultVal==null) {
    		                Map.Entry<K,V> entry = (Map.Entry<K,V>)it.next();
    		                key = entry.getKey();
    		                value = entry.getValue();
    		            } else {
    		                key = (K)it.next();
    		                value = defaultVal;
    		            }
    		        } else { // use stream
    		            key = (K) str.readObject();
    		            value = (defaultVal != null ? defaultVal : (V) str.readObject());
    		        }
    		
    		        Entry<K,V> middle =  new Entry<K,V>(key, value, null);
    		
    	
    		        if (left != null) {
    		            middle.left = left;
    		            left.parent = middle;
    		        }
    		
    		        if (mid < hi) {
    		            Entry<K,V> right = buildFromSorted(level+1, mid+1, hi,
    		                                               it, str, defaultVal);
    		            middle.right = right;
    		            right.parent = middle;
    		        }
    		
    		        return middle;
    		  }

    public Map.Entry<K,V> ceilingEntry(K key) {
    	         return exportEntry(getCeilingEntry(key));
     }
    
    static <K,V> Map.Entry<K,V> exportEntry(MyTreeMap.Entry<K,V> e) {
    	        return e == null? null :
    	            new AbstractMap.SimpleImmutableEntry<K,V>(e);
    }

    	    
    final int  compare(Object k1, Object k2) {
    	        return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
    	            : comparator.compare((K)k1, (K)k2);
    	    }

    final Entry<K,V> getCeilingEntry(K key) {
    	         Entry<K,V> p = root;
    	         while (p != null) {
    	             int cmp = compare(key, p.key);
    	             if (cmp < 0) {
    	                 if (p.left != null)
    	                     p = p.left;
    	                 else
    	                     return p;
    	             } else if (cmp > 0) {
    	                 if (p.right != null) {
    	                     p = p.right;
    	                 } else {
    	                     Entry<K,V> parent = p.parent;
    	                     Entry<K,V> ch = p;
    	                     while (parent != null && ch == parent.right) {
    	                         ch = parent;
    	                         parent = parent.parent;
    	                     }
    	                     return parent;
    	                 }
    	             } else
    	                 return p;
    	         }
    	         return null;
    	 }
    
    
    public void clear() {
    	         size = 0;
    	         root = null;
    }
    
    MyTreeMap<K,V> clone = null;

    public Object clone() {
    	         try {
    	             clone = (MyTreeMap<K,V>) super.clone();
    	         } catch (CloneNotSupportedException e) {
    	             throw new InternalError();
    	         }
    	 
    	         // Put clone into "virgin" state (except for comparator)
    	  
    	         clone.HelperToClone(root);
    	         if(root == null){
    	        	 clone.root = null;
        	         clone.size = 0;
    	         }
    	         return clone;
    }
	
    public void HelperToClone(Entry<K,V> p) {
        if(p != null){
         clone.put(p.getKey(), p.getValue());
         HelperToString(p.right);
         HelperToString(p.left);
       	 
        }
      }
    
    public boolean containsKey(Object key){
    	 return getEntry(key) != null;
    }
    
    final Entry<K,V> getEntryUsingComparator(Object key) {
    	         K k = (K) key;
    	         Comparator<? super K> cpr = comparator;
    	         if (cpr != null) {
    	             Entry<K,V> p = root;
    	             while (p != null) {
    	                 int cmp = cpr.compare(k, p.key);
    	                 if (cmp < 0)
    	                     p = p.left;
    	                 else if (cmp > 0)
    	                     p = p.right;
    	                 else
    	                     return p;
    	             }
    	         }
    	         return null;
    }
    
    final Entry<K,V> getEntry(Object key) {
    				if (comparator != null)
    		             return getEntryUsingComparator(key);
    	         if (key == null)
    	             throw new NullPointerException();
    	         Comparable<? super K> k = (Comparable<? super K>) key;
    	         Entry<K,V> p = root;
    	         while (p != null) {
    	             int cmp = k.compareTo(p.key);
    	             if (cmp < 0)
    	                 p = p.left;
    	             else if (cmp > 0)
    	                 p = p.right;
    	             else
    	                 return p;
    	         }
    	         return null;
    }
     
    public boolean containsValuee(Entry<K,V> p,Object Val) {

        if(p != null){
         
          V val =	p.getValue() ;
          if(val.equals(val)){
        	  return true;
          }
          Boolean val2 = containsValuee(p.left,val);
          if(val2 == true){
        	  return true;
          }
          Boolean val3 = containsValuee(p.right,val);
          if(val3 == true){
        	  return true;
          }
          
        }
        return false;
    }
    
    public boolean containsValue(Object value) {	
    	return containsValuee(root,value);
    }

    public Map.Entry<K,V> firstEntry() {
    	         return exportEntry(getFirstEntry());
    }
    
    final Entry<K,V> getFirstEntry() {
           Entry<K,V> p = root;
           if (p != null)
                while (p.left != null)
                    p = p.left;
           return p;
    }
    
    final Entry<K,V> getLastEntry() {
           Entry<K,V> p = root;
           if (p != null)
               while (p.right != null)
                   p = p.right;
           return p;
   }
    
    Map.Entry<K,V> lastEntry(){
        return exportEntry(getLastEntry());
    }
    
    public V get(Object key) {
         Entry<K,V> p = getEntry(key);
         return (p==null ? null : p.value);
    }
    
    public Comparator<? super K> comparator() {
           return comparator;
    }

    public V put(K key, V value) {
    	         Entry<K,V> t = root;
    	        if (t == null) {
 
    	             root = new Entry<K,V>(key, value, null);
    	             size = 1;
    	             return null;
    	       }
    	        int cmp;
    	         Entry<K,V> parent;
         Comparator<? super K> cpr = comparator;
         if (cpr != null) {
             do {
                 parent = t;
    	                 cmp = cpr.compare(key, t.key);
    	                 if (cmp < 0)
    	                     t = t.left;
    	                 else if (cmp > 0)
    	                     t = t.right;
    	                 else
    	                     return t.setValue(value);
    	             } while (t != null);
    	         }
    	         else {
    	             if (key == null)
    	                 throw new NullPointerException();
    	             Comparable<? super K> k = (Comparable<? super K>) key;
    	             do {
    	                 parent = t;
    	                 cmp = k.compareTo(t.key);
    	                 if (cmp < 0)
    	                     t = t.left;
    	                 else if (cmp > 0)
    	                     t = t.right;
    	                 else
    	                     return t.setValue(value);
    	             } while (t != null);
    	         }
    	         Entry<K,V> e = new Entry<K,V>(key, value, parent);
    	         if (cmp < 0)
    	             parent.left = e;
    	        else
    	             parent.right = e;
                   size++;
         return null;
     }
    
    public V remove(Object key) {
    	         Entry<K,V> p = getEntry(key);
    	        if (p == null)
    	             return null;
    	 
    	         V oldValue = p.value;
    	         deleteEntry(p);
    	         return oldValue;
    	    }
    
    
    static <K,V> MyTreeMap.Entry<K,V> successor(Entry<K,V> t) {
    	        if (t == null)
    	            return null;
    	        else if (t.right != null) {
    	            Entry<K,V> p = t.right;
    	            while (p.left != null)
    	                p = p.left;
    	            return p;
    	        } else {
    	            Entry<K,V> p = t.parent;
    	            Entry<K,V> ch = t;
    	            while (p != null && ch == p.right) {
    	              ch = p;
    	                p = p.parent;
    	            }
    	            return p;
    	        }
    	    }
    
    public int size() {
    	         return size;
    	         
    
    }
    
    private void deleteEntry(Entry<K,V> p) {
    	        size--;
    	
    	        if (p.left != null && p.right != null) {
    	            Entry<K,V> s = successor (p);
    	            p.key = s.key;
    	            p.value = s.value;
    	            p = s;
    	        } // p has 2 children
    	
           Entry<K,V> replacement = (p.left != null ? p.left : p.right);
    	
    	        if (replacement != null) {
    	            // Link replacement to parent
    	            replacement.parent = p.parent;
    	            if (p.parent == null)
    	                root = replacement;
    	            else if (p == p.parent.left)
    	                p.parent.left  = replacement;
    	            else
    	                p.parent.right = replacement;
    	
    	            p.left = p.right = p.parent = null;
    	
    	  
    	        } else if (p.parent == null) { // return if we are the only node.
    	            root = null;
    	        } else { //  No children. Use self as phantom replacement and unlink.
    	         
    	
    	            if (p.parent != null) {
    	                if (p == p.parent.left)
    	                    p.parent.left = null;
    	                else if (p == p.parent.right)
    	                    p.parent.right = null;
    	                p.parent = null;
    	            }
    	        }
    	    }
    
    private Set setA = new HashSet();

   public Collection<V> values(){
	   setA.clear(); 
    	HelperValues(root);
		return setA;
    }
    

    public void HelperValues(Entry<K,V> p) {
     if(p != null){
    	 V val = p.getValue();
    	 

		 setA.add(val);
    	 HelperValues(p.right);
    	 HelperValues(p.left);
    	 
     }
   }
   
    private String toString ;

    public void HelperToString(Entry<K,V> p) {
        if(p != null){
         toString += " Key =" + p.getKey() + " Value = " + p.getValue() + "\n";
         HelperToString(p.right);
         HelperToString(p.left);
       	 
        }
      }

   public String toString(){
	   toString ="";
	   HelperToString(root);
	   return toString;
    }

    @Override
     public Set<java.util.Map.Entry<K, V>> entrySet() {
    			// TODO Auto-generated method stub
	     return null;
   }
    
}