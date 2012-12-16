package com.spotlightcoding.components;

import org.newdawn.slick.geom.Vector2f;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;

public class LeftRightMovement extends Component {
	
	
	//------------------------------------------------CONSTANTS
	
	
	
	//------------------------------------------------PROPERTIES
	
	//------------------------------------------------CONSTRUCTOR
	public LeftRightMovement(){
		
		
	}
	//------------------------------------------------GETS/SETS
	//------------------------------------------------PUBLIC METHODS
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// TODO add a check in entity to tell if boundary is reached in level
		Input input = gc.getInput();
		Vector2f position = owner.getPosition();
		
		if(input.isKeyDown(Input.KEY_A)){
			position.x += 0.4f * delta;
		}
		if(input.isKeyDown(Input.KEY_D)){
			position.x -= 0.4f * delta;
		}
		
		// System.out.println(position.x + position.y);
		
		
	}
	//------------------------------------------------PRIVATE METHODS

}
