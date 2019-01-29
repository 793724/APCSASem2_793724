/**
 * Lab 129 It's Me Mario
 *
 * @ Emma Chiu
 * @ 1/29/19
 */

public class Mario extends Character{
    public Mario(String c, int s){
        super(c, s);
    }

    public void setSpeed(int speed){
        super.setSpeed(speed*2);
    }
}
