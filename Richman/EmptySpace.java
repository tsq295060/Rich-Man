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
	  if(ChoiceOfUpgrade.equals("��������")){
						Land.land[i].Level[i]++;
						Panel.img[i] = hs.LevelUp(Land.land[i].Level[i]);
						Richman.ch1.setAsset(Richman.ch1.getAsset() - hs.getPrice(Land.land[i].Level[i]));
				}
				else{
					Richman.ch1.setAsset(Richman.ch1.getAsset() + hs.getProfit(Land.land[i].Level[i]));
					JOptionPane.showMessageDialog(null, "���Ѿ���õ�ǰ��������");
					
				}
	}
	}
	
	public void BuyBuilding(){
		ChoiceOfBuy = JOptionPane.showConfirmDialog(null, "���Ա��пյأ�������Ҫ��������"
				, " ",JOptionPane.YES_NO_OPTION);
	}
	public void UpgradeBuilding(){
		String[] options = {"��������","�������"};
		ChoiceOfUpgrade = (String) JOptionPane.showInputDialog(null,
				"���ѡ�����������򽫲��ܵõ���ǰ���\n"
				+ "��ѡ����Ҫ���еĲ�����\n ", " ",JOptionPane.PLAIN_MESSAGE,
				new ImageIcon(""),options,"xx");	
	}	
}