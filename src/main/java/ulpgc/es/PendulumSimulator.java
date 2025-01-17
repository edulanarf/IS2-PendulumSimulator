package ulpgc.es;

public class PendulumSimulator {
    private final double dt;

    public PendulumSimulator(double dt) {
        this.dt = dt;
    }

    private Ball simulate(Ball ball){
        return willStop(ball) ?
                new Ball(newThetaAfterStopOf(ball), newOmegaAfterStopOf(ball), ball.g(), ball.L(),ball.mass()):
                new Ball(newThetaOf(ball), newOmegaOf(ball), ball.g(), ball.L(),ball.mass());

    }

    private double newOmegaOf(Ball ball) {
        return 0;
    }

    private double newThetaOf(Ball ball) {
        return 0;
    }

    private boolean willStop(Ball ball) {
        return false;
    }
}
