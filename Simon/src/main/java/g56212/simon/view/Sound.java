package g56212.simon.view;

import javafx.scene.control.Button;

/**
 *
 * @author piotr
 */
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class Sound {

    public static void playSound(Button button) throws MidiUnavailableException {

        int noteNumber;
        switch (button.getId()) {
            case "green":
                noteNumber = 69;
                break;
            case "red":
                noteNumber = 71;
                break;
            case "yellow":
                noteNumber = 72;
                break;
            case "blue":
                noteNumber = 74;
                break;
            default:
                noteNumber = 0;
                break;
        }

        var synth = MidiSystem.getSynthesizer();
        synth.open();
        var channel = synth.getChannels()[0];
        channel.noteOn(noteNumber, 80);

        var pause = new PauseTransition(Duration.seconds(1));

        pause.setOnFinished(event -> channel.noteOff(noteNumber));
        pause.play();

    }
}
