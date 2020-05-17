package Richman;

public class Character {
	
	private String name;
	private double asset;
	private int x,y;
	private static Character singletonInstance;
	
	private Character(int initX ,int initY,double initasset,String initname){
		x = initX;
		y = initY;
		name = initname;
		asset = initasset;
	}
	public static Character getSingletonInstance() {
		if(singletonInstance == null) {
			 singletonInstance = new Character(37,250,10000,"");
		}
		return singletonInstance;
	}
	public void setLocation(int newX,int newY){
		this.x = newX;
		this.y = newY; 
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getName(){
		return name;
	}
	public double getAsset(){
		return asset;
	}
	public void setAsset(double newAsset){
		asset = newAsset;
	}
	public void reduceAsset(double newAsset){
		asset = asset - newAsset;
	}
	public void addAsset(double newAsset){
		asset = asset + newAsset;
	}
	public void setName(String newName){
		name = newName;
	}
	
}
