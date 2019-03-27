/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class French implements Languages{
    private int numSpeakers;
    private String name;

    public French() {
        numSpeakers = 229000000;
        name = "French";
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
        return "Bonjour";
    }
}
