import java.io.*;

public class Lab_2 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int [][] Board = new int[10][10];
		String[] contents = readFile("names.txt");		
		
		try {
			x = Integer.parseInt(contents[0]);
			y = Integer.parseInt(contents[1]);
		}catch(Exception e) {
			System.out.println("Invalid data");
			System.exit(0);
		}
		Point p = new Point(x,y);
		
	}//main
	
		public static String[] readFile(String fileName) {
			String[] contents = new String[fileName.length()]; 
			int length = 0;

		        try {

		            // input
		            BufferedReader in = new BufferedReader(new FileReader(fileName));
		            in.mark(Short.MAX_VALUE);  // see api

		            // count number of lines in file
		            while (in.readLine() != null) {
		              length++;
		            }

		            in.reset(); // rewind the reader to the start of file

		            // read in contents of file and print to screen
		            int i = 0;
		            while (i < length) {
		            	if(i>1 && (!in.readLine().equals("N") && !in.readLine().equals("S") && !in.readLine().equals("E") && !in.readLine().equals("W"))) {
		            		System.out.println("invalid data");
		            		System.exit(0);
		            	}
		              contents[i] = in.readLine();
		              i++;
		            }
		            in.close();
		        } catch (Exception e) {
		            System.out.println("File Input Error");
		        }
		        return contents;
		}//readFile	

}//Lab2
