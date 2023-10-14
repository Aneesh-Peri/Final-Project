import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;

public class BattlePanel extends JPanel
{  
    // fields
   Font font;
   Font sizedFont;
   ImageIcon image1;
   JLabel picLabel;
   JLabel picLabel2;
   JLabel rivalPokemonName;
   JLabel playerPokemonName;
   private BufferedImage dialogueImage;
   private BufferedImage rivalPokemonImage;
   private BufferedImage playerPokemonImage;
   
   //temp:
   JPanel ImagePanel1;
   JPanel ImagePanel2;
    
   private BufferedImage myImage;
   private Graphics ben;
   Rectangle healthBar;
   MainPanel mainPanel;
   JFrame f;
    
   Pokemon activePlayerPokemon;
   Pokemon activeRivalPokemon;
   Pokemon[] playerDeck = new Pokemon[6];
   Pokemon[] rivalDeck = new Pokemon[6];
    
    // constructors
   public BattlePanel(MainPanel mainPanel)
   {   
      this.mainPanel = mainPanel;
        
        //bg setup
      try
      {
         myImage = new BufferedImage(480, 432,BufferedImage.TYPE_INT_RGB);
         ben = myImage.getGraphics();
         ben.setColor(Color.WHITE);
         ben.fillRect(0,0,480,432);
      }
      catch(Exception e)
      {
         System.out.println("Can't print out the background");
      }
      try 
      {
         File imageFile2 = new File("images/dialoguebox.png");
         dialogueImage = ImageIO.read(imageFile2);
      } 
      catch (IOException e) 
      {
         e.printStackTrace();
      }
        //importing font
      try
      {
         File font_file = new File("Font1.ttf");
         font = Font.createFont(Font.TRUETYPE_FONT, font_file);
         sizedFont = font.deriveFont(18f);
      }
      catch(FontFormatException e)
      {
         System.out.println("Can't import font");
      }
      catch(IOException e)
      {
         System.out.println("Can't import font");
      }
        
        //instantiating pokemon
      playerDeck[0] = new Pokemon("NIDOKING", 50, "THUNDERBOLT", "THRASH", "MEGA KICK", "ROCK SLIDE", "sprites/nidoking.png", 150);
      playerDeck[1] = new Pokemon("GYARADOS", 50, "BLIZZARD", "HYDRO PUMP", "THUNER", "SURF", "sprites/gyarados.png", 176);
      playerDeck[2] = new Pokemon("PIDGEOT", 50, "WING ATTACK", "AGILITY", "MEGA KICK", "ROCK SLIDE", "sprites/pidgeot_back.png", 150);
      playerDeck[3] = new Pokemon("CLEFABLE", 50, "FIRE BLAST", "ICE BEAM", "QUICK ATTACK", "FLY", "sprites/clefable.png", 171);
      playerDeck[4] = new Pokemon("VILEPLUME", 50, "SOLAR BEAM", "ABSORB", "BODY SLAM", "HYPER BEAM", "sprites/vileplume.png", 150);
      playerDeck[5] = new Pokemon("CHARIZARD", 50, "FLAMETHROWER", "CUT", "EARTHQUAKE", "STRENGTH", "sprites/charizard.png", 150);
        
      rivalDeck[0] = new Pokemon("PIDGEOT", 50, "SKY ATTACK", "", "", "", "sprites/pidgeot_front.png", 150);
      rivalDeck[1] = new Pokemon("ALAKAZAM", 50, "PSYCHIC", "", "", "", "sprites/alakazam.png", 176);
      rivalDeck[2] = new Pokemon("RHYDON", 50, "TAIL WHIP", "", "", "", "sprites/rhydon.png", 150);
      rivalDeck[3] = new Pokemon("ARCANINE", 50, "TAKE DOWN", "", "", "", "sprites/arcanine.png", 171);
      rivalDeck[4] = new Pokemon("EXEGGUTOR", 50, "STOMP", "", "", "", "sprites/exxegutor.png", 150);
      rivalDeck[5] = new Pokemon("BLASTOISE", 50, "BLIZZARD", "", "", "", "sprites/blastoise.png", 150);
      
      // setting actives
      activePlayerPokemon = playerDeck[0];
      activeRivalPokemon = rivalDeck[0];
      
      // Setting the BorderLayout
      setPreferredSize(new Dimension(480, 432));
      setLayout(new BorderLayout());
      
      // Importing sprites
      importPlayerSprite(activePlayerPokemon.getSpriteFilename());
      importRivalSprite(activeRivalPokemon.getSpriteFilename());
         
      JPanel topPanel = new JPanel(); // top panel (main one)
      topPanel.setPreferredSize(new Dimension(480,280));
      topPanel.setLayout(new GridLayout(2,2));
      add(topPanel, BorderLayout.NORTH);
      
      JPanel rivalStatsPanel = new JPanel(); // top left: stats for rival
      rivalStatsPanel.setLayout(new GridLayout(4,1));
      rivalPokemonName = new JLabel(activeRivalPokemon.getName()); // name
      rivalPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
      rivalPokemonName.setFont(sizedFont);
      rivalStatsPanel.add(rivalPokemonName);
      JLabel rivalLevel = new JLabel(":L50"); // level
      rivalLevel.setHorizontalAlignment(SwingConstants.CENTER);
      rivalLevel.setFont(sizedFont);
      rivalStatsPanel.add(rivalLevel);
      JLabel rivalHP = new JLabel("ㅤHP:"); // HP
      rivalHP.setHorizontalAlignment(SwingConstants.LEFT);
      rivalHP.setFont(sizedFont);
      rivalStatsPanel.add(rivalHP);
      topPanel.add(rivalStatsPanel);
      
      JLabel rivalImageLabel = new JLabel(new ImageIcon(rivalPokemonImage)); // top right: rival 'mon sprite
      //JLabel rivalLevel = new JLabel(":L" + activeRivalPokemon.getLevel());
      topPanel.add(rivalImageLabel);
      
      JLabel playerImageLabel = new JLabel(new ImageIcon(playerPokemonImage)); // bottom left: player 'mon sprite
      topPanel.add(playerImageLabel);
      
      JPanel playerStatsPanel = new JPanel(); // bottom right: stats for player
      playerStatsPanel.setLayout(new GridLayout(4,1));
      topPanel.add(playerStatsPanel);
      playerPokemonName = new JLabel(activePlayerPokemon.getName()); // name
      playerPokemonName.setHorizontalAlignment(SwingConstants.LEFT);
      playerPokemonName.setFont(sizedFont);
      playerStatsPanel.add(playerPokemonName);
      JLabel playerLevel = new JLabel(":L" + activePlayerPokemon.getLevel()); // level
      playerLevel.setHorizontalAlignment(SwingConstants.CENTER);
      playerLevel.setFont(sizedFont);
      playerStatsPanel.add(playerLevel);
      JLabel playerHP = new JLabel("ㅤHP:"); // HP
      playerHP.setHorizontalAlignment(SwingConstants.LEFT);
      playerHP.setFont(sizedFont);
      playerStatsPanel.add(playerHP);
      topPanel.add(playerStatsPanel);
      
   
      JPanel dialoguePanel = new JPanel(); // dialogue/menu panel        
      JLabel label = new JLabel("Hello World!");
      label.setPreferredSize(new Dimension(480, 152));
      label.setFont(font.deriveFont(25f));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setVerticalAlignment(SwingConstants.CENTER);
      label.setIcon(new ImageIcon(dialogueImage));
      label.setHorizontalTextPosition(SwingConstants.CENTER);
      label.setVerticalTextPosition(SwingConstants.CENTER);
      dialoguePanel.add(label);
      add(dialoguePanel, BorderLayout.SOUTH);
      
      JButton Return = new JButton("Return");
      Return.setPreferredSize(new Dimension(100,10));
      Return.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {  
               JFrame owner = f; 
               System.out.println("This is trying to run");
               MenuPanel menu = new MenuPanel(mainPanel);
               removeAll();
               add(menu);
               repaint();
               revalidate();
               owner.pack();
            } 
         });
      paintComponent(ben);
   }
   /*public void run()
   {
      while(playerDeck[0].getCurHP() != 0 &&
            playerDeck[1].getCurHP() != 0 &&
            playerDeck[2].getCurHP() != 0 &&
            playerDeck[3].getCurHP() != 0 &&
            playerDeck[4].getCurHP() != 0 &&
            playerDeck[5].getCurHP() != 0 &&
            rivalDeck[0].getCurHP() != 0 &&
            rivalDeck[1].getCurHP() != 0 &&
            rivalDeck[2].getCurHP() != 0 &&
            rivalDeck[3].getCurHP() != 0 &&
            rivalDeck[4].getCurHP() != 0 &&
            rivalDeck[5].getCurHP() != 0 )
      {
         
      }
   }*/
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Color barColor = new Color(4,102,27);
      g.setColor(barColor);
        
      g.fillRect(310,310,90,20); 
      g.fillRect(0,60,90,20);
   
   }
   public void setActivePlayerPokemon(Pokemon pokemon)
   {
      activePlayerPokemon = pokemon;
   }
   public void setRivalPlayerPokemon(Pokemon pokemon)
   {
      activePlayerPokemon = pokemon;
   }
   public void importRivalSprite(String fileName)
   {
      try
      {
         rivalPokemonImage = ImageIO.read(new File(fileName));
      }
      catch(IOException e)
      {
         System.out.println("Can't import rival sprite");
      }
   }
   public void importPlayerSprite(String fileName)
   {
      try
      {
         playerPokemonImage = ImageIO.read(new File(fileName));
      }
      catch(IOException e)
      {
         System.out.println("Can't import player sprite");
      }
   }
   
    
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Pokemon Elite Four!");
        
      frame.setSize(new Dimension(480, 432));
      frame.setLocation(40, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new GridLayout(1,1));
      frame.setContentPane(new BattlePanel(new MainPanel(frame)));
      frame.pack(); 
      frame.setVisible(true);
   
   }
}