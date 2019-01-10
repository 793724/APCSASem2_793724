/**
 * Warm Up 110 Swap Function
 *
 * @ Emma Chiu
 * @ 1/10/19
 */

public class Swap {
    public static void main() {
        int x = 9;
        int y = 12;
        swap(x, y);
    }
    
    public static void swap(int a, int b) {
        int oldA = a;
        a = b;
        b = oldA;
    }
}
