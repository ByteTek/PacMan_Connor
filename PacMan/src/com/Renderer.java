package com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

class Renderer {
	
	private Player player = null;
	private Level level = null;
	private GameState mGameState = null;
	
	Renderer(Player p, Level l, GameState gs) {
		player = p;
		level = l;
		mGameState = gs;
	}
	
	void draw(Graphics g, Point screenSize, int cellSize) {
		g.setColor(new Color(100, 100, 100, 255));
		g.fillRect(0, 0, screenSize.x, screenSize.y);
		
		g.setColor(new Color(255, 255, 255, 50));
		for (int i = cellSize; i < screenSize.x; i += cellSize) {
			g.drawLine(i, 0, i, screenSize.y);
		}
		for (int i = cellSize; i < screenSize.y; i += cellSize) {
			g.drawLine(0, i, screenSize.x, i);
		}
		
		drawBorders(g, cellSize);
		
		g.setColor(Color.red);
		g.fillRect((int) player.getPlayerX(), (int) player.getPlayerY(), player.getPlayerSize(), player.getPlayerSize());
		
		if (mGameState.isPaused()) {
			g.setColor(new Color(255, 255, 255, 255));
			g.drawString("Paused", screenSize.x / 2 - 21, screenSize.y / 2);
		}
	}
	
	private void drawBorders(Graphics g, int cellSize) {

		int i = 0;
		for (String row : level.level) {
			char[] rowArray = row.toCharArray();
			for (int j = 0; j < rowArray.length; j++) {
				if (rowArray[j] == 'b') {
					g.setColor(new Color(0, 0, 255, 255));
					g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
				} 
				if (rowArray[j] == 'c') {
					g.setColor(new Color(0, 255, 0, 255));
					g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
				}
			}
			i++;
		}
	}
}
