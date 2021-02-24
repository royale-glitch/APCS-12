import java.util.*;
public class Lab7 {
		
		private static final double LIMIT = 8.5;
		private static GroceryItem [] groceryItems = {
	            new GroceryItem(0.3,4.99, "Spam"),//16.6
	            new GroceryItem(0.3, 3.99,"cookies"),//13.3	
	            new GroceryItem(0.25,2.40,"beans"),//9.6	
	            new GroceryItem(0.5,4.50, "cereal"),//9.00
	            new GroceryItem(2,15, "Chicken"),//7.5
	            new GroceryItem(0.75, 2.50, "flour"),//3.33
	            new GroceryItem(1, 0.99, "soda"),//0.99             
	          };
		
	public static void main(String[] args) {
		ArrayList<GroceryItem> bag = new ArrayList<GroceryItem>();
		greedyI(bag);	
	}//main

	public static void greedyI(ArrayList<GroceryItem> bag) {
		double totalPrice = 0;
		int totalMass = 0;
		
		while(totalMass <= LIMIT) {
			for(int i = 0; i < groceryItems.length; i++) {
				if(groceryItems[i].getCount() < 2) {
					bag.add(groceryItems[i]);
					totalMass += groceryItems[i].getWeight();
					groceryItems[i].setCount(groceryItems[i].getCount()+1);
					i = 0;
				} else {continue;}
			}
			System.out.println(totalMass);
		}
		for(GroceryItem g : bag) {
			totalPrice += g.getCost();
		}
		
		System.out.println("Price of ideal bag: " + totalPrice);
		System.out.println("Weight of ideal bag: " + totalMass);
		System.out.println("Size of ideal bag: " + bag.size());
		
	}//greedyI
	
}//Lab7
