package game;

import javax.swing.JLabel;

public class timer implements Runnable{
	static int timer2=0;
	static int sc=0;
	int countdown=3;
	public timer(){
		Thread thread=new Thread(this);
		thread.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(Move.cont!=0 && Frame.bool==false){
				
				timer2=timer2+1;
				sc=sc+timer2*10;
				Move.time.setText("Time :"+timer2);
				Move.score.setText("Score"+sc);
				if(timer2>67 && timer2<71){
					Move.time.setText("CHECK1");
				}
				if(timer2>120 && timer2< 125){
					Move.time.setText("CHECK2");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				Move.cd.setText(""+countdown);
				countdown--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				timer2=timer2;
				Move.time.setText("Time :"+timer2);
				if(countdown==0){
					Move.cd.setText("GO");
					Move.cont++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Move.timer++;
					Move.cd.setVisible(false);
				}
			}
		}
	}
}