package game;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
	
public class virtual{
	int x;
	int y;
	JLabel label;
	public int height,weight;
	public virtual(int ver1,int ver2,int ver3,int ver4){
		x=ver1;
		y=ver2;
		weight=ver3;
		height=ver4;
		ImageIcon image=new ImageIcon("ymotor.png");
		 label=new JLabel(image);
		label.setBounds(x,y,weight,height);
		label.setVisible(true);
		Main.frame.add(label);
	}
	public void setbounds(){
		label.setBounds(x,y,weight,height);
		Main.frame.repaint();
	}
	public void setim(ImageIcon imagem){
		label.setIcon(imagem);
	}
	public void overkill(){
		label.setVisible(false);
	}
}
