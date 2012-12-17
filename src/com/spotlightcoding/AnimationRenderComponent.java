package com.spotlightcoding;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class AnimationRenderComponent extends Component{

	private Animation animation;
	
	public AnimationRenderComponent(Animation myAnimation) {
		animation = myAnimation;
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		animation.draw(owner.getPosition().x, owner.getPosition().y);
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		//System.out.println(owner.getPosition().x);
		
		
		
	}

}
