/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class English implements Languages{
    private int numSpeakers;
    private String name;

    public English() {
        numSpeakers = 983000000;
        name = "English";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)371000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "Hello";
    }
}