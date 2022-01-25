package com;

import java.awt.BorderLayout;

import javax.swing.JFrame;

class Pac_Man {

	private JFrame mFrame;
	private GameEngine mGameEngine;
	
	Pac_Man() {
		mFrame = new JFrame("Pac Man");
		mGameEngine = new GameEngine();
		
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setResizable(false);
		
		__init__();
	}
	
	private void __init__() {
		mFrame.setLayout(new BorderLayout());
		
		mFrame.add(mGameEngine);
		mFrame.pack();
		
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Pac_Man();
	}
	
}
