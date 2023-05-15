public class ShellSort<T extends Comparable<T>> {//Added <T extends Comparable<T>>
	/* An utility function to print array of size n */
	static <T> void printArray(T arr[]) {//changed int to T and added <T> after static
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/* function to sort arr using shellSort */
	int sort(T arr[]) {//changed int to T
		int n = arr.length;

		// Start with a big gap, then reduce the gap
		for (int gap = n / 2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size.
			// The first gap elements a[0..gap-1] are already
			// in gapped order keep adding one more element
			// until the entire array is gap sorted
			for (int i = gap; i < n; i += 1) {
				// add a[i] to the elements that have been gap
				// sorted save a[i] in temp and make a hole at
				// position i
				T temp = arr[i];//CHANGED INT TO T

				// shift earlier gap-sorted elements up until
				// the correct location for a[i] is found
				int j;
				//used compareTo function instead of all relational operators because we are working with objects
				for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap)//USED COMPARETO METHOD 
					arr[j] = arr[j - gap];

				// put temp (the original a[i]) in its correct
				// location
				arr[j] = temp;
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		Integer arr[] = { 12, 34, 54, 2, 3};//changed to Integer Object array
		System.out.println("Array before sorting");
		printArray(arr);
		ShellSort<Integer> ob = new ShellSort<>();
		ob.sort(arr);
		System.out.println("Array after sorting");
		printArray(arr);
	}
}
