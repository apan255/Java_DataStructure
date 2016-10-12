//package hw3;

import java.util.Scanner;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GaussianRational 
{
	private Frac aValue;
	private Frac bValue;
	boolean checkInvalidValue;
	
	GaussianRational(){
		checkInvalidValue = true;
	//	System.out.println("hello 4");

	}
	GaussianRational(Frac a, Frac b)
	{
		checkInvalidValue = false;
		aValue = a;
		bValue = b;
	}
	
	GaussianRational(long p, long q, long m, long n)
	{
		Frac pF = new Frac(p,q);
    	Frac qF = new Frac(m,n);
		
		checkInvalidValue = false;

		aValue = pF;
		bValue = qF;

	}
	
	GaussianRational(GaussianRational g)
	{
		checkInvalidValue = false;

		this.aValue = g.aValue ;
		this.bValue = g.bValue;
	}
	
	public GaussianRational add(GaussianRational r)
	{
		if(checkInvalidValue)
		{
			System.out.println("Invalid Value");
		}
		Frac c = (this.aValue).add(r.aValue);
		Frac d = (this.bValue).add(r.bValue);
		
		return new GaussianRational(c,d);
	}
	
	public GaussianRational subtract(GaussianRational r)
	{
		if(checkInvalidValue)
		{
			System.out.println("Invalid Value");
		}
		Frac c = (this.aValue).subtract(r.aValue);
		Frac d = (this.bValue).subtract(r.bValue);
		
		return new GaussianRational(c,d);
	}
	
	public GaussianRational multiply(GaussianRational r) 
	{
		// (a + BI) (c + DI) = ac + adi + bci + bdi 2 = (ac - bd) + (ad +bc) i
		Frac ac = (this.aValue).multiply(r.aValue);
		Frac bd = (this.bValue).multiply(r.bValue);
		Frac ad = (this.aValue).multiply(r.bValue);
		Frac bc = (this.bValue).multiply(r.aValue);
		
		return new GaussianRational(ac.subtract(bd),ad.add(bc));
	}
	
	public GaussianRational divide(GaussianRational r)
	{
		if(checkInvalidValue)
		{
			System.out.println("Invalid Value");
		}
		
	//	(a + BI) / (c + DI) = (ac + BD)/(c 2 + d 2) + (BC - ad)/(c 2 +d 2) i
		
				Frac ac = (this.aValue).multiply(r.aValue);
				Frac bd = (this.bValue).multiply(r.bValue);
				Frac ad = (this.aValue).multiply(r.bValue);
				Frac bc = (this.bValue).multiply(r.aValue);
				
				
				Frac e = (r.aValue).multiply(r.aValue);
				Frac f = (r.bValue).multiply(r.bValue);
				Frac h = (e).add(f);
				
		Frac c = ac.add(bd);
		Frac d = bc.subtract(ad);
		
		return new GaussianRational(c.divide(h),d.divide(h));
	}
	
	public GaussianRational invert()
	{
		if(checkInvalidValue)
		{
			System.out.println("Invalid Value");
		}
		
		//1/(a + BI) = a/(a 2 + b 2) - b/(a 2 + b 2) i
		
		Frac e = (this.aValue).multiply(this.aValue);
		Frac f = (this.bValue).multiply(this.bValue);

		Frac h = (e).add(f);
	  
		Frac c = this.aValue.divide(h);
		Frac d = this.bValue.divide(h);
		d = (d).multiply(-1);
		return new GaussianRational(c,d) ;
	}
	
	@Override
	public String toString()
	{
		if(checkInvalidValue)
		{
			return "Invalid Value";
		}

		String x = (this.aValue).toString();
		String y = (this.bValue).toString();
		return "(" + x + ")" + "+" + "(" + y +")" + "i";
	}
	
	public void read(Boolean val) throws IOException
	{
		
		if(val == true){
		System.out.print( "Please enter a new GaussianRational p == (a/b) + (c/d)i value as 'a/b' first then 'c/d':");		
		Scanner s = new Scanner(System.in);       // associate Scanner object with standard input stream
        s.findWithinHorizon("(-?\\d+)\\s*/\\s*(-?\\d+)",0);// scan standard input for regular expression pattern
      //  s.next("(-?\\d+)\\s*/\\s*(-?\\d+)")
      
        MatchResult result = s.match();    
    
        // collect subtrings matched by "capturing groups" in the pattern (in parentheses)
                                   // scanner no longer needed
       long a = Long.parseLong(result.group(1));     // use first match group to set new nu value
       long b = Integer.valueOf(result.group(2));
       Frac pF = new Frac(a,b);
       this.aValue = pF;

		}else{
			System.out.print( "Please enter (c/d) now:");
		    Scanner s = new Scanner(System.in);       // associate Scanner object with standard input stream
	        s.findWithinHorizon("(-?\\d+)\\s*/\\s*(-?\\d+)",0);// scan standard input for regular expression pattern
	      //  s.next("(-?\\d+)\\s*/\\s*(-?\\d+)")
	      
	        MatchResult result = s.match();    
	    
	        // collect subtrings matched by "capturing groups" in the pattern (in parentheses)
	                                   // scanner no longer needed
	       long a = Long.parseLong(result.group(1));     // use first match group to set new nu value
	       long b = Integer.valueOf(result.group(2));
	       Frac pF = new Frac(a,b);
	       this.bValue = pF;
		}
	}
	
	public void write()
	{
		System.out.println(toString());
	}
	

}
