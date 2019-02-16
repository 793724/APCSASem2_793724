/**
 * Project 2 - Elevens
 * Activity 2
 * @ Emma Chiu
 * @ 2/14/19
 * 
 * This is a class that tests the Deck class.
 */

public class DeckTester {
    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        // create test decks
        Deck deck1 = new Deck(new String[] {"Ace", "Two", "Three", "Four", "Five"}, new String[] {"Clubs"}, new int[] {1, 2, 3, 4, 5});
        Deck deck2 = new Deck(new String[] {"Six", "Seven", "Eight", "Nine", "Ten"}, new String[] {"Spades"}, new int[] {6, 7, 8, 9, 10});
        Deck deck3 = new Deck(new String[] {"Jack", "Queen", "King"}, new String[] {"Hearts", "Diamonds"}, new int[] {11, 12, 13});
        
        // test deck 1
        System.out.println("DECK 1:");
        System.out.println("Empty: " + deck1.isEmpty());
        System.out.println("Starting size: " + deck1.size());
        System.out.println("Dealt card: " + deck1.deal());
        System.out.println("After dealing: " + deck1.toString());
        
        // test deck 2
        System.out.println("DECK 2:");
        System.out.println("Empty: " + deck2.isEmpty());
        System.out.println("Starting size: " + deck2.size());
        System.out.println("Dealt card: " + deck2.deal());
        System.out.println("After dealing: " + deck2.toString());
        
        // test deck 3
        System.out.println("DECK 3:");
        System.out.println("Empty: " + deck3.isEmpty());
        System.out.println("Starting size: " + deck3.size());
        System.out.println("Dealt card: " + deck3.deal());
        System.out.println("After dealing: " + deck3.toString());
    }
}