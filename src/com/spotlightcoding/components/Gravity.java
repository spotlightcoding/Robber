package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class Gravity extends Component{
	
	
	public Gravity(){

	}
	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		Vector2f position = owner.getPosition();
		
		if (owner.getState() == Entity.FALLING){
			position.y += 0.9f * delta;
		}
	}

}
