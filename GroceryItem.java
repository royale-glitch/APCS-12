public class GroceryItem implements Comparable<GroceryItem>{
	private double weight;
	private double cost;
	private String item;
	private int count;
	private double ppkg;
	
	GroceryItem(){
		this.weight = 0;
		this.cost = 0;
		this.item = "";
		this.count = 0;
		this.ppkg = 1;
	}
	
	public GroceryItem(double weight, double cost, String item) {
		this.weight = weight;
		this.cost = cost;
		this.item = item;
		this.count = 0;
		this.ppkg = this.cost / this.weight;
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
	
	public double getPpKg() {
		return this.ppkg;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "Name of item: " + this.getItem() + " Price of item: " + this.getCost() + " Weight of item: " + this.getWeight();
	}

	@Override
	public int compareTo(GroceryItem g) {
		if(g.ppkg > this.ppkg) {
			return 1;
		} else if(this.ppkg == g.ppkg) {
			return 0;
		} else {return -1;}
	}
		
}//GroceryItem
