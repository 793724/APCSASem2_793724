/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class German implements Languages{
    private int numSpeakers;
    private String name;

    public German() {
        numSpeakers = 132000000;
        name = "German";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)76000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "Hallo";
    }
}
