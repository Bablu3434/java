
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class DiwaliHologram extends JPanel {

    private int frame = 0;
    private boolean fireworks = true;
    private final Random random = new Random();

    private final Color[] colors = {
        Color.YELLOW, Color.ORANGE,
        Color.PINK, Color.CYAN,
        Color.MAGENTA, Color.WHITE
    };

    public DiwaliHologram() {
        setBackground(new Color(5, 3, 30));

        Timer timer = new Timer(30, e -> {
            frame++;
            repaint();
        });
        timer.start();

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                fireworks = !fireworks;
            }
        });
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
        int cx = w / 2;
        int cy = h / 2;

        // Magical background
        GradientPaint bg = new GradientPaint(
            0, 0, new Color(4, 3, 35),
            w, h, new Color(75, 5, 65)
        );

        g2.setPaint(bg);
        g2.fillRect(0, 0, w, h);

        // Stars
        for (int i = 0; i < 130; i++) {
            int x = (i * 83) % w;
            int y = (i * 47) % h;
            int size = 1 + (int)(
                3 * Math.abs(Math.sin(frame * .05 + i))
            );

            g2.setColor(Color.WHITE);
            g2.fillOval(x, y, size, size);
        }

        // 3D hologram mandala
        Graphics2D m = (Graphics2D) g2.create();
        m.translate(cx, cy - 20);
        m.rotate(Math.toRadians(frame * 0.7));

        for (int ring = 0; ring < 5; ring++) {
            int radius = 55 + ring * 35;

            m.setColor(new Color(
                255, 190 + ring * 10, 50, 190
            ));

            m.setStroke(new BasicStroke(2));
            m.drawOval(-radius, -radius, radius * 2, radius * 2);

            for (int i = 0; i < 12; i++) {
                double angle = Math.PI * 2 * i / 12;
                int x = (int)(radius * Math.cos(angle));
                int y = (int)(radius * Math.sin(angle));

                m.fillOval(x - 5, y - 5, 10, 10);
            }
        }

        m.dispose();

        // Fireworks
        if (fireworks) {
            for (int i = 0; i < 7; i++) {
                int fx = (i * 151 + 80) % w;
                int fy = 100 + (i * 83) % (h / 2);

                int radius = (frame * 3 + i * 23) % 90;

                g2.setColor(colors[i % colors.length]);

                for (int j = 0; j < 16; j++) {
                    double angle = j * Math.PI / 8;

                    int px = fx + (int)(
                        Math.cos(angle) * radius
                    );
                    int py = fy + (int)(
                        Math.sin(angle) * radius
                    );

                    g2.fillOval(px, py, 5, 5);
                }
            }
        }

        // Glowing title
        String title = "HAPPY DIWALI";
        g2.setFont(new Font("Serif", Font.BOLD, 55));

        int titleX = (w -
            g2.getFontMetrics().stringWidth(title)) / 2;

        for (int i = 8; i >= 1; i--) {
            g2.setColor(new Color(255, 160, 0, 15));
            g2.setStroke(new BasicStroke(i * 2));
            g2.drawString(title, titleX, 90);
        }

        g2.setColor(Color.YELLOW);
        g2.drawString(title, titleX, 90);

        // Diya
        drawDiya(g2, cx - 55, h - 160);

        // Message
        g2.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2.setColor(Color.WHITE);

        String message =
            "May your life shine with happiness and prosperity!";

        int msgX = (w -
            g2.getFontMetrics().stringWidth(message)) / 2;

        g2.drawString(message, msgX, h - 35);

        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.setColor(Color.CYAN);
        g2.drawString(
            "CLICK ANYWHERE TO TOGGLE FIREWORKS",
            20, h - 15
        );
    }

    private void drawDiya(Graphics2D g, int x, int y) {

        // Shadow
        g.setColor(new Color(0, 0, 0, 100));
        g.fillOval(x - 20, y + 40, 150, 25);

        // Diya body
        GradientPaint body = new GradientPaint(
            x, y, Color.YELLOW,
            x, y + 70, new Color(130, 25, 0)
        );

        g.setPaint(body);
        g.fillArc(x, y, 110, 65, 180, 180);

        // Flame glow
        int pulse = (int)(
            10 + 8 * Math.abs(Math.sin(frame * 0.12))
        );

        g.setColor(new Color(255, 140, 0, 65));
        g.fillOval(x + 35 - pulse, y - 65 - pulse,
                   40 + pulse * 2, 75 + pulse * 2);

        // Flame
        GradientPaint flame = new GradientPaint(
            x + 50, y - 65, Color.YELLOW,
            x + 50, y + 5, Color.RED
        );

        g.setPaint(flame);

        Path2D fire = new Path2D.Double();
        fire.moveTo(x + 55, y + 5);
        fire.curveTo(
            x + 5, y - 35,
            x + 75, y - 100,
            x + 55, y - 65
        );
        fire.curveTo(
            x + 100, y - 25,
            x + 90, y - 5,
            x + 55, y + 5
        );

        g.fill(fire);
    }

    public static void main(String[] args) {

        JFrame window = new JFrame(
            "DIWALI HOLOGRAM - JAVA MAGIC"
        );

        DiwaliHologram panel = new DiwaliHologram();

        window.add(panel);
        window.setSize(1000, 700);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        window.setVisible(true);
    }
}
