/**
 * Project 3 - Sorting
 * 
 * @ Emma Chiu
 * @ 3/13/19
 */

public class SelectionSorter extends Sorter{
    public void sort(int[] a) {
        // repeats until the index is one less than the array length
        for(int i = 0; less(i, a.length - 1); i++){
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; less(j, a.length); j++) {
                // compares the start value to the ones after it
                if(less(a[j], a[start])){
                    move(a, start, j);
                }
            }
            // swapping part
            swap(a, start, i);
        }
    }
}