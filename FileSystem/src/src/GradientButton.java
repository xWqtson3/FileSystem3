package src;

import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);

        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // 🎨 SAME gradient style (left dark → right light)
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(16, 55, 66),      // dark left
                getWidth(), 0, new Color(47, 96, 109) // light right
        );

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(21, 58, 81));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
}