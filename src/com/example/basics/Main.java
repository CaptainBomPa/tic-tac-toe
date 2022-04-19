package com.example.basics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 600;
    static final String BG_COLOR = "#00A6A1";
    static final String BG_COLOR_BUTTON = "#02B7B1";
    static final String BG_COLOR_HOVER = "#01E4DC";

    private JButton plVsPl;
    private JButton plVsAi;
    private JLabel label1;

    public Main(JFrame frame)
    {
        frame.setTitle("TicTacToe - by CaptainBomPa");
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        frame.setContentPane(panel);
        frame.getContentPane().setBackground(Color.decode(BG_COLOR));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        label1 = new JLabel("Tic Tac Toe");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("", Font.BOLD, 40));
        gbc.gridx = 0; gbc.gridy = 0; panel.add(label1, gbc);

        plVsPl = new JButton("Player VS Player");
        plVsPl.setBackground(Color.decode(BG_COLOR_BUTTON));
        plVsPl.setForeground(Color.WHITE);
        plVsPl.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        plVsPl.setFont(new Font("", Font.BOLD, 30));
        plVsPl.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(plVsPl, gbc);

        plVsAi = new JButton("Player VS AI");
        plVsAi.setBackground(Color.decode(BG_COLOR_BUTTON));
        plVsAi.setForeground(Color.WHITE);
        plVsAi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        plVsAi.setFont(new Font("", Font.BOLD, 30));
        plVsAi.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(plVsAi, gbc);

        plVsPl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.repaint();
                new GamePlayerVsPlayer(frame);
            }
        });

        plVsAi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                frame.repaint();
                new GamePlayerVsAi(frame);
            }
        });

        plVsPl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                plVsPl.setBackground(Color.decode(BG_COLOR_HOVER));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                plVsPl.setBackground(Color.decode(BG_COLOR_BUTTON));
            }
        });

        plVsAi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                plVsAi.setBackground(Color.decode(BG_COLOR_HOVER));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                plVsAi.setBackground(Color.decode(BG_COLOR_BUTTON));
            }
        });

        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    public static void main(String[] args) {
	    JFrame frame = new JFrame();
        new Main(frame);
    }
}
