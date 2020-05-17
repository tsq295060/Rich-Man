package Richman;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Richman {
	private static int initialX = 37;
	private static int initialY = 250;
	private static int addX = 47;
	private static int addY = 35;
	private static int sum = 0;
	private static double initialAsset = 10000;
	
	static int max = 30;
	static int count = 1;
	
    static JFrame jf = new JFrame();
	 static Land land = new Land();

	//人物的初始横纵坐标，初始资产及姓名
	static Character ch1 = Character.getSingletonInstance();
	static int landNumber=0;
	public static void main(String[] args) throws IOException, InterruptedException {
		Richman.loadBackground();
		JOptionPane.showMessageDialog(null, "大富翁游戏开始！");
		String name = (String) JOptionPane.showInputDialog(null,"请输入角色姓名 ：\n");
		ch1.setName(name);
		Thread.sleep(1000);
		int result=0;
		int choice=0;
		for(count = 1;count <= max;count++){
		//摇骰子，购买建筑
			Thread.sleep(500);
			choice = JOptionPane.showConfirmDialog(null, "您是否选择继续开始第"+count+"轮掷骰子"
				, " ",JOptionPane.YES_NO_OPTION);
			if(choice==0){
			PlayDice.playDice();
			result=PlayDice.getResult();
			sum += result;
			JOptionPane.showMessageDialog(null, "您本轮掷骰子结果为"+result+",您将前进"+result+"步数");
			landNumber=sum%38;
			if(sum > 38){
				sum = sum-38;
			}
			//ch1.setLocation(Land.location[landNumber][0],Land.location[landNumber][1]);
			//坐标变换
			if(sum <= 12){
				ch1.setLocation(initialX+addX*sum, 250);
			}else if(sum > 12 && sum <= 19){
				ch1.setLocation(601, initialY+addY*(sum-12));
			}else if(sum > 19 && sum <= 31){
				ch1.setLocation(initialX+addX*(31-sum), 495);
			}else if(sum > 31 && sum <= 38 ){
				ch1.setLocation(37, initialY+addY*(38-sum));
			}
			Richman.loadBackground();
			Thread.sleep(1000);
			land = Land.getLand(landNumber);
			land.landAct(landNumber);
			Richman.loadBackground();//这一句一定要在最后
			
			if(ch1.getAsset() >= 15000 && (max-count) > 0){
				JOptionPane.showMessageDialog(null, "恭喜您！游戏成功");
				System.exit(1);
			}else if(ch1.getAsset() < 15000 && (max-count) <= 0){
				JOptionPane.showMessageDialog(null, "您未完成目标，游戏失败");
				System.exit(1);
			}else if(ch1.getAsset() <= 0){
				JOptionPane.showMessageDialog(null, "您破产了，游戏结束");
				System.exit(1);
			}
			}
			else{
				choice = JOptionPane.showConfirmDialog(null, "您真的要退出本游戏吗"
				, " ",JOptionPane.YES_NO_OPTION);
				if(choice==0){
					JOptionPane.showMessageDialog(null, "感谢您的参与，期待下次和你相遇");
					System.exit(1);
				}
				else{
					JOptionPane.showMessageDialog(null, "请继续游戏,但您已失去本轮掷骰子的机会");
				}
			}
		}	
	}
	
	public static void loadBackground() {
		Panel mp = new Panel();		
		jf.add(mp);		
		jf.setSize(750, 633);
		jf.setTitle("大富翁");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	
		//获取屏幕大小
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗体信息
		int framewidth = 750;
		int frameheight = 633;		
		int frameX = (screenWidth - framewidth)/2;
		int frameY = (screenHeight - frameheight)/2;
		//将窗体设置在屏幕中央
		jf.setBounds(frameX,frameY,framewidth,frameheight);
		
	}
}
class Panel extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	static Image[] img = new Image[39];
	public void paint(Graphics g){
		GameImage gi = new GameImage();
		//画背景
		g.drawImage(gi.bg, 0, 0, 750, 633, null);
		
		//最上面七栋房子
		if(Land.available[1]== false)
			g.drawImage(img[1], 84  , 215, 64, 72, null);
		if(Land.available[3]== false)
			g.drawImage(img[3], 178  , 215, 64, 72, null);
		if(Land.available[4]== false)
			g.drawImage(img[4], 225 , 215, 64, 72, null);
		if(Land.available[5]== false)
			g.drawImage(img[5], 272 , 215, 64, 72, null);
		if(Land.available[6]== false)
			g.drawImage(img[6], 319 , 215, 64, 72, null);
		if(Land.available[7]== false)
			g.drawImage(img[7], 366 , 215, 64, 72, null);
		if(Land.available[8]== false)
			g.drawImage(img[8], 413 , 215, 64, 72, null);
		if(Land.available[11]== false)
			g.drawImage(img[11], 554 , 215, 64, 72, null);
		if(Land.available[12]== false)
			g.drawImage(img[12], 603 , 215, 64, 72, null);
		
		//右边房子
		if(Land.available[14]== false)
			g.drawImage(img[14], 647 , 320, 64, 72, null);
		if(Land.available[15]== false)
			g.drawImage(img[15], 647 , 357, 64, 72, null);
		if(Land.available[16]== false)
			g.drawImage(img[16], 647 , 394, 64, 72, null);
		if(Land.available[17]== false)
			g.drawImage(img[17], 647 , 431, 64, 72, null);
		if(Land.available[18]== false)
			g.drawImage(img[18], 647 , 465, 64, 72, null);
		
		//下面房子
		if(Land.available[21]== false)
			g.drawImage(img[21], 507 , 465, 64, 72, null);
		if(Land.available[22]== false)
			g.drawImage(img[22], 460 , 465, 64, 72, null);
		if(Land.available[23]== false)
			g.drawImage(img[23], 413 , 465, 64, 72, null);
		if(Land.available[24]== false)
			g.drawImage(img[24], 366 , 465, 64, 72, null);
		if(Land.available[25]== false)
			g.drawImage(img[25], 319 , 465, 64, 72, null);
		if(Land.available[26]== false)
			g.drawImage(img[26], 272 , 465, 64, 72, null);
		if(Land.available[28]== false)
			g.drawImage(img[28], 178 , 465, 64, 72, null);
		if(Land.available[29]== false)
			g.drawImage(img[29], 131 , 465, 64, 72, null);
		if(Land.available[30]== false)
			g.drawImage(img[30], 84 , 465, 64, 72, null);
		
		//左边房子
		if(Land.available[37]== false)
			g.drawImage(img[37], 86 , 283, 64, 72, null);
		if(Land.available[36]== false)
			g.drawImage(img[36], 86 , 320, 64, 72, null);
		if(Land.available[35]== false)
			g.drawImage(img[35], 86 , 357, 64, 72, null);
		if(Land.available[34]== false)
			g.drawImage(img[34], 86 , 394, 64, 72, null);
        
		//关卡信息
		g.drawString("角色姓名： " +Richman.ch1.getName(), 145, 115);
		g.drawString("目标资产： "+15000.0, 145, 135);
		g.drawString("现有资产： "+Richman.ch1.getAsset(),145, 155);
		int turn = Richman.max-Richman.count;
		g.drawString("剩余局数： "+ turn,145, 175);
		
		//房屋价格
		g.drawString("一级建筑购买价格：500", 345, 100);
		g.drawString("二级建筑购买价格：800", 345, 120);
		g.drawString("三级建筑购买价格：1200", 345, 140);
		g.drawString("四级建筑购买价格：1400", 345, 160);
		g.drawString("五级建筑购买价格：1600", 345, 180);
		
		//收益信息
		g.drawString("一级建筑租金收益：800", 530, 100);
		g.drawString("二级建筑租金收益：1300", 530, 120);
		g.drawString("三级建筑租金收益：1900", 530, 140);
		g.drawString("四级建筑租金收益：2600", 530, 160);
		g.drawString("五级建筑租金收益：3400", 530, 180);
		
		//角色动画
		g.drawImage(gi.ch1, Richman.ch1.getX(), Richman.ch1.getY(), 64, 72, null);
	}
}
	
