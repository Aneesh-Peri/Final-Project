import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

public class TestPanel
{  
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Pokemon Elite Four!");
        
        frame.setSize(new Dimension(480, 432));
        frame.setLocation(40, 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setLayout(new GridLayout(1,1));
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setContentPane(new TestingPanel(frame));
        frame.pack(); 
        frame.setVisible(true);

    }
}
class TestingPanel extends JPanel
{  
    // fields
    Font font;
    Font sizedFont;
    ImageIcon image1;
    JLabel picLabel;
    JLabel picLabel2;
    JLabel pokemonName;
    JLabel pokemonName2;
    // constructors
    public TestingPanel(JFrame frame)
    {   
        try
        {
            File font_file = new File("PokemonGb-RAeo.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, font_file);
            sizedFont = font.deriveFont(12f);
        }
        catch(FontFormatException e)
        {
            System.out.println("Can't import font");
        }
        catch(IOException e)
        {
         System.out.println("Can't import font");
        }
        // Setting the BorderLayout
      //setBackground(Color.blue);
      
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(480, 432));
        
 
        
        // Setting up the paths for the Sprites
        try
        {
        Image myPicture = ImageIO.read(new File("Lorelei Sprites/Cloyster.png"));
        Image resizedImage = myPicture.getScaledInstance(192,192, Image.SCALE_DEFAULT);
        picLabel = new JLabel(new ImageIcon(resizedImage));  
        picLabel.setHorizontalAlignment(SwingConstants.RIGHT);    
        }
        catch(IOException e)
        {
         System.out.println("Can't import image");
        }

        try
        {
        Image myPicture = ImageIO.read(new File("Lorelei Sprites/Lapras.png"));
        Image resizedImage = myPicture.getScaledInstance(192,192, Image.SCALE_DEFAULT);
        picLabel2 = new JLabel(new ImageIcon(resizedImage));  
        picLabel2.setHorizontalAlignment(SwingConstants.LEFT);    
        }
        catch(IOException e)
        {
         System.out.println("Can't import image");
        }     
        
        // Setting up our JPanels
        JPanel BigPanel1 = new JPanel();
        JPanel BigPanel2 = new JPanel();   
        JLabel level1 = new JLabel("Level 53");
        JLabel level2 = new JLabel("Level 54");
        level2.setHorizontalAlignment(SwingConstants.RIGHT);
        level1.setFont(sizedFont);
        JLabel hpBar1 = new JLabel("test");
        hpBar1.setFont(sizedFont);
        hpBar1.setHorizontalAlignment(JLabel.LEFT);
        JPanel northSubPanel = new JPanel();
        JPanel southSubPanel = new JPanel();
        JPanel ImagePanel1 = new JPanel();
        ImagePanel1.setLayout(new GridLayout());
        JPanel ImagePanel2 = new JPanel();
        ImagePanel2.setLayout(new GridLayout());
        pokemonName = new JLabel("Cloyster");   
        pokemonName.setHorizontalAlignment(SwingConstants.LEFT);
        pokemonName.setFont(sizedFont);
        pokemonName2 = new JLabel("Lapras");
        pokemonName2.setFont(sizedFont);
        pokemonName2.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel hp = new JLabel("141");
        hp.setFont(sizedFont);
        JLabel hp2 = new JLabel("256");
        hp2.setFont(sizedFont);
        hp2.setHorizontalAlignment(SwingConstants.RIGHT);
        
        BigPanel1.setLayout(new GridLayout(3,1));
        BigPanel2.setLayout(new GridLayout(3,1));
        northSubPanel.setLayout(new GridLayout(1,3));
        southSubPanel.setLayout(new GridLayout(1,3));

        BigPanel1.add(pokemonName);
        BigPanel1.add(hp);
        BigPanel1.add(level1);
        ImagePanel1.add(picLabel);
        northSubPanel.add(BigPanel1);
        northSubPanel.add(ImagePanel1);
        add(northSubPanel, BorderLayout.NORTH);  

        BigPanel2.add(pokemonName2);
        BigPanel2.add(hp2);
        BigPanel2.add(level2);
        ImagePanel2.add(picLabel2);
        southSubPanel.add(ImagePanel2);
        southSubPanel.add(BigPanel2);
        add(southSubPanel, BorderLayout.SOUTH);

                

    }
}