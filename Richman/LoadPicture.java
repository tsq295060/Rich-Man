package Richman;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class LoadPicture extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadPicture(String file1,String file2){
		this.setResizable(false);//��ʾ�������Ŵ�С
		this.setVisible(true);//��ʾ����

  
		int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
		//���ô�����Ϣ
		int frameWidth=250;
		int frameHeight=200;
		int frameX=(screenWidth-frameWidth)/2;
		int frameY=(screenHeight-frameHeight)/2;
		//��������������Ļ����
		this.setBounds(frameX,frameY,frameWidth,frameHeight);
		this.setAlwaysOnTop(true);
		BufferedImage img1=null;
		BufferedImage img2=null;
		
		try{
			img1=ImageIO.read(new File(file1));
			img2=ImageIO.read(new File(file2));
		} catch(IOException e){
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		
		//����ͼƬ
		JLabel label1=new JLabel(new ImageIcon(img1));
		getContentPane().add(label1);
		label1.setBounds(5,20,img1.getWidth(),img1.getHeight());
		JLabel label2=new JLabel(new ImageIcon(img2));
		getContentPane().add(label2);
		label2.setBounds(130,20,img2.getWidth(),img2.getHeight());
		
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        dispose();
        
	}
}