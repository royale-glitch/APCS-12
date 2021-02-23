
public class GroceryItem {
	private double weight;
	private double cost;
	private String item;
	
	GroceryItem(){
		this.weight = 0;
		this.cost = 0;
		this.item = "";
	}
	
	public GroceryItem(double weight, double cost, String item) {
		this.weight = weight;
		this.cost = cost;
		this.item = item;
		
		
	}//GroceryItem
	
	public double getWeight() {
		return this.weight;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public String getItem() {
		return this.item;
	}
	
	
}//GroceryItem
