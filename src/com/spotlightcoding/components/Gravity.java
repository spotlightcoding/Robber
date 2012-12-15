package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class Gravity extends Component{
	private int robState;
	
	
	public Gravity(String myId,int st){
		this.id = myId;
		this. robState = st; 
	}
	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		
		if(this.robState == Entity.FALLING){
			position.y += 0.6f * delta;
		}
		//  TODO add input for x position
		
		//System.out.println(this.robState);
		
	}

}
