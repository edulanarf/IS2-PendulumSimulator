package ulpgc.es;

public class PendulumSimulator {
    private final double dt;

    public PendulumSimulator(double dt) {
        this.dt = dt;
    }

    public Ball simulate(Ball ball){
        return willStop(ball) ?
                new Ball(newThetaOf(ball), newOmegaAfterStopOf(ball), ball.g(), ball.L()):
                new Ball(newThetaOf(ball), newOmegaOf(ball), ball.g(), ball.L());

    }

    private double newOmegaAfterStopOf(Ball ball) {
        //double damping = 0.80;
        return -ball.omega();
    }

    private double newOmegaOf(Ball ball) {
        //double damping = 0.80;
        double acceleration = -(ball.g() / ball.L()) * Math.sin(ball.theta());
        System.out.println("Aceleracion:"+ acceleration);
        return ball.omega() + acceleration * dt;
    }

    private double newThetaOf(Ball ball) {
        return normalizeTheta(ball.theta() + ball.omega() * dt);
    }

    private double normalizeTheta(double theta) {
        while (theta > Math.PI) theta -= 2 * Math.PI;
        while (theta < -Math.PI) theta += 2 * Math.PI;
        return theta;
    }

    private boolean willStop(Ball ball) {
        if (Math.abs(ball.omega()) < 0.010 && (Math.abs(ball.theta()) > Math.PI - 0.1 && Math.abs(ball.theta()) < Math.PI + 0.1)) {
            return true;  // El péndulo ha llegado a un extremo y rebota
        }
        return false;
    }
}
