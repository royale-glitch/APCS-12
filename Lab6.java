import java.io.*;
import java.util.*;
import ptolemy.plot.*;
public class Lab6 {

	 public static final double Xmin = 1995;
	 public static final double Xmax = 2020; // Graph domain
	 public static final int Npoint = 5000;
	  public static void main ( String [] args ) {
		ArrayList<Point> data = new ArrayList<Point>(); 
		ArrayList<Point> data2 = new ArrayList<Point>();
		Plot plotObj = new Plot () ; // Create Plot object
	    plotObj.setTitle("Precipitation vs Year") ;
	    plotObj.setXLabel("Year") ;
	    plotObj.setYLabel ("Precipitation(mm)");
	    // plotObj.setSize (400 , 300) ;
	    // plotObj.setXRange ( Xmin , Xmax ) ;
	    // plotObj.addPoint ( int Set , double x , double y , boolean connect );
	    for(int i = 0; i <= 25; i++) {
	    	String[] temp = readFile("src/weather/" + (i+1995) + ".csv");    	
	    	for(int j = 0; j < temp.length; j++) {
	    		String[]temp2 = temp[i].split("\",\"");
	    		if(i == 0 || temp2[23] == null) {
	    			continue;
	    		}
	    		try {
	    		Point p = new Point(Integer.parseInt(temp2[5]), Integer.parseInt(temp2[6]), Integer.parseInt(temp2[7]),Double.parseDouble(temp2[23]));
	    		System.out.println(p.toString());
	    		data.add(p);
	    		} catch(Exception e) {
	    			continue;
	    		}
	    		
	    	}
	    }
	    
	    for(int i = 0; i <= 25; i++) {
	    	String[] temp = readFile("src/weather2/" + (i+1995) + ".csv");    	
	    	for(int j = 0; j < temp.length; j++) {
	    		String[]temp2 = temp[i].split("\",\"");
	    		if(i == 0 || temp2[23] == null) {
	    			continue;
	    		}
	    		try {
		    		Point p = new Point(Integer.parseInt(temp2[5]), Integer.parseInt(temp2[6]), Integer.parseInt(temp2[7]),Double.parseDouble(temp2[23]));
		    		System.out.println(p.toString());
		    		data2.add(p);
		    		} catch(Exception e) {
		    			continue;
		    		}
	    	}
	    }
	    
	    for(int i = 0; i < data.size(); i++) {
	    	if(data.get(i).getPrecip() == 0) {
	    		data.set(i, data2.get(i));
	    	}
	    	
	    }
	    
	    double xStep = (Xmax - Xmin ) / Npoint;
	    // Plotting loop
	    for (double x = Xmin; x <= Xmax; x += xStep) {
	      for(int i = 0; i < data.size(); i++) {
	    	  double y = data.get(i).getPrecip();
		      plotObj.addPoint (0 , x, y, true) ;
	      }
	    }
	    PlotApplication app = new PlotApplication (plotObj); // Display 
	    
	  }//main
	  
	  public static String[] readFile(String fileName) {
			 
			 BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(fileName));
			} catch (Exception e) {
				System.exit(0);
			}			
             String[] lines = in.lines().toArray(String[]::new);
		        
		        return lines;
		}//readFile
	  
}//Lab
