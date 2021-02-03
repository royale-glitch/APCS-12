import java.io.*;

public class Lab2 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int [][] Board = new int[10][10];
		String[] contents = readFile("DIRECTIONS.txt");		
		
		try {
			x = Integer.parseInt(contents[0]);
			y = Integer.parseInt(contents[1]);
		}catch(Exception e) {
			System.out.println("Invalid data");
			System.exit(0);
		}
		Point p = new Point(x,y);
		
		for(String i : contents) {
			if(i.equals("N")) {
				Point.North(Board, p);
			} if(i.equals("S")) {
				Point.South(Board, p);
			} if(i.equals("E")) {
				Point.East(Board, p);
			} if(i.equals("W")) {
				Point.West(Board, p);
			} else {
				System.out.println("Invalid Data");
				System.exit(0);
			}
		}
		
		Point.sum(Board);
		
	}//main
	
		public static String[] readFile(String fileName) {
			 String[] contents = null;
			 
			int length = 0;

		        try {

		            // input
		            BufferedReader in = new BufferedReader(new FileReader(fileName));
		            in.mark(Short.MAX_VALUE);  // see api

		            // count number of lines in file
		            while (in.readLine() != null) {
		            	length++;
		            }
		            	contents = new String[length];
		            	
		            in.reset(); // rewind the reader to the start of file
		            	System.out.println(length);
		            // read in contents of file and print to screen
		            int i = 0;
		            System.out.println("4our");
		            while (i < length) {
		            	if(i>=2) {
		            		if(in.readLine().equals("N") || in.readLine().equals("S") || in.readLine().equals("E") || in.readLine().equals("W")) {
		            			contents[i] = in.readLine();
		            			System.out.println(contents[i]);
		            		} else {
		            			System.out.println("InVaLiD dAtA");
		            			System.exit(0);
		            		}
		            	}
		            	contents[i] = in.readLine();
		              i++;
		            }
		            System.out.println("w");
		            in.close();
		        } catch (Exception e) {
		            System.out.println("File Input Error");
		            System.exit(0);
		        }
		        return contents;
		}//readFile	

}//Lab2
