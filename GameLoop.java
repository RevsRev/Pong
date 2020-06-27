import java.awt.*;
import java.awt.event.*;

public class GameLoop implements ActionListener {
  GameWindow gW;
  KeyController kC;
  AI aI;

  public GameLoop(GameWindow gW, KeyController kC, AI aI) {
    super();
    this.gW = gW;
    this.kC = kC;
    this.aI = aI;
  }

  public void actionPerformed(ActionEvent e) {
    gW.ball.changePos(gW.ball.x_vel, gW.ball.y_vel, gW.window_x, gW.window_y, gW.racket1, gW.racket2);
    gW.racket1.changePos(0, kC.racket_dirrection, gW.window_y);
    gW.racket2.changePos(0, aI.recommendMove(), gW.window_y);
    gW.repaint();
  }
}
