
public class Lab5 {

	public static void main(String[] args) {
		System.out.println("Average Search Times: ");
		System.out.println("             | 10           | 100             | 1 000 000");
		System.out.println("---------------------------------------------------------");
		System.out.println("Linear Src   |" + linearSearch(null) + "            ns|               ns|       ns|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Binary Src   |            ns|               ns|       ns|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Binary Rec   |            ns|               ns|       ns|");
		
		System.out.println("Average Sort Times: ");
		System.out.println("             | 10           | 100             | 10 000   ");
		System.out.println("---------------------------------------------------------");
		System.out.println("Insertion It |            ns|               ns|       ns|");
		System.out.println("Insertion Rc |            ns|               ns|       ns|");
		System.out.println("Selection It |            ns|               ns|       ns|");
		System.out.println("Selection Rc |            ns|               ns|       ns|");
		System.out.println("Merge Rc     |            ns|               ns|       ns|");
	}//main
	
	public static long linearSearch(int[] query) {
		long startTime = System.nanoTime();
		for(int i : query) {
			if(i == 110938398) {
				return System.nanoTime()-startTime;
			}
		}
		return System.nanoTime()-startTime;
		
		
	}//linearSearch
	
	
	
	

}//Lab5
