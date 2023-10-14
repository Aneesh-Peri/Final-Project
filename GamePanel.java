import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable
{
   // fields 
   //screen sizing
   public final int originalTileSize = 16;
   public final int scale = 3;
   public final int tileSize = originalTileSize * scale; // 48px tiles (scale 3x)
   public final int maxScreenCol = 10;
   public final int maxScreenRow = 9;
   public final int screenWidth = tileSize * maxScreenCol; //w = 160
   public final int screenHeight = tileSize * maxScreenRow; //h = 144
   boolean up = false;
   boolean down = false;
   boolean left = false;
   boolean right = false;
   
   public final int maxWorldCol = 50;
   public final int maxWorldRow = 50;
   public final int worldWidth = maxWorldCol*tileSize;
   public final int worldHeight = maxWorldRow*tileSize;
   
   TileManager tileM = new TileManager(this);
   Key key = new Key();
   public CollisionChecker cChecker = new CollisionChecker(this);
   public Thread gameThread;
   Player player;
   MainPanel mp;
   //Player player = new Player(this, this.key);
   //Rival rival = new Rival(this);
   
   int playerX = 100;
   int playerY = 100;
   int playerSpeed = 4;
   
   //constructor
   public GamePanel(MainPanel mp)
   {
      this.mp = mp;
      player = new Player(this, this.key, this.mp);
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      
      this.addKeyListener(new Key());
      this.setFocusable(true);
   }
   
   //methods
   public void startGameThread()
   {
      gameThread = new Thread(this);
      gameThread.start();
   }
   
   public void stopGameThread()
   {
      gameThread = null;
   }
   
   public void run()
   {
      double drawInterval = 1000000000/60;
      double nextDrawTime = System.nanoTime() + drawInterval;

      while(gameThread != null)
      {
         update();
         repaint();
         
           
         try
         {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
            if(remainingTime < 0)
            {
            remainingTime = 0;
            }
   
            Thread.sleep((long) remainingTime);
            nextDrawTime += drawInterval;
         }
         catch(InterruptedException e)
         {
            e.printStackTrace();
         }
            

      }
   }
   
   public void update()
   {
      player.update();
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g1 = (Graphics2D)g;
      
      tileM.draw(g1);
      player.draw(g1);
      //rival.draw(g1);
            
      g1.dispose();
   }
      
   


   public class Key extends KeyAdapter //Make ONE class that EXTENDS KeyAdapter, and tell it what to do when keys are pressed or released
   {
      public void keyPressed(KeyEvent e) //Make ONE method for key presses; this is overridden, and will be called whenever a key is pressed
      {
         if(e.getKeyCode() == KeyEvent.VK_LEFT && !left) //e.getKeyCode() lets us retrieve which key was just pushed.  !left lets us know the user isn't already holding the left arrow down.
         {
            playerX -= playerSpeed;
            left = true;  //Now, the user is holding down the left key, so set this to true.  Why do we need to keep track of this?  Explanation in the assignment.
         }
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT && !right)
         {
            playerX += playerSpeed;
            right = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_UP && !up)
         {
            playerY -= playerSpeed;
            up = true;
         }
         else if(e.getKeyCode() == KeyEvent.VK_DOWN && !down)
         {
            playerY += playerSpeed;
            down = true;
         }
      }
         
      public void keyReleased(KeyEvent e)
      {
         if(e.getKeyCode() == KeyEvent.VK_LEFT) // If the user lets go of the left arrow
         {
            left = false;  //User is no longer holding the left key, so set this back to false.
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT) // If the user lets go of the left arrow
         {
            right = false;  //User is no longer holding the left key, so set this back to false.
         }
         if(e.getKeyCode() == KeyEvent.VK_UP) // If the user lets go of the left arrow
         {
            up = false;  //User is no longer holding the left key, so set this back to false.
         }
         if(e.getKeyCode() == KeyEvent.VK_DOWN) // If the user lets go of the left arrow
         {
            down = false;  //User is no longer holding the left key, so set this back to false.
         }
      }
   }
}