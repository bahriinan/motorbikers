package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Frame extends JFrame {
	JMenuBar menubar;
	JMenu menu,menu1;
	JMenuItem sub1;
	JMenuItem subb,subs,sub2,sub3,sub33,sub22,subut;
	static JLabel label;
	static boolean bool=false;
	public Frame(){
		super("Hang-On");
		menubar=new JMenuBar();
		menu=new JMenu("GAME");
		subb=new JMenuItem("START");
		sub22=new JMenuItem("PAUSE");
		sub33 = new JMenuItem("RESTART");
		subut=new JMenuItem("UNPAUSE");
		menu.add(subb);
		menu.add(sub22);
		menu.add(sub33);
		menu.add(subut);
		menubar.add(menu);
		add(menubar);
		menu=new JMenu("USER");
		sub1=new JMenuItem("LOGIN");
		sub2=new JMenuItem("HIGH SCORE");
		menu.add(sub1);
		menu.add(sub2);
		menubar.add(menu);
		add(menubar);
		menu1=new JMenu("QUIT");
		subs=new JMenuItem("Exit");
		menu1.add(subs);
		menubar.add(menu1);
		add(menubar);
		super.setJMenuBar(menubar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Handler hand=new Handler();
		subb.addActionListener(hand);
		subut.addActionListener(hand);
		sub1.addActionListener(hand);
		subs.addActionListener(hand);
		sub2.addActionListener(hand);
		sub33.addActionListener(hand);
		sub22.addActionListener(hand);
		ImageIcon image=new ImageIcon("bgpicture.png");
		label=new JLabel(image);
		label.setBounds(0, 0, 600,550);
        label.setVisible(true);
        add(label);
		setSize(750,600);
		setResizable(false);
		setVisible(true);
	}
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==subb){
				JOptionPane.showMessageDialog(null, "IF YOU WANT TO PLAY YOU HAVE TO LOGIN FIRST", "WARNING",JOptionPane.WARNING_MESSAGE);
				Register reg=new Register();
			}
			if(e.getSource()==sub1){
				Register reg=new Register();
			}
			if(e.getSource()==subs){
				JOptionPane.showMessageDialog(null,"THANK YOU","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			if(e.getSource()==sub33){
				Main.frame.dispose();
				Main.frame=new Frame();
			}
			if(e.getSource()==sub2){
				Shscore ss=new Shscore();
			}
			if(e.getSource()==sub22){
				bool=true;
			}
			if(e.getSource()==subut){
				bool=false;
			}
		}
		
	}
	
}
