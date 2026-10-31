package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Sound {

    Clip clip;
    File soundURL[] = new File[30];

    public Sound() {

        /* TEMPLATE
        soundURL[index] = getClass().getResource("NAME");
         */
          soundURL[0] = new File("res/Sound Library/Click.wav");
          soundURL[1] = new File("res/Sound Library/Heal.wav");

          soundURL[15] = new File("res/Music Libray/Music.wav");
          soundURL[16] = new File("res/Music Libray/BattleMusic.wav");
          soundURL[17] = new File("res/Music Libray/ArenaMusic.wav");
          soundURL[18] = new File("res/Music Libray/TitleMusic.wav");

    }

    public void setFile(int i) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i].toURI().toURL());
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch(Exception e) {

        }

    }

    public void play() {

        clip.start();

    }

    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop() {

        clip.stop();

    }

    public float getVolume() {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        return (float) Math.pow(10f, gainControl.getValue() / 20f);
    }

    public void setVolume(float volume) {
        if (volume < 0f || volume > 1f)
            throw new IllegalArgumentException("Volume not valid: " + volume);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(20f * (float) Math.log10(volume));
    }

}