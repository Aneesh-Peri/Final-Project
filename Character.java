/*
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Character
{
   public int worldX;
   public int worldY;
   public int speed;
   public BufferedImage up1, up2, up3, up4, left1, left2, right1, right2, down1, down2, down3, down4;
   public String direction;
   int spriteCounter = 0;
   int spriteNumber = 1;
   public Rectangle solidArea;
   public boolean collisionOn = false;
}
*/

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public abstract class Character {
   public int worldX;
   public int worldY;
   public int speed;
   public BufferedImage up1, up2, up3, up4, left1, left2, right1, right2, down1, down2, down3, down4;
   public String direction;
   int spriteCounter = 0;
   int spriteNumber = 1;
   public Rectangle solidArea;
   public boolean collisionOn = false;

   public abstract void setDefaultValues();
   public abstract void getPlayerImage();
   public abstract void update();

}