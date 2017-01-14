package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class hscore {
	int puan;
	String name;
	
	public hscore(int ver1,String ver2){
		puan=ver1;
		name=ver2;
	}
	public void read() throws IOException{
		 File dosya = new File("Scores.txt");
		 int i=found();
	        FileWriter yazici = new FileWriter(dosya,true);
	        BufferedWriter yaz = new BufferedWriter(yazici);
	        yaz.write(i+"  "+name+"  "+puan);
	        yaz.newLine();
	        yaz.close();
	}
	public int  found() throws IOException{
		FileReader fr=new FileReader("Scores.txt");
		BufferedReader bf=new BufferedReader(fr);
		String line;
		int i=0;
		while((line=bf.readLine())!=null){
			i++;
		}
		return i;
	}
}
