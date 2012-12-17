package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Animation;

import com.spotlightcoding.Component;
 
public class ImageRenderComponent extends Component {
 
	private Image image;
	private Animation animation;
	private boolean animate;
 
	public ImageRenderComponent(Image image)
	{
		this.image = image;
		animate = false;
		animation = null;
	}
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {	
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		
		if (animate) {
			animation.draw(owner.getPosition().getX(), owner.getPosition().getY());
			System.out.println("drawing animation");
		} else {
			image.draw(pos.x, pos.y, scale);
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		image.rotate(owner.getRotation() - image.getRotation());
		animate = owner.getAnimate();
	}
	
	public Image getImage() {
		return image;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
		//System.out.println("Set animation");
	}
}