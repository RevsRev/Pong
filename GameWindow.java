import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class GameWindow extends JPanel {
  int window_x;
  int window_y;
  Racket racket1;
  Racket racket2;
  Ball ball;

  public GameWindow(Racket racket1, Racket racket2, Ball ball, int window_x, int window_y) {
    super();
    this.racket1 = racket1;
    this.racket2 = racket2;
    this.window_x = window_x;
    this.window_y = window_y;
    this.ball = ball;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //g.setColor(Color.WHITE);
    //g.drawRect(0,0,window_x,window_y);
    //g.setColor(Color.BLACK);
    //g.fillRect(0,0, window_x, window_y);

    BufferedImage bufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics g_buff = (Graphics) bufferImage.getGraphics();

    g_buff.setColor(Color.WHITE);
    g_buff.drawRect(0,0,window_x,window_y);
    g_buff.setColor(Color.BLACK);
    g_buff.fillRect(0,0, window_x, window_y);
    draw_Racket(racket1, g_buff, true);
    draw_Racket(racket2, g_buff, true);
    draw_Ball(ball, g_buff, true);
    g.drawImage(bufferImage, 0, 0, null);

  }

  public void draw_Racket(Racket racket, Graphics g, boolean fill) {
    if (fill) {
      g.setColor(Color.WHITE); //for drawing shapes
    } else {
      g.setColor(Color.BLACK); //for erasing shapes
    }
    g.fillRect(racket.x_pos, racket.y_pos, racket.width, racket.height);
  }

  public void draw_Ball(Ball ball, Graphics g, boolean fill) {
    if (fill) {
      g.setColor(Color.WHITE);
    } else {
      g.setColor(Color.BLACK);
    }
    g.fillRect(ball.x_pos, ball.y_pos, ball.size, ball.size);
  }

}
