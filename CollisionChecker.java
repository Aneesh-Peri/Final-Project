
public class CollisionChecker
{
   GamePanel gp;
   public CollisionChecker(GamePanel gp)
   {
      this.gp = gp;
   }
   
   public void checkTile(Character character)
   {
      int characterLeftWorldX = character.worldX + 1;
      int characterRightWorldX = character.worldX + 47;
      int characterTopWorldY = character.worldY + 13;
      int characterBottomWorldY = character.worldY + 60;
      
      int characterLeftCol = characterLeftWorldX/gp.tileSize;
      int characterRightCol = characterRightWorldX/gp.tileSize;
      int characterTopRow = characterTopWorldY/gp.tileSize;
      int characterBottomRow = characterBottomWorldY/gp.tileSize;
      
      int tileNum1;
      int tileNum2;
      
      if(character.direction.equals("up"))
      {
         characterTopRow = (characterTopWorldY - character.speed)/gp.tileSize;
         tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];
         tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
         if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum1].collision == true)
         {
            character.collisionOn = true;
         }
      }
      if(character.direction.equals("down"))
      {
         characterBottomRow = (characterBottomWorldY + character.speed)/gp.tileSize;
         tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
         tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
         if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum1].collision == true)
         {
            character.collisionOn = true;
         }
      }
      if(character.direction.equals("left"))
      {
         characterLeftCol = (characterLeftWorldX - character.speed)/gp.tileSize;
         tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];
         tileNum2 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
         if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum1].collision == true)
         {
            character.collisionOn = true;
         }
      }
      if(character.direction.equals("right"))
      {
         characterRightCol = (characterRightWorldX + character.speed)/gp.tileSize;
         tileNum1 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
         tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
         if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum1].collision == true)
         {
            character.collisionOn = true;
         }
      }
   }
      
}