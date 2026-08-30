import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RadhaArt extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // =========================
        // Background
        // =========================
        GradientPaint bg = new GradientPaint(
                0, 0, new Color(40, 20, 80),
                0, h, new Color(255, 170, 190)
        );
        g2.setPaint(bg);
        g2.fillRect(0, 0, w, h);

        // =========================
        // Moon
        // =========================
        g2.setColor(new Color(255, 245, 190));
        g2.fillOval(650, 60, 90, 90);

        // =========================
        // Water
        // =========================
        g2.setColor(new Color(70, 110, 150, 150));
        g2.fillRect(0, 430, w, 300);

        // Water reflection
        g2.setColor(new Color(255, 210, 180, 100));
        for (int i = 0; i < 12; i++) {
            g2.fillOval(500 + i * 8, 470 + i * 12, 100, 8);
        }

        // =========================
        // Flowers Background
        // =========================
        drawFlower(g2, 100, 150, 25);
        drawFlower(g2, 180, 100, 20);
        drawFlower(g2, 850, 180, 25);
        drawFlower(g2, 920, 100, 20);
        drawFlower(g2, 100, 600, 35);
        drawFlower(g2, 900, 600, 35);

        // =========================
        // Left Tree
        // =========================
        g2.setColor(new Color(80, 45, 25));
        g2.fillRoundRect(70, 80, 35, 550, 20, 20);

        g2.setColor(new Color(40, 120, 60));
        for (int i = 0; i < 20; i++) {
            int x = 30 + (i * 43) % 120;
            int y = 40 + (i * 61) % 500;
            g2.fillOval(x, y, 80, 70);
        }

        // =========================
        // Right Tree
        // =========================
        g2.setColor(new Color(80, 45, 25));
        g2.fillRoundRect(930, 80, 35, 550, 20, 20);

        g2.setColor(new Color(40, 120, 60));
        for (int i = 0; i < 20; i++) {
            int x = 890 + (i * 37) % 120;
            int y = 30 + (i * 53) % 500;
            g2.fillOval(x, y, 80, 70);
        }

        // =========================
        // Radha Ji Body / Saree
        // =========================

        // Saree main
        g2.setColor(new Color(220, 150, 205));
        Path saree = new Path2D.Double();

        saree.moveTo(350, 470);
        saree.curveTo(290, 570, 250, 700, 200, 760);
        saree.lineTo(850, 760);
        saree.curveTo(820, 650, 780, 540, 700, 470);
        saree.closePath();

        g2.fill(saree);

        // Saree golden border
        g2.setColor(new Color(255, 220, 120));
        g2.setStroke(new BasicStroke(7));

        Path border = new Path2D.Double();
        border.moveTo(350, 470);
        border.curveTo(290, 570, 250, 700, 200, 760);
        border.lineTo(850, 760);

        g2.draw(border);

        // =========================
        // Face
        // =========================
        g2.setColor(new Color(225, 165, 125));
        g2.fillOval(455, 210, 220, 280);

        // =========================
        // Hair
        // =========================
        g2.setColor(new Color(35, 20, 25));

        g2.fillOval(430, 170, 260, 170);

        g2.fillOval(420, 230, 80, 270);
        g2.fillOval(620, 230, 80, 260);

        // =========================
        // Hair Flowers
        // =========================
        drawFlower(g2, 460, 250, 18);
        drawFlower(g2, 650, 270, 18);
        drawFlower(g2, 480, 430, 20);

        // =========================
        // Eyes
        // =========================
        g2.setColor(Color.BLACK);

        g2.fillOval(500, 320, 25, 12);
        g2.fillOval(605, 320, 25, 12);

        // Eyelashes
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(500, 320, 485, 312);
        g2.drawLine(625, 320, 640, 312);

        // =========================
        // Nose
        // =========================
        g2.setColor(new Color(150, 90, 70));
        g2.drawArc(550, 340, 30, 45, 270, 100);

        // =========================
        // Smile
        // =========================
        g2.setColor(new Color(170, 50, 70));
        g2.drawArc(535, 375, 70, 35, 200, 140);

        // =========================
        // Bindi
        // =========================
        g2.setColor(new Color(150, 20, 60));
        g2.fillOval(555, 285, 16, 16);

        // =========================
        // Crown / Jewelry
        // =========================
        g2.setColor(new Color(255, 210, 70));

        // Head jewelry
        g2.drawArc(465, 185, 200, 100, 180, 180);

        // Center jewelry
        g2.fillOval(545, 190, 35, 45);

        // Earrings
        g2.fillOval(450, 325, 30, 45);
        g2.fillOval(660, 325, 30, 45);

        // Necklace
        g2.setStroke(new BasicStroke(6));
        g2.drawArc(485, 415, 170, 100, 200, 140);

        // Necklace beads
        for (int i = 0; i < 10; i++) {
            g2.fillOval(495 + i * 16, 450, 10, 10);
        }

        // =========================
        // Dupatta
        // =========================
        g2.setColor(new Color(245, 180, 220, 170));

        Path dupatta = new Path2D.Double();
        dupatta.moveTo(430, 200);
        dupatta.curveTo(650, 100, 800, 250, 820, 650);
        dupatta.lineTo(740, 650);
        dupatta.curveTo(700, 330, 600, 230, 430, 200);
        dupatta.closePath();

        g2.fill(dupatta);

        // Dupatta border
        g2.setColor(new Color(255, 220, 120));
        g2.setStroke(new BasicStroke(5));
        g2.draw(dupatta);

        // =========================
        // Hands
        // =========================
        g2.setColor(new Color(225, 165, 125));

        g2.fillOval(520, 530, 80, 150);
        g2.fillOval(590, 530, 80, 150);

        // =========================
        // Bangles
        // =========================
        g2.setColor(new Color(255, 210, 70));
        g2.setStroke(new BasicStroke(5));

        for (int i = 0; i < 5; i++) {
            g2.drawOval(515 + i * 3, 590, 45, 18);
        }

        // =========================
        // Lotus
        // =========================
        drawLotus(g2, 570, 690);

        // =========================
        // Peacock
        // =========================
        drawPeacock(g2, 150, 520);

        // =========================
        // Title
        // =========================
        g2.setFont(new Font("Serif", Font.BOLD, 38));
        g2.setColor(new Color(255, 240, 190));

        String title = "श्री राधे";
        g2.drawString(title, 450, 70);
    }

    // =========================
    // Flower Function
    // =========================
    void drawFlower(Graphics2D g2, int x, int y, int size) {

        g2.setColor(new Color(255, 130, 180));

        for (int i = 0; i < 6; i++) {
            double angle = Math.toRadians(i * 60);

            int px = x + (int)(Math.cos(angle) * size);
            int py = y + (int)(Math.sin(angle) * size);

            g2.fillOval(
                    px - size / 2,
                    py - size / 2,
                    size,
                    size
            );
        }

        g2.setColor(new Color(255, 220, 80));
        g2.fillOval(x - 8, y - 8, 16, 16);
    }

    // =========================
    // Lotus Function
    // =========================
    void drawLotus(Graphics2D g2, int x, int y) {

        g2.setColor(new Color(255, 130, 170));

        g2.fillOval(x - 60, y, 60, 35);
        g2.fillOval(x, y, 60, 35);
        g2.fillOval(x - 35, y - 25, 70, 45);

        g2.setColor(new Color(255, 210, 100));
        g2.fillOval(x - 10, y + 5, 20, 20);
    }

    // =========================
    // Peacock Function
    // =========================
    void drawPeacock(Graphics2D g2, int x, int y) {

        // Body
        g2.setColor(new Color(30, 100, 170));
        g2.fillOval(x, y, 70, 100);

        // Head
        g2.fillOval(x + 20, y - 40, 50, 50);

        // Eye
        g2.setColor(Color.BLACK);
        g2.fillOval(x + 52, y - 25, 7, 7);

        // Beak
        g2.setColor(new Color(240, 180, 50));
        Polygon beak = new Polygon();
        beak.addPoint(x + 68, y - 15);
        beak.addPoint(x + 95, y);
        beak.addPoint(x + 68, y + 5);
        g2.fillPolygon(beak);

        // Tail
        g2.setColor(new Color(20, 100, 120));

        for (int i = 0; i < 8; i++) {
            g2.fillOval(
                    x - 80 + i * 20,
                    y + 60 - Math.abs(4 - i) * 15,
                    100,
                    150
            );
        }

        // Tail eyes
        g2.setColor(new Color(80, 180, 180));

        for (int i = 0; i < 8; i++) {
            g2.fillOval(
                    x - 45 + i * 20,
                    y + 90 - Math.abs(4 - i) * 15,
                    25,
                    25
            );
        }
    }

    // =========================
    // Main Method
    // =========================
    public static void main(String[] args) {

        JFrame frame = new JFrame("Beautiful Radha Ji Art");

        frame.add(new RadhaArt());

        frame.setSize(1050, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}