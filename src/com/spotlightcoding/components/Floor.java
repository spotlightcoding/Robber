package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class Floor extends Component {
	
	Entity rob;
	
	public Floor(Entity rob) {
		this.rob = rob;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		// Get the position of this block
		Vector2f pos = owner.getPosition();
		// Get the position of the character
		Vector2f robPos = rob.getPosition();
		
		// Check to see if Rob is currently falling
		if ((rob.getState() == Entity.FALLING)) {

			//If Rob is above and touching this block, change his state to normal to halt falling
			if (((robPos.getX() + rob.getSize().getWidth()) > (pos.getX()) && (robPos.getX() < pos.getX() + owner.getSize().getWidth())) && ((robPos.getY() + rob.getSize().getHeight())+5 >= (pos.getY()))) {
				robPos.set(robPos.getX(), pos.getY() - (int)(rob.getSize().getHeight())+5);
				rob.setState(Entity.NORMAL);
			}
		}
	}
}