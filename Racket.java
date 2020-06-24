
public class Racket {
    int x_pos;
    int y_pos;
    int width;
    int height;
    int speed; //controls how fast we can move the racket

    public Racket(int x_pos, int y_pos, int width, int height, int speed) {
      this.x_pos = x_pos;
      this.y_pos = y_pos;
      this.width = width;
      this.height = height;
      this.speed = speed;
    }

    public void changePos(int delx, int dely, int window_height) {

      for (int i=0; i<speed; i++) {
        if (y_pos + dely*(speed-i) <=0) {
          y_pos = 0;
          return;
        } else if (y_pos + dely*(speed-i) + height >= window_height) {
          y_pos = window_height - height;
          return;
        }
      }
      y_pos += speed*dely;
      x_pos += speed*delx; //we won't actually be using this feature ever, so haven't bothered
      //to put in movement conditions at the boundary.
    }
}
