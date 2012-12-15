package com.spotlightcoding;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

import com.spotlightcoding.components.Gravity;
import com.spotlightcoding.components.ImageRenderComponent;
import com.spotlightcoding.components.LeftRightMovement;
import com.spotlightcoding.components.Floor;

public class World extends BasicGameState{
	Image worldMap;
	Image robImg;
	Entity level;
	Entity rob;
	
	ArrayList <Entity>blocks;
	
	public World(int state){
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		worldMap = new Image("res/mapBlank.png");
		robImg = new Image("res/robber.png");
		
		rob = new Entity("Rob", "character");
		rob.AddComponent(new ImageRenderComponent("robRender",robImg));
		rob.AddComponent(new Gravity("robGravity", rob.getState()));
		rob.setPosition(new Vector2f(400,300));
		
		level = new Entity("level", "environment");
		level.AddComponent(new ImageRenderComponent("levelrender", worldMap));
		level.AddComponent(new LeftRightMovement("mapLeftRight"));

		blocks = this.getLevelBlocks();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics gr) throws SlickException {
		level.render(gc,null,gr);
		rob.render(gc,null,gr);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
			level.update(gc, sb, delta);
			rob.update(gc, sb, delta);
	}
	
	private ArrayList<Entity> getLevelBlocks() {
		ArrayList <Entity>arrBlocks = new ArrayList<Entity>();
		
		arrBlocks.add(new Entity("floor1", "floor"));
		arrBlocks.add(new Entity("floor2", "floor"));
		arrBlocks.add(new Entity("floor3", "floor"));
		arrBlocks.add(new Entity("floor4", "floor"));
		arrBlocks.add(new Entity("floor5", "floor"));
		arrBlocks.add(new Entity("floor6", "floor"));
		arrBlocks.add(new Entity("floor7", "floor"));
		arrBlocks.add(new Entity("floor8", "floor"));
		arrBlocks.add(new Entity("floor9", "floor"));
		
		return arrBlocks;
	}

	@Override
	public int getID() {
		return 0;
	}
}