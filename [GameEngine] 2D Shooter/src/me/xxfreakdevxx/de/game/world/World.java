package me.xxfreakdevxx.de.game.world;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import me.xxfreakdevxx.de.game.objects.Box2D;
import me.xxfreakdevxx.de.game.objects.GameObject;

public class World {
	
	private String name = "New World";
	public Box2D player;
	
	public List<GameObject> objects = new LinkedList<GameObject>();
	
	public World(String name) {
		this.name = name;
		setup();
	}
	
	public World() {setup();}
	
	public void setup() {
		player = new Box2D(100, 100, 20, 30);
	}
	
	public void render(Graphics g) {
		player.render(g);
		for(GameObject go : objects) go.render(g);
	}
	
	public void tick() {
		player.tick();
		for(GameObject go : objects) go.tick();
		for(GameObject go : objects) checkColission(go);
	}
	
	public boolean addObjectToWorld(GameObject obj) {
		if(objects.contains(obj) == false) objects.add(obj);
		else return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public void checkColission(GameObject go) {
		for(GameObject g : objects){
			if(g != go && g.intersects(go)) {
				System.out.println("Box2D: "+((Box2D)g).box_name+" intersects with "+((Box2D)g).box_name);
			}
		}
		
	}
	
}
