package main;

import javax.swing.JFrame;

public class GameWindow {
	
	private JFrame jframe; //you could also extend from JFrame 
	
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel); //always add everything before setVisible()
		jframe.setLocationRelativeTo(null); //aligns window in the center upon startup
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);
	}
}
