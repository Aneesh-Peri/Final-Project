import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Arrays;


public class TileManager
{
   GamePanel gp;
   Tile[] tile;
   public int mapTileNum[] [];
   
   public TileManager(GamePanel gp)
   {
      this.gp = gp;
      tile = new Tile[30];
      
      mapTileNum = new int[gp.maxWorldCol][gp.maxWorldCol];
      
      loadMap(); 
      getTileImage();    
   }
   
   public void loadMap()
   {
      try
      {
         Scanner infile = new Scanner( new File("maps/Map_lorelei.txt") );
         int row = 0;
         while(infile.hasNextLine())
         {
            String[] temp = infile.nextLine().split(" ");
            for(int col = 0; col < temp.length; col++)
            {
               mapTileNum[col][row] = Integer.parseInt(temp[col]);
            }       
            row++;
         }
      }
      catch(Exception e)
      {
         
      }
   }
   
   public void getTileImage()
   {
      try
      {
         tile[0] = new Tile();
         tile[0].image = ImageIO.read(new File("tiles/Black.png"));
         tile[0].collision = true;
         
         tile[1] = new Tile();
         tile[1].image = ImageIO.read(new File("tiles/Blackr.png"));
         tile[1].collision = true;
         
         tile[2] = new Tile();
         tile[2].image = ImageIO.read(new File("tiles/Blacktl.png"));
         tile[2].collision = true;
         
         tile[3] = new Tile();
         tile[3].image = ImageIO.read(new File("tiles/Blacktr.png"));
         tile[3].collision = true;
         
         tile[4] = new Tile();
         tile[4].image = ImageIO.read(new File("tiles/Boulder.png"));
         tile[4].collision = true;
         
         tile[5] = new Tile();
         tile[5].image = ImageIO.read(new File("tiles/Door.png"));
         tile[5].collision = true;
         
         tile[6] = new Tile();
         tile[6].image = ImageIO.read(new File("tiles/Gravestone.png"));
         tile[6].collision = true;
         
         tile[7] = new Tile();
         tile[7].image = ImageIO.read(new File("tiles/Squarefloor.png"));
         
         tile[8] = new Tile();
         tile[8].image = ImageIO.read(new File("tiles/Statuebottom.png"));
         tile[8].collision = true;
         
         tile[9] = new Tile();
         tile[9].image = ImageIO.read(new File("tiles/Statuetop.png"));
         tile[9].collision = true;
         
         tile[10] = new Tile();
         tile[10].image = ImageIO.read(new File("tiles/Stripedfloor.png"));
         
         tile[11] = new Tile();
         tile[11].image = ImageIO.read(new File("tiles/Tiledfloor.png"));
         
         tile[12] = new Tile();
         tile[12].image = ImageIO.read(new File("tiles/Wall.png"));
         tile[12].collision = true;
         
         tile[13] = new Tile();
         tile[13].image = ImageIO.read(new File("tiles/Water.png"));
         tile[13].collision = true;
         
         tile[14] = new Tile();
         tile[14].image = ImageIO.read(new File("tiles/Waterledge.png"));
         tile[14].collision = true;
         
         tile[15] = new Tile();
         tile[15].image = ImageIO.read(new File("tiles/Blackl.png"));
         tile[15].collision = true;
         
         tile[16] = new Tile();
         tile[16].image = ImageIO.read(new File("tiles/Blacktlr.png"));
         tile[16].collision = true;
         
         tile[17] = new Tile();
         tile[17].image = ImageIO.read(new File("tiles/Blacklr.png"));
         tile[17].collision = true;
         
         tile[18] = new Tile();
         tile[18].image = ImageIO.read(new File("tiles/Wallblackl.png"));
         tile[18].collision = true;
         
         tile[19] = new Tile();
         tile[19].image = ImageIO.read(new File("tiles/Wallblackr.png"));
         tile[19].collision = true;
         
         tile[20] = new Tile();
         tile[20].image = ImageIO.read(new File("tiles/Wallblacktr.png"));
         tile[20].collision = true;
         
         tile[21] = new Tile();
         tile[21].image = ImageIO.read(new File("tiles/Wallblacktl.png"));
         tile[21].collision = true;
         
         tile[22] = new Tile();
         tile[22].image = ImageIO.read(new File("tiles/Floorrivalt.png"));
         tile[22].collision = true;
         
         tile[23] = new Tile();
         tile[23].image = ImageIO.read(new File("tiles/FLoorrivalb.png"));
         tile[23].collision = true;
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
   
   public void draw(Graphics2D g2)
   {
      int worldCol = 0;
      int worldRow = 0;
      
      while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
      {
         int tileNum = mapTileNum[worldCol][worldRow];
         
         int worldX = worldCol * gp.tileSize;
         int worldY = worldRow * gp.tileSize;
         int screenX = worldX - gp.player.worldX + gp.player.screenX;
         int screenY = worldY - gp.player.worldY + gp.player.screenY;
         
         if(worldX + 2*gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - 2*gp.tileSize  < gp.player.worldX + gp.player.screenX &&
            worldY + 2*gp.tileSize  > gp.player.worldY - gp.player.screenY &&
            worldY - 2*gp.tileSize  < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
         worldCol++;
         
         if(worldCol == gp.maxWorldCol)
         {
            worldCol = 0;            
            worldRow ++;
         }
      }
   }
}