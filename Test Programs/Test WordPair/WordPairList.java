import java.util.ArrayList;
/**
 * Test WordPair
 *
 * @ Emma Chiu
 * @ 3/11/19
 */

public class WordPairList {
    private ArrayList<WordPair> allPairs;
    
    public static void main(){
        // test one example
        String[] wordNums = {"one", "two", "three"};
        WordPairList exampleOne = new WordPairList(wordNums);
        System.out.println("Example One:");
        exampleOne.print();
        System.out.println(exampleOne.numMatches());
        System.out.println();
        
        // test a second example
        String[] phrase = {"the", "more", "the", "merrier"};
        WordPairList exampleTwo = new WordPairList(phrase);
        System.out.println("Example Two:");
        exampleTwo.print();
        System.out.println(exampleTwo.numMatches());
    }
    
    public WordPairList(String[] words){
        allPairs = new ArrayList<WordPair>();
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }
    
    public int numMatches(){
        int matches = 0;
        for(int i = 0; i < allPairs.size(); i++){
            if(allPairs.get(i).getFirst().equals(allPairs.get(i).getSecond())){
                matches++;
            }
        }
        return matches;
    }
    
    public void print(){
        // extra method to print out WordPairLists
        for(int i = 0; i < allPairs.size(); i++){
            System.out.println(allPairs.get(i).getFirst() + ", " + allPairs.get(i).getSecond());
        }
    }
}
