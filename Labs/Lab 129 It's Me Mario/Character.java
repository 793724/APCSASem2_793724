/**
 * Lab 129 It's Me Mario
 *
 * @ Emma Chiu
 * @ 1/29/19
 */

public class Character {
    String catchphrase;
    int speed;
    
    public Character(String c, int s) {
        catchphrase = c;
        speed = s;
    }

    public void setCatchphrase(String phrase) {
        catchphrase = phrase;
    }
    
    public String getCatchphrase() {
        return catchphrase;
    }
    
    public void setSpeed(int value) {
        speed = value;
    }
    
    public int getSpeed() {
        return speed;
    }
}
