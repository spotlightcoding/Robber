package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class MoveJumping extends Component{
	//------------------------------------------------CONSTANTS
	private final int JUMP_HEIGHT = 128;
	//------------------------------------------------PROPERTIES
	private int robState;
	private float prevHeight; 
	private float topHeight;
	private float speed; 
	private int jumpCount;
	//------------------------------------------------CONSTRUCTOR
	public MoveJumping(){
		this.speed = 0.4f;
		jumpCount = 0;
	}
	//------------------------------------------------GETS/SETS
	//------------------------------------------------PUBLIC METHODS
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		
		Input input = gc.getInput();
		Vector2f position = owner.getPosition();
		robState = owner.getState();
					
		if((input.isKeyPressed(Input.KEY_W)) || (input.isKeyPressed(Input.KEY_UP)) && (jumpCount <=1)){
			speed= 0.4f;
			prevHeight = position.y;
			topHeight = position.y - JUMP_HEIGHT;
			owner.setState(Entity.JUMPING);
			if(jumpCount == 1){
				speed = 0.9f;
				topHeight =  position.y - (JUMP_HEIGHT + 32);
			}
			jumpCount++;
		}
			
		if(owner.getState() == Entity.JUMPING){
			
			if(position.y >= topHeight) {
				position.y -= speed * delta;
			
			}else if(position.y <= topHeight){
				owner.setState(Entity.FALLING);
			}
		}
		if((owner.getState() == Entity.NORMAL) && (jumpCount != 0) ){
			jumpCount = 0;
		}
		
		
		
		
		
	}
	//------------------------------------------------PRIVATE METHODS
}
