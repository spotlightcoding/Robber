package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;

import com.spotlightcoding.Component;
import com.spotlightcoding.Entity;

public class TriggerAnimation extends Component {
	
	Entity rob;
	SpriteSheet spritesheet;
	int frames, duration;
	
	public TriggerAnimation(Entity rob, SpriteSheet spritesheet, int frames, int duration) {
		this.rob = rob;
		this.spritesheet = spritesheet;
		this.frames = frames;
		this.duration = duration;
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		if ((!owner.getAnimate()) && ((rob.getPosition().getX() + rob.getSize().getWidth()) >= owner.getPosition().getX()) && ((rob.getPosition().getX()) <= (owner.getPosition().getX() + owner.getSize().getWidth()))) {
			if (owner.getAnimation() == null) {
				owner.setAnimation(new Animation(spritesheet, 0, 0, frames, 0, true, duration, true));
				// System.out.println("Set animation");
			}
			
			if (!owner.getAnimate()) {
				owner.setAnimate(true);
			}
		} else {
			if (owner.getAnimate()) {
				//owner.setAnimate(false);
			}

			//System.out.println(owner.getAnimate());
		}
	}
}