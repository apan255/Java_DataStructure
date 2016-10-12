da.

import java.io.*;
import java.util.ArrayList;

public class Omar {

    public Omar(){
	}
    
    
    public boolean numberOfVerses(String filepathCheck) {
		
    	Integer countVerses = 0;
		FileReader in = null;
		BufferedReader br = null;

		try {
			in = new FileReader(filepathCheck);
			
			//out.write(0);
			br = new BufferedReader(in);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("I") || line.contains("II") ) {
					
					countVerses++;
				}
			}
			
			if(countVerses >= 2){
				return true;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;	
   }

    public void printTwoVerses(String filepathCheck) throws Exception {

    	ArrayList<String> storeVerses1 = new ArrayList<String>();
    	ArrayList<String> storeVerses2 = new ArrayList<String>();

		FileReader in = null;
		//FileWriter out = null;
		BufferedReader br = null;
		try {
              in = new FileReader(filepathCheck);
			
			//out.write(0);
			br = new BufferedReader(in);
			String line;
			Boolean startStroringVersesI = false;
			Boolean startStroringVersesII = false;
			Boolean stopStoring = false;

			while ((line = br.readLine()) != null) {
			    if(line.isEmpty()){
			    	continue;
			    }
				if (line.contains("III")) {
					startStroringVersesII = false;
					startStroringVersesI = false;
					stopStoring = true;
				}
				
				if (line.contains("II")) {
					startStroringVersesI = false;
				}
				
				if(startStroringVersesI){
					storeVerses1.add(line);
				}
				if(startStroringVersesII){
					storeVerses2.add(line);
				}
				
				if (line.contains("I") && (line.length() == 1)) {
					startStroringVersesI = true;
				}
				if (line.contains("II")) {
					startStroringVersesII = true;
					startStroringVersesI = false;

				}
				
				if(stopStoring){
					break;
				}
			}
			
			
           for(int i =0; i< storeVerses1.size() ; i++ )	{
        	   if(i == 0 || i == 1){
        		   System.out.println( storeVerses1.get(i) );
        	   }else{
        		   
        		   if(i == (storeVerses1.size()-1)){
            		   System.out.println( storeVerses1.get(i) );

        		   }else{
            		   System.out.println("..." );
        		   }   
        	   }
           }
           
           System.out.println("");
           
           for(int i =0; i< storeVerses2.size() ; i++ )	{
        	   if(i == 0 || i == 1){
        		   System.out.println( storeVerses2.get(i) );
        	   }else{
        		   
        		   if(i == (storeVerses2.size()-1)){
            		   System.out.println( storeVerses2.get(i) );

        		   }else{
            		   System.out.println("..." );
        		   }   
        	   }
           }
			
		} finally {
			if (in != null) {
				in.close();
			}
		}

	}
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Omar da = new Omar();
		try {
			System.out.println("****************************************************");
			System.out.println("Test Case1 : Checking two verses exit or not");
			System.out.println("****************************************************");
            System.out.println("" );

			
		
			     String file1 = "TestFiles/TestCase1.txt";
                 if(da.numberOfVerses(file1) == false){
                	 System.out.println("Number of Verses are less than expected");
                 }
                 
                 System.out.println("" );
                 System.out.println("" );
                 System.out.println("" );
                 System.out.println("****************************************************");
     			System.out.println("Test Case2 : Printing two verses from my fav poem");
     			System.out.println("****************************************************");
                System.out.println("" );

                 String file2 = "TestFiles/TestCase2.txt";
                 if(da.numberOfVerses(file2) == false){
                	 System.out.println("Number of Verses are less than expected");
                 }else{
                	 da.printTwoVerses(file2);
                 }
                 System.out.println("" );
                 System.out.println("" );
                 System.out.println("" );

                 
                 System.out.println("****************************************************");
      			System.out.println("Test Case3 : Printing two verses from  Rubaiyat of Omar Khayyam poem");
      			System.out.println("****************************************************");
                System.out.println("" );

                  String file3 = "TestFiles/TestCase3.txt";
                  if(da.numberOfVerses(file3) == false){
                 	 System.out.println("Number of Verses are less than expected");
                  }else{
                 	 da.printTwoVerses(file3);
                  }
                  
                 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}
	}
}
