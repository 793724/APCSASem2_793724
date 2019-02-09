import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.KeyEventDispatcher;
import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;
import java.util.Random;
/**
 * Simple Game
 *
 * @ Emma Chiu
 * @ 2/7/19
 * 
 * TO DO:
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
    boolean moveRight;
    boolean moveLeft;
    boolean moveUp;
    boolean moveDown;

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
        moveRight = false;
        moveLeft = false;
        moveUp = false;
        moveDown = false;
    }

    protected void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.fillRect(160, 40, 200, 200);
        g.setColor(Color.green);
        g.fillRect(360, 0, 40, 40);
        if(stop == true && dead == false){
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B = (int)(Math.random()*256);
            Color randColor = new Color(R, G, B);
            g.setColor(randColor);
            repaint();
        } else {
            g.setColor(Color.black);
        }
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
            int eyeX;
            int eyeY;
            if(moveRight == true){
                eyeX = rectX + 6;
                eyeY = rectY + 5;
                moveRight = false;
            } else if (moveLeft == true){
                eyeX = rectX + 3;
                eyeY = rectY + 5;
                moveLeft = false;
            } else if(moveUp == true){
                eyeX = rectX + 4;
                eyeY = rectY + 4;
                moveUp = false;
            } else if(moveDown == true){
                eyeX = rectX + 4;
                eyeY = rectY + 7;
                moveDown = false;
            } else {
                eyeX = rectX + 4;
                eyeY = rectY + 4;
            }
            g.fillOval(eyeX, eyeY, eyeSize/2, eyeSize/2);
            g.fillOval(eyeX + 8, eyeY, eyeSize/2, eyeSize/2);
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
            int eyeX;
            int eyeY;
            if(moveRight == true){
                eyeX = rectX + 30;
                eyeY = rectY + 25;
                moveRight = false;
            } else if (moveLeft == true){
                eyeX = rectX + 15;
                eyeY = rectY + 25;
                moveLeft = false;
            } else if(moveUp == true){
                eyeX = rectX + 22;
                eyeY = rectY + 20;
                moveUp = false;
            } else if(moveDown == true){
                eyeX = rectX + 22;
                eyeY = rectY + 35;
                moveDown = false;
            } else {
                eyeX = rectX + 22;
                eyeY = rectY + 20;
            }
            g.fillOval(eyeX, eyeY, eyeSize/2, eyeSize/2);
            g.fillOval(eyeX + 40, eyeY, eyeSize/2, eyeSize/2);
        }
        Graphics text = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 20);
        text.setFont(font);
        text.drawString("Welcome! Use the arrow keys to get to", 20, 390);
        text.drawString("the green square. Don't touch red!", 20, 420);
        Font smallFont = new Font("Serif", Font.PLAIN, 10);
        text.setFont(smallFont);
        text.drawString("(P.S. Stuck? Find a way to shift your luck!)", 20, 445);
        Font endFont = new Font("Serif", Font.PLAIN, 50);
        text.setFont(endFont);
        if(stop == true){
            if(dead == true){
                text.drawString("YOU LOSE.", 75, 200);
            } else {
                text.drawString("YOU WIN!", 80, 200);
            }
        }
    }

    public void keyPressed(KeyEvent e){
        if(stop == false){
            Dimension componentSizeDimension = getSize();
            if(e.isShiftDown() == true){
                small = true;
            } else if(e.getKeyCode() == 37){
                if(rectX > gutterX){
                    rectX = rectX - 20;
                    moveLeft = true;
                }
            } else if(e.getKeyCode() == 39){
                if(rectX + rectWidth < componentSizeDimension.getWidth() - gutterX){
                    rectX = rectX + 20;
                    moveRight = true;
                }
            } else if(e.getKeyCode() == 38){
                if(rectY > gutterY){
                    rectY = rectY - 20;
                    moveUp = true;
                }
            } else if(e.getKeyCode() == 40){
                if(rectY + rectHeight < componentSizeDimension.getHeight() - gutterY){
                    rectY = rectY + 20;
                    moveDown = true;
                }
            }
            repaint();
        }
        if(rectX + rectWidth > 160 && rectX < 360 && rectY + rectHeight > 40 && rectY < 240) {
            dead = true;
            stop = true;
        }
        if(rectX > 360 && rectY + rectHeight < 40 && small == true){
            stop = true;
        }
    }

    public void keyTyped(KeyEvent e){
        // empty method
    }

    public void keyReleased(KeyEvent e){
        // empty method
    }
}
