package baitaplon_buinhuquynh;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JButton btnLogIn;
    private JButton btnRegister;
    private JButton btnForget;
    private JLabel lbTaiKhoan;
    private JLabel lbMatKhau;
    private JTextField txtTaiKhoan;
    private JPasswordField txtMatKhau;

    public Main() {
        prepareGUI();
    }

    public void prepareGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btnLogIn = new JButton("Đăng Nhập");
        btnRegister = new JButton("Đăng Kí");
        btnForget = new JButton("Quên mật khẩu");

        lbTaiKhoan = new JLabel("Tên tài khoản: ");
        lbMatKhau = new JLabel("Mật Khẩu: ");

        txtTaiKhoan = new JTextField(20);
        txtMatKhau = new JPasswordField(20);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lbTaiKhoan, gbc);

        gbc.gridx = 1;
        panel.add(txtTaiKhoan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lbMatKhau, gbc);

        gbc.gridx = 1;
        panel.add(txtMatKhau, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnLogIn, gbc);

        gbc.gridy = 3;
        panel.add(btnRegister, gbc);

        gbc.gridy = 4;
        panel.add(btnForget, gbc);

        add(panel);
        setTitle("Đăng nhập");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main li = new  Main();
            
        }
    }

