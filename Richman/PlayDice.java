package Richman;

import java.io.*;
public class PlayDice {
	private static String file1="";
	private static String file2="";
	private static int result=0;

	public static int throwDice() throws IOException {
		int index = (int)(Math.random() * 10 % 6);//0-5随机数
		return index+1;
	}

	//判断随机数与哪张骰子图片相对应

	public static String judge(int index){
		String file="";
		if(index==1){
			file="imgs/img1.jpg";
		}
		else if(index==2){
			file="imgs/img2.jpg";
		}
		else if(index==3){
			file="imgs/img3.jpg";
		}
		else if(index==4){
			file="imgs/img4.jpg";
		}
		else if(index==5){
			file="imgs/img5.jpg";
		}
		else {
			file="imgs/img6.jpg";
		}
			return file;
	}
	public static int getResult(){
		return result;
	}
	public static void playDice() throws IOException{
		int index1=throwDice();
		file1=judge(index1);
		int index2=throwDice();
		file2=judge(index2);
		result=index1+index2;
		new LoadPicture(file1,file2);
		
	}
}