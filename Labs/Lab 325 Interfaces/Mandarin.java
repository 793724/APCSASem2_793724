/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Mandarin implements Languages{
    private int numSpeakers;
    String name;

    public Mandarin() {
        numSpeakers = 1090000000;
        name = "Mandarin";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)897000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "你好";
    }
}