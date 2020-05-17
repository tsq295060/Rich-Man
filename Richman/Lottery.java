package Richman;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Lottery implements Incidents
{
	public void incidentAct(int i){
		int choice = JOptionPane.showConfirmDialog(null, "请选择是否花200元购买彩票"
					+"\n如果您拥有免费购买乐透卡，您将不会被收取购买费用"
				, " ",JOptionPane.YES_NO_OPTION); 
		  if(choice == 0){
			if(Richman.ch1.getAsset() < 200){	
				JOptionPane.showMessageDialog(null,"您余额不足");  
			}else{	
				Richman.ch1.reduceAsset(200);
				Richman.loadBackground();
				String text1="";
				text1=JOptionPane.showInputDialog("请输入你想买的彩票号码:0-100");
				 while(text1.equals("")){
					text1 = JOptionPane.showInputDialog("输入错误，请重新输入");
				}
				 if(text1==null){
					JOptionPane.showMessageDialog(null,"您临时取消了买彩票，但仍需付出资金"); 
				}
				else{
					int index = Integer.parseInt(text1);
				while(index > 100||index<0){
					text1 = JOptionPane.showInputDialog("输入错误，请重新输入");
					index = Integer.parseInt(text1);
					}
					
				int random=(int)(Math.random()*10+1);//产生1-10的随机数	
				//System.out.println(random);
				index = index/random;
					
				if(0 < index && index< 10){
					Richman.ch1.addAsset(2000);
		               JOptionPane.showMessageDialog(null,"恭喜您获得一等奖，余额加2000");
				}
				else if(30 < index && index < 50){
					Richman.ch1.addAsset(1000);
		               JOptionPane.showMessageDialog(null,"恭喜您获得二等奖，余额加1000");
				}
				else if(70 < index && index < 100){
					Richman.ch1.addAsset(500);
		               JOptionPane.showMessageDialog(null,"恭喜您获得三等奖，余额加500");
				}
				else{
					JOptionPane.showMessageDialog(null,"很遗憾，您没有中奖");
				}
			}
			}
			Richman.loadBackground();
		}
		else{
            JOptionPane.showMessageDialog(null,"您放弃了买彩票");
		}
	}
	}
