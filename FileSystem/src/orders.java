import javax.swing.*;
import java.awt.*;

public class orders extends JFrame {

    public orders() {

        // Get screen size
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = screen.width;
        int screenH = screen.height;

        // Base design
        int baseW = 1920;
        int baseH = 1080;

        double scaleX = (double) screenW / baseW;
        double scaleY = (double) screenH / baseH;

        setTitle("Orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ✅ Fullscreen
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setUndecorated(true);
        setResizable(false);

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        Font font = new Font("Arial", Font.BOLD, (int)(30 * scaleY));

        GradientButton wor = new GradientButton("<-");

        GradientButton user = new GradientButton("user");
        GradientButton categProduct = new GradientButton("Category/Product");
        GradientButton ordersBtn = new GradientButton("Orders"); // renamed to avoid conflict
        GradientButton logout = new GradientButton("Logout");

        // ✅ Scaled bounds
        user.setBounds((int)(895 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        categProduct.setBounds((int)(1115 * scaleX), (int)(84 * scaleY), (int)(300 * scaleX), (int)(40 * scaleY));
        ordersBtn.setBounds((int)(1495 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        logout.setBounds((int)(1695 * scaleX), (int)(84 * scaleY), (int)(150 * scaleX), (int)(40 * scaleY));
        wor.setBounds((int)(120 * scaleX), (int)(900 * scaleY), (int)(80 * scaleX), (int)(35 * scaleY));

        // Style
        GradientButton[] buttons = {user, categProduct, ordersBtn, logout, wor};
        for (GradientButton b : buttons) {
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setContentAreaFilled(false);
            b.setFont(font);
        }

        wor.setBorderPainted(true);
        wor.setFocusPainted(true);

        // ✅ Background image
        ImageIcon icon = new ImageIcon("C:\\Users\\man56\\Downloads\\FileSystem\\FileSystem\\orders.png");

        if (icon.getIconWidth() == -1) {
            System.out.println("Image not found!");
        }

        Image img = icon.getImage().getScaledInstance(screenW, screenH, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(0, 0, screenW, screenH);
        label.setLayout(null); // IMPORTANT

        // Add components
        label.add(user);
        label.add(categProduct);
        label.add(ordersBtn);
        label.add(logout);
        label.add(wor);

        setContentPane(label);

        setVisible(true);

        // Actions
        user.addActionListener(e -> {
            this.dispose();
            new HomePage();
        });

        categProduct.addActionListener(e -> {
            this.dispose();
            new categoryProduct();
        });

        logout.addActionListener(e -> {
            this.dispose();
        });

        wor.addActionListener(e -> {
            this.dispose();
            new HomePage();
        });
    }
}