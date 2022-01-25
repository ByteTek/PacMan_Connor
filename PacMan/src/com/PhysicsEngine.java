package com;

import java.awt.Rectangle;
import java.util.ArrayList;

class PhysicsEngine {

	private GameState mGameState = null;
	private Player player = null;
	private Level level = null;
	
	PhysicsEngine(Player p, Level l, GameState gs) {
		player = p;
		level = l;
		mGameState = gs;
	}
	
	void update(long fps, ArrayList<WallPiece> wallPieces, int cellSize) {
		if (mGameState.headingRight()) {
			 player.setPlayerX((float)(player.getPlayerX() + player.getPlayerSpeed() / fps));
		}
		if (mGameState.headingLeft()) {
			 player.setPlayerX((float)(player.getPlayerX() - player.getPlayerSpeed() / fps));
		}
		
		if (mGameState.headingUp()) {
			 player.setPlayerY((float)(player.getPlayerY() - player.getPlayerSpeed() / fps));
		}
		if (mGameState.headingDown()) {
			 player.setPlayerY((float)(player.getPlayerY() + player.getPlayerSpeed() / fps));
		}
		
		player.updateColliders();
		detectCollisions(wallPieces, cellSize);
	}
	
	private void detectCollisions(ArrayList<WallPiece> wallPieces, int cellSize) {
		for (WallPiece wall : wallPieces) {
			Rectangle wallRect = new Rectangle(wall.getPosition().x, wall.getPosition().y, cellSize, cellSize);
			
			System.out.println("test");
			
			if (player.getMainCollider().intersects(wallRect)) {
				System.out.println("Collided");
				for (int i = 0; i < player.getColliders().size(); i++) {
					if (player.getColliders().get(i).contains(wallRect)) {
						switch (i) {
						case 0:
							player.setPlayerY(wallRect.y - cellSize);
							System.out.println("Head");
							break;
						case 1:
							player.setPlayerY(wallRect.y + cellSize);
							break;
						case 2:
							player.setPlayerX(wallRect.x - cellSize);
							break;
						case 3:
							player.setPlayerX(wallRect.x + cellSize);
							break;
						}
					}
				}
			}
		}
	}
}
