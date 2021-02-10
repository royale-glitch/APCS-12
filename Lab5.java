public class Lab5 {

	public static void main(String[] args) {
		int[] a10u = new int[10];
		int[] a10s = new int[10];
		
		int[] a100u = new int[100];
		int[] a100s = new int[100];
		
		int[] a10000u = new int[10000];
		int[] a1000000s = new int[1000000];
		
		for(int i =0; i < a10u.length; i++) {
			a10u[i] = (int)Math.random()*5000;
		}
		
		for(int i =0; i < a100u.length; i++) {
			a100u[i] = (int)Math.random()*5000;
		}
		
		for(int i =0; i < a10000u.length; i++) {
			a10000u[i] = (int)Math.random()*5000;
		}
		
		for(int i =0; i < a10s.length; i++) {
			a10s[i] = i;
		}
		
		for(int i =0; i < a100s.length; i++) {
			a100s[i] = i;
		}
		
		for(int i =0; i < a1000000s.length; i++) {
			a1000000s[i] = i;
		}
		
		
		
		
		System.out.println("Average Search Times: ");
		System.out.println("             | 10           | 100          | 1 000 000");
		System.out.println("---------------------------------------------------------");
		System.out.println("Linear Src   |       " + linearSearch(a10s) + " ns|       " + linearSearch(a100s)   + " ns|  "+ linearSearch(a1000000s) +" ns|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Binary Src   |       " + iBinarySearch(a10s, 6969) + " ns|        " + iBinarySearch(a100s, 6969)   + " ns|     "+ iBinarySearch(a1000000s, 6969) +" ns|");
		System.out.println("---------------------------------------------------------");
		long startTime = System.nanoTime();
		rBinarySearch(a10s,0, a10s.length-1, 6969);
		long elapsedTime = System.nanoTime()-startTime;
		long startTime2 = System.nanoTime();
		rBinarySearch(a100u,0, a10s.length-1, 6969);
		long elapsedTime2 = System.nanoTime()-startTime2;
		long startTime3 = System.nanoTime();
		rBinarySearch(a10000u,0, a10s.length-1, 6969);
		long elapsedTime3 = System.nanoTime()-startTime3;
		System.out.println("Binary Rec   |      " + elapsedTime + " ns|       " + elapsedTime2   + " ns|     "+ elapsedTime3 +" ns|");
		
		System.out.println("Average Sort Times: ");
		System.out.println("             | 10           | 100          | 10 000   ");
		System.out.println("---------------------------------------------------------");
		System.out.println("Insertion It |       " + iInsertionSort(a10u) + " ns|       " + iInsertionSort(a100u)   + " ns|     "+ iInsertionSort(a10000u) +" ns|");
		System.out.println("---------------------------------------------------------");
		 startTime = System.nanoTime();
		rInsertionSort(a10u, a10u.length-1);
		elapsedTime = System.nanoTime()-startTime;
		startTime2 = System.nanoTime();
		rInsertionSort(a100u, a100u.length-1);
		elapsedTime2 = System.nanoTime()-startTime2;
		startTime3 = System.nanoTime();
		rInsertionSort(a10000u, a10000u.length-1);
		elapsedTime3 = System.nanoTime()-startTime3;
		System.out.println("Insertion Rc |      " + elapsedTime + " ns|      " + elapsedTime2 + " ns|       "+ elapsedTime3 +" ns|");
		System.out.println("---------------------------------------------------------");
		System.out.println("Selection It |       " + iSelectionSort(a10u) + " ns|      " + iSelectionSort(a100u)   + " ns|     "+ iSelectionSort(a10000u) +" ns|");
		System.out.println("---------------------------------------------------------");
		startTime = System.nanoTime();
		rInsertionSort(a10u, a10u.length-1);
		elapsedTime = System.nanoTime()-startTime;
		startTime2 = System.nanoTime();
		rInsertionSort(a100u, a100u.length-1);
		elapsedTime2 = System.nanoTime()-startTime2;
		startTime3 = System.nanoTime();
		rInsertionSort(a10000u, a10000u.length-1);
		elapsedTime3 = System.nanoTime()-startTime3;
		System.out.println("Selection Rc |        " + elapsedTime + " ns|      " + elapsedTime2   + " ns|       "+ elapsedTime3 +" ns|");
		System.out.println("---------------------------------------------------------");
		startTime = System.nanoTime();
		mergeSort(a10u, a10u.length-1);
		elapsedTime = System.nanoTime()-startTime;
		startTime2 = System.nanoTime();
		mergeSort(a100u, a100u.length-1);
		elapsedTime2 = System.nanoTime()-startTime2;
		startTime3 = System.nanoTime();
		mergeSort(a10000u, a10000u.length-1);
		elapsedTime3 = System.nanoTime()-startTime3;
		System.out.println("   Merge Rc  |       " + elapsedTime + " ns|      " + elapsedTime2   + " ns|        "+ elapsedTime3 +" ns|");
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
            }
            return rBinarySearch(arr, mid + 1, r, x); 
          } //rBinarySearch   
            return -1;
 
    }//rBinarySearch
	
	public static long iInsertionSort(int[] arr) { 
        int n = arr.length; 
        long startTime = System.nanoTime();
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
          
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }
        return System.nanoTime()-startTime;
    }//iInsertionSort
	
	public static void rInsertionSort(int arr[], int n) { 
        
        if (n <= 1) {
            return; 
        }
        
        rInsertionSort(arr, n-1);        
         
        int last = arr[n-1]; 
        int j = n-2; 
       
        while (j >= 0 && arr[j] > last) { 
            arr[j+1] = arr[j]; 
            j--; 
        } 
        arr[j+1] = last; 
    }//rinsertionSort
	
	public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Function to perform selection sort on arr[]
    public static long iSelectionSort(int[] arr){
       long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            
            int min = i;
 
            for (int j = i + 1; j < arr.length; j++) {
               
                if (arr[j] < arr[min]) {
                    min = j;    
                }
            }
 
            
            swap(arr, min, i);
            
        }
        return System.nanoTime()-startTime;
    }//iSelectionSort
    
   public static void rSelectionSort(int arr[], int i, int n){
        
        int min = i;
        for (int j = i + 1; j < n; j++) {
           
            if (arr[j] < arr[min])
                min = j;    
        }
     
        
        swap(arr, min, i);
     
        if (i + 1 < n) {
            rSelectionSort(arr, i + 1, n);
        }
    }//rSelectionSort
   
   public static void rMerge(int[] a, int[] l, int[] r, int left, int right) {
		  
		     int i = 0, j = 0, k = 0;
		     while (i < left && j < right) {
		         if (l[i] <= r[j]) {
		             a[k++] = l[i++];
		         }
		         else {
		             a[k++] = r[j++];
		         }
		     }
		     while (i < left) {
		         a[k++] = l[i++];
		     }
		     while (j < right) {
		         a[k++] = r[j++];
		     }
		 }//rMerge
   
   public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    rMerge(a, l, r, mid, n - mid);
	}//mergeSort
	
}//Lab5
