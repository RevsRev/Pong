import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class KeyController extends Frame implements KeyListener {
  int racket_dirrection = 0; //+1 for up, 0 for stationary, -1 for down.
  boolean quit = false;

  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch(keyCode) {
      case KeyEvent.VK_UP:
        racket_dirrection = -1;
        break;
      case KeyEvent.VK_DOWN:
        racket_dirrection = +1;
        break;
      case KeyEvent.VK_ESCAPE:
        quit = true;
    }
  }

  public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch(keyCode) {
      case KeyEvent.VK_UP:
        this.racket_dirrection = 0;
        break;
      case KeyEvent.VK_DOWN:
        this.racket_dirrection = 0;
        break;
    }
  }

  public void keyTyped(KeyEvent e) {
    return;
  }

}
