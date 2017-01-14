package game;

import javax.swing.JProgressBar;

public class pbex {
	JProgressBar pb; 
	public pbex(){
		pb= new JProgressBar(0,100);
        pb.setBounds(0,100,50,30);
        pb.setValue(100);
        pb.setStringPainted(true);
        Main.frame.add(pb);
	}
	public void achive(){
		if(Move.avsp==0){
			pb.setValue(0);
		}
		else if(Move.avsp>10000){
			pb.setValue(25);
		}
		else if(Move.avsp>100000){
			pb.setValue(50);
		}
		else if(Move.avsp>150000){
			pb.setValue(75);
		}
		else{
			pb.setValue(100);
		}
	}
}
