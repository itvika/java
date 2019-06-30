package misc;
/**
 * @author Vikas Kumar
 * @Email  itvika@gmail.com
 * @Phone  9868366690
 * @LinkedIn https://linkedin.com/in/itvika/


*/
public class Factorial {
	public static int fact(int n) {
		if(n==1)
			return n;
		
		System.out.println(n);
		return n*fact(n-1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(5));
	}

}
