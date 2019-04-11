import java.util.ArrayList;
/**
 * Homework 410 Climbing Club
 *
 * @ Emma Chiu
 * @ 4/10/19
 */

public class Runner {
    public static void main() {
        // testing part a
        System.out.println("PART A:");
        ClimbingClub hikerClub = new ClimbingClub();
        hikerClub.addClimbA("Monadnock", 274);
        hikerClub.addClimbA("Whiteface", 301);
        hikerClub.addClimbA("Algonquin", 225);
        hikerClub.addClimbA("Monadnock", 344);
        hikerClub.print();
        // testing part c
        System.out.println("Distinct peaks: " + hikerClub.distinctPeakName());
        System.out.println();
        
        // testing part b
        System.out.println("PART B:");
        ClimbingClub hikerClubb = new ClimbingClub();
        hikerClubb.addClimbB("Monadnock", 274);
        hikerClubb.addClimbB("Whiteface", 301);
        hikerClubb.addClimbB("Algonquin", 225);
        hikerClubb.addClimbB("Monadnock", 344);
        hikerClubb.print();
        // testing part c
        System.out.println("Distinct peaks: " + hikerClubb.distinctPeakName());
    }
}
