package com.spotlightcoding.components;

import org.newdawn.slick.geom.Vector2f;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;
import com.spotlightcoding.World;

public class LeftRightMovement extends Component {

	//------------------------------------------------PROPERTIES
	Entity rob;
	
	//------------------------------------------------CONSTRUCTOR
	public LeftRightMovement(Entity rob){
		this.rob = rob;
		
	}
	//------------------------------------------------PUBLIC METHODS
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		if (rob.getPosition().getY() + rob.getSize().getHeight() < (World.GROUND_LEVEL + 6)) {
			Input input = gc.getInput();
			Vector2f position = owner.getPosition();
			
			if ((rob.getBarrier() != Entity.BARRIER_LEFT) && ((input.isKeyDown(Input.KEY_A)) || (input.isKeyDown(Input.KEY_LEFT)))){	
				// Check to see if any right key is pressed down before moving
				if ((!input.isKeyDown(Input.KEY_D)) && (!input.isKeyDown(Input.KEY_RIGHT))) {
					position.x += 0.4f * delta;
					
					if (rob.getBarrier() == Entity.BARRIER_RIGHT) {
						rob.setBarrier(Entity.BARRIER_NONE);
					}
				}
			}
			
			if ((rob.getBarrier() != Entity.BARRIER_RIGHT) && ((input.isKeyDown(Input.KEY_D)) || (input.isKeyDown(Input.KEY_RIGHT)))){
				
				if ((!input.isKeyDown(Input.KEY_A)) && (!input.isKeyDown(Input.KEY_LEFT))) {
					position.x -= 0.4f * delta;
					
					if (rob.getBarrier() == Entity.BARRIER_LEFT) {
						rob.setBarrier(Entity.BARRIER_NONE);
					}
				}
			}
		}	
	}

}
