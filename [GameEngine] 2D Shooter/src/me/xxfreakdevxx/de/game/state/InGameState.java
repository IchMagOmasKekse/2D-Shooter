package me.xxfreakdevxx.de.game.state;

import java.awt.Color;
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
	public InGameState() {
		super("[In Game State]");
		
		world = new World();
		
		Box2D box = new Box2D(130, 600, 2040, 20, "Boden");
		box.fill_color = Color.green;
		world.addObjectToWorld(box);
	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
	@Override
	public void tick() {
		world.tick();
		Game.getCamera().tick(world.player);
	}
	
}
