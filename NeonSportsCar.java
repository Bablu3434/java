
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NeonSportsCar extends JPanel implements ActionListener {

    private int wheelRotation = 0;
    private int carX = 0;
    private final Timer timer;

    public NeonSportsCar() {
        setBackground(new Color(5, 5, 20));
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        int w = getWidth();
        int h = getHeight();

        // Background stars
        g2.setColor(Color.WHITE);

        for (int i = 0; i < 70; i++) {
            int x = (i * 137) % w;
            int y = (i * 79) % h;
            g2.fillOval(x, y, 2, 2);
        }

        // Ground
        g2.setColor(new Color(20, 20, 45));
        g2.fillRect(0, h - 100, w, 100);

        // Neon road lines
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(0, h - 95, w, h - 95);

        g2.setColor(Color.CYAN);
        g2.drawLine(0, h - 5, w, h - 5);

        int x = 120 + carX;
        int y = h - 245;

        // Car shadow
        g2.setColor(new Color(0, 255, 255, 50));
        g2.fillOval(x - 10, y + 155, 380, 35);

        // Car body glow
        g2.setColor(new Color(0, 255, 255, 35));
        g2.fillRoundRect(x - 10, y + 35, 360, 125, 35, 35);

        // Car body
        Polygon body = new Polygon();
        body.addPoint(x, y + 100);
        body.addPoint(x + 30, y + 60);
        body.addPoint(x + 95, y + 45);
        body.addPoint(x + 145, y + 5);
        body.addPoint(x + 235, y + 5);
        body.addPoint(x + 295, y + 65);
        body.addPoint(x + 340, y + 85);
        body.addPoint(x + 350, y + 125);
        body.addPoint(x + 10, y + 125);

        GradientPaint paint = new GradientPaint(
            x, y, new Color(0, 80, 255),
            x, y + 140, new Color(120, 0, 255)
        );

        g2.setPaint(paint);
        g2.fillPolygon(body);

        // Car outline
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(body);

        // Windows
        Polygon window = new Polygon();
        window.addPoint(x + 105, y + 42);
        window.addPoint(x + 150, y + 12);
        window.addPoint(x + 225, y + 12);
        window.addPoint(x + 270, y + 65);
        window.addPoint(x + 95, y + 65);

        g2.setColor(new Color(5, 10, 35));
        g2.fillPolygon(window);

        g2.setColor(Color.CYAN);
        g2.drawPolygon(window);

        // Headlights
        g2.setColor(Color.CYAN);
        g2.fillRoundRect(x + 300, y + 82, 42, 10, 10, 10);

        // Front neon light
        g2.setColor(Color.WHITE);
        g2.fillRect(x + 338, y + 105, 10, 5);

        // Wheels
        drawWheel(g2, x + 75, y + 120);
        drawWheel(g2, x + 285, y + 120);

        // Spoiler
        g2.setColor(Color.MAGENTA);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(x + 20, y + 55, x + 20, y + 25);
        g2.drawLine(x + 5, y + 25, x + 65, y + 25);

        // Title
        g2.setFont(new Font("Arial", Font.BOLD, 28));
        g2.setColor(Color.CYAN);
        g2.drawString("NEON SPORTS CAR", 30, 45);

        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        g2.setColor(Color.MAGENTA);
        g2.drawString("FUTURE IS HERE", 35, 68);
    }

    private void drawWheel(Graphics2D g2, int x, int y) {

        // Wheel glow
        g2.setColor(new Color(0, 255, 255, 70));
        g2.fillOval(x - 28, y - 28, 56, 56);

        // Tire
        g2.setColor(Color.BLACK);
        g2.fillOval(x - 23, y - 23, 46, 46);

        // Neon border
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(3));
        g2.drawOval(x - 23, y - 23, 46, 46);

        // Rim
        g2.setColor(Color.MAGENTA);
        g2.drawOval(x - 13, y - 13, 26, 26);

        // Rotating spokes
        g2.setColor(Color.WHITE);

        for (int i = 0; i < 4; i++) {
            double a = Math.toRadians(wheelRotation + i * 90);

            int x2 = x + (int)(13 * Math.cos(a));
            int y2 = y + (int)(13 * Math.sin(a));

            g2.drawLine(x, y, x2, y2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wheelRotation += 10;
        carX += 2;

        if (carX > getWidth() - 500) {
            carX = 0;
        }

        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Neon Sports Car");

        NeonSportsCar car = new NeonSportsCar();

        frame.add(car);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
