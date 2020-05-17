package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
public class EmptySpace implements Incidents
{    static int ChoiceOfBuy;
     static String ChoiceOfUpgrade="";
	  static House hs = new House();
	  
	 public void incidentAct(int i){
		if(Land.times[i]==0){
			BuyBuilding();
			Land.available[i]=true;
		   if(ChoiceOfBuy==0){
		Richman.ch1.setAsset(Richman.ch1.getAsset() - 500);
	   	Land.times[i]++;
		Land.available[i] = false;
		Richman.loadBackground();
	   }
		}
	else {
		UpgradeBuilding();
	  if(ChoiceOfUpgrade.equals("升级建筑")){
						Land.land[i].Level[i]++;
						Panel.img[i] = hs.LevelUp(Land.land[i].Level[i]);
						Richman.ch1.setAsset(Richman.ch1.getAsset() - hs.getPrice(Land.land[i].Level[i]));
				}
				else{
					Richman.ch1.setAsset(Richman.ch1.getAsset() + hs.getProfit(Land.land[i].Level[i]));
					JOptionPane.showMessageDialog(null, "您已经获得当前房子收益");
					
				}
	}
	}
	
	public void BuyBuilding(){
		ChoiceOfBuy = JOptionPane.showConfirmDialog(null, "你旁边有空地，请问你要购买建筑吗？"
				, " ",JOptionPane.YES_NO_OPTION);
	}
	public void UpgradeBuilding(){
		String[] options = {"升级建筑","获得收益"};
		ChoiceOfUpgrade = (String) JOptionPane.showInputDialog(null,
				"如果选择升级建筑则将不能得到当前租金\n"
				+ "请选择你要进行的操作：\n ", " ",JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(""),options,"xx");	
	}	
}