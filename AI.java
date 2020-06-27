public class AI {
  private int difficulty; //difficulty 0 is easy, 1 medium, etc...
  Racket rightRacket; //the racket to be controlled by the AI
  Ball ball; //the ball the AI is trying to hit

  public AI(int difficulty, Racket rightRacket, Ball ball) {
    this.difficulty = difficulty;
    this.rightRacket = rightRacket;
    this.ball = ball;
  }

  public int recommendMove() {
    switch (difficulty) {
      case 0:
        if (ball.y_pos>rightRacket.y_pos+rightRacket.height/2) {
          return 1;
        }
        return -1;
    }
    return 0;
  }

}
