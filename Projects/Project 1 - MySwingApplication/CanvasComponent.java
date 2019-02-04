import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Project 1 - MySwingApplication
 *
 * @ Emma Chiu
 * @ 1/31/19
 */

public class CanvasComponent extends JComponent implements MouseListener, MouseMotionListener{
    int rectX;
    int rectY;
    int rectWidth;
    int rectHeight;
    int mouseFromX;
    int mouseFromY;
    boolean shapeSelected;
    int mouseToX;
    int mouseToY;
    
    public CanvasComponent(int w, int h){
        setSize(rectWidth, rectHeight);
        rectX = 150;
        rectY = 150;
        rectWidth = w;
        rectHeight = h;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    protected void paintComponent(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
    }
    
    public void mouseClicked(MouseEvent e){
    }
    
    public void mousePressed(MouseEvent e){
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        
        if(mouseFromX > rectX && mouseFromX < rectX + rectWidth && mouseFromY > rectY && mouseFromY < rectY + rectHeight){
            shapeSelected = true;
        }
    }
    
    public void mouseReleased(MouseEvent e){
    }
    
    public void mouseEntered(MouseEvent e){
    }
    
    public void mouseExited(MouseEvent e){
    }
    
    public void mouseDragged(MouseEvent e){
        if(shapeSelected == true){
            mouseToX = e.getX();
            mouseToY = e.getY();
            rectX = rectX + (mouseToX - mouseFromX);
            rectY = rectY + (mouseToY - mouseFromY);
            mouseFromX = mouseToX;
            mouseFromY = mouseToY;
            repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e){
    }
}
