import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToLower {
     
			private static Scanner sysIn;

			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
		    	ArrayList<String> storeData = new ArrayList<String>();
				//FileWriter out = null;
			
				try {
					sysIn = new Scanner(System.in);
					String s="";
					 while ( sysIn.hasNextLine() )
					 {
						 s = sysIn.nextLine() ;
						 for ( int i = 0; i < s.length(); ++i )
						 {
							 if(Character.isUpperCase(s.charAt(i)))
							 {
								 s=s.toLowerCase();
							 }
						 }
						 System.out.println(s);
		  				 storeData.add(s);
					 }
		  			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
				}
			}
				
}
