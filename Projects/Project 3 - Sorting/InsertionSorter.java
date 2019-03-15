/**
 * Project 3 - Sorting
 * 
 * @ Emma Chiu
 * @ 3/13/19
 */

public class InsertionSorter extends Sorter{
    public void sort(int[] a) {
        // repeats until the index is one less than the array length
        for(int i = 1; less(i, a.length); i++){
            // runs through the array beginning at i and going backward
            for(int j = i; less(0, j); j--) {
                // compares the start value to the ones after it
                if(less(a[j], a[j-1])){
                    // if the current value is less, swap the two
                    swap(a, j, j-1);
                }
            }
        }
    }
}