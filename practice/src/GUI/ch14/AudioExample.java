package GUI.ch14;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AudioExample extends JFrame {

    Clip clip;
    AudioExample() {
        JButton play = new JButton("play");
        JButton stop = new JButton("stop");
        JButton again = new JButton("play again");
    }

    private void loadClip(String path) {
        try {
            clip = AudioSystem.getClip();
            File audioFile = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
