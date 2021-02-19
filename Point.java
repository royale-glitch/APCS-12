public class Point {
	private int year;
	private int month;
	private int day;
	private double precip;
	
	Point(){
		year = 0;
		month = 0;
		day = 0;
		precip = 0;
	}
	
	public Point(int year, int month, int day, double precipitation) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.precip = precipitation;		
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public double getPrecip() {
		return this.precip;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setPrecip(double precip) {
		this.precip = precip;
	}
	
	public String toString() {
		return this.year + "/" + this.month +  "/" + this.day + ": Precipitation: " + this.precip;
	}
	
	
	
}//Point
