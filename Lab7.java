import java.util.*;
/*
 * February 25, 2021 
 * Author: Surya Narayan
 * Lab 7: Grocery Problem
 * Iterative and Recursive solutions
 */
public class Lab7 {
		static int counter = 0;
		static final double LIMIT = 8.5;
		private static GroceryItem [] groceryItems = {
	            new GroceryItem(0.3,4.99, "Spam"),//16.67
	            new GroceryItem(1, 0.99, "soda"),//0.99 	            
	            new GroceryItem(0.3, 3.99,"cookies"),//13.33	            
	            new GroceryItem(2,15, "Chicken"),//7.5
	            new GroceryItem(0.25,2.40,"beans"),//9.6    
	            new GroceryItem(0.5,1.20, "cereal"),//2.40
	            new GroceryItem(1, 2.50, "flour"),//2.50                  
	          };
		
	public static void main(String[] args) {
		//sorts the array of the list of items based on $/kg
		Arrays.sort(groceryItems);
		@SuppressWarnings("unused")
		ArrayList<GroceryItem> bag = new ArrayList<GroceryItem>();
		//greedyI(bag);
		
		
		//creating a fullBag with 2 of each item
		ArrayList<GroceryItem> FULL = new ArrayList<GroceryItem>();
		for(GroceryItem g : groceryItems){
			for(int i = 0; i < 2; i++){
				FULL.add(g);
			}
		}
		
        long startTime = System.nanoTime();
        ArrayList<GroceryItem> perfectBag = bestBag(FULL);
        long duration = (System.nanoTime() - startTime);
        System.out.println("Time: " + duration + " ns");
        System.out.println("# method calls = " + counter);
        System.out.println("# items = " + perfectBag.size());
        System.out.println("weight items = " + bagWeight(perfectBag) + " kg.");
        System.out.println("cost items = $" + bagCost(perfectBag));
        printBag(perfectBag);
			
	}//main
	
	
	//Greedy Algorithm
	public static void greedyI(ArrayList<GroceryItem> bag) {
		double totalPrice = 0;
		double totalMass = 0;		
		//checks if items can be added to the bag if the mass is below the maximum OR 2 of each item in the store have been added 
			for(int i = 0; i < groceryItems.length; i++) {
				 if(groceryItems[i].getCount() < 2 && totalMass + groceryItems[i].getWeight() < 8.5) {
					bag.add(groceryItems[i]);
					totalMass += groceryItems[i].getWeight();
					groceryItems[i].setCount(groceryItems[i].getCount()+1);
						i--;							
				 }
			}
		for(GroceryItem g : bag) {
			totalPrice += g.getCost();
		}
		
		System.out.println("Price of ideal bag: $" + totalPrice);
		System.out.println("Mass of ideal bag: " + totalMass + " kg");
		System.out.println("Size of ideal bag: " + bag.size() + " items");
		System.out.println("---------------------------");
		
	}//greedyI
	
		//recursive algorithm
		private static ArrayList<GroceryItem> bestBag(ArrayList<GroceryItem> b) {        
			counter++;
			if(bagWeight(b) <= 8.5) {   		
				return b;
	    	} else {
	    		b.remove(b.size()-1);
	    		return bestBag(b);
	    	}
	    } // bestBag

	    // returns the weight of bag b
	    public static double bagWeight(ArrayList<GroceryItem>b) {
	    	double totalMass = 0;	    	
	    	for(GroceryItem g : b) {
	    		totalMass += g.getWeight();
	    	}
	    	return totalMass;
	    }//bagWeight

	    // returns the value of bag b
	    public static double bagCost(ArrayList<GroceryItem>b) {
	    	double totalCost = 0;	    	
	    	for(GroceryItem g : b) {
	    		totalCost += g.getCost();
	    	}
	    	return totalCost;
	    }//bagCost

	    // returns number of items of i in bag b
	    public static int bagCount(ArrayList<GroceryItem> b, String i) {
	    	int count = 0;	    	
	    	for(GroceryItem g : b) {
	    		if(g.getItem().equals(i)) {
	    			count ++;
	    		}
	    	}
	    	return count;
	    }//bagCount

	    // prints contents of bag b
	    public static void printBag(ArrayList<GroceryItem>  b) {
	    	for(GroceryItem g : b) {
	    		System.out.println(g);
	    	}
	    }//printBag
}//Lab7
