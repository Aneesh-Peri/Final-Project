import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.FontFormatException;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {
           
    BufferedImage img;
    Font font;
    Font sizedFont;
    
 
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g.drawImage(img, 0, 0, 200,200, null);
        g.setFont(sizedFont);
        g.drawString("CLOYSTER", 20, 20);
    }
 
    public LoadImageApp(){
       try {
           img = ImageIO.read(new File("/Users/nathanliu/Documents/School Resources/CS Foundations/Final Project/red_up_1.png"));

  
       } catch (IOException e) {
       }
       try{
         File font_file = new File("Font1.ttf");
         font = Font.createFont(Font.TRUETYPE_FONT, font_file);
         sizedFont = font.deriveFont(12f);
         
       } catch (IOException e) {
       } catch (FontFormatException f) {
       }
   
 
    }
 
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(200,200);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
 
    public static void main(String[] args) {
 
        JFrame f = new JFrame("Load Image Sample");
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new LoadImageApp());
        f.pack();
        f.setVisible(true);
    }
}