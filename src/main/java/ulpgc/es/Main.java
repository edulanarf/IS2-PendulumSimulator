package ulpgc.es;

import ulpgc.es.model.Ball;
import ulpgc.es.model.BallPresenter;
import ulpgc.es.model.PendulumSimulator;
import ulpgc.es.swing.MainFrame;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(Math.PI / 6, 0, 9.81, 1.5,0,0, 10,1);
        MainFrame frame = new MainFrame();
        new BallPresenter(ball,frame.getBallDisplay(),new PendulumSimulator(0.001)).execute();
        frame.setVisible(true);
    }
}