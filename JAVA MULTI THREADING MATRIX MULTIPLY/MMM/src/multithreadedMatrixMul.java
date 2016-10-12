
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class multithreadedMatrixMul  {

    private Integer matrix_Row_A = 0;
    private Integer matrix_Col_A = 0;
    private Integer matrix_Row_B = 0;
    private Integer matrix_Col_B = 0;
    private Integer matrix_Row_c = 0;
    private Integer matrix_Col_c = 0;
    private Integer matrix_Row_d = 0;
    private Integer matrix_Col_d = 0;
   
    public static threadWork [][] Threads = new threadWork[3][3];

    
    float[][] aMatrix = null;
    float[][] bMatrix = null;
    float[][] cMatrix = null;
    float[][] dMatrix = null;

   public void getMatrix(String filepathCheck) {
		
    
		FileReader in = null;
		BufferedReader br = null;

		try {
			in = new FileReader(filepathCheck);

			//out.write(0);
			br = new BufferedReader(in);
			String line;			
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split(" ");
				matrix_Row_A = Integer.parseInt(tokens[0]);
				matrix_Col_A = Integer.parseInt(tokens[1]);
				aMatrix= new float[matrix_Row_A][matrix_Col_A];

				for(int k=0;k<matrix_Row_A;k++){
					if((line = br.readLine()) != null){
						String[] tokens2 = line.split(" ");
						for(int z=0;z<matrix_Col_A;z++){
							aMatrix[k][z] = Integer.parseInt(tokens2[z]);

						}
					}
				}
				if((line = br.readLine()) != null){
				String[] tokens3 = line.split(" ");
				matrix_Row_B = Integer.parseInt(tokens3[0]);
				matrix_Col_B = Integer.parseInt(tokens3[1]);
				bMatrix= new float[matrix_Row_B][matrix_Col_B];
				int k=0;
				for(;k<matrix_Row_B;k++){
					if((line = br.readLine()) != null){
						String[] tokens4 = line.split(" ");
						for(int kk=0;kk<matrix_Col_B;kk++){
							bMatrix[k][kk] = Integer.parseInt(tokens4[kk]);
						}
					}
				}
				 if(matrix_Row_B == k){
					 break;
				 }
				
				
			  }
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		System.out.println("***** Printing Matrix A *****");
		printMatrix(aMatrix,matrix_Row_A,matrix_Col_A);
		
		System.out.println("***** Printing Matrix B *****");
		printMatrix(bMatrix,matrix_Row_B,matrix_Col_B);

   }
    
   public void printMatrix(float[][] dMatrix,Integer row, Integer col){

	   for(int i = 0 ; i <row;i++){
		   for(int j=0; j< col;j++){
			   
			   System.out.print(dMatrix[i][j]);
			   System.out.print(" ");
		   }
		   System.out.println(" ");
	   }
   }
   
   
   public Boolean checkMatrixCanBeMultiplied(){
	   Boolean val = true;
	   
	   if(matrix_Col_A == matrix_Row_B){
		   return val;
	   }
	   return false;
   }
   


   
  public void simpleMatrixMul(){
	  matrix_Row_d = matrix_Row_A;
  	  matrix_Col_d = matrix_Col_B;
	  dMatrix= new float[matrix_Row_d][matrix_Col_d];
      System.out.println(" Simple multipied mtarix without thread started ");

      long startTime = System.nanoTime();
	  for (int i = 0; i < matrix_Row_A; i++) { // aRow
          for (int j = 0; j < matrix_Col_B; j++) { // bColumn
              for (int k = 0; k < matrix_Col_A; k++) { // aColumn
            	  dMatrix[i][j] += aMatrix[i][k] * bMatrix[k][j];
              }
          }
      }
      long time = System.nanoTime() - startTime;
      System.out.println(" Matrix mul completed in ns = "+ time);

	  System.out.println("***** Printing Matrix D [ Simple multipied mtarix without thread]: *****");
		printMatrix(dMatrix,matrix_Row_d,matrix_Col_d);
  }

    public void executeMul() {
    	
    	 try {
    		 
    	        
    	        System.out.println("***** Printing Matrix A *****");
    			printMatrix(aMatrix,matrix_Row_A,matrix_Col_A);
    			
    			System.out.println("***** Printing Matrix B *****");
    			printMatrix(bMatrix,matrix_Row_B,matrix_Col_B);

    	    	matrix_Row_c = matrix_Row_A;
    	    	matrix_Col_c = matrix_Col_B;
				cMatrix= new float[matrix_Row_c][matrix_Col_c];

			    System.out.println("Mtarix multiplication with thread started ");
	                Threads = new threadWork[matrix_Row_c][matrix_Col_c];
			      
    	//creates 9 Worker threads. Each thread Calculates a Matrix Value and sets it to C matrix
        for (int i = 0; i<matrix_Row_c; i++){
            for (int j=0; j<matrix_Col_c; j++){
                Threads[i][j] = new threadWork(i,j,aMatrix, bMatrix,cMatrix);
                Threads[i][j].start();
            }
        }
        for (int i = 0; i<matrix_Row_c; i++){
            for (int j=0; j<matrix_Col_c; j++){
                Threads[i][j].join();
            }
        }
        long val = Threads[0][0].totalExcutionTime;
        System.out.println(" Matrix mul completed in ns = "+ val );

        System.out.println("***** Printing Matrix C [multipied mtarix]: *****");
		printMatrix(cMatrix,matrix_Row_c,matrix_Col_c);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    
}