/**
 * Lab 325 Interfaces
 *
 * @ Emma Chiu
 * @ 3/25/19
 */

public class Spanish implements Languages{
    private int numSpeakers;
    private String name;

    public Spanish() {
        numSpeakers = 527000000;
        name = "Spanish";
    }
    
    public int getSpeakers() {
        return numSpeakers;
    }
    
    public String getName() {
        return name;
    }
    
    public double nativeSpeak() {
        return (double)436000000/(double)numSpeakers * 100.0;
    }
    
    public String sayHello() {
        return "Hola";
    }
}
