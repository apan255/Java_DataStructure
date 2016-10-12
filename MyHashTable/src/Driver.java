/**
 * Driver - for MyHashTable generic class.
 * 
 * @author robertirwin
 *
 */

class MyItem<Key> implements KeyedValue<Key>
{
    Key key;
    String name;
    int age;
    
    MyItem( Key k, String n, int a) {
        key = k;
        name = n;
        age = a;
    }

    public Key getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "item with key " + getKey() + ": \n" +
                "\tKey: " + getKey() + "\n" + 
                "\tName: " + getName() + "\n" + 
                "\tAge: " + getAge();          
    }    
}

public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        MyHashTable<String,MyItem<String>> t = new MyHashTable<String,MyItem<String>>();
        MyItem<String> i = new MyItem<String>("123456789","Joe Schmoe",49);
        MyItem<String> j = new MyItem<String>("987654321","Ajay Bloosh",23);
        MyItem<String> k = new MyItem<String>("101010101","Tara Boomdeay",30);
        
        
        
        System.out.println( " Hash map isEmpty() " + t.isEmpty());
        System.out.println( "");
        System.out.println( " Insert  an item with key == 123456789 , name == Joe Schmoe ,age =49" );
        MyItem zz = t.insert(i);
        
        System.out.println( "Item Inserted " + zz );
        System.out.println( "");

        System.out.println( " Hash map isEmpty() " + t.isEmpty());
        System.out.println( "");

        System.out.println( " Insert  an item with key == 123456789 , name == den Schmoe ,age =50" );
        MyItem<String> k2 = new MyItem<String>("123456789","den Schmoe",50);
	    MyItem kk = t.insert(k2);
        System.out.println( "Item Inserted " + kk );
        System.out.println( "");

        System.out.println( " Insert  an item with key == 987654321 , name == Ajay Bloosh ,age =23" );

        t.insert(j);
        System.out.println( " Insert  an item with key == 101010101 , name == Tara Boomdeay ,age =30" );

        t.insert(k);
        System.out.println( "");

        
        
        System.out.println( "size  of Hash map  == " + t.size() );  
        System.out.println( "");

        System.out.println( "Max of hash map  " + t.max());
        System.out.println( "");

        System.out.println( " Min of hash map " + t.min());
        System.out.println( "");

        
        System.out.println( "Keys of HashMap"  ); 
        Object[] mykeys = t.keyArray();

        for(int jj=0;jj < mykeys.length;jj++){
      	  
   		  System.out.println( "print key itr === " + mykeys[jj] );      
        }
        System.out.println( "");

        System.out.println( " Clearing HashMap" );
        t.clear();
        System.out.println( "size  of Hash map  == " + t.size() );  
        System.out.println( " Hash map isEmpty() " + t.isEmpty());
        System.out.println( "");


    }
}
