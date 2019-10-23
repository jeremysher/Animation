package io.github.jeremysher.animation;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Animation extends Canvas implements MouseListener, KeyListener {
	
	private Image offscreenImage;
	private Graphics offscreenGraphics;
	private double deltaTime; //s
	private double t1; //ms
	
	public Animation(int x, int y, String title) {
		JFrame frame = new JFrame(title);
		this.setSize(x, y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
        frame.setVisible(true);
        offscreenImage = this.createImage(this.getSize().width, this.getSize().height);
        offscreenGraphics = offscreenImage.getGraphics();
        addMouseListener(this);
        addKeyListener(this);
	}
	
	public abstract void run();
	
	public abstract void draw(Graphics2D g);
	
	public void start() {
		t1 = System.currentTimeMillis();
		loop();
	}
	
	private void loop() {
		while (true) {
			deltaTime = (System.currentTimeMillis() - t1) / 1000;
			run();
			t1 = System.currentTimeMillis();
			this.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D og2d = (Graphics2D) offscreenGraphics;
		og2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		draw(og2d);
		g.drawImage(offscreenImage, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
		((Graphics2D) offscreenGraphics).clearRect(0, 0, this.getSize().width, this.getSize().height);
		paint(g);
	}
	
	public double getDeltaTime() {
		return deltaTime;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
    }
	
	@Override
    public void mouseReleased(MouseEvent e) {
    	
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    	
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    	
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    	
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    	
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    	
    }
    
    

}
