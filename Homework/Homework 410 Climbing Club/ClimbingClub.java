import java.util.ArrayList;
/**
 * Homework 410 Climbing Club
 *
 * @ Emma Chiu
 * @ 4/10/19
 */

public class ClimbingClub {
    private ArrayList<ClimbInfo> climbList;
    
    public ClimbingClub() {
        climbList = new ArrayList<ClimbInfo>();
    }
    
    // PART A - add new climbInfo objects to the array list
    public void addClimbA(String peakName, int climbTime){
        ClimbInfo added = new ClimbInfo(peakName, climbTime);
        climbList.add(added);
    }
    
    // PART B - alphabetically add new climbInfo objects to the array list
    public void addClimbB(String peakName, int climbTime){
        ClimbInfo toAdd = new ClimbInfo(peakName, climbTime);
        for(int i = 0; i < climbList.size(); i++){
            if(peakName.compareTo(climbList.get(i).getName()) <= 0) {
                // checks alphabetical order using "compare to" method
                climbList.add(i, toAdd);
                return;
            }
        }
        
        climbList.add(toAdd);
    }
    
    public int distinctPeakName() {
        if(climbList.size() == 0) {
            return 0;
        }
        
        ClimbInfo currInfo = climbList.get(0);
        String prevName = currInfo.getName();
        String currName = null;
        int numNames = 1;
        
        for(int k = 1; k < climbList.size(); k++){
            currInfo = climbList.get(k);
            currName = currInfo.getName();
            if(prevName.compareTo(currName) != 0){
                numNames++;
                prevName = currName;
            }
        }
        
        return numNames;
        
        // question answers:
        
        // no, implementing distinctPeakNames will not work if the names are
        // ordered as in part a, since the two similar names are not next to
        // one another and will therefore not be detected
        
        // yes, implementing distinctPeakNames will work if the names are ordered
        // as in part b, since all similar names will be next to one another
        // and will be detected accordingly
    }
    
    public void print() {
        // extra method used to test within the runner class
        for(int i = 0; i < climbList.size(); i++){
            System.out.println(climbList.get(i).getName() + ", " + climbList.get(i).getTime());
        }
    }
}
