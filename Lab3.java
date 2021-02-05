import java.util.*;
public class Lab3 {

	public static void main(String[] args) {
		int b = 2;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an Integer: ");
		int a = in.nextInt();
		System.out.println("The factorial of " + a + " is " + iFactorial(a) + " ");
		long startTime = System.nanoTime();
		System.out.println("The factorial of " + a + " is " + rFactorial(a) + " ");
		System.out.println("Elapsed time: " + (System.nanoTime()-startTime) + " ns");		
		System.out.println("Enter an Integer: ");
		a = in.nextInt();
		System.out.println("Is " + a + " prime?" + IisPrime(a));
		long startTime2 = System.nanoTime();
		System.out.println("Is " + a + " prime?" + RisPrime(a, b));
		System.out.println("Elapsed time: " + (System.nanoTime()-startTime2) + " ns");	
		in.close();
	}//main
	
	public static long rFactorial(int n) {
		
		if (n >= 1) {
            return n * rFactorial(n - 1);
		} else {
            return 1;
		}  
 		
	}//rFactorial
	
	public static long iFactorial(int n) {
		long startTime = System.nanoTime();
		for(int i = n-1; i > 1; i--) {
			n *= i;
		} 
		long elapsedTime = System.nanoTime()-startTime;
		System.out.println("Elapsed time: " + elapsedTime + "ns");
		return (long)n;
	}//iFactorial
	
	public static boolean IisPrime(int n) {
		int i = 2;
		long startTime = System.nanoTime();
		long elapsedTime;
		
			while(i < n) {
				if(n % i == 0) {
					elapsedTime = System.nanoTime()-startTime;
					System.out.println("Elapsed time: " + elapsedTime + "ns");
					return false;
				}	
				i++;
			}
		elapsedTime = System.nanoTime()-startTime;
		System.out.println("Elapsed time: " + elapsedTime);
		return true;
	}//IisPrime
	
	static boolean RisPrime(int n, int i) { 
  
        // Base cases 
        if (n <= 2) 
            return (n == 2) ? true : false; 
        if (n % i == 0) 
            return false; 
        if (i * i > n) 
            return true; 
       
        // Check for next divisor 
        return RisPrime(n, i + 1); 
    }//RisPrime 
	

}//Lab3
