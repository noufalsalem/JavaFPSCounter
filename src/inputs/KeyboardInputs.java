package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {

		// W - A - S - D cases. VK = virtual key
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.changeY(-5); // W GOES UP ON Y AXIS
			break;
		case KeyEvent.VK_A:
			gamePanel.changeX(-5); // A GOES LEFT ON X AXIS
			break;
		case KeyEvent.VK_S:
			gamePanel.changeY(5); // S GOES DOWN ON Y AXIS
			break;
		case KeyEvent.VK_D:
			gamePanel.changeX(5); // D GOES LEFT ON X AXIS
			break;
		}

	}

}
