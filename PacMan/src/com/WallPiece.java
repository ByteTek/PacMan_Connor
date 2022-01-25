package com;

import java.awt.Point;

class WallPiece {

	private Point position;
	private String type;
	
	WallPiece(Point pos, String type) {
		position = pos;
		this.type = type;
	}
	
	Point getPosition() {
		return position;
	}
	
	String getType() {
		return type;
	}
	
}
