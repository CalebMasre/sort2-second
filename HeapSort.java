public class HeapSort <T extends Comparable<T>> {//Added <T extends Comparable<T>>
	public void sort(T arr[]) {//changed int to T 
		int N = arr.length;
		// Build heap (rearrange array)
		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		// One by one extract an element from heap
		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			T temp = arr[0];//changed int to T
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(T arr[], int N, int i) {//changed int to T 
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		//Changed relational operators to a compareTo functions because we are working with objects
		if (l < N && arr[l].compareTo(arr[largest]) > 0)// SWITCHED TO COMPARE TO FUNCTION
			largest = l;

		// If right child is larger than largest so far
		if (r < N && arr[r].compareTo(arr[largest]) > 0)// SWITCHED TO COMPARE TO FUNCTION
			largest = r;

		// If largest is not root
		if (largest != i) {
			T swap = arr[i];//CHANGED INT TO T
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, N, largest);
		}
	}


	/* A utility function to print array of size n */
	static <T> void printArray(T[] arr) {//changed int to T and added <T> after static
		int N = arr.length;

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		
		Integer arr[] = { 12, 11, 13, 5, 6, 7 };//changed to Integer Object array
		int n = arr.length;
		System.out.println("Array before sorting");
		printArray(arr);
		HeapSort<Integer> ob = new HeapSort<>();
		ob.sort(arr);
		System.out.println("Sorted array is");
		printArray(arr);
	}

}