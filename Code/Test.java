import java.util.Scanner;
import java.util.Random;

class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int size = 0;
		int[] arrayToSort;
		SortingClass sort = new SortingClass();
		Random random = new Random();
		Scanner input = new Scanner(System.in);

		System.out.println("Comparison of Heap Sort, Dual Pivot Quick Sort and Shell Sort\n");
		
		System.out.println("1. 1000");
		System.out.println("2. 10000");
		System.out.println("3. 100000\n");
		System.out.print("Please select a size: ");
		int sizeArray = input.nextInt();

		if (sizeArray == 1) {
			size = 1000;
		} else if (sizeArray == 2) {
			size = 10000;
		} else if (sizeArray == 3) {
			size = 100000;
		}

		arrayToSort = new int[size];

		System.out.println("\n1. Equal Integer");
		System.out.println("2. Random Integer");
		System.out.println("3. Increasing Integer");
		System.out.println("4. Decreasing Integer\n");
		System.out.print("Plase select a type: ");
		int type = input.nextInt();

		String printtype="";
		
		if (type == 1) {
			printtype="Equal Integer";
			for (int i = 0; i < size; i++) {
				arrayToSort[i] = 10;
			}
		} else if (type == 2) {
			printtype="Random Integer";
			for (int i = 0; i < size; i++) {
				int number = random.nextInt(size);
				arrayToSort[i] = number;
			}
		} else if (type == 3) {
			printtype="Increasing Integer";
			for (int i = 0; i < size; i++) {
				arrayToSort[i] = i;
			}
		} else if (type == 4) {
			printtype="Decreasing Integer";
			for(int i=0;i<size;i++) {
				arrayToSort[i]=size-1-i;
			}
		}

		System.out.println("\n1. Heap Sort");
		System.out.println("2. Dual Pivot Quick Sort");
		System.out.println("3. Shell Sort\n");
		System.out.print("Please select a sorting: ");
		int sorting = input.nextInt();
		
		/*System.out.println("\nBEFORE SORTING:\n");
		for (int i = 0; i < size; i++) {
			System.out.print(arrayToSort[i] + " ");
			if (i % 25 == 0 && i != 0)
				System.out.println();
		}*/
		
		String printsorting="";
		
		long startTime=0;
		long estimatedTime=0;
		
		if (sorting == 1) {
			printsorting="Heap Sort";
			startTime=System.nanoTime();
			sort.heapSort(arrayToSort);
			estimatedTime = System.nanoTime() - startTime;
			//System.out.println("\n\nAFTER SORTING:\n");
			//sort.printArray(sort.heapSort(arrayToSort));
		}
		else if(sorting==2) {
			printsorting="Dual Pivot Quick Sort";
			startTime=System.nanoTime();
			sort.DualPivotQuickSort(arrayToSort, 0, size-1);
			estimatedTime = System.nanoTime() - startTime;
			//System.out.println("\n\nAFTER SORTING:\n");
			//sort.printArray(sort.DualPivotQuickSort(arrayToSort, 0, size-1));
		
		}
		else if(sorting==3) {
			printsorting="Shell Sort";
			startTime=System.nanoTime();
			sort.shellSort(arrayToSort);
			estimatedTime = System.nanoTime() - startTime;
			//System.out.println("\n\nAFTER SORTING:\n");
			//sort.printArray(sort.shellSort(arrayToSort));
		}

		
		System.out.println("\n\nRUNNING TIME: ");
		System.out.print(printsorting+"/ "+printtype+"/ "+size+": "+estimatedTime+" ns");

		

	}

}
