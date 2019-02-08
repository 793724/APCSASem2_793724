import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.KeyEventDispatcher;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
/**
 * Simple Game
 *
 * @ Emma Chiu
 * @ 2/7/19
 * 
 * TO DO:
 * - Limit window size
 * - Put win and lose methods on the screen
 * - Update instructions on-screen
 */

public class CanvasComponent extends JComponent implements KeyListener{
    // instance variables
    int rectX;
    int rectY;
    int arcWidth;
    int arcHeight;
    int rectWidth;
    int rectHeight;
    int eyeSize;
    boolean small;
    int gutterX;
    int gutterY;
    boolean dead;
    boolean stop;
    boolean thrown;

    public CanvasComponent(int w, int h){
        rectX = 10;
        rectY = 250;
        arcWidth = 20;
        arcHeight = 20;
        rectWidth = w;
        rectHeight = h;
        setSize(rectWidth, rectHeight);
        eyeSize = 30;
        gutterX = 10;
        gutterY = 10;
        dead = false;
        stop = false;
        thrown = false;
    }

    protected void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.fillRect(160, 40, 200, 200);
        g.setColor(Color.green);
        g.fillRect(360, 0, 40, 40);
        g.setColor(Color.black);
        if(small == true){
            rectWidth = 20;
            rectHeight = 20;
            arcWidth = 4;
            arcHeight = 4;
            eyeSize = 6;
            g.fillRoundRect(rectX, rectY, rectWidth, rectHeight, arcWidth, arcHeight);
            if(dead == false){
                g.setColor(Color.white);
            } else {
                g.setColor(Color.red);
            }
            g.fillOval(rectX + 3, rectY + 4, eyeSize, eyeSize);
            g.fillOval(rectX + 11, rectY + 4, eyeSize, eyeSize);
            g.setColor(Color.black);
            g.fillOval(rectX + 22/5, rectY + 4, eyeSize/2, eyeSize/2);
            g.fillOval(rectX + 62/5, rectY + 4, eyeSize/2, eyeSize/2);
        } else {
            g.fillRoundRect(rectX, rectY, rectWidth, rectHeight, arcWidth, arcHeight);
            if(dead == false){
                g.setColor(Color.white);
            } else {
                g.setColor(Color.red);
            }
            g.fillOval(rectX + 15, rectY + 20, eyeSize, eyeSize);
            g.fillOval(rectX + 55, rectY + 20, eyeSize, eyeSize);
            g.setColor(Color.black);
            g.fillOval(rectX + 22, rectY + 20, eyeSize/2, eyeSize/2);
            g.fillOval(rectX + 62, rectY + 20, eyeSize/2, eyeSize/2);
        }
        Graphics text = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 18);
        text.setFont(font);
        text.drawString("Welcome to the game! Use the arrow keys to", 10, 390);
        text.drawString("get to the green square. Don't touch red!", 10, 410);
        Font smallFont = new Font("Serif", Font.PLAIN, 10);
        text.setFont(smallFont);
        text.drawString("(P.S. Stuck? Find a way to shift your luck!)", 10, 425);
    }

    public void keyPressed(KeyEvent e){
        if(stop == false){
            Dimension componentSizeDimension = getSize();
            if(e.isShiftDown() == true){
                small = true;
            } else if(e.getKeyCode() == 37){
                if(rectX > gutterX){
                    rectX = rectX - 20;
                }
            } else if(e.getKeyCode() == 39){
                if(rectX + rectWidth < componentSizeDimension.getWidth() - gutterX){
                    rectX = rectX + 20;
                }
            } else if(e.getKeyCode() == 38){
                if(rectY > gutterY){
                    rectY = rectY - 20;
                }
            } else if(e.getKeyCode() == 40){
                if(rectY + rectHeight < componentSizeDimension.getHeight() - gutterY){
                    rectY = rectY + 20;
                }
            }
            repaint();
        }
        if(rectX + rectWidth > 160 && rectX < 360 && rectY + rectHeight > 40 && rectY < 240 && thrown == false) {
            dead = true;
            stop = true;
            System.out.println();
            System.out.println("YOU LOSE.");
            thrown = true;
        }
        if(rectX > 360 && rectY + rectHeight < 40 && small == true && thrown == false){
            stop = true;
            System.out.println();
            System.out.println("YOU WIN!");
            thrown = true;
        }
    }

    public void keyTyped(KeyEvent e){
        // empty method
    }

    public void keyReleased(KeyEvent e){
        // empty method
    }
}
