package ulpgc.es.model;

public class PendulumSimulator {
    private final double dt;

    public PendulumSimulator(double dt) {
        this.dt = dt;
    }

    public Ball simulate(Ball ball){
        return new Ball(newThetaOf(ball), newOmegaOf(ball), ball.g(), ball.L(), newXOf(ball), newYOf(ball), ball.r(), ball.damping());
    }



    private double newYOf(Ball ball) {
        return 100*(-ball.L()*Math.cos(ball.theta()));
    }

    private double newXOf(Ball ball) {
        return 100*ball.L()*Math.sin(ball.theta()); //Multiplico para adaptarlo a un tamaño mas grande en la pantalla
    }

    private double newOmegaOf(Ball ball) {
        double acceleration = -(ball.g() / ball.L()) * Math.sin(ball.theta());
        return ball.damping()*ball.omega() + acceleration * dt;

    }

    private double newThetaOf(Ball ball) {
        return normalizeTheta(ball.theta() + ball.omega() * dt);
    }

    private double normalizeTheta(double theta) {
        while (theta > Math.PI) theta -= 2 * Math.PI;
        while (theta < -Math.PI) theta += 2 * Math.PI;
        return theta;
    }


}
