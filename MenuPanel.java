import javax.swing.*;
import java.awt.*;



public class MenuPanel extends JPanel
{
    MainPanel mainPanel;
    public MenuPanel(MainPanel mainPanel)
    {   
        this.mainPanel = mainPanel;
        setPreferredSize(new Dimension(480,432));
        JPanel CenterSubPanel = new JPanel();
        JButton Save = new JButton("Save to File: ");
        Save.setHorizontalAlignment(SwingConstants.CENTER);
        JButton Load = new JButton("Load to File: ");
        Load.setHorizontalAlignment(SwingConstants.CENTER);
        JButton Return = new JButton("Return back to Game: ");
        JPanel WestSubPanel = new JPanel();

        CenterSubPanel.add(Save);
        CenterSubPanel.add(Load);
        CenterSubPanel.add(Return);
        add(CenterSubPanel,BorderLayout.CENTER);

        WestSubPanel.add(Return);
        add(WestSubPanel, BorderLayout.EAST);
    }

}