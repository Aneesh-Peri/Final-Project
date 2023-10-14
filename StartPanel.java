import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel
{
    // fields
    MainPanel mainPanel;

    // constructors
    public StartPanel(MainPanel mainPanel)
    {
        this.mainPanel = mainPanel;

        // Setting the BorderLayout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(480, 460));

        // Setting the Label with Basic Information about my screen
        try
        {
            BufferedImage myPicture = ImageIO.read(new File("images/final.jpg"));
            Image newImage = myPicture.getScaledInstance(480, 432, Image.SCALE_DEFAULT);
            JLabel picLabel = new JLabel(new ImageIcon(newImage));
            picLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(picLabel, BorderLayout.CENTER);
        }
        catch(IOException ex)
        {
            System.out.println("Image could not be found");
        }

        JButton save = new JButton("Save to File");
        save.setFont(new Font("SansSerif", Font.BOLD, 13));
        save.setHorizontalAlignment(SwingConstants.LEFT);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("saving...");
            }
        });

        JButton load = new JButton("Load to File");
        load.setFont(new Font("SansSerif", Font.BOLD, 13));
        load.setHorizontalAlignment(SwingConstants.CENTER);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("loading...");
            }
        });

        // Setting up our subPanel which will allow use to add the button.
        JPanel centerSubPanel = new JPanel();
        centerSubPanel.setLayout(new GridLayout(1,1));

        // Setting up our JButton which will allow the user in order to start the game
        JButton start = new JButton("Start");
        start.setSize(20,10);
        start.setHorizontalTextPosition(SwingConstants.CENTER);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("starting...");
                mainPanel.showGame();
            }
        });

        centerSubPanel.add(save);
        centerSubPanel.add(load);
        centerSubPanel.add(start);
        add(centerSubPanel,BorderLayout.SOUTH);
    }
}

