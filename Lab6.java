import java.io.*;
import java.util.*;
import ptolemy.plot.*;
public class Lab6{

	 public static final double Xmin = 1995;
	 public static final double Xmax = 2020; // Graph domain
	 public static final int Npoint = 5000;
	  public static void main ( String [] args ) {
		ArrayList<Double> data = new ArrayList<Double>(); 
		Plot plotObj = new Plot () ; // Create Plot object
	    plotObj.setTitle("Precipitation vs Year") ;
	    plotObj.setXLabel("Year") ;
	    plotObj.setYLabel ("Precipitation(mm)");
	    // plotObj.setSize (400 , 300) ;
	    // plotObj.setXRange ( Xmin , Xmax ) ;
	    // plotObj.addPoint ( int Set , double x , double y , boolean connect );
	    double average = 0;
	    for(int i = 0; i <= 25; i++) {
		    	String[] temp = readFile("src/weather/" + (i+1995) + ".csv");    	
		    	String[] temp1 = readFile("src/weather2/" + (i+1995) + ".csv");
		    	//iterates through each line of the file
		    	for(int j = 0; j < temp.length; j++) {
		    		//splits each line of the file into an array at ","
		    		String[]temp2 = temp[j].split("\",\"");
		    		temp2[23] = temp2[23].trim();
		    		String[] temp3 = temp1[j].split("\",\"");
		    		temp3[23] = temp3[23].trim();
		    		System.out.println("temp2: " +temp2[23] + "temp3:  "+ temp3[23]);
		    		//skips the first line of each file and skips any null/empty values
		    		if(j == 0 || (temp2[23] == null || temp3[23] == null) || (temp2[23] == "" || temp3[23] == "")) {
		    			continue;
		    		}	    			
		    		// 23 is precipitation
		    		try {
		    		average = (Double.parseDouble(temp2[23]) + Double.parseDouble(temp3[23]))/2;
		    		}catch(Exception e) {
		    			average = 0;
		    		}
		    		data.add(average);		    		
		    }
	    } 	
	    System.out.println(data.size());
	    for(Double d : data) {
	    	System.out.println(d);
	    }
	    
	    double xStep = (Xmax - Xmin ) / Npoint;
	    // Plotting loop
	    for (double x = Xmin; x <= Xmax; x += xStep) {
	      for(int i = 0; i < data.size(); i++) {
	    	  double y = data.get(i);
	    	 
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
