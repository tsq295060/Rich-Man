package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LandMine implements Incidents
{
	public void incidentAct(int i) throws InterruptedException{
		JOptionPane.showMessageDialog(null,"哎呀，您踩中了地雷,金钱需要扣除500");
		Richman.ch1.reduceAsset(500);
		Richman.loadBackground();
	}
}