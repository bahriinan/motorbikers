package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class Shscore extends JFrame{
	JTextArea jta;
	public Shscore(){
		super("HIGH SCORE");
		setSize(500,500);
		jta=new JTextArea();
		jta.setSize(450,450);
		jta.setVisible(true);
		add(jta);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		handler hand=new handler();
		hand.execute();
	}
	public class handler extends SwingWorker<String,String>{
		@Override
		
		protected String doInBackground() throws Exception {
			while(true){
				FileReader fr=new FileReader("Scores.txt");
				String line;
				BufferedReader bf=new BufferedReader(fr);
				while((line=bf.readLine())!=null){
					jta.setText(line);
				}
				return line;

			}
			// TODO Auto-generated method stub
					}
		
	}
}
