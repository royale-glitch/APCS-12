import java.util.Scanner;
public class Lab4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] q = input.split("");
		if(q.length != 1) {
			System.out.println("NO!");
			System.exit(0);
		} else{
			emuLike(input);
		}
		
	}//main
	
	public static boolean emuLike(String input) {
		if(input.contains("e") && input.contains("m") && input.contains("u")) {
			System.out.println("Your word is emulike");
			return true;
		} else {return false;}
	}//emuLike

}//Lab4
