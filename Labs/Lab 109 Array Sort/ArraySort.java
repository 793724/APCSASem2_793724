/**
 * Lab 109 Array Sort
 *
 * @ Emma Chiu
 * @ 1/9/19
 */

public class ArraySort {
    public static void main() { // main method
        // declares, initializes, and prints original array
        int[] array = {500, 25, 4, 294, 81, 27, 0};
        System.out.print("Here is your unsorted array: [");
        printArray(array);
        
        // declares, initializes (calls sortArray method), and prints the sorted array
        int[] sortedArray = sortArray(array);
        System.out.print("Here is your sorted array: [");
        printArray(sortedArray);
    }
    
    public static int[] sortArray(int[] ints){ // method to sort the array
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
    
    public static void printArray(int[] ints){ // extra method to print an array
        // runs through the array, printing the values
        for(int i = 0; i < ints.length - 1; i++){
            System.out.print(ints[i] + ", ");
        }
        
        // prints the final value with a bracket instead of a comma
        System.out.println(ints[ints.length - 1] + "]");
    }
}
