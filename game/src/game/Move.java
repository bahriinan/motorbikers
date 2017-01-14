package game;



import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Move implements Runnable,KeyListener {
	ImageIcon image;
	JLabel label,label2;
	static JLabel label3;
	static JLabel sl=new JLabel("Speed : 0");
	static JLabel time=new JLabel("Time : 0");
	static JLabel score=new JLabel("Scores : 0");
	static JLabel cd=new JLabel("3");
	static Rectangle rect;
	static int x=500;
	static int puan=0;
	static int y=450;
	static int speed=1400;
	static int ms=0;
	//static int timer=0;
	public static int avsp=0;
	static int check=0;
	static int cont=0;
	static Thread thread;
	public Move(){
		movement movem=new movement();	
		sl.setBounds(20,20,100,30);
		sl.setVisible(true);
		time.setBounds(650,20,100,30);
		time.setVisible(true);
		Main.frame.add(time);
		Main.frame.add(sl);
		cd.setBounds(40, 20,50,50);
		cd.setVisible(true);
		Main.frame.add(cd);
		score.setBounds(650, 40, 100, 30);
		score.setVisible(true);
		Main.frame.add(score);
		image=new ImageIcon("motor.png");
		label3= new JLabel(image); 
		label3.setBounds(500,450,100,100);
		label3.setVisible(true);
		Main.frame.add(label3);
		Main.frame.addKeyListener(this);
		image=new ImageIcon("road.png");
		label= new JLabel(image); 
		label.setBounds(0, 0, 750,550);
		label.setVisible(true);
		Main.frame.add(label);
		image=new ImageIcon("road22.png");
		label2=new JLabel(image);
		label2.setBounds(0, 0, 750,550);
		label2.setVisible(true);
		Main.frame.add(label2);
		thread = new Thread(this);
		timer tier=new timer();
		rect=new Rectangle(x,y,100,100);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			/*if(x==15){
				System.out.println("aaaaa");
				image=new ImageIcon("boom.png");
				label3.setIcon(image);
				Main.frame.repaint();
			}*/
	        move(+x, 0);
	        image = new ImageIcon("sol.png");
	        label3.setIcon(image);
		}
	    else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	    	move(-x, 0);
	    	
	    	image = new ImageIcon("sag.png");
	    	label3.setIcon(image);	
	    }
	        
	    else if (e.getKeyCode() == KeyEvent.VK_UP){
	    	if(Frame.bool==false){
	    	if(timer.timer2!=0){
	    		if(speed!=100){
		    		thread = new Thread(this);
		    		thread.start();
		    		ms=ms+10;
		    		speed=speed-100;
		    		sl.setText("Speed :"+ms);
		    		cont++;
		    		try {
						audio aa=new audio();
						try {
							aa.play();
							System.out.print(movement.toggle);
							if(movement.toggle==false){
								aa.stop();
							}
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    	}
	    	}
	    	}
	    }
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			ms=ms-10;
	        speed=speed+100;
	        sl.setText("Speed :"+ms);
		}
	}
	public void	move(int xa,int yb){
			if(xa>0){
				x=x-10;
				label3.setBounds(x,y,100,100);
			label3.repaint();
			if(x<5){
				image=new ImageIcon("boom.png");
				label3.setIcon(image);
				hscore hs=new hscore(timer.timer2,Register.metin);
				try {
					hs.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Frame.bool=true;
				JOptionPane.showMessageDialog(null,"The Game  Over","WARNING",JOptionPane.WARNING_MESSAGE);
			}
		}else{
				x=x+10;
				label3.setBounds(x,y,100,100);
				label3.repaint();
				if(x>650){
					image=new ImageIcon("boom.png");
					label3.setIcon(image);
					hscore hs=new hscore(timer.timer2,Register.metin);
					try {
						hs.read();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Frame.bool=true;
					JOptionPane.showMessageDialog(null,"The Game Over","WARNING",JOptionPane.WARNING_MESSAGE);
		}
		}
		/*else{
			if(yb>0){
				if(y!=0){
				y=y-10;
				label3.setBounds(x,y,100,100);
				label3.repaint();
				}
			}else{
				if(y!=810){
					y=y+10;
					label3.setBounds(x,y,100,100);
					label3.repaint();
					}
				}
			
		}*/
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		image = new ImageIcon("motor.png");
    	label3.setIcon(image);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		int x=0;
		// TODO Auto-generated method stub
		while(true){
			if(Frame.bool==false){
				calc();
			// TODO Auto-generated method stub
			if(x==0){
				label.setVisible(false);
				label2.setVisible(true);
				x=1;
			}else{
				label.setVisible(true);
				label2.setVisible(false);
				 x=0;
		}
			if(avsp>10000 && avsp<50000){
				ImageIcon imagen=new ImageIcon("sageðim.png");
				ImageIcon imagel=new ImageIcon("saðeðim2.png");
				label.setIcon(imagen);
				label2.setIcon(imagel);
				check=1;
			}
			if(avsp>50000){
				check=2;
				ImageIcon imager=new ImageIcon("road.png");
				ImageIcon imager2=new ImageIcon("road22.png");
				label.setIcon(imager);
				label2.setIcon(imager2);
			}
			
			if(avsp>80000 && avsp<130000){
				ImageIcon imagen=new ImageIcon("solv1.png");
				ImageIcon imagel=new ImageIcon("soleðim2.png");
				label.setIcon(imagen);
				label2.setIcon(imagel);
				check=3;
			}
			if(avsp>200000 && avsp<250000){
				ImageIcon imagen=new ImageIcon("solv1.png");
				ImageIcon imagel=new ImageIcon("soleðim2.png");
				label.setIcon(imagen);
				label2.setIcon(imagel);
				check=3;
			}
			if(avsp>350000 && avsp< 400000){
				ImageIcon imagen=new ImageIcon("sageðim.png");
				ImageIcon imagel=new ImageIcon("saðeðim2.png");
				label.setIcon(imagen);
				label2.setIcon(imagel);
				check=1;
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	public static void display(ImageIcon image){
		label3.setIcon(image);
	}
	public int calc(){
		avsp=avsp+(ms*timer.timer2);
		return avsp;
	}	
}
