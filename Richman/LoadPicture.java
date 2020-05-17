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
		this.setResizable(false);//显示窗体缩放大小
		this.setVisible(true);//显示窗体

  
		int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗体信息
		int frameWidth=250;
		int frameHeight=200;
		int frameX=(screenWidth-frameWidth)/2;
		int frameY=(screenHeight-frameHeight)/2;
		//将窗体设置在屏幕中央
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
		
		//设置图片
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