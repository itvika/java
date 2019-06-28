package dynamicprogramming;


import java.util.stream.IntStream;

/**
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
Maximum size square sub-matrix with all 1s
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

Output is:
===============
0 1 1 0 1 
1 1 0 1 0 
0 1 1 1 0 
1 1 1 1 0 
1 1 1 1 1 
0 0 0 0 0 
===============
0 1 1 0 1 
1 1 0 1 0 
0 1 1 1 0 
1 1 2 2 0 
1 2 2 3 1 
0 0 0 0 0 
Max sub array size:3

 */

public class MaximumSubSquareMatrixInAMatrix {
	
	
	public int getMaxSquare(int arr[][]) {
		int result[][] = new int[arr.length][arr[0].length];
		
		
		int max = 0;
        for(int i=0; i < arr.length; i++){
            result[i][0] = arr[i][0];
            if (result[i][0] == 1)
            {
                max = 1;
            }
        }
        
        for(int i=0;i<arr[0].length;i++) {
    		result[0][i]=arr[0][i];
    		if (result[0][i] == 1)
            {
                max = 1;
            }
    	}
        
        
        
        
        for(int i=1; i < arr.length; i++){
            for(int j=1; j < arr[i].length; j++){
                if(arr[i][j] == 0){
                    continue;
                }
                int t=IntStream.of(new int[]{result[i-1][j],result[i-1][j-1],result[i][j-1]}).min()
                		.orElse(0);
                
                result[i][j] =  t +1;
                if(result[i][j] > max){
                    max = result[i][j];
                }
            }
        }
        printArray(result);
       return max;
        
	}
	
	
	
	public void printArray(int arr[][]) {
		System.out.println("===============");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int arr[][] ={{0, 1, 1, 0, 1},  
                	{1, 1, 0, 1, 0},  
                	{0, 1, 1, 1, 0}, 
                	{1, 1, 1, 1, 0}, 
                	{1, 1, 1, 1, 1}, 
                	{0, 0, 0, 0, 0}};
		
	MaximumSubSquareMatrixInAMatrix  obj=new MaximumSubSquareMatrixInAMatrix();
	obj.printArray(arr);
	int subArraySize=obj.getMaxSquare(arr);
	System.out.println("Max sub array size:"+subArraySize);
				 
	}
}
