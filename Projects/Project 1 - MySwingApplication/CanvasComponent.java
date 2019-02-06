import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 * Project 1 - MySwingApplication
 *
 * @ Emma Chiu
 * @ 1/31/19
 */

public class CanvasComponent extends JComponent implements ActionListener, MouseListener, MouseMotionListener{
    // instance variables
    int rectX;
    int rectY;
    int rectWidth;
    int rectHeight;
    int mouseFromX;
    int mouseFromY;
    boolean mouseInRect;
    boolean shapeSelected;
    int mouseToX;
    int mouseToY;
    int animationDeltaX;
    int animationDeltaY;
    int gutterX;
    int gutterY;
    Timer animationTimer;
    
    public CanvasComponent(int w, int h){
        // initializes canvas component object
        setSize(rectWidth, rectHeight);
        rectX = 150;
        rectY = 150;
        rectWidth = w;
        rectHeight = h;
        animationDeltaX = 1;
        animationDeltaY = 0;
        gutterX = 10;
        gutterY = 10;
        // picks up mouse events
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        // animation timer
        animationTimer = new Timer(20, this);
        animationTimer.start();
    }
    
    protected void paintComponent(Graphics g){
        // drawing the rectangle
        if(mouseInRect == true){
            // rectangle flashes random colors when your mouse is inside it/hasn't moved after exiting it
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B = (int)(Math.random()*256);
            Color randColor = new Color(R, G, B);
            g.setColor(randColor);
        } else {
            g.setColor(Color.black);
        }
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }
    
    public void mouseClicked(MouseEvent e){
        // empty method
    }
    
    public void mousePressed(MouseEvent e){
        // gets the position of the mouse
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        
        // determines whether or not the mouse is inside the rectangle
        if(mouseFromX > rectX && mouseFromX < rectX + rectWidth && mouseFromY > rectY && mouseFromY < rectY + rectHeight){
            shapeSelected = true;
        } else {
            shapeSelected = false;
        }
    }
    
    public void mouseReleased(MouseEvent e){
        // used to make rectangle start moving after letting go of it
        shapeSelected = false;
    }
    
    public void mouseEntered(MouseEvent e){
        // empty method
    }
    
    public void mouseExited(MouseEvent e){
        // empty method
    }
    
    public void mouseDragged(MouseEvent e){
        if(shapeSelected == true){
            // gets the second mouse position
            mouseToX = e.getX();
            mouseToY = e.getY();
            // increments x position of rectangle
            rectX = rectX + (mouseToX - mouseFromX);
            // increments y position of rectangle
            rectY = rectY + (mouseToY - mouseFromY);
            // resets and redraws the shape
            mouseFromX = mouseToX;
            mouseFromY = mouseToY;
            repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e){
        // gets the position of the mouse
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        
        // extra method to determine whether or not your cursor is in the rectangle
        if(mouseFromX > rectX && mouseFromX < rectX + rectWidth && mouseFromY > rectY && mouseFromY < rectY + rectHeight){
            mouseInRect = true;
        } else {
            mouseInRect = false;
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(shapeSelected == false){
            // new dimension object
            Dimension componentSizeDimension = getSize();
            if (rectX + rectWidth + animationDeltaX + gutterX > componentSizeDimension.getWidth()){
                // if the rectangle hits the right border, move down
                animationDeltaX = 0;
                animationDeltaY = 1;
                // resets x and y positions
                rectX = (int)componentSizeDimension.getWidth() - rectWidth - gutterX;
                rectY = rectY + animationDeltaY;
            } else if(rectY + rectHeight + animationDeltaY + gutterY > componentSizeDimension.getHeight()){
                // if the rectangle hits the bottom border, move left            
                animationDeltaX = -1;
                animationDeltaY = 0;
                // resets x and y positions
                rectX = rectX + animationDeltaX;
                rectY = (int)componentSizeDimension.getHeight() - rectHeight - gutterY;
            } else if(rectX + animationDeltaX < gutterX){
                // if the rectangle hits the left border, move up            
                animationDeltaX = 0;
                animationDeltaY = -1;
                // resets x and y positions
                rectX = gutterX;
                rectY = rectY + animationDeltaY;
            } else if(rectY + animationDeltaY < gutterY){
                // if the rectangle hits the top border, move right            
                animationDeltaX = 1;
                animationDeltaY = 0;
                // resets x and y positions
                rectX = rectX + animationDeltaX;
                rectY = gutterY;
            } else {
                // if the rectangle has not collided with a border, keep moving in the same direction
                rectX = rectX + animationDeltaX;
                rectY = rectY + animationDeltaY;
            }
        }
        // redraws the shape
        repaint();
    }
}
