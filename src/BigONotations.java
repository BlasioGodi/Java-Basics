
public class BigONotations {
	
	//Class Properties
	private int [] theArray;
	private int arraySize;
	private int itemsInArray = 0;
	public long startTime;
	public long endTime;
	
	//Constructor
	public BigONotations(int size) {
		arraySize = size;
		theArray = new int[size];
	}
	
	//Methods of class
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random()*1000)+10;
		}
		itemsInArray = arraySize-1;
	}
	
	//Order of O(1)
	public void AddItemtoArray(int newItem) {
		theArray[itemsInArray++] = newItem;
	}
	
	//Order of O(n)
	public void LinearSearch(int value) {
		boolean valueInArray = false;
		String indexsWithValue = "";
		
		startTime = System.currentTimeMillis();
		
		for(int i=0; i < arraySize; i++) {
			if (theArray[i]==value) {
				valueInArray = true;
				indexsWithValue = i + " ";
			}
		}
		System.out.println("Value found: " + valueInArray);
		
		endTime = System.currentTimeMillis();
		System.out.println("Linear search took "+(endTime - startTime));
	}
	
	//Order of O(n^2)
	public void BubbleSort() {
		
		startTime = System.currentTimeMillis();
		
		for (int i = arraySize-1; i>1; i--) {
			for (int j = 0; j < i; j++) {
				if (theArray[j] > theArray[j+1]) {
					var temp = theArray[j];
					theArray[j] = theArray[j+1];
					theArray[j+1] = temp;
				}
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("BubbleSort took "+(endTime - startTime));
		
	}
	
	//Order of O(log n)
	public void BinarySearch(int value) {
		
		startTime = System.currentTimeMillis();
		
		int lowIndex = 0;
		int highIndex = arraySize-1;
		
		int timesThrough = 0;
		
		while (lowIndex <= highIndex) {
			
			int middleIndex = (highIndex + lowIndex)/2;
			
			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;
			else if (theArray[middleIndex] > value)
				highIndex = middleIndex -1;
			else {
				
				System.out.println("Found match in index "+ middleIndex);
				lowIndex = highIndex + 1;
			}
			timesThrough++;
		}		
		endTime = System.currentTimeMillis();
		System.out.println("BinarySeach took "+(endTime - startTime));
		System.out.println("TimesThrough "+timesThrough);
		
	}
	
	//Order of O(n log n)
	public void QuickSort(int left, int right) {
		
		if (right - left <= 0)
			return;
		else {
			int pivot = theArray[right];
			int pivotLocation = PartitionArray(left, right, pivot);
			
			QuickSort(left, pivotLocation - 1);
			QuickSort(pivotLocation + 1, right);
		}
		
	}
	
	public int PartitionArray(int left, int right, int pivot)
    {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true)
        {
            while (theArray[++leftPointer] < pivot)
                ;
            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            if (leftPointer >= rightPointer)
            {
                break;
            }
            else
            {
                var temp = leftPointer;
                leftPointer = rightPointer;
                rightPointer = temp;

            }
        }
        
        var temp = leftPointer;
        leftPointer = right;
        right = temp;
        
        return leftPointer;
    }

	//Main program
	public static void main(String[] args) {
		
		BigONotations algoTest1 = new BigONotations(100000);
		algoTest1.generateRandomArray();
		
		BigONotations algoTest2 = new BigONotations(200000);
		algoTest2.generateRandomArray();
		
		BigONotations algoTest3 = new BigONotations(300000);
		algoTest3.generateRandomArray();
		
		BigONotations algoTest4 = new BigONotations(400000);
		algoTest4.generateRandomArray();
		
		BigONotations algoTest5 = new BigONotations(500000);
		algoTest5.generateRandomArray();
		
		//Linear Search algorithm
		algoTest1.LinearSearch(20);
		algoTest2.LinearSearch(20);
		algoTest3.LinearSearch(20);
		algoTest4.LinearSearch(20);
		algoTest5.LinearSearch(20);

		//BubbleSort algorithm
		algoTest1.BubbleSort();
		algoTest2.BubbleSort();
		algoTest3.BubbleSort();
		algoTest4.BubbleSort();
		algoTest5.BubbleSort();
		
		//BinarySearch algorithm
		algoTest1.BinarySearch(20);
		algoTest2.BinarySearch(20);
		algoTest3.BinarySearch(20);
		algoTest4.BinarySearch(20);
		algoTest5.BinarySearch(20);
		
		//QuickSort algorithm
		algoTest1.QuickSort(0,algoTest1.itemsInArray);
		algoTest2.QuickSort(0,algoTest2.itemsInArray);
		algoTest3.QuickSort(0,algoTest3.itemsInArray);
		algoTest4.QuickSort(0,algoTest4.itemsInArray);
		algoTest5.QuickSort(0,algoTest5.itemsInArray);

	}

}
