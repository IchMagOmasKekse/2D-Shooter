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
	public Color fill_color = Color.GRAY;
	private static final long serialVersionUID = 1L;

	public Box2D(int x, int y, int w, int h) {
		setBounds(x, y, w, h);
	}
	public Box2D(int x, int y, int w, int h, String box_name) {
		setBounds(x, y, w, h);
		this.box_name = box_name;
	}
	
	public void render(Graphics g) {
		g.setColor(fill_color);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(0f,0f,0f,0.3f));
		g.fillRect(x-2, y-10, 100, 20);
		g.setColor(Color.WHITE);
		g.drawString("X/Y: "+getBounds2D().getX()+"/"+getBounds2D().getY(), (int)getBounds2D().getX(), (int)getBounds2D().getY());
	}
	
	public void tick() {
		//TODO: Implementieren
	}
	
	public boolean isColiding(Rectangle a) {
		return a.intersects(this);
	}
	
}
