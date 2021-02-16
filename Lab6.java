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
	    
	    for (double x = Xmin; x <= Xmax; x += xStep) {
	      double y = Math.sin( x ) * Math.sin ( x ) ;
	      plotObj.addPoint (0 , x , y , true ) ;
	    }
	  }//main
	  
	  public static String[] readFile(String year) {
			 
			 BufferedReader in = new BufferedReader(new FileReader("src/weather/" + year + ".txt"));
             String[] lines = in.lines().toArray(String[]::new);
		        
		        return lines;
		}//readFile

}//Lab6
