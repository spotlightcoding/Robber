package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class Gravity extends Component{
	private Entity rob;
	
	
	public Gravity(Entity rob){
		this.rob = rob;
	}
	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		
		if (rob.getState() == Entity.FALLING){
			position.y += 0.6f * delta;
		}
		
		//System.out.println(this.robState);
		
	}

}
