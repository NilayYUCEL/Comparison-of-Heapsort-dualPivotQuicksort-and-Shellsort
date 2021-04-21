
public class SortingClass {
	
	//HEAP sORT
	public int[] heapSort(int arrayToSort[]) {
		
		int size = arrayToSort.length;

		for (int i = (size / 2) - 1; i >= 0; i--) {
			heapify(arrayToSort, size, i);
		}

		for (int i = size - 1; i >= 0; i--) {

			int temp = arrayToSort[0];
			arrayToSort[0] = arrayToSort[i];
			arrayToSort[i] = temp;

			heapify(arrayToSort, i, 0);
		}

		return arrayToSort;
	}

	public void heapify(int arr[], int size, int i) {

		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < size && arr[left] > arr[largest])
			largest = left;

		if (right < size && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapify(arr, size, largest);
		}
	}

	//DUAL PÝVOT QUÝCK SORT
	public int[] DualPivotQuickSort(int[] arrayToSort, int left, int right) {

		if (left < right) {
			int leftpivot, rightpivot;
			int[] pivots;
			pivots = partition(arrayToSort, left, right);
			rightpivot = pivots[0];
			leftpivot = pivots[1];
			DualPivotQuickSort(arrayToSort, left, leftpivot - 1);
			DualPivotQuickSort(arrayToSort, leftpivot + 1, rightpivot - 1);
			DualPivotQuickSort(arrayToSort, rightpivot + 1, right);
		}
		return arrayToSort;
	}

	public int[] partition(int[] arr, int left, int right) {
		int swap;

		if (arr[left] > arr[right]) {
			swap = arr[left];
			arr[left] = arr[right];
			arr[right] = swap;
		}

		int leftpoint = left + 1;
		int rightpoint = right - 1, x = leftpoint, leftpivot = arr[left], rightpivot = arr[right];
		while (x <= rightpoint) {

			if (arr[x] < leftpivot) {
				swap = arr[x];
				arr[x] = arr[leftpoint];
				arr[leftpoint] = swap;
				leftpoint++;
			}

			else if (arr[x] >= rightpivot) {

				while (arr[rightpoint] > rightpivot && x < rightpoint)
					rightpoint--;

				swap = arr[x];
				arr[x] = arr[rightpoint];
				arr[rightpoint] = swap;

				rightpoint--;

				if (arr[x] < leftpivot) {

					swap = arr[x];
					arr[x] = arr[leftpoint];
					arr[leftpoint] = swap;
					leftpoint++;

				}
			}
			x++;
		}

		leftpoint--;
		rightpoint++;

		swap = arr[left];
		arr[left] = arr[leftpoint];
		arr[leftpoint] = swap;

		swap = arr[right];
		arr[right] = arr[rightpoint];
		arr[rightpoint] = swap;

		int[] retval = { rightpoint, leftpoint };

		return retval;
	}

	//SHELL sORT
	public int[] shellSort(int arrayToSort[]) {
		int size = arrayToSort.length;

		for (int gap = size / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < size; i++) {
				int temp = arrayToSort[i];

				int j;
				for (j = i; j >= gap && arrayToSort[j - gap] > temp; j -= gap)
					arrayToSort[j] = arrayToSort[j - gap];

				arrayToSort[j] = temp;
			}
		}
		return arrayToSort;
	}

	
	public void printArray(int arr[]) {
		int size = arr.length;
		for (int i = 0; i < size; ++i) {
			System.out.print(arr[i] + " ");
			if (i % 25 == 0 && i != 0) // for printing properly
				System.out.println();
		}
		System.out.println();
	}

}
