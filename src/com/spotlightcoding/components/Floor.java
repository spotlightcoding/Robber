package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class Floor extends Component {
	
	Entity rob;
	
	public Floor(String id, Entity rob) {
		this.id = id;
		this.rob = rob;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f pos = owner.getPosition();
		Vector2f robPos = rob.getPosition();
		
		if ((rob.state == "") || (rob.state == "")) {
			
		}
	}
}