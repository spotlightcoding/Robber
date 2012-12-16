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
	private float topHeight;
	private float speed; 
	private int jumpCount;
	//------------------------------------------------CONSTRUCTOR
	public MoveJumping(){
		this.speed = 0.6f;
		jumpCount = 0;
	}
	//------------------------------------------------GETS/SETS
	//------------------------------------------------PUBLIC METHODS
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		//get the input, state of rob and his position
		Input input = gc.getInput();
		Vector2f position = owner.getPosition();
		robState = owner.getState();
					
		// check if the up key or w was pressed and that there are only 2 jumps left
		if((input.isKeyPressed(Input.KEY_W) && (jumpCount <=1)) || ((input.isKeyPressed(Input.KEY_UP) && (jumpCount <=1)))){
			//reset his speed
			speed= 0.6f;
			// set the height to achieve in the jump
			topHeight = position.y - JUMP_HEIGHT;
			//set rob's state to currently jumping
			owner.setState(Entity.JUMPING);
			// if it is the second jump increase jump speed and add to the height to achieve
			if(jumpCount == 1){
				speed = 1.1f;
				topHeight =  position.y - (JUMP_HEIGHT + 64);
			}
			jumpCount++;
		}
		
		// check if rob is jumping
		if(owner.getState() == Entity.JUMPING){
			// increase his position to top height
			if(position.y >= topHeight) {
				position.y -= speed * delta;
			// if he reached his toop height set his state to falling to let gravity do the work
			}else if(position.y <= topHeight){
				owner.setState(Entity.FALLING);
			}
		}
		// if he is back on the ground reset his jump count
		if((owner.getState() == Entity.NORMAL) && (jumpCount != 0) ){
			jumpCount = 0;
		}
	}
}
