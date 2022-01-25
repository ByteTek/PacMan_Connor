package com;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

class Level {

	ArrayList<String> level = new ArrayList<String>();

	Level() {
		level.add("............................");
		level.add("............................");
		level.add("............................");
		level.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		level.add("b............bb............b");
		level.add("b.cbbc.cbbbc.bb.cbbbc.cbbc.b");
		level.add("b.bbbb.bbbbb.bb.bbbbb.bbbb.b");
		level.add("b.cbbc.cbbbc.cc.cbbbc.cbbc.b");
		level.add("b..........................b");
		level.add("b.cbbc.cc.cbbbbbbc.cc.cbbc.b");
		level.add("b.cbbc.bb.cbbbbbbc.bb.cbbc.b");
		level.add("b......bb....bb....bb......b");
		level.add("bbbbbc.bbbbc.bb.cbbbb.cbbbbb");
		level.add(".....b.bbbbc.cc.cbbbb.b.....");
		level.add(".....b.bb..........bb.b.....");
		level.add(".....b.bb.bbbbbbbb.bb.b.....");
		level.add("bbbbbc.cc.b......b.cc.cbbbbb");
		level.add("..........b......b..........");
		level.add("bbbbbc.cc.b......b.cc.cbbbbb");
		level.add(".....b.bb.bbbbbbbb.bb.b.....");
		level.add(".....b.bb..........bb.b.....");
		level.add(".....b.bb.cbbbbbbc.bb.b.....");
		level.add("bbbbbc.cc.cbbbbbbc.cc.cbbbbb");
		level.add("b............bb............b");
		level.add("b.cbbc.cbbbc.bb.cbbbc.cbbc.b");
		level.add("b.cbbb.cbbbc.cc.cbbbc.bbbc.b");
		level.add("b...bb................bb...b");
		level.add("bbc.bb.cc.cbbbbbbc.cc.bb.cbb");
		level.add("bbc.cc.bb.cbbbbbbc.bb.cc.cbb");
		level.add("b......bb....bb....bb......b");
		level.add("b.cbbbbbbbbc.bb.cbbbbbbbbc.b");
		level.add("b.cbbbbbbbbc.cc.cbbbbbbbbc.b");
		level.add("b..........................b");
		level.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		level.add("............................");
		level.add("............................");
	}

	ArrayList<WallPiece> getWallPieces(int cellSize) {
		
		ArrayList<WallPiece> wallPieces = new ArrayList<>();

		int i = 0;
		for (String row : level) {
			char[] rowArray = row.toCharArray();
			for (int j = 0; j < rowArray.length; j++) {
				if (rowArray[j] == 'a') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "a"));
				}
				if (rowArray[j] == 'b') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "b"));
				}
				if (rowArray[j] == 'c') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "c"));
				}
				if (rowArray[j] == 'd') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "d"));
				}
				if (rowArray[j] == 'e') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "e"));
				}
				if (rowArray[j] == 'f') {
					wallPieces.add(new WallPiece(new Point(j * cellSize, i * cellSize), "f"));
				}
			}
			i++;
		}

		return wallPieces;
	}
}
