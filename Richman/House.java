package Richman;

import java.awt.Image;

public class House {
	private static int price;
	private static int profit;
	private static Image img;
	
	static GameImage gi = new GameImage();
	
	public int getPrice(int level){
		if(level == 1)
			price = 500;
		if(level == 2)
			price = 800;
		if(level == 3)
			price = 1200;
		if(level == 4)
			price = 1400;
		if(level == 5)
			price = 1600;
		return price;
	}
	
	public int getProfit(int level){
		if(level == 1)
			profit = 800;
		if(level == 2)
			profit = 1300;
		if(level == 3)
			profit = 1900;
		if(level == 4)
			profit = 2600;
		if(level == 5)
			profit = 3400;
		return profit;
	}
	
	public Image LevelUp(int level){
		if(level == 2)
			img = gi.house2;
		if(level == 3)
			img = gi.house3;
		if(level == 4)
			img = gi.house4;
		if(level == 5)
			img = gi.house5;
		return img;
	}

}
