package me.xxfreakdevxx.de.game.state;

import java.awt.Graphics;

public class StateManager {
	
	/*
	 * getCurrentState();
	 * getInstance();
	 * 
	 * setCurrentState(GameState state);
	 * setTitleOfCurrentState(String new_title);
	 * 
	 * renderState(Graphics g);
	 * tickState();
	 */
	
	public static GameState current_state = null;
	
	public StateManager() {}
	
	public static void setCurrentState(GameState state) {
		current_state = state;
	}
	public static void setTitleOfCurrentState(String new_title) {
		current_state.title = new_title;
	}
	
	public static GameState getCurrentState() {
		return current_state;
	}
	
	public static void render(Graphics g) {
		//TODO: Implementieren
		if(getCurrentState() != null) getCurrentState().render(g);
	}
	
	public static void tick() {
		//TODO: Implementieren
		if(getCurrentState() != null) getCurrentState().tick();
	}
	
	public abstract static class GameState {
		
		public String title = "";
		
		public GameState(String title) {
			this.title = title;
		}
		
		public abstract void render(Graphics g);
		public abstract void tick();
		
	}
	
}
