package dynamicprogramming;

/**
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

*/
public class LongestCommonSubsequence {
	public void findLCS(char[] C1,char[] C2) {
		int len1=C1.length;
		int len2=C2.length;
		int max=0;
		int[][] tempArray=new int[len1+1][len2+1];
		for(int i=1;i<tempArray.length;i++) {
			for(int j=1;j<tempArray[0].length;j++) {
				//System.out.println(C1[i-1]+"-"+C2[j-1]);
				if(C1[i-1]==C2[j-1]) {
					tempArray[i][j]=tempArray[i-1][j-1]+1;
				}else {
					tempArray[i][j]=Math.max(tempArray[i-1][j], tempArray[i][j-1]);
				}
				if(max<tempArray[i][j]) {
					max=tempArray[i][j];
				}
				
			}
		}
		
		printArray(tempArray);
		System.out.println("LCS:"+max);
	}
	
	public void printArray(int[][] A) {
		for(int i=0;i<A.length;i++) {
			for (int j=0;j<A[0].length;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String s1="ABCDGHLQR";
		String s2="AEDPHR";
		LongestCommonSubsequence obj=new LongestCommonSubsequence();
		obj.findLCS(s1.toCharArray(),s2.toCharArray());
		
		

	}

}
