package me.xxfreakdevxx.de.game;

public class Camera {
	private float x=0,y=0;
	private float move_speed = 5f;
	private float offset = 0f;
	public Camera(float x, float y) {
		this.x=x;
		this.y=y;
	}
	public Camera(Location location) {
		this.x=(float)location.getX();
		this.y=(float)location.getY();
	}
	
	public void tick() {
		x += ((MouseInput.getInstance().x_uncon - x) - Game.windowWidth/2) * 0.05f;
		y += ((MouseInput.getInstance().y_uncon - y) - Game.windowHeight/2) * 0.05f;
//		x += ((object.getLocation().getX(false) - x) - SquareCraft.windowWidth/2);
//		y += ((object.getLocation().getY(false) - y) - SquareCraft.windowHeight/2);
	
		if(x <= 0) x = 0; 
		if(x >= (Game.windowWidth + 32)) x = (Game.windowWidth+32);
		if(y <= 0) y = 0; 
		if(x >= (Game.windowHeight + 16)) x = (Game.windowHeight+16);
		Game.log("camera", "X/10:"+(x/10));
		Game.log("camera", "Y/10:"+(y/10));
	}

	public float getX() {
		return x;
	}
	public int getX(boolean fixToRaster) {	
		if(fixToRaster) return (int) ((x/Game.getCamera().getOffset())*Game.getCamera().getOffset());
		else return (int)x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}
	public int getY(boolean fixToRaster) {
		if(fixToRaster) return (int) ((y/Game.getCamera().getOffset())*Game.getCamera().getOffset());
		else return (int)y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void addX(int direction) {
		x+=move_speed * direction;
//		x+=SquareCraft.blocksize * direction;
	}
	public void addY(int direction) {
		y+=move_speed * direction;
//		y+=SquareCraft.blocksize * direction;
	}
	
	public float getOffset() {
		return offset;
	}
	
	public void biggerOffset() {
		if(offset < 200f) offset+=0.1f;
		else return;
	}
	public void smallerOffset() {
		if(offset > 0f) offset-=0.1f;
		else return;
	}
	
}
