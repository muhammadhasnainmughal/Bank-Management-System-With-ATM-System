import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;

public class choice extends JFrame {

    public choice() {
        setTitle("Choose Option");
        setUndecorated(true);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initUI();
    }

    private void initUI() {
        // Theme Colors
        Color lightBlue = new Color(220, 240, 255);
        Color accentBlue = new Color(100, 180, 255);
        Color hoverBlue = new Color(70, 160, 255);

        // Fonts
        Font titleFont = new Font("Segoe UI", Font.BOLD, 18);
        Font buttonFont = new Font("Segoe UI", Font.PLAIN, 15);

        // Top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(accentBlue);
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));

        JLabel title = new JLabel("Select Your Choice");
        title.setForeground(Color.WHITE);
        title.setFont(titleFont);

        JButton closeBtn = new JButton("X");
        closeBtn.setFocusPainted(false);
        closeBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setBackground(accentBlue);
        closeBtn.setBorder(null);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.setPreferredSize(new Dimension(40, 30));

        closeBtn.addActionListener(e -> System.exit(0));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtn.setBackground(hoverBlue);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtn.setBackground(accentBlue);
            }
        });

        topBar.add(title, BorderLayout.WEST);
        topBar.add(closeBtn, BorderLayout.EAST);

        // Main Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(lightBlue);
        centerPanel.setLayout(new GridLayout(2, 1, 20, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JButton bankBtn = createModernButton("Bank Management", accentBlue, hoverBlue, buttonFont);
        JButton atmBtn = createModernButton("ATM System", accentBlue, hoverBlue, buttonFont);

        bankBtn.addActionListener(e -> {
            new login().setVisible(true);
            dispose();
        });

        atmBtn.addActionListener(e -> {
            new atm_portal().setVisible(true);
            dispose();
        });

        centerPanel.add(bankBtn);
        centerPanel.add(atmBtn);

        add(topBar, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JButton createModernButton(String text, Color base, Color hover, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setFocusPainted(false);
        button.setBackground(base);
        button.setForeground(Color.WHITE);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setOpaque(true);

        button.setBorder(BorderFactory.createLineBorder(new Color(180, 220, 250), 1, true));
        button.setContentAreaFilled(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hover);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(base);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new choice().setVisible(true));
    }
}
