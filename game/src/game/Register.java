package game;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Register extends JFrame {
	static String metin;
	public JTextField jtf;
	public JLabel label,label2;
	public JPasswordField jpf;
	public JButton button,button2;
	public Register(){
		super("LOGIN");
		setLayout(null);
		label=new JLabel("NAME: ");
		label2=new JLabel("PASSWORD: ");
		label.setBounds(15,25,60,20);
		label2.setBounds(15,62,110,20);
		jtf=new JTextField();
		jtf.setBounds(90,28,140,30);
		jpf=new JPasswordField();
		jpf.setBounds(90,62,140,30);
		button=new JButton("LOGIN");
		button2=new JButton("HELP");
		button.setBounds(100, 100, 80,40);
		button2.setBounds(170, 100, 80,40);
		add(label);
		add(label2);
		add(jtf);
		add(jpf);
		add(button);
		add(button2);
		setSize(350,350);
		setVisible(true);
		Handler handless=new Handler();
		button.addActionListener(handless);
	}
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button){
				metin=jtf.getText();
				String pass=new String(jpf.getPassword());
				
				try {
					if(ctrl()==0){
						
						try{
					        File dosya = new File("Register.txt");
					        FileWriter yazici = new FileWriter(dosya,true);
					        BufferedWriter yaz = new BufferedWriter(yazici);
					        yaz.write(metin+"  "+pass);
					        yaz.newLine();
					        yaz.close();
					        //System.out.println("Ekleme Ýþlemi Baþarýlý");
					    }
					    catch (Exception hata){
					        hata.printStackTrace();
					    }
						JOptionPane.showMessageDialog(null,"Register Completed","INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						Main.frame.label.setVisible(false);
						Move mv=new Move();
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Login Completed","INFORMATION", JOptionPane.INFORMATION_MESSAGE);
						Main.frame.label.setVisible(false);
						Move mv=new Move();
						dispose();
					}
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
		}
		public int ctrl() throws IOException{
			FileReader fr=new FileReader("Register.txt");
			String line;
			String ka=jtf.getText();
			String pass=new String(jpf.getPassword());
			BufferedReader bf=new BufferedReader(fr);
			while((line=bf.readLine())!=null){
				if(line.equals(ka+"  "+pass)){
					return 1;
				}
				else{
					return 0;
				}
			}
			return 5;
		}
	}
}
