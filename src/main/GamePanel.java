package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private Color color = new Color(200, 100, 98);

	// initialize x & y to change for the movable object on screen
	private float xDelta = 100, yDelta = 100;
	private float xDir = 1f, yDir = 1f;
	private Random random;

	public GamePanel() {

		random = new Random();
		/**
		 * Listener methods implemented in separate class and package for cleaner
		 * organization
		 */

		mouseInputs = new MouseInputs(this); // due to passing twice
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1280, 800);
		setPreferredSize(size);
	}

	public void changeX(int value) {
		// increase/decrease X Delta from keyboard/mouse inputs
		this.xDelta += value;
	}

	public void changeY(int value) {
		// increase/decrease Y Delta from keyboard/mouse inputs
		this.yDelta += value;
	}

	public void setObjPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateObj();
		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);

	}

	private void updateObj() {

		///// Reverse X AXIS direction when hit border of window
		xDelta += xDir;
		if (xDelta > 400 || xDelta < 0) { // where 400 is the width of the window. change later
			xDir *= -1; // 1 * -1 = -1, -1*-1 = 1, so reverses direction
			color = getRandomColor(); // generate random color when hit border
		}

		///// Reverse Y AXIS direction when hit border of window
		yDelta += yDir;
		if (yDelta > 400 || yDelta < 0) { // where 400 is height of window. change later
			yDir *= -1; // same thing: reverses direction.
			color = getRandomColor();
		}

	}

	private Color getRandomColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);

		return new Color(r, g, b);
	}
}
