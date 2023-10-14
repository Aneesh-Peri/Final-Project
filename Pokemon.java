public class Pokemon 
{
   private String name;
   private int level;
   private String move1;
   private String move2;
   private String move3;
   private String move4;
   private String spriteFilename;
   private int curHP;
   private int maxHP;

   public Pokemon(String nameVal, int levelVal, String move1Val, String move2Val, String move3Val, String move4Val, String spriteFilenameVal, int maxHPVal) 
   {
      name = nameVal;
      level = levelVal;
      move1 = move1Val;
      move2 = move2Val;
      move3 = move3Val;
      move4 = move4Val;
      spriteFilename = spriteFilenameVal;
      curHP = maxHPVal;
      maxHP = maxHPVal;
   }

   // Accessor methods
   public String getName()
   {
      return name;
   }
   
   public int getLevel() 
   {
      return level;
   }

   public String getMove1() 
   {
      return move1;
   }

   public String getMove2() 
   {
      return move2;
   }

   public String getMove3() 
   {
      return move3;
   }

   public String getMove4() 
   {
      return move4;
   }

   public String getSpriteFilename() 
   {
      return spriteFilename;
   }

   public int getCurHP() 
   {
      return curHP;
   }
   public int getMaxHP()
   {
      return maxHP;
   }

    // Modifier methods

   public void setLevel(int level)
   {
      this.level = level;
   }

   public void setMove1(String move1) 
   {
      this.move1 = move1;
   }

   public void setMove2(String move2) 
   {
      this.move2 = move2;
   }

   public void setMove3(String move3) 
   {
      this.move3 = move3;
   }

   public void setMove4(String move4) 
   {
      this.move4 = move4;
   }

   public void setSpriteFilename(String spriteFilename) 
   {
      this.spriteFilename = spriteFilename;
   }

   public void setHp(int curHP)
   {
      this.curHP = curHP;
   }
}