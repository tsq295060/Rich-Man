package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Lottery implements Incidents
{
	public void incidentAct(int i){
		int choice = JOptionPane.showConfirmDialog(null, "��ѡ���Ƿ�200Ԫ�����Ʊ"
					+"\n�����ӵ����ѹ�����͸�����������ᱻ��ȡ�������"
				, " ",JOptionPane.YES_NO_OPTION); 
		  if(choice == 0){
			if(Richman.ch1.getAsset() < 200){	
				JOptionPane.showMessageDialog(null,"������");  
			}else{	
				Richman.ch1.reduceAsset(200);
				Richman.loadBackground();
				String text1="";
				text1=JOptionPane.showInputDialog("������������Ĳ�Ʊ����:0-100");
				 while(text1.equals("")){
					text1 = JOptionPane.showInputDialog("�����������������");
				}
				 if(text1==null){
					JOptionPane.showMessageDialog(null,"����ʱȡ�������Ʊ�������踶���ʽ�"); 
				}
				else{
					int index = Integer.parseInt(text1);
				while(index > 100||index<0){
					text1 = JOptionPane.showInputDialog("�����������������");
					index = Integer.parseInt(text1);
					}
					
				int random=(int)(Math.random()*10+1);//����1-10�������	
				//System.out.println(random);
				index = index/random;
					
				if(0 < index && index< 10){
					Richman.ch1.addAsset(2000);
		               JOptionPane.showMessageDialog(null,"��ϲ�����һ�Ƚ�������2000");
				}
				else if(30 < index && index < 50){
					Richman.ch1.addAsset(1000);
		               JOptionPane.showMessageDialog(null,"��ϲ����ö��Ƚ�������1000");
				}
				else if(70 < index && index < 100){
					Richman.ch1.addAsset(500);
		               JOptionPane.showMessageDialog(null,"��ϲ��������Ƚ�������500");
				}
				else{
					JOptionPane.showMessageDialog(null,"���ź�����û���н�");
				}
			}
			}
			Richman.loadBackground();
		}
		else{
            JOptionPane.showMessageDialog(null,"�����������Ʊ");
		}
	}
	}
