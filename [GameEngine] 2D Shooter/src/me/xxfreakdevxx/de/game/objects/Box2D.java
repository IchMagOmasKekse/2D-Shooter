package me.xxfreakdevxx.de.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box2D extends GameObject {
	
	/*
	 * render(Graphics g);
	 * tick();
	 * 
	 * isColliding(Rectangle a);
	 */
	
	public String box_name = "Unnamed";
	private static final long serialVersionUID = 1L;

	public Box2D(int x, int y, int w, int h) {
		setBounds(x, y, w, h);
	}
	public Box2D(int x, int y, int w, int h, String box_name) {
		setBounds(x, y, w, h);
		this.box_name = box_name;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, height);
	}
	
	public void tick() {
		//TODO: Implementieren
	}
	
	public boolean isColiding(Rectangle a) {
		return a.intersects(this);
	}
	
}
