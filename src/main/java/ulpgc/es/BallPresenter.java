package ulpgc.es;

import java.util.Timer;
import java.util.TimerTask;

public class BallPresenter {
    private Ball ball;
    private final BallDisplay ballDisplay;
    private final PendulumSimulator pendulumSimulator;

    public BallPresenter(Ball ball, BallDisplay ballDisplay, PendulumSimulator pendulumSimulator) {
        this.ball = new Ball(ball.theta(),ball.omega(),ball.g(), ball.L(), ball.x(),ball.y(),ball.r(), ball.damping());
        this.ballDisplay = ballDisplay;
        this.pendulumSimulator = pendulumSimulator;
    }

    public void execute(){
        new Timer().schedule(simulateTask(), 1, 1);
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
        this.ballDisplay.drawCircle((int) ball.r(),(int) ball.x(), (int) ball.y());
        System.out.println("Theta: "+ball.theta()+ " Omega: "+ball.omega());
    }
}
