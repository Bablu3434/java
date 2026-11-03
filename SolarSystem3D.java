
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SolarSystem3D extends JPanel implements ActionListener {

    private double angle = 0;
    private final Timer timer;

    private final String[] planets = {
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"
    };

    private final int[] distances = {
        65, 95, 130, 165, 210, 255, 295, 335
    };

    private final int[] sizes = {
        7, 11, 13, 10, 25, 21, 17, 16
    };

    private final Color[] colors = {
        Color.GRAY,
        new Color(255, 180, 90),
        Color.BLUE,
        Color.RED,
        new Color(210, 150, 100),
        new Color(230, 200, 130),
        Color.CYAN,
        new Color(50, 100, 255)
    };

    private final double[] speeds = {
        3.1, 3.2, 2.5, 2.0,
        1.1, 0.8, 0.55, 0.4
    };

    public SolarSystem3D() {
        setBackground(Color.BLACK);
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

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        // Background stars
        g2.setColor(Color.WHITE);

        for (int i = 0; i < 180; i++) {
            int x = (i * 127 + 23) % getWidth();
            int y = (i * 83 + 17) % getHeight();

            g2.fillOval(x, y, 2, 2);
        }

        // Title
        g2.setFont(new Font("Arial", Font.BOLD, 25));
        g2.setColor(Color.CYAN);
        g2.drawString("3D SOLAR SYSTEM", 25, 40);

        // Sun glow
        g2.setColor(new Color(255, 150, 0, 35));
        g2.fillOval(cx - 48, cy - 48, 96, 96);

        // Orbit paths
        g2.setStroke(new BasicStroke(1));

        for (int distance : distances) {
            g2.setColor(new Color(100, 100, 100, 100));

            g2.drawOval(
                cx - distance,
                cy - distance,
                distance * 2,
                distance * 2
            );
        }

        // Sun
        GradientPaint sun = new GradientPaint(
            cx - 20, cy - 20,
            Color.YELLOW,
            cx + 20, cy + 20,
            Color.RED
        );

        g2.setPaint(sun);
        g2.fillOval(cx - 28, cy - 28, 56, 56);

        // Planets
        for (int i = 0; i < planets.length; i++) {

            double a = angle * speeds[i] + i;

            int x = cx + (int)(distances[i] * Math.cos(a));
            int y = cy + (int)(distances[i] * Math.sin(a));

            // Planet
            g2.setColor(colors[i]);
            g2.fillOval(
                x - sizes[i] / 2,
                y - sizes[i] / 2,
                sizes[i],
                sizes[i]
            );

            // Saturn rings
            if (i == 5) {
                g2.setColor(new Color(230, 210, 160));
                g2.drawOval(
                    x - 18, y - 8, 36, 16
                );
            }

            // Planet names
            g2.setFont(new Font("Arial", Font.PLAIN, 11));
            g2.setColor(Color.WHITE);
            g2.drawString(planets[i], x + 8, y - 8);
        }

        // Sun name
        g2.setColor(Color.YELLOW);
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        g2.drawString("SUN", cx - 14, cy + 45);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.015;
        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("3D Solar System");

        SolarSystem3D solarSystem = new SolarSystem3D();

        frame.add(solarSystem);
        frame.setSize(900, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
