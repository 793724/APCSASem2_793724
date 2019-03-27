/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Arabic implements Languages{
    private int numSpeakers;
    private String name;

    public Arabic() {
        numSpeakers = 422000000;
        name = "Arabic";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)290000000/(double)numSpeakers * 100.0;
    }
        
    public String sayHello() {
        return "مرحبا";
    }
}
