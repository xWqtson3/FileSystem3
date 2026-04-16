import src.GradientButton;

import javax.swing.*;
import java.awt.*;

public class fileSystem {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        // Get screen size
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = screen.width;
        int screenH = screen.height;

        // Base design size (your original layout)
        int baseW = 1920;
        int baseH = 1080;

        double scaleX = (double) screenW / baseW;
        double scaleY = (double) screenH / baseH;

        // Background image (scaled to screen)
        ImageIcon icon = new ImageIcon("C:\\Users\\man56\\Downloads\\FileSystem\\FileSystem\\LoginPage.png");

        if (icon.getIconWidth() == -1) {
            System.out.println("Image not found!");
        }

        Image img = icon.getImage().getScaledInstance(screenW, screenH, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(0, 0, screenW, screenH);
        label.setLayout(null); // IMPORTANT

        Font font = new Font("Arial", Font.BOLD, (int)(30 * scaleY));

        GradientButton loginButt = new GradientButton("Login");
        GradientTextField emailTex = new GradientTextField(20);
        GradientTextField passwordText = new GradientTextField(20);

        emailTex.setForeground(Color.WHITE);
        passwordText.setForeground(Color.WHITE);

        emailTex.setFont(font);
        passwordText.setFont(font);

        // ✅ Scaled positions
        emailTex.setBounds(
                (int)(680 * scaleX),
                (int)(625 * scaleY),
                (int)(554 * scaleX),
                (int)(66 * scaleY)
        );

        passwordText.setBounds(
                (int)(680 * scaleX),
                (int)(760 * scaleY),
                (int)(554 * scaleX),
                (int)(66 * scaleY)
        );

        loginButt.setBounds(
                (int)(895 * scaleX),
                (int)(860 * scaleY),
                (int)(150 * scaleX),
                (int)(50 * scaleY)
        );

        loginButt.setBorderPainted(false);
        loginButt.setFocusPainted(false);
        loginButt.setContentAreaFilled(false);
        loginButt.setFont(font);

        frame.setTitle("mainPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        frame.setUndecorated(true);
        frame.setResizable(false);

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(frame);
        } else {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }

        frame.add(label);
        label.add(loginButt);
        label.add(emailTex);
        label.add(passwordText);

        frame.setVisible(true);

        // Button action
        loginButt.addActionListener(e -> {
            String email = emailTex.getText();
            String password = passwordText.getText();

            if (email.equals("a") && password.equals("a")) {
                frame.dispose();
                new HomePage();
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong login!");
            }
        });
    }
}