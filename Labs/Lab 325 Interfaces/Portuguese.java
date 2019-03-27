/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Portuguese implements Languages{
    private int numSpeakers;
    private String name;

    public Portuguese() {
        numSpeakers = 229000000;
        name = "Portuguese";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)218000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "Olá";
    }
}
