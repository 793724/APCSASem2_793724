import java.util.ArrayList;

/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Runner {
    public static void main() {
        // constructs one object of each language
        Languages m = new Mandarin();
        Languages s = new Spanish();
        Languages e = new English();
        Languages a = new Arabic();
        Languages r = new Russian();
        Languages g = new German();
        Languages f = new French();
        Languages p = new Portuguese();
        
        // constructs a new array list of languages objects
        ArrayList<Languages> list = new ArrayList<Languages>();
        
        // adds each language object to the array list
        list.add(m);
        list.add(s);
        list.add(e);
        list.add(a);
        list.add(r);
        list.add(g);
        list.add(f);
        list.add(p);
        
        // prints the list normally with each language
        System.out.println("Here is your list of languages!");
        print(list);
        
        // prints the list sorted by number of speakers
        System.out.println();
        System.out.println("The languages sorted by number of speakers worldwide (highest to lowest):");
        speakSort(list);
        printSpeak(list);
        
        // prints the list sorted by percentage of native speakers
        System.out.println();
        System.out.println("The languages sorted by percent of native speakers (highest to lowest):");
        nativeSort(list);
        printNative(list);
    }
    
    public static void speakSort(ArrayList<Languages> list) {
        // uses selection sort to sort the list by number of speakers
        
        // repeats until the index is one less than the array length
        for(int i = 0; i < list.size() - 1; i++) {
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < list.size(); j++) {
                // compares the start value to the ones after it
                if(list.get(j).getSpeakers() > list.get(start).getSpeakers()){
                    start = j;
                }
            }
            // swapping part
            Languages temp = list.get(start);
            list.set(start, list.get(i));
            list.set(i, temp);
        }
    }
    
    public static void nativeSort(ArrayList<Languages> list) {
        // uses selection sort to sort the list by percentage of native speakers
        
        // repeats until the index is one less than the array length
        for(int i = 0; i < list.size() - 1; i++) {
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < list.size(); j++) {
                // compares the start value to the ones after it
                if(list.get(j).nativeSpeak() > list.get(start).nativeSpeak()){
                    start = j;
                }
            }
            // swapping part
            Languages temp = list.get(start);
            list.set(start, list.get(i));
            list.set(i, temp);
        }
    }
    
    public static void printSpeak(ArrayList<Languages> list) {
        // prints the list, labeling each with the number of speakers
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + list.get(i).getName() + ": " + list.get(i).getSpeakers());
        }
    }
    
    public static void printNative(ArrayList<Languages> list) {
        // prints the list, labeling each with the percentage of native speakers
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + list.get(i).getName() + ": " + list.get(i).nativeSpeak());
        }
    }
    
    public static void print(ArrayList<Languages> list) {
        // prints the list, labeling each with the translated "hello"
        
        for(int i = 0; i < list.size(); i++) {
            System.out.println("    " + list.get(i).getName() + ": " + list.get(i).sayHello());
        }
    }
}
