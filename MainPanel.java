import javax.swing.*;
public class MainPanel extends JPanel
{
   JFrame owner;
   StartPanel startPanel;
   GamePanel gamePanel;
   BattlePanel battlePanel;
   DialoguePanel dialoguePanel;

   public MainPanel(JFrame f)
   {
      owner = f;
      startPanel = new StartPanel(this);
      gamePanel = new GamePanel(this);
      dialoguePanel = new DialoguePanel(this);
      battlePanel = new BattlePanel(this);
      add(startPanel);
   }

   public void showPanel(JPanel p)
   {
      removeAll();
      add(p);
      repaint();
      revalidate();
      owner.pack();
              
        
   }

   public void showGame()
   {
      showPanel(gamePanel);
      gamePanel.startGameThread();
      gamePanel.requestFocusInWindow();
   }
    
   public void showDialogue()
   {
      showPanel(dialoguePanel);
      dialoguePanel.requestFocusInWindow();
   }
   
   public void showBattle()
   {
      showPanel(battlePanel);
      battlePanel.requestFocusInWindow();
   }
}