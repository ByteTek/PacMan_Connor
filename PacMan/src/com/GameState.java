package com;

class GameState {

	private static boolean mRunning = false;
	private static boolean mPaused = true;
	private static boolean mGameOver = true;
	
	private boolean headingRight;
	private boolean headingLeft;
	private boolean headingUp;
	private boolean headingDown;
	
	void startThread() {
		mRunning = true;
	}
	
	boolean isRunning() {
		return mRunning;
	}
	
	boolean isPaused() {
		return mPaused;
	}
	
	void pause() {
		mPaused = !mPaused;
	}
	
	boolean headingRight() {
		return headingRight;
	}
	
	boolean headingLeft() {
		return headingLeft;
	}
	
	boolean headingUp() {
		return headingUp;
	}
	
	boolean headingDown() {
		return headingDown;
	}
	
	void headRight() {
		stop();
		headingRight = true;
	}
	
	void headLeft() {
		stop();
		headingLeft = true;
	}
	
	void headUp() {
		stop();
		headingUp = true;
	}
	
	void headDown() {
		stop();
		headingDown = true;
	}
	
	void stop() {
		headingRight = false;
		headingLeft = false;
		headingUp = false;
		headingDown = false;
	}
	
}
