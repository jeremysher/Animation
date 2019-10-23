package io.github.jeremysher.animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class Test {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		Animation animation = new Animation(500, 500, "Test Window") {
			
			int mouseX = 0;

			@Override
			public void run() {
				
			}

			@Override
			public void draw(Graphics2D g) {
				g.setColor(Color.red);
				g.drawString("" + mouseX, 20, 20);
				g.fillOval(mouseX, 100, 20, 20);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseX = e.getX();
			}
			
		};
		animation.start();
	}

}
