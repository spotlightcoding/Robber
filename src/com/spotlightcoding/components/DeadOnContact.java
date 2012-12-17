package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class DeadOnContact extends Component{
	private Entity rob;
	private float meX, meY,robX,robY;
	private float meWidth,meHeight,robWidth,robHeight;
	private boolean triggered;
	
	
	public DeadOnContact(Entity myRob){
		this.rob = myRob;
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		Vector2f position = owner.getPosition();
		Vector2f robPosition = rob.getPosition();

		meWidth = owner.getSize().width;
		meHeight = owner.getSize().height;
		robWidth = rob.getSize().width;
		robHeight = rob.getSize().height;
		
		
		if((robPosition.x >= position.x) && (robPosition.x <= position.x + meWidth)){
			rob.setState(Entity.DEAD);
			
		}else if((robPosition.x + robWidth >= position.x) && (robPosition.x + robWidth <= position.x + meWidth)){
			rob.setState(Entity.DEAD);
		}
		
//		else if((robPosition.y >= position.y) && (robPosition.y <= position.y + meHeight)){
//			rob.setState(Entity.DEAD);
//		}else if((robPosition.y + robHeight >= position.y) && (robPosition.y + robHeight <= position.y + meHeight)){
//			rob.setState(Entity.DEAD);
//			System.out.println(owner.getType());
//		}
	}
}
