package Richman;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Land {
	private static Incidents ic;
	static int[] times=new int[38];
	static GameImage gi = new GameImage();
	static boolean[] available = new boolean[38];//ве
    static int[] Level = new int[38];
	public Land(){
		for(int i = 0;i < 38 ; i++){
			available[i]=true;
			Panel.img[i] = gi.house1;
			Level[i] = 1;
			times[i]=0;	
		}
	}
	public static Land[] land=new Land[38];
	public static void setIncident(Incidents newIncident){
		ic=newIncident;
	}
	public static Land getLand(int i){
			return land[i];
	}
	
	public static void landAct(int i)throws IOException,InterruptedException{
		if(i==0){
		}
		else if(i==9||i==20||i==31){
			try {
				setIncident(new LandMine());
				ic.incidentAct(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(i==10||i==32){
			try {
				setIncident(new GamblingHouse());
				ic.incidentAct(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(i==2||i==13||i==33){
			setIncident(new Cards());
				ic.incidentAct(i);
		}
		else if(i==19||i==27){
			setIncident(new Lottery());
				ic.incidentAct(i);
		}
		else 
		{
			setIncident(new EmptySpace());
				ic.incidentAct(i);
		}
	}
}
	