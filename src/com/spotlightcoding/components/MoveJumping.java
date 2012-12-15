package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class MoveJumping extends Component{
//------------------------------------------------CONSTANTS
	
	
	
	//------------------------------------------------PROPERTIES
	private int robState;
	//------------------------------------------------CONSTRUCTOR
	public MoveJumping(String myId,int st){
		this.id = myId;
		this.robState = st;
		
	}
	//------------------------------------------------GETS/SETS
	//------------------------------------------------PUBLIC METHODS
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO add a check in entity to tell if boundary is reached in level
		Input input = gc.getInput();
		Vector2f position = owner.getPosition();
		if(robState == Entity.JUMPING){
			if(input.isKeyDown(Input.KEY_W)){
				position.y += 0.6f * delta;
			}
			if(input.isKeyDown(Input.KEY_D)){
				position.y += 0.6f * delta;
			}
			if(input.isKeyDown(Input.KEY_A)){
				position.y += 0.6f * delta;
			}
			
		}
		
		
		
		
	}
	//------------------------------------------------PRIVATE METHODS
}
