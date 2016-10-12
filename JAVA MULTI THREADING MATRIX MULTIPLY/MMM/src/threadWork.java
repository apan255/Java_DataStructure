
public class threadWork extends Thread{
    private int row;
    private int col;
    private float [][] A;
    private float [][] B;
    private float [][] C;
    public static long totalExcutionTime = 0;
    public threadWork(int row, int col, float[][] A,
    		float[][] B, float[][] C) {
        this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.C = C;

    }
    
    public void run() {
        long startTime = System.nanoTime();
    	float val = 0;
    	int BiSize = B.length;
		int k = 0;
		for(;k<BiSize;k++){
			val +=   A[row][k] * B[k][col];
         }  
        long time = System.nanoTime() - startTime;
           C[row][col]  = val;
           totalExcutionTime += time;
 	      System.out.println("My thread " + this.getId() + " execution time: "+ row  + " "+ col + " "+ C[row][col]);

      // System.out.println("My thread " + this.getId() + " execution time: " + time + " ns");
    }
}