import java.io.BufferedReader;
import java.io.FileReader;

import ptolemy.plot.*;
public class Lab6 {

	 public static final double Xmin = 0;
	  public static final double Xmax = 300; // Graph domain
	  public static final int Npoint = 500;
	  public static void main ( String [] args ) {
	    Plot plotObj = new Plot () ; // Create Plot object
	    plotObj.setTitle("Rainfall vs Month") ;
	    plotObj.setXLabel("Month") ;
	    plotObj.setYLabel ("Rainfall");
	    // plotObj.setSize (400 , 300) ;
	    // plotObj.setXRange ( Xmin , Xmax ) ;
	    // plotObj.addPoint ( int Set , double x , double y , boolean connect );
	    double xStep = (Xmax - Xmin ) / Npoint;
	    // Plotting loop
	    
	    PlotApplication app = new PlotApplication ( plotObj ) ; // Display
	    String[] Rainy = readFile("Rain.txt");
	    
	    for (double x = Xmin; x <= Xmax; x += xStep) {
	      double y = Math.sin( x ) * Math.sin ( x ) ;
	      plotObj.addPoint (0 , x , y , true ) ;
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
		            	if(i > 1 && i < contents.length-1) {		            		
		            		
		            		if(C.equals("N") || C.equals("S") || C.equals("E") || C.equals("W")) {
		            			contents[i] = C;
		            			
		            		} else {
		            			System.out.println("InVaLiD dAtA");
		            			System.exit(0);
		            		}
		            	}		        
		            	contents[i] = C;
		              i++;
		            }//while 
		            
		            in.close();
		        } catch (Exception e) {
		            System.out.println("File Input Error");
		            System.exit(0);
		        }
		        
		        return contents;
		}//readFile

}//Lab6
