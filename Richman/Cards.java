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
		int index = (int)(Math.random() * 5)+1;//��ÿ�Ƭ,����1-6�������
		if(index == 1){
				JOptionPane.showMessageDialog(null,"��ϲ����������ʿ��������������700");
				Richman.ch1.addAsset(700);
		}
		else if(index == 2){
			JOptionPane.showMessageDialog(null,"��ϲ��������ƶ�����"
					+ "������һ���������ƶ���Ȩ��");
			Richman.max++;
			System.out.println("max:" + Richman.max);
		}
		else if(index == 3){
			JOptionPane.showMessageDialog(null,"��Ǹ����һ�ŵ��׿�");
			try {
			    setIncidents(new LandMine());
				incident.incidentAct(9);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(index == 4){
			JOptionPane.showMessageDialog(null,"��ϲ�����һ�Ŷĳ����볡�ѿ�����������ȥ���ĳ�");
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
			JOptionPane.showMessageDialog(null,"��ϲ�������ѹ�����͸��"
					+ "����������ȥ����͸��");
			Richman.ch1.setLocation(601, 495);
			Richman.loadBackground();
			setIncidents(new Lottery());
			incident.incidentAct(19);
			Richman.ch1.addAsset(200);
		}
		else if(index == 6){
			JOptionPane.showMessageDialog(null,"��Ǹ�����һ�ż��ʿ����������۳�500Ԫ");
			Richman.ch1.reduceAsset(500);
		}
	}
}
