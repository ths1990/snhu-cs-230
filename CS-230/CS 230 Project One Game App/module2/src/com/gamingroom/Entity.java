package com.gamingroom;

public class Entity {
	
	//Attributes for Entity class- all that inherit will have a name and an ID
	protected long id;
	protected String name;
	
	//Default constructor - protected to allow children viewing access
	protected Entity() {

}
	//Constructor method - Entity has name and id
	public Entity(long id, String name) {
		
		this.id = id;
		this.name = name;
		
	}
	
	
	//Access method to return ID
	public long getId() {
		
		return id;
		
	}
	
	//Access method to return name
	public String getName() {
		
		return name;
	}
	
	//Returns String displays value of id and name
	@Override
	public String toString() {
		
		return "Entity [id=" + id + ", name=" + name + "]";
		
	}
	
}
