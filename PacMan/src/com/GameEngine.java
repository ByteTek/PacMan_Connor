/**
 * 
 */
package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

/**
 * @author ConRose456
 *
 */
class GameEngine extends JPanel implements Runnable, KeyListener {

	private GameState mGameState;
	private PhysicsEngine mPhysicsEngine;
	private Renderer mRenderer;
	
	private Player mPlayer;
	private Level mLevel;

	private final int WIDTH = 280, HEIGHT = 360;

	private Thread mThread;
	private int mFPS;
	
	private int cellSize = 10;
	
	private ArrayList<WallPiece> wallPieces;

	GameEngine() {
		mPlayer = new Player(cellSize);
		mLevel = new Level();
		
		mGameState = new GameState();
		mPhysicsEngine = new PhysicsEngine(mPlayer, mLevel, mGameState);
		mRenderer = new Renderer(mPlayer, mLevel, mGameState);
		
		wallPieces = mLevel.getWallPieces(cellSize);

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		addKeyListener(this);

		startThread();
	}

	private void startThread() {
		mGameState.startThread();
		mThread = new Thread(this);
		mThread.start();
	}

	@Override
	public void run() {

		while (mGameState.isRunning()) {

			long startTime = System.nanoTime();

			if (!mGameState.isPaused()) {
				mPhysicsEngine.update(mFPS, wallPieces, cellSize);
			}
			repaint();

			float fpsCap = 16666666.67f;
			long endTime = System.nanoTime() - startTime;

			if (endTime < fpsCap) {
				try {
					Thread.sleep(TimeUnit.NANOSECONDS.toMillis((long) fpsCap) - TimeUnit.NANOSECONDS.toMillis(endTime));
					endTime = System.nanoTime() - startTime;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (endTime >= 1) {
				final int NANO_PER_SEC = 1000000000;
				mFPS = (int) (NANO_PER_SEC / endTime);
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		mRenderer.draw(g, new Point(WIDTH, HEIGHT), cellSize);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE) {
			mGameState.pause();
		}
		
		if (!mGameState.isPaused()) {
			if (key == KeyEvent.VK_D) {
				mGameState.headRight();
			}
			if (key == KeyEvent.VK_A) {
				mGameState.headLeft();
			}
			if (key == KeyEvent.VK_W) {
				mGameState.headUp();
			}
			if (key == KeyEvent.VK_S) {
				mGameState.headDown();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
