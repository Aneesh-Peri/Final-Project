import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class PokemonDriver
{
   public static void main(String[] args) 
   {
      JFrame frame = new JFrame("Pokemon Red");
      frame.setTitle("Pokemon Elite 4");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(160, 140);

      MainPanel mainPanel = new MainPanel(frame);
      frame.add(mainPanel);
      
      frame.pack();
      
      frame.setVisible(true);
   }
}