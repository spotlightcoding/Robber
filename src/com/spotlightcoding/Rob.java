package com.spotlightcoding;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Rob extends StateBasedGame{
	public static final int  MENU = 0;
	public static final int WORLD = 1;
	
	public Rob(String name){
		super(name);
		this.addState(new World(0));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(0).init(gc, this);
		this.enterState(0);
		
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Rob("Rob"));// what game is going in the window
			appgc.setDisplayMode(750, 600, false);
			//appgc.setVSync(true);
			//appgc.setMaximumLogicUpdateInterval(50);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
