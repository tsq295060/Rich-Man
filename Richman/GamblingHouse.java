package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GamblingHouse implements Incidents
{
	public void incidentAct(int i) throws IOException{
		int choice = JOptionPane.showConfirmDialog(null, "��ѡ���Ƿ����ĳ�������Ϸ?"
				+ "\n�볡��Ϊ100Ԫ\n����������볡�ѿ������ᱻ��ȡ�볡��", " ",JOptionPane.YES_NO_OPTION); 
	      
		if(choice == 0){
			int j = 0;
			int result1 = 0;
			int result2 = 0;
			Richman.ch1.reduceAsset(100);
			while(choice == 0){
				j++;
				JOptionPane.showMessageDialog(null,"�뿪ʼ��Ϸ");
				
				PlayDice one=new PlayDice();
				one.playDice();
				result1 = one.getResult();
				JOptionPane.showMessageDialog(null,"�ĳ������������ӵ���֮��Ϊ"+result1);
				
				PlayDice two=new PlayDice();
				two.playDice();
				result2=two.getResult();
				JOptionPane.showMessageDialog(null,"���������ӵ���֮��Ϊ"+result2);
				
				if(result1 > result2){
					Richman.ch1.reduceAsset(500*j);
					JOptionPane.showMessageDialog(null,
							"�����ˣ�"+ "��۳�"+500*j);
				}
				else if(result1 == result2){
					JOptionPane.showMessageDialog(null,"ƽ��");
				}
				else{
					Richman.ch1.addAsset(500*j);
					JOptionPane.showMessageDialog(null,"��Ӯ�ˣ�"
							+ "�����"+500*j+"�Ľ���");
				}
			choice = JOptionPane.showConfirmDialog(null, "��ѡ���Ƿ����������Ϸ"
					, " ",JOptionPane.YES_NO_OPTION); 
					Richman.loadBackground();
			}
		}else
			JOptionPane.showMessageDialog(null,"����δ������Ϸ���ʲ�����");  
	}
	
}