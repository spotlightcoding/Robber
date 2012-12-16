package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;
import com.spotlightcoding.World;

public class Hole extends Component {
	
	Entity rob;
	
	public Hole(Entity rob) {
		this.rob = rob;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// Get the position of this block
		Vector2f pos = owner.getPosition();
		
		// Get the position of the character
		Vector2f robPos = rob.getPosition();
		
		// If Rob is in a normal state, is completely above and touching this hole, make him fall
		if ((rob.getState() == Entity.NORMAL) && 
				(robPos.getX() > (pos.getX()) && (robPos.getX() < pos.getX() + owner.getSize().getWidth())) && 
				((robPos.getY() + rob.getSize().getHeight())+5 >= (pos.getY()))) {
			
			rob.setState(Entity.FALLING);
		} else if ((rob.getState() == Entity.FALLING) && (robPos.getY() > World.GROUND_LEVEL + 100)) {
			// If Rob's y value is below a certain point, kill him!
			rob.setState(Entity.DEAD);
		}
	}
	
}
