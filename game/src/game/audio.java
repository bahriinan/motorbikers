package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class audio {
	static File audioFile;
	public audio() throws UnsupportedAudioFileException, IOException{
		audioFile = new File("dota.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	}
	public void play() throws IOException, UnsupportedAudioFileException, InterruptedException{
		try {
			Clip cc = AudioSystem.getClip();
			cc.open(AudioSystem.getAudioInputStream(audioFile));
			cc.start();
			//Thread.sleep(1000);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void stop(){
		try {
			Clip cc = AudioSystem.getClip();
			try {
				cc.open(AudioSystem.getAudioInputStream(audioFile));
			} catch (IOException | UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cc.stop();
			//Thread.sleep(1000);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	