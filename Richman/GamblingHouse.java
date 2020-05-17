package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GamblingHouse implements Incidents
{
	public void incidentAct(int i) throws IOException{
		int choice = JOptionPane.showConfirmDialog(null, "请选择是否进入赌场进行游戏?"
				+ "\n入场费为100元\n如果您有免入场费卡将不会被收取入场费", " ",JOptionPane.YES_NO_OPTION); 
	      
		if(choice == 0){
			int j = 0;
			int result1 = 0;
			int result2 = 0;
			Richman.ch1.reduceAsset(100);
			while(choice == 0){
				j++;
				JOptionPane.showMessageDialog(null,"请开始游戏");
				
				PlayDice one=new PlayDice();
				one.playDice();
				result1 = one.getResult();
				JOptionPane.showMessageDialog(null,"赌场地主所掷骰子点数之和为"+result1);
				
				PlayDice two=new PlayDice();
				two.playDice();
				result2=two.getResult();
				JOptionPane.showMessageDialog(null,"您所掷骰子点数之和为"+result2);
				
				if(result1 > result2){
					Richman.ch1.reduceAsset(500*j);
					JOptionPane.showMessageDialog(null,
							"您输了，"+ "需扣除"+500*j);
				}
				else if(result1 == result2){
					JOptionPane.showMessageDialog(null,"平局");
				}
				else{
					Richman.ch1.addAsset(500*j);
					JOptionPane.showMessageDialog(null,"您赢了，"
							+ "获得了"+500*j+"的奖励");
				}
			choice = JOptionPane.showConfirmDialog(null, "请选择是否继续进行游戏"
					, " ",JOptionPane.YES_NO_OPTION); 
					Richman.loadBackground();
			}
		}else
			JOptionPane.showMessageDialog(null,"您并未进行游戏，资产余额不变");  
	}
	
}