package game;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class movement implements Runnable {
	ArrayList<virtual> mlist=new ArrayList<virtual>();
	Rectangle rec=new Rectangle();
	static boolean toggle=true;
	public movement(){
		virtual vm=new virtual(150,250,100,100);
		mlist.add(vm);
		vm=new virtual(150,450,100,100);
		mlist.add(vm);
		vm=new virtual(250,250,100,100);
		mlist.add(vm);
		vm=new virtual(250,450,100,100);
		mlist.add(vm);
		vm=new virtual(350,250,100,100);
		mlist.add(vm);
		vm=new virtual(350,450,100,100);
		mlist.add(vm);
		vm=new virtual(450,250,100,100);
		mlist.add(vm);
		Thread thread=new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(Frame.bool==false){
			for(virtual vx:mlist){
				rec.setBounds(vx.x, vx.y, 100, 100);
				if(Move.ms>=50){
					vx.y=vx.y+5;
					vx.setbounds();
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*if(Move.rect.intersects(rec)){
						ImageIcon image=new ImageIcon("boom.png");
						Move.display(image);
						vx.overkill();
						Frame.bool=true;
						hscore hs=new hscore(timer.timer2,Register.metin);
						try {
							hs.read();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"The Game is Over","WARNING",JOptionPane.WARNING_MESSAGE);
				}*/
			
					
				}
				else if(Move.ms>=60){
					vx.y=vx.y+30;
					vx.setbounds();
					try {
						Thread.sleep(125);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(Move.ms<30 && Move.ms!=0){
					vx.y=vx.y-5;
					vx.setbounds();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(Move.ms<20 && Move.ms!=0){
					vx.y=vx.y-15;
					vx.setbounds();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(Move.ms==0 && Move.cont!=0){
					vx.y=vx.y-50;
					vx.setbounds();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(Move.ms<60 && Move.cont!=0){
					Random rnd=new Random();
					int rn=rnd.nextInt();
					rn=rn%2;
					if(rn==0){
						if(vx.x!=10){
							vx.x=vx.x-10;
							vx.setbounds();
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(rn==1){
						if(vx.x!=660){
							vx.x=vx.x+10;
							vx.setbounds();
							try {
								Thread.sleep(30);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				if(Move.ms==90){
					vx.y=vx.y+50;
					vx.setbounds();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(timer.timer2>60 && timer.timer2<150){
					int diffx=Move.x-vx.x;
					//System.out.println(vx.x);
					if(diffx<=50 && Move.x>vx.x){
						vx.x+=10;
					System.out.print("v-1-");	
					}else if(diffx>=-50 && Move.x<vx.x){
						vx.x-=10;
					System.out.print("v-2-");	
					}
					//System.out.println(vx.x);
					if(!Move.rect.intersects(rec)){
						ImageIcon image=new ImageIcon("boom.png");
						Move.display(image);
						vx.overkill();
						Frame.bool=true;
						hscore hs=new hscore(timer.timer2,Register.metin);
						try {
							hs.read();
							toggle=false;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"The Game is Over","WARNING",JOptionPane.WARNING_MESSAGE);
				}
			
			}
				if(Move.check==1){
					ImageIcon imaginel=new ImageIcon("ymotosag.png");
					vx.setim(imaginel);
					if(vx.x!=600){
						vx.x=vx.x+10;
					}
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(Move.check==2){
					ImageIcon imaginel=new ImageIcon("ymotor.png");
					vx.setim(imaginel);
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(Move.check==3){
					ImageIcon imaginel=new ImageIcon("ymotosol.png");
					vx.setim(imaginel);
					if(vx.x!=600){
						vx.x=vx.x-10;
					}
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		}
	}
}
