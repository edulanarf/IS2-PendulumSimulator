package ulpgc.es;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(Math.PI / 2, 0.1, 9.81, 1.5,0,0);
        MainFrame frame = new MainFrame();
        new BallPresenter(ball,frame.getBallDisplay(), new PendulumSimulator(0.001)).execute();
        frame.setVisible(true);
    }
}