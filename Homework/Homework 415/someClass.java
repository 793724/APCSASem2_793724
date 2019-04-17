import java.util.ArrayList;
/**
 * Homework 415 - Problem 4
 *
 * @ Emma Chiu
 * @ 4/15/19
 */

public class someClass {
    static ArrayList<String> s;
    
    public someClass() {
        // fill list
        s = new ArrayList<String>();
        s.add("Apple");
        s.add("Banana");
        s.add("Cat");
        s.add("Dog");
        s.add("Cockroach");
        s.add("Elephant");
        s.add("Donkey");
    }
    
    public static void main() {
        // to test methods
        someClass c = new someClass();
        
        // print original
        System.out.println("The original ArrayList is as follows:");
        c.print();
        System.out.println();
        
        // scramble and print
        c.shuffleStrings(s);
        System.out.println("The scrambled ArrayList is as follows:");
        c.print();
        System.out.println();
        
        // sort and print
        c.sortStrings(s);
        System.out.println("The sorted ArrayList is as follows:");
        c.print();
        System.out.println();
        
        // insertString method
        c.insertString("stop");
        System.out.println("The ArrayList with the inserted string is as follows:");
        c.print();
        System.out.println();
    }
    
    public void sortStrings(ArrayList<String> names) {
        // selection sort
        // repeats until the index is one less than the array length
        for(int i = 0; i < names.size() - 1; i++){
            // value at which to start the sort
            int start = i;
            // runs through the array beginning just after the start
            for(int j = i + 1; j < names.size(); j++) {
                // compares the start value to the ones after it
                if(names.get(j).compareTo(names.get(start)) < 0){
                    start = j;
                }
            }
            // swapping part
            String tempJ = names.get(start);
            names.set(start, names.get(i));
            names.set(i, tempJ);
        }
    }
    
    public void shuffleStrings(ArrayList<String> names) {
        // shuffle the contents of names
        for(int i = 0; i < names.size(); i++){
            int rand = (int)(Math.random()*names.size());
            String temp = names.get(i);
            names.set(i, names.get(rand));
            names.set(rand, temp);
        }
    }
    
    public void insertString(String word) {
        // insert the parameter "word" after the last sorted index in the array
        for(int i = 0; i < s.size() - 1; i++){
            if(s.get(i).compareTo(s.get(i+1)) > 1){
                s.add(i, word);
                return;
            }
        }
        s.add(word);
    }
    
    public void print() {
        // to print out s
        for(int i = 0; i < s.size(); i++){
            System.out.print(s.get(i) + " ");
        }
        System.out.println();
    }
}