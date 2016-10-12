import java.math.BigInteger;

/**
 * Tests Frac class.
 * 
 * @author robertirwin
 *
 */

public class Driver
{
    public static void main( String args[] )
    {
    	
    	BigInteger val22 = new BigInteger(Integer.toString(22));
    	BigInteger val7 = new BigInteger(Integer.toString(7));
    	BigInteger val2 = new BigInteger(Integer.toString(2));
    	BigInteger val3 = new BigInteger(Integer.toString(3));
    	BigInteger val6 = new BigInteger(Integer.toString(6));
    	BigInteger valNeg8 = new BigInteger(Integer.toString(-8));
    	
        Frac p = new Frac(val22,val7);
        
        Frac q = new Frac(val2,val3);
        Frac r = new Frac(val6,valNeg8);
        Frac s = new Frac();

        System.out.println( (p instanceof Frac) );   // introspection!

   
        System.out.println(); 

        System.out.println( "The value of p is " + p );  // + is String concatenation; p implicitly converted to String via toString method
        System.out.println( "The value of q is " + q );
        System.out.println( "The value of r is " + r );
        System.out.println( "The value of s is " + s + "\n" ); 
   
        byte b = 2; 
        short h = 2;  
        int i = 2; 
        long l = 2; 
        char c = 2;
        
       
        Byte B = new Byte(b); 
        Short H = new Short(h);  
        Integer I = new Integer(i);  
        Long L = new Long(l);
        Character C = new Character(c);
        
        
        BigInteger val_1 = new BigInteger(Integer.toString(b));
        BigInteger val_2 = new BigInteger(Integer.toString(h));
        BigInteger val_3 = new BigInteger(Integer.toString(i));
        BigInteger val_4 = new BigInteger(Long.toString(l));
        BigInteger val_5 = new BigInteger(Integer.toString(c));
        
        
        BigInteger val_6 = new BigInteger(Integer.toString(B));
        BigInteger val_7 = new BigInteger(Integer.toString(H));
        BigInteger val_8 = new BigInteger(Integer.toString(I));
        BigInteger val_9 = new BigInteger(Long.toString(L));
        BigInteger val_10 = new BigInteger(Integer.toString(C));

        
        System.out.println( "The value of p+b is " + (p.add(val_1)) ); // 1
        System.out.println( "The value of p+h is " + (p.add(val_2)) ); // 2
        System.out.println( "The value of p+i is " + (p.add(val_3)) ); // 3
        System.out.println( "The value of p+l is " + (p.add(val_4)) ); // 4
        System.out.println( "The value of p+c is " + (p.add(val_5)) ); // 5
        System.out.println( "The value of p+B is " + (p.add(val_6)) ); // 6
        System.out.println( "The value of p+H is " + (p.add(val_7)) ); // 7
        System.out.println( "The value of p+I is " + (p.add(val_8)) ); // 8
        System.out.println( "The value of p+L is " + (p.add(val_9)) ); // 9
        System.out.println( "The value of p+C is " + (p.add(val_10)) ); // 10

        
        System.out.println( "Numerator of p is " + p.getNumerator() );
        System.out.println( "Denominator of p is " + p.getDenominator() );
        System.out.println( "Now set p to 1/2 via writers..." );
        
        BigInteger vall1 = new BigInteger(Integer.toString(1));
    	BigInteger vall2 = new BigInteger(Integer.toString(2));
        
        p.setNumerator( vall1 );
        p.setDenominator( vall2 );
        System.out.println( "The value of p is " + p );
        System.out.print( "\n" );  // note difference between print vs. println
        
        System.out.println( "The value of 1/p is " + p.invert() );     // unary inversion operation
        System.out.println( "The value of 1/s is " + s.invert() );     // "
        System.out.println( "The value of r+s is " + r.add(s) );       // binary add operation
        System.out.println( "The value of s+r is " + s.add(r) );       // "
        System.out.println( "The value of q+r is " + q.add(r) );
        System.out.println( "The value of q-r is " + q.subtract(r) );
        System.out.println( "The value of q*r is " + q.multiply(r) );
        System.out.println( "The value of q/r is " + q.divide(r) );
        System.out.println( "The value of 1/(p+q) is " + p.add(q).invert() );  // composing operations
        System.out.println( "The value of s = p/(q*r) is " + (s = p.divide(q.multiply(r))) );  // note assignment
        System.out.println( "The value of s is " + s );
        System.out.println();
        
        System.out.print( "Please enter a new fraction p value (as n/d): ");
        p.read();
        p.write();
        
    }
}
