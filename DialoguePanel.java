import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import javax.swing.OverlayLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import java.awt.event.*;

public class DialoguePanel extends JPanel 
{
    private BufferedImage image;
    private BufferedImage dialogueImage;
    KeyHandler key = new KeyHandler();
    MainPanel mp;
    Font font;
   
    public DialoguePanel(MainPanel mp) 
    {
        this.mp = mp;
        setPreferredSize(new Dimension(480, 432));
        setLayout(new BorderLayout());
        this.addKeyListener(new KeyHandler());
        try 
        {
            File imageFile = new File("images/screenshot.png");
            image = ImageIO.read(imageFile);
            File imageFile2 = new File("images/dialoguebox.png");
            dialogueImage = ImageIO.read(imageFile2);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        try
        {
        File font_file = new File("Font1.ttf");
        font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        } catch (IOException e) {
        } catch (FontFormatException f) {
        }
        
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel, BorderLayout.NORTH);
        
        JLabel label = new JLabel("<html>ㅤI'm the Pokémon league champion!<br>ㅤDo you know what that means?<br>ㅤI am the most powerful trainer<br>ㅤin the world!<br>ㅤ<br>ㅤㅤㅤㅤ(press space to continue)</html>");
        label.setPreferredSize(new Dimension(480, 152));
        label.setFont(font.deriveFont(13f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon(dialogueImage));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);

        
        add(label, BorderLayout.SOUTH);
    }
    private class KeyHandler extends KeyAdapter
    {
      public void keyPressed(KeyEvent e) 
      {
         if(e.getKeyCode() == KeyEvent.VK_SPACE) 
         {
            mp.showBattle();
         }
      }
    }
}