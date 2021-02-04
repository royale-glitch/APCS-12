public class Lab3 {

	public static void main(String[] args) {
		System.out.println(rFactorial(8));
		System.out.println(iFactorial(8));
		System.out.println(IisPrime(101));
		System.out.println(RisPrime(101, 2));

	}//main
	
	public static long rFactorial(int n) {
		int i = n;
		long startTime = System.currentTimeMillis();
		long elapsedTime;
		if(i == 0){
			elapsedTime = System.currentTimeMillis()-startTime;
			System.out.println(elapsedTime);
			return 1;
		} else if(i == 1) {
			elapsedTime = System.currentTimeMillis()-startTime;
			System.out.println(elapsedTime);
			return (long)n;
		} else {
			return (long)(i * rFactorial(n-1));
		}
		
	}//rFactorial
	
	public static int iFactorial(int n) {
		long startTime = System.currentTimeMillis();
		for(int i = n-1; i > 1; i--) {
			n *= i;
		} 
		long elapsedTime = System.currentTimeMillis()-startTime;
		System.out.println(elapsedTime);
		return n;
	}//iFactorial
	
	public static boolean IisPrime(int n) {
		int i = 2;
		long startTime = System.currentTimeMillis();
		long elapsedTime;
		
			while(i < n) {
				if(n % i == 0) {
					elapsedTime = System.currentTimeMillis()-startTime;
					System.out.println(elapsedTime);
					return false;
				}	
				i++;
			}
		elapsedTime = System.currentTimeMillis()-startTime;
		System.out.println(elapsedTime);
		return true;
	}//IisPrime
	
	public static boolean RisPrime(int n, int i) {
			
			long startTime = System.currentTimeMillis();
			long elapsedTime;
				if(n % i == 0) {
					elapsedTime = System.currentTimeMillis()-startTime;
					System.out.println(elapsedTime);
					return false;
				}else if(i < n) {
					RisPrime(n, i+1);
					return true;
				} else {
					elapsedTime = System.currentTimeMillis()-startTime;
					System.out.println(elapsedTime);
				}	
			
		return true;	
		
	}//RisPrime
	

}//Lab3
