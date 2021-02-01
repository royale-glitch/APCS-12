import java.util.*;
public class Lab_1 {

	public static void main(String[] args) {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		Scanner in = new Scanner(System.in);
		do{
			String input = in.nextLine();			
			
			//First point
			try {
				String[] coords = input.split(",");
				x1 = Integer.parseInt(coords[0]);
				y1 = Integer.parseInt(coords[1]);
			} catch(Exception e) {
				System.out.println("Invalid. Enter an integer.");
				continue;
			}
			
			String input2 = in.nextLine();			
			
			//Second point
			try {
				String[] coords2 = input2.split(",");
				x2 = Integer.parseInt(coords2[0]);
				y2 = Integer.parseInt(coords2[1]);
			} catch(Exception e) {
				System.out.println("Invalid. Enter an integer.");
				continue;
			}
			break;
		}while(true);
		
		int dx = x2-x1;
		int dy = y2-y1;
		
		double output = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
		System.out.println(output);
		in.close();
	}//main

}//Lab_1
