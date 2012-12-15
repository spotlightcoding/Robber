package com.spotlightcoding.components;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import com.spotlightcoding.Component;
 
public class ImageRenderComponent extends Component {
 
	private Image image;
 
	public ImageRenderComponent(String id, Image image)
	{
		this.id = id;
		this.image = image;
	}
 
	
	public void render(GameContainer gc, StateBasedGame sb, Graphics gr) {
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		image.draw(pos.x, pos.y, scale);
	}
 
	
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		image.rotate(owner.getRotation() - image.getRotation());
	}
 
}
