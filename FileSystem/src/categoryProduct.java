import javax.swing.*;
import java.awt.*;

public class categoryProduct extends JFrame {

    public categoryProduct() {

        // ================= SCREEN =================
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = screen.width;
        int screenH = screen.height;

        double scaleX = (double) screenW / 1920;
        double scaleY = (double) screenH / 1080;

        setTitle("Category/Product Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        setUndecorated(true);
        setResizable(false);

        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        // ================= BACKGROUND =================
        JPanel bg = new JPanel();
        bg.setLayout(null);
        bg.setBackground(new Color(10, 30, 40));
        bg.setBounds(0, 0, screenW, screenH);
        setContentPane(bg);

        // ================= NAVBAR =================
        GradientButton user = new GradientButton("Users");
        GradientButton categProduct = new GradientButton("Category/Product");
        GradientButton orders = new GradientButton("Orders");
        GradientButton logout = new GradientButton("Log-out");

        user.setBounds((int)(900 * scaleX), (int)(60 * scaleY), (int)(140 * scaleX), (int)(40 * scaleY));
        categProduct.setBounds((int)(1050 * scaleX), (int)(60 * scaleY), (int)(220 * scaleX), (int)(40 * scaleY));
        orders.setBounds((int)(1280 * scaleX), (int)(60 * scaleY), (int)(140 * scaleX), (int)(40 * scaleY));
        logout.setBounds((int)(1430 * scaleX), (int)(60 * scaleY), (int)(140 * scaleX), (int)(40 * scaleY));

        bg.add(user);
        bg.add(categProduct);
        bg.add(orders);
        bg.add(logout);

        // ================= TITLE =================
        JLabel title1 = new JLabel("CATEGORY/PRODUCT");
        title1.setFont(new Font("Arial", Font.BOLD, (int)(50 * scaleY)));
        title1.setForeground(Color.WHITE);
        title1.setBounds((int)(120 * scaleX), (int)(140 * scaleY), (int)(600 * scaleX), (int)(60 * scaleY));

        JLabel title2 = new JLabel("MANAGEMENT");
        title2.setFont(new Font("Arial", Font.BOLD, (int)(50 * scaleY)));
        title2.setForeground(new Color(255, 200, 0));
        title2.setBounds((int)(700 * scaleX), (int)(140 * scaleY), (int)(400 * scaleX), (int)(60 * scaleY));

        bg.add(title1);
        bg.add(title2);

        // ================= LEFT PANEL =================
        RoundedPanel leftPanel = new RoundedPanel(30, new Color(20, 90, 90, 180));
        leftPanel.setBounds((int)(120 * scaleX), (int)(250 * scaleY), (int)(800 * scaleX), (int)(420 * scaleY));
        leftPanel.setLayout(null);

        JLabel headers = new JLabel("NAME     QUANTITY     PRICE     DESCRIPTION     CATEGORY");
        headers.setForeground(Color.WHITE);
        headers.setBounds((int)(40 * scaleX), (int)(20 * scaleY), (int)(700 * scaleX), (int)(30 * scaleY));

        RoundedPanel innerCard = new RoundedPanel(40, new Color(30, 100, 100, 180));
        innerCard.setBounds((int)(150 * scaleX), (int)(80 * scaleY), (int)(500 * scaleX), (int)(220 * scaleY));

        JButton editBtn = new JButton("Edit category/products");
        editBtn.setBounds((int)(260 * scaleX), (int)(320 * scaleY), (int)(250 * scaleX), (int)(40 * scaleY));

        leftPanel.add(headers);
        leftPanel.add(innerCard);
        leftPanel.add(editBtn);

        bg.add(leftPanel);

        // ================= RIGHT FORM =================
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setOpaque(false);
        rightPanel.setBounds((int)(1050 * scaleX), (int)(250 * scaleY), (int)(500 * scaleX), (int)(420 * scaleY));

        String[] labels = {"NAME", "QUANTITY", "PRICE", "DESCRIPTION", "CATEGORY"};

        for (int i = 0; i < labels.length; i++) {

            JLabel lbl = new JLabel(labels[i]);
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Arial", Font.BOLD, (int)(16 * scaleY)));
            lbl.setBounds(0, (int)(i * 70 * scaleY), (int)(200 * scaleX), (int)(30 * scaleY));

            GradientField field = new GradientField();
            field.setBounds(0, (int)(i * 70 * scaleY + 30 * scaleY), (int)(400 * scaleX), (int)(30 * scaleY));

            rightPanel.add(lbl);
            rightPanel.add(field);
        }

        bg.add(rightPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new categoryProduct();
    }
}

// ================= ROUNDED PANEL =================
class RoundedPanel extends JPanel {
    private int radius;
    private Color color;

    public RoundedPanel(int radius, Color color) {
        this.radius = radius;
        this.color = color;
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    }
}

// ================= GRADIENT BUTTON =================
class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);
        setForeground(Color.WHITE);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(
                0, 0, new Color(0, 200, 200),
                getWidth(), getHeight(), new Color(0, 100, 150)
        );

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g);
    }
}

// ================= GRADIENT INPUT =================
class GradientField extends JTextField {

    public GradientField() {
        setOpaque(false);
        setBorder(null);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(
                0, 0, new Color(20, 120, 120),
                getWidth(), getHeight(), new Color(10, 60, 60)
        );

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        super.paintComponent(g);
    }
}