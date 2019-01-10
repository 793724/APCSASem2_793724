/**
 * Lab 110 Sorting Two (combined with lab 109)
 *
 * @ Emma Chiu
 * @ 1/10/19
 * 
 * ADD COMMENTS!
 */

public class ArraySort {
    public static void main() { // main method
        // declares, initializes, and prints original array
        int[] array = {500, 25, 1, 81, 4, 49};
        System.out.print("Here is your unsorted array: [");
        printArray(array);
        
        // declares, initializes, sorts, and prints the sorted array
        // int[] sortedArray = mySort(array); // mySort method
        // int[] sortedArray = bubbleSort(array); // bubbleSort method
        int[] sortedArray = selectionSort(array); // selectionSort method
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray);
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
        int limit = ints.length - 1;
        for(int i = limit; i > 1; i--){
            for(int j = 0; j < limit; j++){
                if(ints[j] > ints[j+1]){
                    int tempJ = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = tempJ;
                }
            }
        }
        return ints;
    }
    
    public static int[] selectionSort(int[] ints){ // uses selection sort
        for(int i = 0; i < ints.length - 1; i++){
            int start = i;
            for(int j = i + 1; j < ints.length; j++) {
                if(ints[j] < ints[start]){
                    int tempJ = ints[j];
                    ints[j] = ints[start];
                    ints[start] = tempJ;
                }
            }
        }
        return ints;
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