package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LandMine implements Incidents
{
	public void incidentAct(int i) throws InterruptedException{
		JOptionPane.showMessageDialog(null,"��ѽ���������˵���,��Ǯ��Ҫ�۳�500");
		Richman.ch1.reduceAsset(500);
		Richman.loadBackground();
	}
}