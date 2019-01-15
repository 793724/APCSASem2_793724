import java.util.ArrayList;
/**
 * Lab 114b Sorting: ArrayList
 *
 * @ Emma Chiu
 * @ 1/14/19
 */

public class ArraySort {
    public static void main() { // main method
        
        //MY SORT
        // declares, initializes, and prints original array
        System.out.println("MySort Method");
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        array1.add(500);
        array1.add(25);
        array1.add(1);
        array1.add(81);
        array1.add(4);
        array1.add(49);
        System.out.print("Here is your unsorted array: [");
        printArray(array1);
        
        // declares, initializes, sorts, and prints the sorted array
        ArrayList<Integer> sortedArray1 = mySort(array1); // mySort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray1);
        
        // BUBBLE SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Bubble Sort Method");
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        array2.add(500);
        array2.add(25);
        array2.add(1);
        array2.add(81);
        array2.add(4);
        array2.add(49);
        System.out.print("Here is your unsorted array: [");
        printArray(array2);
        
        // declares, initializes, sorts, and prints the sorted array
        ArrayList<Integer> sortedArray2 = bubbleSort(array2); // bubbleSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray2);
        
        
        // SELECTION SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Selection Sort Method");
        ArrayList<Integer> array3 = new ArrayList<Integer>();
        array3.add(500);
        array3.add(25);
        array3.add(1);
        array3.add(81);
        array3.add(4);
        array3.add(49);
        System.out.print("Here is your unsorted array: [");
        printArray(array3);
        
        // declares, initializes, sorts, and prints the sorted array
        ArrayList<Integer> sortedArray3= selectionSort(array3); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray3);
        
        
        // INSERTION SORT
        // declares, initializes, and prints original array
        System.out.println();
        System.out.println("Insertion Sort Method");
        ArrayList<Integer> array4 = new ArrayList<Integer>();
        array4.add(500);
        array4.add(25);
        array4.add(1);
        array4.add(81);
        array4.add(4);
        array4.add(49);
        System.out.print("Here is your unsorted array: [");
        printArray(array4);
        
        // declares, initializes, sorts, and prints the sorted array
        ArrayList<Integer> sortedArray4= insertionSort(array4); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray4);
    }
    
    public static ArrayList<Integer> mySort(ArrayList<Integer> ints){ // my method to sort the array
        // metrics variables
        int compares = 0;
        int swaps = 0;
        double time = System.nanoTime();
        
        // creates a new array list
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        // for loop runs through array
        for(int j = 0; j < ints.size(); j++) {
            // declares and initializes two variables to store values
            int lowest = 999999999;
            int position = 0;
            for(int i = 0; i < ints.size(); i++){
                // identify lowest value
                compares++;
                if(ints.get(i) < lowest){
                    lowest = ints.get(i);
                    position = i;
                    swaps++;
                }
            }
            // add the lowest value to the sorted array
            sorted.add(lowest);
            
            // set the lowest value to an abnormally high number to avoid choosing it again
            ints.set(position, 999999999);
        }
        double endTime = System.nanoTime();
        
        // prints metrics
        System.out.println("Compares: " + compares);
        System.out.println("Swaps: " + swaps);
        System.out.println("Nanoseconds taken: " + (endTime - time));
        
        // returns the sorted array
        return sorted;
    }
    
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> ints){ // uses bubble sort
        // metrics variables
        int compares = 0;
        int swaps = 0;
        double time = System.nanoTime();
        
        // where the sort ends each time
        int limit = ints.size() - 1;
        
        // repeats until the limit gets to 1
        for(int i = limit; i > 1; i--){
            // runs through the array until the limit
            for(int j = 0; j < limit; j++){
                // compares the current value to the one after
                compares++;
                if(ints.get(j) > ints.get(j+1)){
                    // if the current value is greater, swap the two
                    int tempJ = ints.get(j);
                    ints.set(j, ints.get(j+1));
                    ints.set(j+1, tempJ);
                    swaps++;
                }
            }
        }
        double endTime = System.nanoTime();
        
        // prints metrics
        System.out.println("Compares: " + compares);
        System.out.println("Swaps: " + swaps);
        System.out.println("Nanoseconds taken: " + (endTime - time));
        
        // returns the sorted array
        return ints;
    }
    
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> ints){ // uses selection sort
        // metrics variables
        int compares = 0;
        int swaps = 0;
        double time = System.nanoTime();
        
        // repeats until the index is one less than the array length
        for(int i = 0; i < ints.size() - 1; i++){
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < ints.size(); j++) {
                // compares the start value to the ones after it
                compares++;
                if(ints.get(j) < ints.get(start)){
                    start = j;
                }
            }
            // swapping part
            int tempJ = ints.get(start);
            ints.set(start, ints.get(i));
            ints.set(i, tempJ);
            swaps++;
        }
        double endTime = System.nanoTime();
        
        // prints metrics
        System.out.println("Compares: " + compares);
        System.out.println("Swaps: " + swaps);
        System.out.println("Nanoseconds taken: " + (endTime - time));
        
        // returns the sorted array
        return ints;
    }
    
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> ints){ // uses insertion sort
        // metrics variables
        int compares = 0;
        int swaps = 0;
        double time = System.nanoTime();
        
        int tempJ;
        // repeats until the index is one less than the array length
        for(int i = 1; i < ints.size(); i++){
            // runs through the array beginning at i and going backward
            for(int j = i; j > 0; j--) {
                // compares the start value to the ones after it
                compares++;
                if(ints.get(j) < ints.get(j-1)){
                    // if the current value is less, swap the two
                    tempJ = ints.get(j);
                    ints.set(j, j-1);
                    ints.set(j-1, tempJ);
                    swaps++;
                }
            }
        }
        double endTime = System.nanoTime();
        
        // prints metrics
        System.out.println("Compares: " + compares);
        System.out.println("Swaps: " + swaps);
        System.out.println("Nanoseconds taken: " + (endTime - time));
        
        // returns the sorted array
        return ints;
    }
    
    public static void printArray(ArrayList<Integer> ints){ // extra method to print an array
        // runs through the array, printing the values
        for(int i = 0; i < ints.size() - 1; i++){
            System.out.print(ints.get(i) + ", ");
        }
        
        // prints the final value with a bracket instead of a comma
        System.out.println(ints.get(ints.size() - 1) + "]");
    }
}