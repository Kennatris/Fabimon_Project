import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wPressed, aPressed, dPressed, sPressed, escPressed, spacePressed, iPressed, f12Pressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {    // Wenn eine Taste gedrückt wird wird diese Methode aufgerufen.

        int code = e.getKeyCode();  // Speichert den Code der Taste die gedrückt wird in einer Variable ab.

        if (code == KeyEvent.VK_W) {    // schaut nach welche Taste gedrückt wurde und setzt den jeweiligen Boolean auf true.
            wPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            dPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            sPressed = true;
        }

        if (code == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }

        if (code == KeyEvent.VK_ESCAPE) {
            escPressed = true;
        }

        if (code == KeyEvent.VK_I) {
            iPressed = true;
        }

        if (code == KeyEvent.VK_F12) {
            f12Pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {   //Wenn die Taste losgelassen wurde wird der jeweilige Boolean auf false gesetzt.

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            aPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            dPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            sPressed = false;
        }

        if (code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }

        if (code == KeyEvent.VK_ESCAPE) {
            escPressed = false;
        }

        if (code == KeyEvent.VK_I) {
            iPressed = false;
        }

        if (code == KeyEvent.VK_F12) {
            f12Pressed = false;
        }
    }
}