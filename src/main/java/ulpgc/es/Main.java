package ulpgc.es;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(Math.PI / 2, 0.1, 9.81, 1.5);
        Mainframe frame = new MainFrame();
        new BallPresenter(ball, new PendulumSimulator(0.001)).execute();
    }
}