import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ball {
  int x_pos;
  int y_pos;
  int x_vel;
  int y_vel;
  int size;
  int lscore = 0; //we keep track of the scores using the ball
  int rscore = 0;

  List<Integer> init_vel = new ArrayList<>(); // this is used for resetting the ball after each round.
  public void initialiseVelocityAraray() {
    for (int i=-2; i<3; i++) {
      if (i==0) {
        continue;
      } else {
        init_vel.add(i);
      }
    }
  }

  public Ball(int x_pos, int y_pos, int x_vel, int y_vel, int size) {
    this.x_pos = x_pos;
    this.y_pos = y_pos;
    this.x_vel = x_vel;
    this.y_vel = y_vel;
    this.size = size;
    initialiseVelocityAraray();
  }

  public void changeVel(int delvx, int delvy) {
    this.x_vel += delvx;
    this.y_vel += delvy;
  }

  public void changePos(int delx, int dely, int window_x, int window_y, Racket leftRacket, Racket rightRacket) {
    x_pos += delx;
    y_pos += dely;
    bounce(window_x, window_y, leftRacket, rightRacket);
  }

  public void resetBall(int window_x, int window_y) {
    x_pos = window_x/2;
    y_pos = window_y/2;
    Random randvx = new Random();
    Random randvy = new Random();
    x_vel = init_vel.get(randvx.nextInt(init_vel.size()));
    y_vel = init_vel.get(randvy.nextInt(init_vel.size()));
  }

  public void bounce(int window_x, int window_y, Racket leftRacket, Racket rightRacket) {
    //this function handles collisions between the ball and the sides of the window and the rackets.
    if (y_pos<0 && y_vel < 0) {
      y_vel = -y_vel;
    } else if (y_pos+size>window_y && y_vel>0) {
      y_vel = -y_vel;
    }
    //bouncing off the left racket
    if (x_pos>=leftRacket.x_pos + leftRacket.width && x_pos + x_vel<=leftRacket.x_pos + leftRacket.width && x_vel<0) {
      if (y_pos <= leftRacket.y_pos + leftRacket.height && y_pos >= leftRacket.y_pos) {
        y_pos += (x_pos-leftRacket.x_pos-leftRacket.width)*y_vel/x_vel;
        x_pos = leftRacket.x_pos + leftRacket.width;
        x_vel = -(x_vel-1); //each bounce increases speed
        y_vel += Math.signum(y_vel);
      }
    } else if (x_pos < leftRacket.x_pos) {
        resetBall(window_x, window_y);
        rscore += 1; //the right racket scored a point!
    }

    //bouncing off the right racket
    if (x_pos<=rightRacket.x_pos && x_pos + x_vel >= rightRacket.x_pos && x_vel>0) {
      if (y_pos <= rightRacket.y_pos + rightRacket.height && y_pos >= rightRacket.y_pos) {
        y_pos += (rightRacket.x_pos - x_pos)*y_vel/x_vel;
        x_pos = rightRacket.x_pos;
        x_vel = -(x_vel+1);
      }
    } else if (x_pos > rightRacket.x_pos) {
      resetBall(window_x, window_y);
      lscore += 1;
    }
  }

}
