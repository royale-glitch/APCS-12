public class GroceryItem {
	private double weight;
	private double cost;
	private String item;
	private int count;
	
	GroceryItem(){
		this.weight = 0;
		this.cost = 0;
		this.item = "";
		this.count = 0;
	}
	
	public GroceryItem(double weight, double cost, String item) {
		this.weight = weight;
		this.cost = cost;
		this.item = item;
		this.count = 0;
		
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

	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "Name of item: " + this.getItem() + "\nPrice of item: " + this.getCost() + "\nWeight of item: " + this.getWeight();
	}
		
}//GroceryItem
