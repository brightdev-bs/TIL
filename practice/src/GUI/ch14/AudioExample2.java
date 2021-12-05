package GUI.ch14;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AudioExample2 extends JFrame {

    AudioExample2() {
        try {
            Clip clip = AudioSystem.getClip();
            File file = new File("/Users/byeongsukim/Desktop/TIL/practice/src/GUI/ch14/audio.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if(event.getType() == LineEvent.Type.STOP) {
                        getContentPane().setBackground(Color.ORANGE);
                    }
                }
            });
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(100,100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AudioExample2();
    }
}
