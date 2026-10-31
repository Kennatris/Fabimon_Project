// almost everything done by Phillip
package main.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean wPressed, aPressed, dPressed, sPressed, escPressed, spacePressed, iPressed, f12Pressed, upPressed, downPressed, leftPressed, rightPressed, enterPressed, shiftPressed, hPressed, kPressed, entPressed, tPressed, rPressed, tabPressed;
    int genutzt = 1;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {    // Wenn eine Taste gedrückt wurde wird diese Methode aufgerufen.

        int code = e.getKeyCode();  // Speichert den Code der Taste die gedrückt wird in einer Variable ab.

        if (code == KeyEvent.VK_W) {    // schaut nach welche Taste gedrückt wurde und setzt den jeweiligen Boolean auf true.
            wPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }
        if(code == KeyEvent.VK_TAB){
            tabPressed = true;
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
            if(genutzt == 1) {
                f12Pressed = true;
                genutzt=0;
            }
        }

        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        if (code == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
        }

        if (code == KeyEvent.VK_H) {
            hPressed = true;
        }

        if (code == KeyEvent.VK_K) {
            kPressed = true;
        }

        if (code == KeyEvent.VK_DELETE) {
            if(genutzt == 1) {
                entPressed = true;
                genutzt=0;
            }
        }

        if (code == KeyEvent.VK_T) {
            tPressed = true;
        }

        if (code == KeyEvent.VK_R) {
            rPressed = true;
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
            genutzt = 1;
        }
        if(code == KeyEvent.VK_TAB){
            tabPressed = false;
        }

        if (code == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }

        if (code == KeyEvent.VK_H) {
            hPressed = false;
        }

        if (code == KeyEvent.VK_K) {
            kPressed = false;
        }

        if (code == KeyEvent.VK_DELETE) {
            entPressed = false;
        }

        if (code == KeyEvent.VK_T) {
            tPressed = false;
        }

        if (code == KeyEvent.VK_R) {
            rPressed = false;
        }

    }

}