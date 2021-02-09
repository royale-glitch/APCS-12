
public class Lab5 {

	public static void main(String[] args) {
		System.out.println("Average Search Times: ");
		System.out.println("             | 10           | 100             | 1 000 000");
		System.out.println("---------------------------------------------------------");
		System.out.println("Linear Src   |" + linearSearch(null) + "ns|               ns|       ns|");
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
	
	public static long iBinarySearch(int[] arr, int x)  { 
        int l = 0;
        int r = arr.length - 1; 
        long startTime = System.nanoTime();
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == x) {
                return System.nanoTime()-startTime; 
            }
            // If x greater, ignore left half 
            if (arr[m] < x) { 
                l = m + 1; 
            }
            // If x is smaller, ignore right half 
            else {
                r = m - 1; 
            }
        } 
  
        // if we reach here, then element was 
        // not present 
        return System.nanoTime()-startTime; 
    }//iBinarySearch
	
	public static int rBinarySearch(int[] arr, int l, int r, int x){ 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            
            if (arr[mid] == x) {
                return mid; 
            }
            
            if (arr[mid] > x) {
                return rBinarySearch(arr, l, mid - 1, x); 
            }else {
            return rBinarySearch(arr, mid + 1, r, x); 
            }
        } 
  
       
        return -1; 
    }//rBinarySearch
	
	public static void iInsertionSort(int[] arr) { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
          
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    }//iInsertionSort
	
	public static void iSelectionSort(int[] arr) {
		}
	
}//Lab5
