package ulpgc.es;

import java.util.Timer;
import java.util.TimerTask;

public class BallPresenter {
    private Ball ball;
    private final BallDisplay ballDisplay;
    private final PendulumSimulator pendulumSimulator;

    public BallPresenter(Ball ball, BallDisplay ballDisplay, PendulumSimulator pendulumSimulator) {
        this.ball = new Ball(ball.theta(),ball.omega(),ball.g(), ball.L(), ball.x(),ball.y());
        this.ballDisplay = ballDisplay;
        this.pendulumSimulator = pendulumSimulator;
    }

    public void execute(){
        new Timer().schedule(simulateTask(), 10, 10);
    }

    private TimerTask simulateTask() {
        return new TimerTask() {
            @Override
            public void run() {
                simulate();
            }
        };
    }

    public void simulate(){
        this.ballDisplay.clear();
        ball = pendulumSimulator.simulate(this.ball);
        //this.ballDisplay.drawCircle((int) ball.x(),(int) ball.h(), (int) ball.x());
        System.out.println(ball);
    }
}
