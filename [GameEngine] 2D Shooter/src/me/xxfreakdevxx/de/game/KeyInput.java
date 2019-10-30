package me.xxfreakdevxx.de.game;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import me.xxfreakdevxx.de.game.state.InGameState;
import me.xxfreakdevxx.de.game.state.StateManager;


public class KeyInput extends KeyAdapter {
	
	public List<String> cooldown_bypass = new LinkedList<String>();
	public ConcurrentLinkedQueue<Integer> pressed_keys = new ConcurrentLinkedQueue<Integer>();
	
	public float move_speed = 3f;
	
	public KeyInput() {
		addBypass("W", "A", "S", "D");
//		addBypass("Oben", "Links", "Unten", "Rechts");
		addBypass("Leertaste", "Umschalt", "Steuerung", "Escape");
	}
	public void addBypass(String... letter) {
		for(String s : letter) if(cooldown_bypass.contains(s) == false) cooldown_bypass.add(s);
	}
	
	private int ticked = 0;
	public void tick() {
		ticked++;
		if(ticked == 1) ticked = 0;
		else return;
		for(int key : pressed_keys) {
			switch(key) {
			case KeyEvent.VK_W:
				((InGameState)StateManager.getCurrentState()).world.player.y -= move_speed;
				break;
			case KeyEvent.VK_A:
				((InGameState)StateManager.getCurrentState()).world.player.x -= move_speed;
				break;
			case KeyEvent.VK_S:
				((InGameState)StateManager.getCurrentState()).world.player.y += move_speed;
				break;
			case KeyEvent.VK_D:
				((InGameState)StateManager.getCurrentState()).world.player.x += move_speed;
				break;
			case KeyEvent.VK_P:
				Game.getCamera().biggerOffset();
				break;
			case KeyEvent.VK_O:
				Game.getCamera().smallerOffset();
				break;
			case KeyEvent.VK_RIGHT:
				Game.getCamera().addX(-1);
				break;
			case KeyEvent.VK_LEFT:
				Game.getCamera().addX(1);
				break;
			case KeyEvent.VK_UP:
				Game.getCamera().addY(1);
				break;
			case KeyEvent.VK_DOWN:
				Game.getCamera().addY(-1);
				break;
			case KeyEvent.VK_PLUS:
				Game.fps_maximal++;
				break;
			case KeyEvent.VK_MINUS:
				Game.fps_maximal--;
				break;
			case KeyEvent.VK_L:
				release(key);
				break;
			}
		}
	}
	int height = 20;
	int space = 2;
	int amount = 1;
	public void render(Graphics g) {
		if(pressed_keys.isEmpty()) {
			g.drawString("Kein Cooldown registriert", 10, 10+space+height);
		}else {
			for(int key : pressed_keys) {
				g.drawString("Key: "+KeyEvent.getKeyText(key), 10, 10+((amount+1)*space)+(amount*height));
				amount++;
			}
		}
		amount=1;
	}
	public void press(int key) {
		if(pressed_keys.contains(key) == false) {
			pressed_keys.add(key);
		}
	}
	public void release(int key) {
		pressed_keys.remove(key);
	}
	
	//TODO: Get Interaction
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		press(key);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		release(key);
	}
	
	
}
