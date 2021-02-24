import java.util.*;
public class Lab7 {
		static int counter;
		static final double LIMIT = 8.5;
		private static GroceryItem [] groceryItems = {
	            new GroceryItem(0.3,4.99, "Spam"),//16.6
	            new GroceryItem(0.3, 3.99,"cookies"),//13.3	
	            new GroceryItem(0.25,2.40,"beans"),//9.6	            
	            new GroceryItem(2,15, "Chicken"),//7.5
	            new GroceryItem(1, 2.50, "flour"),//2.50
	            new GroceryItem(0.5,1.20, "cereal"),//2.40
	            new GroceryItem(1, 0.99, "soda"),//0.99             
	          };
		
	public static void main(String[] args) {
		ArrayList<GroceryItem> bag = new ArrayList<GroceryItem>();
		greedyI(bag);
		
		/*skeleton code
		ArrayList<GroceryItem> temp = new ArrayList<GroceryItem>();
        long startTime = System.nanoTime();
        ArrayList<GroceryItem> perfectBag = bestBag(temp);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration/1000 + " ms");
        System.out.println("# method calls = " + counter);
        System.out.println("# items = " + perfectBag.size());
        System.out.println("weight items = " + bagWeight(perfectBag) + " kg.");
        System.out.println("cost items = $" + bagCost(perfectBag));
        printBag(perfectBag);
        */
			
	}//main

	public static void greedyI(ArrayList<GroceryItem> bag) {
		double totalPrice = 0;
		double totalMass = 0;		
		
		//checks if items can be added to the bag if the mass is below the maximum or 2 of each item in the store have been added 
		while(isNotMax(bag)) {
			for(int i = 0; i < groceryItems.length; i++) {
				 if(totalMass > LIMIT) {
					break;
				} 
				 if(groceryItems[i].getCount() < 2) {
					bag.add(groceryItems[i]);
					totalMass += groceryItems[i].getWeight();
					groceryItems[i].setCount(groceryItems[i].getCount()+1);
					if(i > 0) {
						i--;
					} else {i = 0;}
				} 				
			}
		}
		for(GroceryItem g : bag) {
			totalPrice += g.getCost();
		}
		
		System.out.println("Price of ideal bag: " + totalPrice);
		System.out.println("Weight of ideal bag: " + totalMass);
		System.out.println("Size of ideal bag: " + bag.size());
		
	}//greedyI
	
	public static boolean isNotMax(ArrayList<GroceryItem> bag) {
		for(GroceryItem g : bag) {
			if(g.getCount() != 2) {
				return false;
			}
		}
		return true;
	}//isMax
	
	    @SuppressWarnings("unused")
		private static ArrayList<GroceryItem> bestBag(ArrayList<GroceryItem> b) {
	        
	        // counts recursive calls
	        counter++;
	        if(counter % 10000000 == 0)
	            System.out.println("# method calls : " + counter);
	      return b;
	    } // bestBag

	    // returns the weight of bag b
	    public static double bagWeight(ArrayList<GroceryItem>b) {
	    	return 0;
	    }

	    // returns the value of bag b
	    public static double bagCost(ArrayList<GroceryItem>b) {
	    	return 0;
	    }

	    // returns number of items of i in bag b
	    public static int bagCount(ArrayList  b, String i) {
	    	return 0;
	    }

	    // prints contents of bag b
	    public static void printBag(ArrayList  b) {

	    }
}//Lab7
