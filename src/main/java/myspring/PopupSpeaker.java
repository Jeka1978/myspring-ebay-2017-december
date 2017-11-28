package myspring;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class PopupSpeaker implements Speaker {
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
