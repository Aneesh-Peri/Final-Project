import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Player extends Character
{
   GamePanel gp;
   GamePanel.Key k;
   MainPanel mp;
   Boolean standing = true;
   
   Boolean temp = false;
   Boolean swap = false;
   String tempDir = "";
   public final int screenX;
   public final int screenY;
   
   public Player(GamePanel gp, GamePanel.Key k, MainPanel mp)
   {
      this.gp = gp;
      this.k = k;
      this.mp = mp;
      
      screenX = gp.screenWidth/2 - gp.tileSize;
      screenY = gp.screenHeight/2 + (gp.tileSize/4);
      
      solidArea = new Rectangle(0,36,gp.tileSize, 12);
      
      
      setDefaultValues();
      getPlayerImage();
   }
   
   @Override
   public void setDefaultValues()
   {      
      worldX = gp.tileSize*4;
      worldY = gp.tileSize*8 - (gp.tileSize/4);
      speed = 4;
      direction = "up";
   }
   
   public void getPlayerImage()
   {
      try
      {
         up1 = ImageIO.read(new File("owsprites/red_up_stand.png"));
         up2 = ImageIO.read(new File("owsprites/red_up_1.png"));
         up3 = ImageIO.read(new File("owsprites/red_up_stand.png"));
         up4 = ImageIO.read(new File("owsprites/red_up_2.png"));
         down1 = ImageIO.read(new File("owsprites/red_down_stand.png"));
         down2 = ImageIO.read(new File("owsprites/red_down_1.png"));
         down3 = ImageIO.read(new File("owsprites/red_down_stand.png"));
         down4 = ImageIO.read(new File("owsprites/red_down_2.png"));
         left1 = ImageIO.read(new File("owsprites/red_left_1.png"));
         left2 = ImageIO.read(new File("owsprites/red_left_2.png"));
         right1 = ImageIO.read(new File("owsprites/red_right_1.png"));
         right2 = ImageIO.read(new File("owsprites/red_right_2.png"));
         
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
   
   public void update()
   {
      if(gp.left == false && gp.right == false && gp.up == false && gp.down == false) //checking for standing
      {
         standing = true;
      }
      else
      {
         standing = false;
      } 
       
      
      if(temp == false)
      {
         if(gp.left == true && gp.right == false && gp.up == false && gp.down == false && temp == false)  //moving
         {
            direction = "left";
            //worldX -= 2*speed;
            tempDir = "left";
         }
         if(gp.right == true && gp.left == false && gp.up == false && gp.down == false &&  temp == false)
         {
            direction = "right";
            //worldX += speed;
            tempDir = "right";
         }
         if(gp.up == true && gp.right == false && gp.left == false && gp.down == false && temp == false)
         {
            direction = "up";
            //worldY -= speed;
            tempDir = "up";
         }
         if (gp.down == true && gp.right == false && gp.up == false && gp.left == false && temp == false)
         {
            direction = "down";
            //worldY += speed;
            tempDir = "down";
         }
         
         collisionOn = false;
         gp.cChecker.checkTile(this);
      
         if(collisionOn == false && standing == false)
         {
            if(direction.equals("left"))
            {
               worldX -= speed;
            }
            if(direction.equals("right"))
            {
               worldX += speed;
            }
            if(direction.equals("up"))
            {
               worldY -= speed;
            }
            if(direction.equals("down"))
            {
               worldY += speed;
            }
         }
      }
      

       if(collisionOn == false)
       {
          if(tempDir.equals("left"))
          {
             worldX -= speed;
             temp = true;
          }
          if(tempDir.equals("right"))
          {
             worldX += speed;
             temp = true;
          }
          if(tempDir.equals("up"))
          {
             worldY -= speed;
             temp = true;
          }
          if(tempDir.equals("down"))
          {
             worldY += speed;
             temp = true;
          }
          
          if( (worldX%gp.tileSize == 0 &&
               worldY%gp.tileSize == 36))
          {
             tempDir = "";
             temp = false;
          }
      }
      if(worldY == 4*gp.tileSize - 12 && worldX == 5*gp.tileSize) // end gamethread when player reaches gary
      {
            direction = "up";
            spriteNumber = 1;
            if(swap == true)
            {
               gp.stopGameThread();
               try {
                  gp.gameThread.sleep(100);
               } catch (InterruptedException e) 
               {
                 Thread.currentThread().interrupt();
               }
               mp.showDialogue();
            }
            swap = true;
      }
      
      spriteCounter++;
      if(spriteCounter > 8)
      {
         if(spriteNumber == 1)
         {
            spriteNumber = 2;
         }
         else if(spriteNumber == 2)
         {
            spriteNumber = 3;
         }
         else if(spriteNumber == 3)
         {
            spriteNumber = 4;
         }
         else if(spriteNumber == 4)
         {
            spriteNumber = 1;
         }
         spriteCounter = 0;
      }

   }
   
   public void draw(Graphics2D g1)
   {
      
      BufferedImage image = null;
      if(direction.equals("left"))
      {
         if(standing)
         {
            image = left1;
         }
         else
         {
            if(spriteNumber%2 == 1)
            {
               image = left1;
            }
            else if(spriteNumber%2 == 0)
            {
               image = left2;
            }
         }
      }
      else if(direction.equals("right"))
      {
         if(standing)
         {
            image = right2;
         }
         else
         {
            if(spriteNumber%2 == 1)
            {
               image = right1;
            }
            else if(spriteNumber%2 == 0)
            {
               image = right2;
            }
         }
      }
      else if(direction.equals("up"))
      {
         if(standing)
         {
            image = up1;
         }
         else
         {
            if(spriteNumber == 1)
            {
               image = up1;
            }
            if(spriteNumber == 2)
            {
               image = up2;
            }
            if(spriteNumber == 3)
            {
               image = up3;
            }
            if(spriteNumber == 4)
            {
               image = up4;
            }
         }
      }
      else if(direction.equals("down"))
      {
         if(standing)
         {
            image = down1;
         }
         else
         {
            if(spriteNumber == 1)
            {
               image = down1;
            }
            if(spriteNumber == 2)
            {
               image = down2;
            }
            if(spriteNumber == 3)
            {
               image = down3;
            }
            if(spriteNumber == 4)
            {
               image = down4;
            }  
         }       
      }
      
      g1.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);     
   }
}
   