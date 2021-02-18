import java.io.*;

import ptolemy.plot.*;
public class Lab6 {

	 public static final double Xmin = 1995;
	  public static final double Xmax = 2020; // Graph domain
	  public static final int Npoint = 500;
	  public static void main ( String [] args ) {
	    String[][] precip = new String[32][];
	    String[][] precip1 = new String[32][];
	    //precipitation in [22] or [23]
		Plot plotObj = new Plot () ; // Create Plot object
	    plotObj.setTitle("Precipitation vs Year") ;
	    plotObj.setXLabel("Year") ;
	    plotObj.setYLabel ("Precipitation(mm)");
	    // plotObj.setSize (400 , 300) ;
	    // plotObj.setXRange ( Xmin , Xmax ) ;
	    // plotObj.addPoint ( int Set , double x , double y , boolean connect );
	    double xStep = (Xmax - Xmin ) / Npoint;
	    // Plotting loop
	    for (double x = Xmin; x <= Xmax; x += xStep) {
	      double y = Math.sin( x ) * Math.sin ( x ) ;
	      plotObj.addPoint (0 , x , y , true ) ;
	    }
	    PlotApplication app = new PlotApplication ( plotObj ) ; // Display
	    
	    for(int i = 1995; i <= 2020; i++) {
	    	precip[i] = readFile("src/weather/" + i + ".csv");	    	
	    }
	    
	    for(int i = 1995; i <= 2020; i++) {
	    	precip1[i] = readFile("src/weather2/" + i + ".csv");
	    }
	  }//main
	  
	  public static String[] readFile(String fileName) {
			 
			 BufferedReader in = new BufferedReader(System.in);
			try {
				in = new BufferedReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
			
			}
             String[] lines = in.lines().toArray(String[]::new);
		        
		        return lines;
		}//readFile
	  
}//Lab
