import java.io.IOException;

public class Driver
{
    public static void main( String args[] ) throws IOException
    {
        
    	
    	//Constructors
    	System.out.println( "***** Demonstrating Constructors *****" );
    	System.out.println(); 
    	System.out.println("Show Default Contrucutor GaussianRational()");
    	GaussianRational p1 = new GaussianRational() ;
    	System.out.println(p1.toString());
    	System.out.println("Show explicit value constructor Frac(22,7) and Frac(2,3) ");
    	Frac pF = new Frac(4,5);
    	Frac qF = new Frac(2,3);
    	GaussianRational p2 = new GaussianRational(pF,qF) ;
    	System.out.println(p2.toString());
    	System.out.println("Show explicit value constructor long l = 2; long c = 2 ;long d = 3; long e = 2 ; ");
    	long l = 2; long c = 2 ;long d = 3; long e = 2;
    	GaussianRational p3 = new GaussianRational(l,c,d,e) ;
    	System.out.println(p3.toString());
    	System.out.println("Show copy constructor GaussianRational p4 = p3 ");
    	GaussianRational p4 = p3;
    	System.out.println(p4.toString());
    	System.out.println("Show copy constructor GaussianRational p5( p2) ");
    	GaussianRational p5 = p2;
    	System.out.println(p5.toString());
    	
    	
    	//Arithmetic
    	System.out.println(); 
    	System.out.println( "***** Demonstrating Arthmetic *****" );
    	System.out.println(); 
    	
        System.out.println(" Add: (a + bi) + (c + di) = (a+c) + (b + d) i");

        System.out.println( "The value of p2+p3 (add) is " + (p2.add(p3)) );
    	System.out.println(); 

        System.out.println(" Subtract: (a + bi) + (c + di) = (a-c) + (b - d) i");

        System.out.println( "The value of p2-p3(subtract) is " + (p2.subtract(p3)) );
    	System.out.println(); 

        System.out.println(" Multiply: (a + BI) (c + DI) = ac + adi + bci + bdi 2 = (ac - bd) + (ad +bc) i");

        System.out.println( "The value of p2*b3(multiply) is " + (p2.multiply(p3)) );
    	System.out.println(); 

        System.out.println("Divide: (a + BI) / (c + DI) = (ac + BD)/(c 2 + d 2) + (BC - ad)/(c 2 +d 2) i  ");

        
        System.out.println( "The value of p2/b3(divide) is " + (p2.divide(p3)) );
    	System.out.println(); 

        System.out.println("Invert: 1/(a + BI) = a/(a 2 + b 2) - b/(a 2 + b 2) i ");

        System.out.println( "The value of p2(invert) is " + p2.toString() );
            	GaussianRational p10 = p2.invert();
    	System.out.println(p10.toString());
    	System.out.println(); 

       
    	// Tostring 
    	
    	System.out.println(); 
    	System.out.println( "***** Demonstrating Tostring *****" );
    	System.out.println(" p2.toString() instanceof String === ");
    	System.out.println( p2.toString() instanceof String); 
    	

    	// Tostring 
    	
    	System.out.println(); 
    	System.out.println( "***** Demonstrating Tostring *****" );
    	System.out.println(" p2.toString() instanceof String === ");
    	System.out.println( p2.toString() instanceof String); 
    	
    	//
    //	read()   (read Gaussian rational number from standard input and set target object accordingly -- use regular expression matching)
    //	write()   (write value of target to standard output)
    	System.out.println(); 
    	System.out.println( "***** Demonstrating Read() and write() *****" );
    	System.out.println("***** Demonstrating Read() *****");
    	 
        p2.read(true);
        p2.read(false);
      	System.out.println("***** Demonstrating write() *****");

        p2.write();
        System.out.println("***** End *****");
     
        
    }
}