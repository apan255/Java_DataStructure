import java.io.*;
import java.util.Scanner;

public class CalmDown {
     
	private static Scanner sysIn;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileWriter out = null;
	
		try {
			sysIn = new Scanner(System.in);
			String s="";
			 while ( sysIn.hasNextLine() )
			 {
				 s = sysIn.nextLine();
				 String my_new_str2 = "";
				 for ( int i = 0; i < s.length(); ++i )
				 {
					 String my_new_str = s.replaceAll("!!", ".");
					  my_new_str2 = my_new_str.replaceAll("!", ".");
				 }
				 System.out.println(my_new_str2);
			 }
  			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}
	}
				
}
