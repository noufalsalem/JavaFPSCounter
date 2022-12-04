package main;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread loopThread;
	private final int FPS = 120;

	public Game() {

		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		startLoop();

	}

	private void startLoop() {
		loopThread = new Thread(this);
		loopThread.start();

	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS; // nanoseconds per frame
		long lastFrame = System.nanoTime();
		long currentNanoTime = System.nanoTime();

		int frames = 0;
		long lastCheck = System.currentTimeMillis();

		// infinite loop
		while (true) {

			///////////// FPS /////////////
			currentNanoTime = System.nanoTime();

			if (currentNanoTime - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = currentNanoTime;
				frames++;
			}
			///////////////////////////////

			///////// FPS COUNTER /////////
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			//////////////////////////////
		}

	}
}
