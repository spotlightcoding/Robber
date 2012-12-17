package com.spotlightcoding;
 
import java.util.ArrayList;

import java.awt.Dimension;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Animation;

import com.spotlightcoding.components.ImageRenderComponent;
import com.spotlightcoding.Component;

public class Entity {
	//------------------------------CONSTANTS
	// player constants
	public static final int NORMAL = 0;
	public static final int FALLING = 1;
	public static final int JUMPING = 2;
	public static final int DEAD = 3;
	
	public static final String BARRIER_LEFT = "barrierLeft";
	public static final String BARRIER_RIGHT = "barrierRight";
	public static final String BARRIER_NONE = "barrierNone";
	
	//------------------------------PROPERTIES
    private String id;
    private Dimension size;
    private Vector2f position;
    private float scale;
    private float rotation;
    private int state;
    private String type;
    private boolean animate;
    private Animation animation;
    
    // Robot properties
    private boolean activated;
    private String direction;
    
    private String barrier;
 
    ImageRenderComponent renderComponent;
 
    ArrayList<Component> components;
    
	//------------------------------CONSTRUCTOR
    public Entity(String id, String type)
    {
        this.id = id;
        size = new Dimension();
        this.state = NORMAL;
        this.type = type;
        components = new ArrayList<Component>();
        position = new Vector2f(0,0);
        scale = 1;
        rotation = 0;
        size = new Dimension();
        barrier = BARRIER_NONE;
        animation = null;
    }
	//------------------------------GETS/SET
    public void addComponent(Component component)
    {
        if(ImageRenderComponent.class.isInstance(component)){
        	renderComponent = (ImageRenderComponent)component;
        	size.setSize(renderComponent.getImage().getWidth(), renderComponent.getImage().getHeight());
        }
            
        component.setOwnerEntity(this);
        components.add(component);
    }
 
    public Component getComponent(String id)
    {
        for(Component comp : components)
		{
		    if (comp.getId().equalsIgnoreCase(id)) {
		    	return comp;
		    }
		}
        return null;
    }
 
    public Vector2f getPosition()
    {
    	return position;
    }
 
    public float getScale()
    {
    	return scale;
    }
 
    public float getRotation()
    {
    	return rotation;
    }
 
    public String getId()
    {
    	return id;
    }
    public int getState()
    {
    	return state;
    }
    
    public Dimension getSize() {
    	return size;
    }
    
    public String getType() {
    	return this.type;
    }
    
    public String getBarrier() {
    	return this.barrier;
    }
    
    public boolean getAnimate() {
    	return animate;
    }
    
    public Animation getAnimation() {
    	return animation;
    }
    
    public void setAnimate(boolean setting) {
    	this.animate = setting;
    }
    
    public void setState(int myState){
    	this.state = myState;
    }
    
    public void setBarrier(String barrier){
    	this.barrier = barrier;
    }
 
    public void setPosition(Vector2f position) {
    	this.position = position;
    }
 
    public void setRotation(float rotate) {
        rotation = rotate;
    }
 
    public void setScale(float scale) {
    	this.scale = scale;
    }
    
    public void setBotActive(boolean myActive){
    	activated = myActive;
    }
    
    public void setAnimation(Animation animation) {
    	this.animation = animation;
    }
    
    public boolean isBotActive(){
    	return activated;
    }
    
    public void setDirection(String myDirec){
    	direction = myDirec;
    }
    public String getDirection(){
    	return direction;
    }

	//------------------------------PUBLIC METHODS
    
    public void update(GameContainer gc, StateBasedGame sb, int delta)
    {
    	if ((animate) && (renderComponent.getAnimation() == null)) {
        	renderComponent.setAnimation(animation);
		}
    	
        for(Component component : components)
        {
            component.update(gc, sb, delta);
        }
    }
 
    public void render(GameContainer gc, StateBasedGame sb, Graphics gr)
    {
        if(renderComponent != null) {
        	renderComponent.render(gc, sb, gr);
        }
    }
}