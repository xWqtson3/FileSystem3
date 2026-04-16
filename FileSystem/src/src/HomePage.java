package src;

import javax.swing.*;
import java.awt.*;


public class HomePage extends JFrame {

    public HomePage() {
        setTitle("Home Page");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JFrame frame = new JFrame();

        Font font = new Font("Arial", Font.BOLD, 30);

        GradientButton row = new GradientButton("->");

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

        row.setBounds(1695,900,80,35);
        row.setBorderPainted(true); // frame ng button
        row.setFocusPainted(true); //ito sa textbox
        row.setContentAreaFilled(false);
        row.setFont(font);

        ImageIcon icon = new ImageIcon("HomePage.png");
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

        label.add(row);

        setContentPane(label);


        setVisible(true);



        categProduct.addActionListener(e -> {

            this.dispose(); // close login window
            new categoryProduct();  // open new class

        });

        orders.addActionListener(e -> {

            this.dispose(); // close login window
            new orders();  // open new class

        });

        logout.addActionListener(e -> {

            this.dispose(); // close login window


        });
    }
}