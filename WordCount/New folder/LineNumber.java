
import java.io.*;
import java.util.Scanner;

public class LineNumber {
	

	     
		private static Scanner sysIn;

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			//FileWriter out = null;
		
			try {
				sysIn = new Scanner(System.in);
				String s="";
				
				 int val = 1;
				 while ( sysIn.hasNextLine() )
				 {
					 String str1 = String.format("%05d", val);
					 s = sysIn.nextLine();
					 String my_new_str2 = str1 + " " + s;
					 System.out.println(my_new_str2);
					 val++;
				 }
	  			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
			}
		}
					

}
