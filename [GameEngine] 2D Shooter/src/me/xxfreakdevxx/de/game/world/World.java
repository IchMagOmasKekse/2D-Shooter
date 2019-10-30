package me.xxfreakdevxx.de.game.world;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import me.xxfreakdevxx.de.game.objects.GameObject;

public class World {
	
	private String name = "New World";
	
	public List<GameObject> objects = new LinkedList<GameObject>();
	
	public World(String name) {
		this.name = name;
	}
	
	public World() {}
	
	public void render(Graphics g) {
		for(GameObject go : objects) go.render(g);
	}
	
	public void tick() {
		for(GameObject go : objects) go.tick();		
	}
	
	public boolean addObjectToWorld(GameObject obj) {
		if(objects.contains(obj) == false) objects.add(obj);
		else return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	
}
