import java.util.*;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
public class Lab4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("please enter a word: ");
		String input = in.nextLine();
		String[] p = input.split(" ");
		if(p.length != 1) {
			System.out.println("NO!");
			System.exit(0);
		} else{
			//emuLike(input);
		}
		System.out.println("please enter a word: ");
		input = in.nextLine();
		String[] q = input.split(" ");
		System.out.println("please enter a word: ");
		String input2 = in.nextLine();
		String[] q2 = input.split(" ");
		if(q.length != 1 || q2.length != 1) {
			System.out.println("NO!");
			System.exit(0);
		} else{
			fooBarLike(input, input2);
		}
		in.close();
	}//main
	
	public static void emuLike(String input) {
		if(input.contains("e") && input.contains("m") && input.contains("u")) {
			System.out.println("The word " + input + " is emulike");
		} else {System.out.println("The word " + input + " is NOT emulike");}
	}//emuLike
	
	public static void fooBarLike(String a, String b) {
		StringBuffer sb = new StringBuffer();
		String[] temp = a.split("");
		List<String> temp1 = new ArrayList<String>();
		for(String s : temp) {
			temp1.add(s);
		}
		
		if(b.contains(temp1.get(0))) {
			System.out.println(temp1.get(0));
			temp1.remove(0);
			for (String s : temp1) {
		         sb.append(s);
		         sb.append(" ");
		      }
		      String str = sb.toString();
		      System.out.println(sb);
		      fooBarLike(str, b);
		} else if(temp1.size() == 0) {
			System.out.println("The word " + b + " is foobarlike");
		} else {
			System.out.println("The word " + b + " is NOT foobarlike");
		}

			
	}//fooBarLike

}//Lab4
