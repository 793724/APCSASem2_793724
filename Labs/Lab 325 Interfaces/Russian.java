/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Russian implements Languages{
    private int numSpeakers;
    private String name;

    public Russian() {
        numSpeakers = 267000000;
        name = "Russian";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)153000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "Привет";
    }
}
