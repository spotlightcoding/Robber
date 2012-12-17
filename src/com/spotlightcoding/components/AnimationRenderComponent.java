package com.spotlightcoding.components;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;

public class AnimationRenderComponent extends Component {

	private Animation animation;
	private float posX, posY;
	
	public AnimationRenderComponent(Animation myAnimation) {
		animation = myAnimation;
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		animation.draw(posX, posY);
		//System.out.println("rendering animation");
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		
		posX = owner.getPosition().getX();
		posY = (float)(owner.getPosition().getY() - owner.getSize().getHeight()) - 10;
		//System.out.println(owner.getPosition().x);
		//System.out.println("Updating animation");
	}
}
