import java.io.BufferedReader;
import java.io.FileReader;

import ptolemy.plot.*;
public class Lab6 {

	 public static final double Xmin = 1995;
	  public static final double Xmax = 2020; // Graph domain
	  public static final int Npoint = 500;
	  public static void main ( String [] args ) {
	    Plot plotObj = new Plot () ; // Create Plot object
	    plotObj.setTitle("Precipitation vs Year") ;
	    plotObj.setXLabel("Year") ;
	    plotObj.setYLabel ("Precipitation(mm)");
	    // plotObj.setSize (400 , 300) ;
	    // plotObj.setXRange ( Xmin , Xmax ) ;
	    // plotObj.addPoint ( int Set , double x , double y , boolean connect );
	    double xStep = (Xmax - Xmin ) / Npoint;
	    // Plotting loop
	    
	    PlotApplication app = new PlotApplication ( plotObj ) ; // Display
	    String[] Rainy = readFile("Precip1.txt");
	    String[] Rainy1 = readFile("Precip2.txt");
	    double[] rainData = new double[Rainy.length];
	    double[] rainData1 = new double[Rainy1.length];
	    for(int i = 0; i < Rainy.length; i++) {
	    	rainData[i] = Double.parseDouble(Rainy[i]);
	    }
	    
	    for(int i = 0; i < Rainy1.length; i++) {
	    	rainData1[i] = Double.parseDouble(Rainy1[i]);
	    }
	    
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
		            	if(C.equals("")) {
		            		continue;		            	
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
