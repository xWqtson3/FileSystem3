package src;

import javax.swing.*;
import java.awt.*;


public class orders extends JFrame {

    public orders() {
        setTitle("Orders");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.BOLD, 30);

        JFrame frame = new JFrame();

        GradientButton wor = new GradientButton("<-");


        GradientButton user = new GradientButton("user");
        GradientButton categProduct = new GradientButton("Category/Product");
        GradientButton orders = new GradientButton("Orders");
        GradientButton logout = new GradientButton("Logout");

        user.setBounds(895,84,150,40);
        user.setBorderPainted(false); // frame ng button
        user.setFocusPainted(false); //ito sa textbox
        user.setContentAreaFilled(false);
        user.setFont(font);

        categProduct.setBounds(1115,84,300,40);
        categProduct.setBorderPainted(false); // frame ng button
        categProduct.setFocusPainted(false); //ito sa textbox
        categProduct.setContentAreaFilled(false);
        categProduct.setFont(font);

        orders.setBounds(1495,84,150,40);
        orders.setBorderPainted(false); // frame ng button
        orders.setFocusPainted(false); //ito sa textbox
        orders.setContentAreaFilled(false);
        orders.setFont(font);

        logout.setBounds(1695,84,150,40);
        logout.setBorderPainted(false); // frame ng button
        logout.setFocusPainted(false); //ito sa textbox
        logout.setContentAreaFilled(false);
        logout.setFont(font);

        wor.setBounds(120,900,80,35);
        wor.setBorderPainted(true); // frame ng button
        wor.setFocusPainted(true); //ito sa textbox
        wor.setContentAreaFilled(false);
        wor.setFont(font);

        ImageIcon icon = new ImageIcon("orders.png");
        Image img = icon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(img));

        frame.setTitle("mainPage");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        frame.add(label);
        label.add(user);
        label.add(categProduct);
        label.add(orders);
        label.add(logout);

        label.add(wor);

        setContentPane(label);


        setVisible(true);

        user.addActionListener(e -> {

            this.dispose(); // close login window
            new HomePage();  // open new class

        });

        categProduct.addActionListener(e -> {

            this.dispose(); // close login window
            new categoryProduct();  // open new class

        });

        logout.addActionListener(e -> {

            this.dispose(); // close login window


        });
    }
}