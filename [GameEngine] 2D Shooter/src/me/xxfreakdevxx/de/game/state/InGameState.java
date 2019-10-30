package me.xxfreakdevxx.de.game.state;

import java.awt.Canvas;
import java.awt.Graphics;

import me.xxfreakdevxx.de.game.Game;
import me.xxfreakdevxx.de.game.objects.Box2D;
import me.xxfreakdevxx.de.game.state.StateManager.GameState;
import me.xxfreakdevxx.de.game.world.World;

public class InGameState extends GameState {
	
	/*
	 * getTitle();
	 * setTitle();
	 * 
	 * render(Graphics g);
	 * tick();
	 */
	public World world;
	private Canvas canvas = Game.getInstance();
	
	public InGameState() {
		super("[In Game State]");
		
		world = new World();
		
		Box2D rect = new Box2D(130, 600, 240, 20, "Boden");
		world.addObjectToWorld(rect);
	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	@Override
	public void tick() {
		world.tick();
	}
	
}