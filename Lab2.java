import java.io.*;

public class Lab_2 {

	public static void main(String[] args) {
		int x = 0;
		int y = 0;
		int [][] Board = new int[10][10];
		String[] contents = readFile("DIRECTIONS.txt");		
	
		try {
			x = Integer.parseInt(contents[0]);
			y = Integer.parseInt(contents[1]);
				
			if(x < 0 || x>9 || y < 0 || y > 9) {
				System.out.println("AInvalid data");
				System.exit(0);
			}
				
		}catch(Exception e) {
			System.out.println("BInvalid data");
			System.exit(0);
		}
		Point p = new Point(x,y);
		
		for(int i = 2; i < contents.length; i++) {
			if(contents[i].equals("N")) {
				Point.North(Board, p);
			}else if(contents[i].equals("S")) {
				Point.South(Board, p);
			}else if(contents[i].equals("E")) {
				Point.East(Board, p);
			}else if(contents[i].equals("W")) {
				Point.West(Board, p);
			} else if(contents[i].equalsIgnoreCase("End of File")){
				System.out.println(Point.sum(Board));
				System.exit(0);
			}else {
				System.out.println("Invalid Data");
				System.exit(0);
			}
		}
		
		
		
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
		            	
		            // read in contents of file and print to screen
		            int i = 0;
		            
		            while (i < length) {
		            	String C = in.readLine();
		            	if(i>=2 && i < contents.length-1) {		            		
		            		if(C.equals("N") || C.equals("S") || C.equals("E") || C.equals("W")) {
		            			contents[i] = C;
		            		} else {
		            			System.out.println("InVaLiD dAtA");
		            			System.exit(0);
		            		}
		            	}
		        
		            	contents[i] = C;
		              i++;
		            }
		            
		            in.close();
		        } catch (Exception e) {
		        	e.printStackTrace();
		            System.out.println("File Input Error");
		            System.exit(0);
		        }
		        return contents;
		}//readFile	

}//Lab2
