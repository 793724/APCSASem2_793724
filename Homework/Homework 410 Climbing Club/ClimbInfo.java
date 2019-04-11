/**
 * Homework 410 Climbing Club
 *
 * @ Emma Chiu
 * @ 4/10/19
 */

public class ClimbInfo {
    // instance variables, a constructor, and methods as described in provided info
    String name;
    int time;
    
    public ClimbInfo(String peakName, int climbTime){
        name = peakName;
        time = climbTime;
    }
    
    public String getName(){
        return name;
    }
    
    public int getTime(){
        return time;
    }
}
