
public class Lab3 {

	public static void main(String[] args) {
		rFactorial(90);
		iFactorial(90);
		IisPrime(101);
		RisPrime(101, 2);

	}//main
	
	public static long rFactorial(int n) {
		long startTime = System.currentTimeMillis();
		if(n == 1) {
			return (long)n;
		} else {
			return (long)(n * rFactorial(n-1));
		}
	}//rFactorial
	
	public static int iFactorial(int n) {

		for(int i = n; i > 1; i--) {
			n *= i;
		} 
		return n;
	}//iFactorial
	
	public static boolean IisPrime(int n) {
		int i = 2;
		while(i < n) {
			if(n % i == 0) {
				return false;
			}							
		}
		
		return true;
	}//IisPrime
	
	public static boolean RisPrime(int n, int i) {

		
			if(n % i == 0) {
				return false;
			}else if(i == n) {
				return true;
			} else {
				RisPrime(n, i+1);
			}		
		return true;	
		
	}//RisPrime
	

}//Lab3
