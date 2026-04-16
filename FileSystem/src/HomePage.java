import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    public HomePage() {

        // Screen size
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = screen.width;
        int screenH = screen.height;

        int baseW = 1920;
        int baseH = 1080;

        double scaleX = (double) screenW / baseW;
        double scaleY = (double) screenH / baseH;

        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, (int)(30 * scaleY));

        GradientButton row = new GradientButton("->");
        GradientButton user = new GradientButton("user");
        GradientButton categProduct = new GradientButton("Category/Product");
        GradientButton orders = new GradientButton("Orders");
        GradientButton logout = new GradientButton("Logout");

        // Positions
        user.setBounds((int)(895 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        categProduct.setBounds((int)(1115 * scaleX), (int)(84 * scaleY), (int)(300 * scaleX), (int)(40 * scaleY));
        orders.setBounds((int)(1495 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        logout.setBounds((int)(1695 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        row.setBounds((int)(1695 * scaleX), (int)(900 * scaleY), (int)(80 * scaleX), (int)(35 * scaleY));

        GradientButton[] buttons = {user, categProduct, orders, logout, row};
        for (GradientButton b : buttons) {
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setContentAreaFilled(false);
            b.setFont(font);
        }

        // ✅ Load background safely
        ImageIcon icon = new ImageIcon("C:\\Users\\man56\\Downloads\\FileSystem\\FileSystem\\HomePage.png");

        JLabel label;
        if (icon.getIconWidth() == -1) {
            System.out.println("Image not found!");
            label = new JLabel(); // fallback so UI still works
        } else {
            Image img = icon.getImage().getScaledInstance(screenW, screenH, Image.SCALE_SMOOTH);
            label = new JLabel(new ImageIcon(img));
        }

        label.setBounds(0, 0, screenW, screenH);
        label.setLayout(null);

        // Add components
        label.add(user);
        label.add(categProduct);
        label.add(orders);
        label.add(logout);
        label.add(row);

        setContentPane(label);

        // ✅ FULLSCREEN AFTER everything is set
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setUndecorated(true);
        setResizable(false);

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        setVisible(true);

        // Actions
        categProduct.addActionListener(e -> {
            dispose();
            new categoryProduct();
        });

        orders.addActionListener(e -> {
            dispose();
            new orders();
        });

        logout.addActionListener(e -> dispose());
    }
}