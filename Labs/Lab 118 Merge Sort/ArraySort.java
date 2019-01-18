/**
 * Lab 110 Sorting Two (combined with lab 109)
 *
 * @ Emma Chiu
 * @ 1/10/19
 */

public class ArraySort {
    public static void main() { // main method
        //MY SORT
        // declares, initializes, and prints original array
        System.out.println("MySort Method");
        int[] array1 = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array1);
        
        // declares, initializes, sorts, and prints the sorted array
        int[] sortedArray1 = mySort(array1); // mySort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray1);
        
        // BUBBLE SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Bubble Sort Method");
        int[] array2 = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array2);
        
        // declares, initializes, sorts, and prints the sorted array
        int[] sortedArray2 = bubbleSort(array2); // bubbleSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray2);
        
        
        // SELECTION SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Selection Sort Method");
        int[] array3 = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array3);
        
        // declares, initializes, sorts, and prints the sorted array
        int[] sortedArray3 = selectionSort(array3); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray3);
        
        
        // INSERTION SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Insertion Sort Method");
        int[] array4 = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array4);
        
        // declares, initializes, sorts, and prints the sorted array
        int[] sortedArray4 = insertionSort(array4); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray4);
        
        // MERGE SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Merge Sort Method");
        int[] array5 = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array5);
        
        // declares, initializes, sorts, and prints the sorted array
        int[] sortedArray5 = insertionSort(array5); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray5);
    }
    
    public static int[] mySort(int[] ints){ // my method to sort the array
        // creates a new array the same length as the original
        int[] sorted = new int[ints.length];

        // for loop runs through array
        for(int j = 0; j < ints.length; j++) {
            // declares and initializes two variables to store values
            int lowest = 999999999;
            int position = 0;
            for(int i = 0; i < ints.length; i++){
                // identify lowest value in array
                if(ints[i] < lowest){
                    lowest = ints[i];
                    position = i;
                }
            }
            // add the lowest value to the sorted array
            sorted[j] = lowest;
            
            // set the lowest value to an abnormally high number to avoid choosing it again
            ints[position] = 999999999;
        }
        
        // returns the sorted array
        return sorted;
    }
    
    public static int[] bubbleSort(int[] ints){ // uses bubble sort
        // where the sort ends each time
        int limit = ints.length - 1;
        
        // repeats until the limit gets to 1
        for(int i = limit; i > 1; i--){
            // runs through the array until the limit
            for(int j = 0; j < limit; j++){
                // compares the current value to the one after
                if(ints[j] > ints[j+1]){
                    // if the current value is greater, swap the two
                    int tempJ = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = tempJ;
                }
            }
        }
        // returns the sorted array
        return ints;
    }
    
    public static int[] selectionSort(int[] ints){ // uses selection sort
        // repeats until the index is one less than the array length
        for(int i = 0; i < ints.length - 1; i++){
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < ints.length; j++) {
                // compares the start value to the ones after it
                if(ints[j] < ints[start]){
                    start = j;
                }
            }
            // swapping part
            int tempJ = ints[start];
            ints[start] = ints[i];
            ints[i] = tempJ;
        }
        
        // returns the sorted array
        return ints;
    }
    
    public static int[] insertionSort(int[] ints){ // uses insertion sort
        int tempJ;
        // repeats until the index is one less than the array length
        for(int i = 1; i < ints.length; i++){
            // runs through the array beginning at i and going backward
            for(int j = i; j > 0; j--) {
                // compares the start value to the ones after it
                if(ints[j] < ints[j-1]){
                    // if the current value is less, swap the two
                    tempJ = ints[j];
                    ints[j] = ints[j-1];
                    ints[j-1] = tempJ;
                }
            }
        }
        
        // returns the sorted array
        return ints;
    }
    
    public static int[] mergeSort(int[] a, int n){ // uses merge sort
        if(n < 2){
            return a; // finished
        }
        int mid = n/2;
        int[] l = new int[mid]; // one half of array
        int[] r = new int[n - mid]; // other half of array
        for(int i = 0; i < mid; i++){
            l[i] = a[i]; // initializes array
        }
        for(int i = mid; i < n; i++){
            r[i - mid] = a[i]; // initializes array
        }
        
        // recursive part
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        // to merge the smaller arrays
        merge(a, l, r, mid, n - mid);
        
        // returns the sorted array
        return a;
    }
    
    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        // merge method for merge sort
        // instance variables to keep track of index within array
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left && j < right){
            // runs through array until reaching the end (middle)
            if(l[i] <= r[j]){
                a[k++] = l[i++]; // adds the left value to the array
            } else {
                a[k++] = r[j++]; // adds the right value to the array
            }
        }
        while(i < left) {
            a[k++] = l[i++]; // incrementation
        }
        while(j < right) {
            a[k++] = r[j++]; // incrementation
        }
    }
    
    public static void printArray(int[] ints){ // extra method to print an array
        // runs through the array, printing the values
        for(int i = 0; i < ints.length - 1; i++){
            System.out.print(ints[i] + ", ");
        }
        
        // prints the final value with a bracket instead of a comma
        System.out.println(ints[ints.length - 1] + "]");
    }
}