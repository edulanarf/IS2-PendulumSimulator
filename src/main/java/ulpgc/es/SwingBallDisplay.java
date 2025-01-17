package ulpgc.es;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SwingBallDisplay extends JPanel implements BallDisplay {

    private List<Paint> paints = new ArrayList<>();
    @Override
    public void drawCircle(int r, int x, int y) {
        synchronized (paints) {
            paints.add(new Paint(r, x, y)); // Agregar de manera segura
        }
        repaint(); // Forzar la actualización del panel
    }

    @Override
    public void clear() {
        synchronized (paints) {
            paints.clear();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        synchronized (paints) {
            for (Paint paint : paints) {
                int centerX = this.getWidth() / 2;
                int centerY = this.getHeight() / 2;
                int xPosition = centerX - paint.x() - paint.r();
                int yPosition = centerY - paint.y() - paint.r();
                int diameter = paint.r() * 2;
                g.setColor(Color.BLACK);
                g.drawLine(centerX, centerY , xPosition+paint.r(), yPosition+paint.r());
                g.setColor(Color.RED);
                g.fillOval(xPosition, yPosition, diameter, diameter);
                g.drawOval(xPosition, yPosition, diameter, diameter);
            }
        }
    }

    private record Paint(int r, int x, int y) {
    }
}
