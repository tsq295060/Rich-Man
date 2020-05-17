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

	//����ĳ�ʼ�������꣬��ʼ�ʲ�������
	static Character ch1 = Character.getSingletonInstance();
	static int landNumber=0;
	public static void main(String[] args) throws IOException, InterruptedException {
		Richman.loadBackground();
		JOptionPane.showMessageDialog(null, "������Ϸ��ʼ��");
		String name = (String) JOptionPane.showInputDialog(null,"�������ɫ���� ��\n");
		ch1.setName(name);
		Thread.sleep(1000);
		int result=0;
		int choice=0;
		for(count = 1;count <= max;count++){
		//ҡ���ӣ�������
			Thread.sleep(500);
			choice = JOptionPane.showConfirmDialog(null, "���Ƿ�ѡ�������ʼ��"+count+"��������"
				, " ",JOptionPane.YES_NO_OPTION);
			if(choice==0){
			PlayDice.playDice();
			result=PlayDice.getResult();
			sum += result;
			JOptionPane.showMessageDialog(null, "�����������ӽ��Ϊ"+result+",����ǰ��"+result+"����");
			landNumber=sum%38;
			if(sum > 38){
				sum = sum-38;
			}
			//ch1.setLocation(Land.location[landNumber][0],Land.location[landNumber][1]);
			//����任
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
			Richman.loadBackground();//��һ��һ��Ҫ�����
			
			if(ch1.getAsset() >= 15000 && (max-count) > 0){
				JOptionPane.showMessageDialog(null, "��ϲ������Ϸ�ɹ�");
				System.exit(1);
			}else if(ch1.getAsset() < 15000 && (max-count) <= 0){
				JOptionPane.showMessageDialog(null, "��δ���Ŀ�꣬��Ϸʧ��");
				System.exit(1);
			}else if(ch1.getAsset() <= 0){
				JOptionPane.showMessageDialog(null, "���Ʋ��ˣ���Ϸ����");
				System.exit(1);
			}
			}
			else{
				choice = JOptionPane.showConfirmDialog(null, "�����Ҫ�˳�����Ϸ��"
				, " ",JOptionPane.YES_NO_OPTION);
				if(choice==0){
					JOptionPane.showMessageDialog(null, "��л���Ĳ��룬�ڴ��´κ�������");
					System.exit(1);
				}
				else{
					JOptionPane.showMessageDialog(null, "�������Ϸ,������ʧȥ���������ӵĻ���");
				}
			}
		}	
	}
	
	public static void loadBackground() {
		Panel mp = new Panel();		
		jf.add(mp);		
		jf.setSize(750, 633);
		jf.setTitle("����");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	
		//��ȡ��Ļ��С
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		//���ô�����Ϣ
		int framewidth = 750;
		int frameheight = 633;		
		int frameX = (screenWidth - framewidth)/2;
		int frameY = (screenHeight - frameheight)/2;
		//��������������Ļ����
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
		//������
		g.drawImage(gi.bg, 0, 0, 750, 633, null);
		
		//�������߶�����
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
		
		//�ұ߷���
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
		
		//���淿��
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
		
		//��߷���
		if(Land.available[37]== false)
			g.drawImage(img[37], 86 , 283, 64, 72, null);
		if(Land.available[36]== false)
			g.drawImage(img[36], 86 , 320, 64, 72, null);
		if(Land.available[35]== false)
			g.drawImage(img[35], 86 , 357, 64, 72, null);
		if(Land.available[34]== false)
			g.drawImage(img[34], 86 , 394, 64, 72, null);
        
		//�ؿ���Ϣ
		g.drawString("��ɫ������ " +Richman.ch1.getName(), 145, 115);
		g.drawString("Ŀ���ʲ��� "+15000.0, 145, 135);
		g.drawString("�����ʲ��� "+Richman.ch1.getAsset(),145, 155);
		int turn = Richman.max-Richman.count;
		g.drawString("ʣ������� "+ turn,145, 175);
		
		//���ݼ۸�
		g.drawString("һ����������۸�500", 345, 100);
		g.drawString("������������۸�800", 345, 120);
		g.drawString("������������۸�1200", 345, 140);
		g.drawString("�ļ���������۸�1400", 345, 160);
		g.drawString("�弶��������۸�1600", 345, 180);
		
		//������Ϣ
		g.drawString("һ������������棺800", 530, 100);
		g.drawString("��������������棺1300", 530, 120);
		g.drawString("��������������棺1900", 530, 140);
		g.drawString("�ļ�����������棺2600", 530, 160);
		g.drawString("�弶����������棺3400", 530, 180);
		
		//��ɫ����
		g.drawImage(gi.ch1, Richman.ch1.getX(), Richman.ch1.getY(), 64, 72, null);
	}
}
	
