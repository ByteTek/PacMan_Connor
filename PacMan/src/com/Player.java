package com;

import java.awt.Rectangle;
import java.util.ArrayList;

class Player {

	private int playerSize = 10;
	
	private float playerX = 140;
	private float playerY = 320;
	
	private int speed = 60;
	
	private Rectangle mainCollider;
	private ArrayList<Rectangle> colliders = new ArrayList<>();
	
	private int cellSize;
	
	Player(int cellSize) {
		this.cellSize = cellSize;	
		mainCollider = new Rectangle((int) playerX, (int) playerY, cellSize, cellSize);
		
		colliders.add(new Rectangle((int)(playerX + 2), (int)(playerY + 9), 6, 4)); // Bottom
		colliders.add(new Rectangle((int)(playerX + 2), (int)(playerY - 1), 6, 4)); // Top
		colliders.add(new Rectangle((int)(playerX - 1), (int)(playerY + 2), 6, 4)); // Right
		colliders.add(new Rectangle((int)(playerX + 9), (int)(playerY + 2), 6, 4)); // Left
	}
	
	void updateColliders() {
		mainCollider = new Rectangle((int) playerX, (int) playerY, cellSize, cellSize);
		
		// Feet
		colliders.get(0).x = (int)(playerX + 2);
		colliders.get(0).y = (int)(playerY + 9);
		colliders.get(0).width = 6;
		colliders.get(0).height = 4;
		
		// Head
		colliders.get(1).x = (int)(playerX + 2);
		colliders.get(1).y = (int)(playerY - 1);
		colliders.get(1).width = 6;
		colliders.get(1).height = 4;
		
		// Right
		colliders.get(2).x = (int)(playerX - 1);
		colliders.get(2).y = (int)(playerY + 2);
		colliders.get(2).width = 4;
		colliders.get(2).height = 6;
		
		// Left
		colliders.get(3).x = (int)(playerX + 9);
		colliders.get(3).y = (int)(playerY + 2);
		colliders.get(3).width = 4;
		colliders.get(3).height = 6;
	}
	
	int getPlayerSize() {
		return playerSize;
	}
	
	float getPlayerX() {
		return playerX;
	}
	
	float getPlayerY() {
		return playerY;
	}
	
	int getPlayerSpeed() {
		return speed;
	}
	
	void setPlayerX(float x) {
		playerX = x;
	}
	
	void setPlayerY(float y) {
		playerY = y;
	}
	
	Rectangle getMainCollider() {
		return mainCollider;
	}
	
	ArrayList<Rectangle> getColliders() {
		return colliders;
	}
}
