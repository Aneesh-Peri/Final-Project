import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;

public class Rival extends Character
{
   GamePanel gp;
   Boolean standing = true;
   public int screenX;
   public int screenY;
   
   public Rival(GamePanel gp)
   {
      this.gp = gp;
      setDefaultValues();
      getPlayerImage();
   }
   
   public void setDefaultValues()
   {      
      worldX = gp.tileSize*5;
      worldY = gp.tileSize*3 - (gp.tileSize/4);
      speed = 4;
      direction = "up";
   }
   
   public void getPlayerImage()
   {
      try
      {
         down1 = ImageIO.read(new File("owsprites/Rival.png"));  
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
   
   public void update()
   { 
   }


   public void draw(Graphics2D g1)
   {  
      BufferedImage image = null;
      image = down1;
      g1.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);     
   }
}