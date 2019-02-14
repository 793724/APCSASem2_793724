/**
 * Project 2 - Elevens
 * Activity 1
 * @ Emma Chiu
 * @ 2/14/19
 * 
 * This is a class that tests the Card class.
 */

public class CardTester {
    /**
       * The main method in this class checks the Card operations for consistency.
       * @param args is not used.
    */
    
   public static void main(String[] args) {
       // Make new cards
       Card cardOne = new Card("Eight", "Clubs", 8);
       Card cardTwo = new Card("Ace", "Spades", 1);
       Card cardThree = new Card("Jack", "Diamonds", 11);
       
       // Test card one
       System.out.println("Card One:");
       System.out.println(cardOne.rank() + ", " + cardOne.suit() + ", " + cardOne.pointValue());
       System.out.println(cardOne.toString());
       System.out.println();
       
       // Test card two
       System.out.println("Card Two:");
       System.out.println(cardTwo.rank() + ", " + cardTwo.suit() + ", " + cardTwo.pointValue());
       System.out.println(cardTwo.toString());
       System.out.println();
       
       // Test card one
       System.out.println("Card Three:");
       System.out.println(cardThree.rank() + ", " + cardThree.suit() + ", " + cardThree.pointValue());
       System.out.println(cardThree.toString());
    }
}
