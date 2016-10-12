
import java.io.*;

public class driver {    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		multithreadedMatrixMul da = new multithreadedMatrixMul();
		try {
			
			
		
			System.out.println("****************************************************");
			System.out.println("Read the two input matrices from a text file, and print them out neatly");
			System.out.println("****************************************************");
            System.out.println("" );
			String file1 = "TestFiles/matrix2d.txt";
			
            da.getMatrix(file1);
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("****************************************************");
			System.out.println("check that matrix dimensions allow multiplication; if not, complain and quit");
			System.out.println("****************************************************");
            System.out.println("" );
            
            Boolean val2 = da.checkMatrixCanBeMultiplied();
            if(val2){
     		   System.out.println(" Matrix Can be multiplied");
            }else{
     		   System.out.println("Matrix Can't be multiplied ");
            }
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );

            System.out.println("****************************************************");
       	    System.out.println("Matrix multiply without thread");
       		System.out.println("****************************************************");
            System.out.println("" );
            da.simpleMatrixMul();
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" ); 
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("****************************************************");
			System.out.println("Spin off threads to work concurrently on the computation of the product matrix");
			System.out.println("****************************************************");
            System.out.println("" );
            da.executeMul();
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
            System.out.println("" );
                 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}
	}
}
