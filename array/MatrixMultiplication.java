package array;
/**
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/


*/
public class MatrixMultiplication {
	public static void multiply(int[][] m1,int[][]m2) {
		int m1_row=m1.length;
		int m1_col=m1[0].length;
		
		int m2_row=m2.length;
		int m2_col=m2[0].length;
		
		if(m1_col!=m2_row) {
			System.out.println("No compitable for multiplication!!");
			return;
		}
		//i will go up to number of rows of 1st matrix
		//j will go up to number of cols of 2nd matrix
		// k will go upto number of cols of 1st matrix or number of rows of 2nd matrix
		
		int[][] m3=new int[m1_row][m2_col];
		for(int i=0;i<m1_row;i++) {
			for(int j=0;j<m2_col;j++) {
				for(int k=0;k<m1_col;k++) {
					m3[i][j]+=m1[i][k]*m2[k][j];
				}
			}
		}
		printArray(m3);	
	}
	
	public  static  void printArray(int arr[][]) {
		System.out.println("===============");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] m1= {{1, 1, 1, 1}, 
                {2, 2, 2, 2}, 
                {3, 3, 3, 3}, 
                {4, 4, 4, 4}};
		int[][] m2= {{1, 1, 1, 1}, 
                {2, 2, 2, 2}, 
                {3, 3, 3, 3}, 
                {4, 4, 4, 4}}; 
		
		multiply(m1,m2);

	}

}
