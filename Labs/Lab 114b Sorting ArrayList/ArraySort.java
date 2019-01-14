import java.util.ArrayList;
/**
 * Lab 114b Sorting: ArrayList
 *
 * @ Emma Chiu
 * @ 1/14/19
 */

public class ArraySort {
    public static void main() { // main method
        //MAIN ARRAYLIST
        ArrayList<Integer> mainArray = new ArrayList<Integer>();
        mainArray.add(500);
        mainArray.add(25);
        mainArray.add(1);
        mainArray.add(81);
        mainArray.add(4);
        mainArray.add(49);
        
        //MY SORT
        // declares, initializes, and prints original array
        System.out.println("MySort Method");
        ArrayList<Integer> array1 = mainArray;
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
        ArrayList<Integer> array2 = mainArray;
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
        ArrayList<Integer> array3 = mainArray;
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
        ArrayList<Integer> array4 = mainArray;
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
            sorted.set(j, lowest);
            
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
        int limit = ints.length - 1;
        
        // repeats until the limit gets to 1
        for(int i = limit; i > 1; i--){
            // runs through the array until the limit
            for(int j = 0; j < limit; j++){
                // compares the current value to the one after
                compares++;
                if(ints[j] > ints[j+1]){
                    // if the current value is greater, swap the two
                    int tempJ = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = tempJ;
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
        for(int i = 0; i < ints.length - 1; i++){
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < ints.length; j++) {
                // compares the start value to the ones after it
                compares++;
                if(ints[j] < ints[start]){
                    start = j;
                }
            }
            // swapping part
            int tempJ = ints[start];
            ints[start] = ints[i];
            ints[i] = tempJ;
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
        for(int i = 1; i < ints.length; i++){
            // runs through the array beginning at i and going backward
            for(int j = i; j > 0; j--) {
                // compares the start value to the ones after it
                compares++;
                if(ints[j] < ints[j-1]){
                    // if the current value is less, swap the two
                    tempJ = ints[j];
                    ints[j] = ints[j-1];
                    ints[j-1] = tempJ;
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