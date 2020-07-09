import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//import java.awt.Toolkit;

public class Pong {

  public static void main(String []args) {

    //Toolkit.getDefaultToolkit().sync(); //seems to reduce lag

    int window_x = 600;
    int window_y = 400;
    int rally_count = 0;
    int ball_vx = 1;
    int ball_vy = 1;
    int racket_speed = 3;

    Racket racket1 = new Racket(10, window_y/2, 5, 40, racket_speed);
    Racket racket2 = new Racket(window_x - 10, window_y/2, 5, 40, racket_speed);
    Ball ball = new Ball(window_x/2, window_y/2, ball_vx, ball_vy, 5);

    GameWindow gW = new GameWindow(racket1, racket2, ball, window_x, window_y);
    KeyController kC = new KeyController();
    AI aI = new AI(0, gW.racket2, gW.ball);
    //gW.addKeyListener(kC);
    //new KeyController();

    GameLoop gL = new GameLoop(gW, kC, aI);


    JFrame jF = new JFrame("Pong");
    jF.addKeyListener(kC);
    jF.add(gL.gW);
    jF.setSize(gW.window_x,gW.window_y);
    jF.setVisible(true);
    jF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //jF.setIgnoreRepaint(true);
    
    Timer timer = new Timer(15, gL);
    timer.start();

    /*while (true) {
      gW.ball.changePos(ball.x_vel, ball.y_vel, window_x, window_y, gW.racket1, gW.racket2);
      gW.racket1.changePos(0, kC.racket_dirrection, window_y);
      gW.repaint();
      try {
        Thread.sleep(100);
      } catch (InterruptedException ex) {
        continue;
      }
    }*/
  }
}
