package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Cards implements Incidents
{
	private static Incidents incident;
	public static void setIncidents(Incidents newIncidents){
		incident=newIncidents;
	}
	public void incidentAct(int i)throws IOException,InterruptedException{
		int index = (int)(Math.random() * 5)+1;//获得卡片,产生1-6的随机数
		if(index == 1){
				JOptionPane.showMessageDialog(null,"恭喜您获得了增资卡，您的余额增加700");
				Richman.ch1.addAsset(700);
		}
		else if(index == 2){
			JOptionPane.showMessageDialog(null,"恭喜您获得了移动卡，"
					+ "额外获得一次掷骰子移动的权利");
			Richman.max++;
			System.out.println("max:" + Richman.max);
		}
		else if(index == 3){
			JOptionPane.showMessageDialog(null,"抱歉你获得一张地雷卡");
			try {
			    setIncidents(new LandMine());
				incident.incidentAct(9);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(index == 4){
			JOptionPane.showMessageDialog(null,"恭喜您获得一张赌场免入场费卡，现在您将去往赌场");
			Richman.ch1.setLocation(507, 250);
			Richman.loadBackground();
			try {
				setIncidents(new GamblingHouse());
				incident.incidentAct(10);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Richman.ch1.addAsset(100);
		}
		else if(index == 5){
			JOptionPane.showMessageDialog(null,"恭喜您获得免费购买乐透卡"
					+ "，现在您将去往乐透点");
			Richman.ch1.setLocation(601, 495);
			Richman.loadBackground();
			setIncidents(new Lottery());
			incident.incidentAct(19);
			Richman.ch1.addAsset(200);
		}
		else if(index == 6){
			JOptionPane.showMessageDialog(null,"抱歉您获得一张减资卡，您的余额扣除500元");
			Richman.ch1.reduceAsset(500);
		}
	}
}
