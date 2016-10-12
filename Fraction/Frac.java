import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * The <code>Frac</code> class represents fractions (i.e., rational numbers).  
 * <code>Frac</code> values are always maintained in normalized form (see
 * {@link #reduce() reduce()} below).

 */
public class Frac
{
    // fields -------------------------------------------------

    /** Holds fraction's numerator */
    private BigInteger  nu;  
    /** Holds fraction's denominator */
    private BigInteger  de;  
   // new BigInteger(Integer.toString(intValue))
    // methods ------------------------------------------------

    // constructors
    /** Default constructor; yields Frac with initial value 1/0 (invalid). */
    public Frac () { nu = new BigInteger(Integer.toString(1));  de = new BigInteger(Integer.toString(0)); }
    /** Constructs a Frac with specified initial numerator and denominator values.
     * @param n the initial value of the numerator
     * @param d the initial value of the denominator
     */
    public Frac ( BigInteger n, BigInteger d ) { nu = n;  de = d; reduce(); }  // explicit value constructor

    // accessors
    /** Returns current denominator value.
     * @return current value of de field */
    public BigInteger getDenominator() { return de; }
    /** Returns current numerator value. 
     * @return current value of nu value */
    public BigInteger getNumerator() { return nu; }
    /** Sets numerator to <em>post-reduction</em> value of parameter.
     * @param n new nu value; the stored value may be different due to reduction */
    public void setNumerator( BigInteger n ) { nu = n;  reduce(); }
    /** Sets denominator to <em>post-reduction</em> value of parameter.
     * @param d new de value; the stored value may be different due to reduction */
    public void setDenominator( BigInteger d ) { de = d;  reduce(); }

    // arithmetic
    /** Creates new fraction equal to inverted value of target fraction. 
     * @return new Frac instance equal to inverted value of target object */
    public Frac invert()  { return (de.intValue() == 0) ? new Frac() : new Frac(de, nu); }
    /** Creates new <code>Frac</code> equal to sum of target <code>Frac</code> and specified <code>Frac</code>.
     * @param q Frac object to be added to target Frac object
     * @return new Frac instance representing the sum of target object and q */
    
   
    public Frac add( Frac q )  { 
    	    
    	BigInteger  nuTemp = new BigInteger(Integer.toString(((nu.intValue()) * q.de.intValue() + (de.intValue()) * (q.nu.intValue()))));
    	BigInteger  deTemp = new BigInteger(Integer.toString((   (de.intValue()) * (q.de.intValue()) )));
    	return new Frac(nuTemp,deTemp); 
    	
    }
    /** Creates new <code>Frac</code> equal to sum of target <code>Frac</code> and specified integer.
     * @param l integer value to be added to target fraction
     * @return new Frac instance representing the sum of target object and l */
    public Frac add( BigInteger l )  { 
    	BigInteger  nuTemp = new BigInteger(Integer.toString( nu.intValue() + de.intValue() * l.intValue()));
    //	BigInteger  deTemp = new BigInteger(Integer.toString(1));
    	return new Frac(nuTemp, de); 
    	
    }
    /** Creates new <code>Frac</code> equal to difference of target <code>Frac</code> and specified <code>Frac</code>.
     * @param q Frac object to be subtracted from target Frac object
     * @return new Frac instance representing the difference of target object and q */
   public Frac subtract( Frac q )   {  
		  	BigInteger  nuTemp = new BigInteger(Integer.toString(((nu.intValue()) * q.de.intValue() - (de.intValue()) * (q.nu.intValue()))));
	BigInteger  deTemp = new BigInteger(Integer.toString((   (de.intValue()) * (q.de.intValue()) )));
		   
	return	new Frac(nuTemp,deTemp); 
   }
   /** Creates new <code>Frac</code> equal to difference of target <code>Frac</code> and specified integer.
    * @param l integer value to be subtracted from target fraction
    * @return new Frac instance representing the difference of target object and l */
    public Frac subtract( BigInteger l )   { 
    	BigInteger  nuTemp = new BigInteger(Integer.toString( nu.intValue() - de.intValue() * l.intValue()));
    	return new Frac(nuTemp, de); 
    	
    }
    /** Creates new <code>Frac</code> equal to product of target <code>Frac</code> and specified <code>Frac</code>.
     * @param q Frac object by which to multiply target fraction
     * @return new Frac instance representing the product of target object and q */
    public Frac multiply( Frac q )  { 
	  	BigInteger  nuTemp = new BigInteger(Integer.toString((nu.intValue()) * q.nu.intValue()));
	BigInteger  deTemp = new BigInteger(Integer.toString((   (de.intValue()) * (q.de.intValue()) )));
		   
    	
    	return new Frac(nuTemp, deTemp); 
    	
    
    }
    /** Creates new <code>Frac</code> equal to product of target <code>Frac</code> and specified integer.
     * @param l integer by which to multiply target fraction
     * @return new Frac instance representing the product of target object and l */
    public Frac multiply( BigInteger l )  { 
    	
	  	BigInteger  nuTemp = new BigInteger(Integer.toString((nu.intValue()) * l.intValue()));

    	return new Frac(nuTemp, de); }
    
    
    /** Creates new <code>Frac</code> equal to quotient of target <code>Frac</code> and specified <code>Frac</code>.
     * @param q Frac object by which to divide target Frac object
     * @return new Frac instance representing the quotient of target object and q */
    
    
    public Frac divide( Frac q )  { 
    	
	 // 	BigInteger  Value1 = new BigInteger(Integer.toString((nu.intValue()) * l.intValue()));
	  	BigInteger  Value2 = new BigInteger(Integer.toString((nu.intValue()) * q.de.intValue()));
	  BigInteger  Value3 = new BigInteger(Integer.toString((   (de.intValue()) * (q.nu.intValue()) )));
	  	
	  	
    	return ((de.intValue() *q.de.intValue()) == 0) ? new Frac() : new Frac(Value2,Value3); 
    	
    }
    /** Creates new <code>Frac</code> equal to quotient of target <code>Frac</code> and specified integer.
     * @param l integer by which to divide target Frac object
     * @return new Frac instance representing the quotient of target object and l */
    public Frac divide( BigInteger l)  { 
    	
	  //	BigInteger  Value2 = new BigInteger(Integer.toString((nu.intValue()) * q.de.intValue()));
	  BigInteger  Value3 = new BigInteger(Integer.toString((   (de.intValue()) * (l.intValue()) )));
	  	
    	return ((de.intValue()*l.intValue()) == 0) ? new Frac() : new Frac(nu, Value3);
    	
    
    }

    // string-ization and I/O
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() { return (de.intValue() == 1) ? nu + "" : nu + "/" + de; }
    /** Write <code>Frac</code> value to standard output stream. */
    public void write()  { System.out.print( this ); }
    /** Create a Frac instance from fraction value specified in standard input stream.
     * @return new Frac instance representing the input fraction (in normalized form)
     */
    public Frac read()  
    {
        Scanner s = new Scanner(System.in);       // associate Scanner object with standard input stream
        s.findWithinHorizon("(-?\\d+)\\s*/\\s*(-?\\d+)",0);// scan standard input for regular expression pattern
        MatchResult result = s.match();           // collect subtrings matched by "capturing groups" in the pattern (in parentheses)
        s.close();     
      //  BigInteger.par
        // scanner no longer needed
        
        Long nuTmp = Long.parseLong(result.group(1));  
        String NuTmpStr = nuTmp.toString();
         nu = new BigInteger( NuTmpStr );

        // use first match group to set new nu value
        // nu = Integer.valueOf(result.group(1)); // another way to assign int value for nu from String; RHS is an Integer, automatically "unboxed" to an int
        
         Long deTmp = Long.parseLong(result.group(2));  
         String deTmpStr = deTmp.toString();
          de = new BigInteger( deTmpStr );
        
       // de = Long.parseLong(result.group(2));     // use second match group to set new de value
        // de = new Integer(result.group(2));     // another alternative way assign int value for de; RHS is an Integer, automatically "unboxed" to an int
        reduce();
        return this;
    }

    // private auxiliaries (the first two are class methods, indicated by 'static' keyword)
    /** The signum function, testing whether an integer is less than, equal to, or greater than zero.
     * @param i integer to be tested
     * @return -1 if i &lt; 0, 0 if i == 0 and +1 if i &gt; 0  
     */
    private static int sgn( BigInteger i )  { return i.intValue() < 0 ? -1 : (i.intValue() > 0 ? 1 : 0); }           // signum function
    /** Computes the greatest common divisor of two integers, via Euclid's algorithm.
     * @param i one of the two integers
     * @param j the other of the two integers
     * @return greatest common divisor of i and j
     */
    private static BigInteger gcd( BigInteger i, BigInteger j)  {
    	BigInteger  Value3 = null;
    	if(j.intValue() != 0){
    		Value3 = new BigInteger(Integer.toString((   (i.intValue()) % (j.intValue())   )));
    	}
    	
    	return (j.intValue() == 0) ?  i : gcd (j, Value3 );
    	
    }
    // greatest common denominator
    /** Normalizes representation of target <code>Frac</code> object.
     * Normalization means adjusting the numerator and denominator to yield an equal value such that:
     * <ul>
     * <li>numerator and denominator are reduced to lowest terms</li>
     * <li>only the numerator may be negative (the denominator value will always be non-negative)</li>
     * <li>invalid fractions are stored as 1/0</li>
     * <li>zero-valued fractions are stored as 0/1</li>
     * </ul>
     * It is important to note that <code>reduce()</code> mutates the target object.
     * @return normalized Frac instance
     */
    private Frac reduce()  // reduce to lowest terms & normalize (0/1 represents 0, sign carried by numerator only)
    {
    	BigInteger g;
    	  BigInteger  Value1 = new BigInteger(Integer.toString((   Math.abs(nu.intValue())  )));
      	  BigInteger  Value2 = new BigInteger(Integer.toString((   Math.abs(de.intValue())  )));

        g = gcd(Value1 , Value2);
        if ( de.intValue() != 0 )
        {
        	
       	 BigInteger  Value3 = new BigInteger(Integer.toString((   Math.abs(nu.intValue()/g.intValue())  )));
    	  BigInteger  Value4 = new BigInteger(Integer.toString((   -Math.abs(nu.intValue()/g.intValue())  )));
       // de != 0 implies g != 0
  	  BigInteger  Value7 = new BigInteger(Integer.toString((   Math.abs(de.intValue()/g.intValue())  )));
      
        	
        	
        
            nu = (sgn(nu) == sgn(de)) ? Value3 : Value4;
            de = Value7;
        }
        else
        {
        	 BigInteger  Value5 = new BigInteger(Integer.toString((   1  )));
         	  BigInteger  Value6 = new BigInteger(Integer.toString((   0  )));
            nu = Value5;
            de = Value6;
        }
        return this;
    }
}
